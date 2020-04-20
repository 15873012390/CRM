package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.mybatis.HTIStockDao;
import com.zktr.crmproject.dao.mybatis.HTIWarehouseDao;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.ProductDemandVo;
import com.zktr.crmproject.vo.StockAdvancedSearch;
import com.zktr.crmproject.vo.StockNumberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class HTStockService {
    @Autowired
    private HTIStockDao istockDao;
    @Autowired
    private HTIWarehouseDao iwarehouseDao;

    /**
     * 查询所有库存信息
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Stock> queryAllStockByPage(Integer curpage, Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Stock> list = istockDao.queryAllStock();
        PageInfo<Stock> pager = new PageInfo<>(list);
        return new Pager<Stock>(pager.getTotal(),pager.getList());
    }

    /**
     * 清除库存为0的库存
     */
    public void removeStockisZero(){
        istockDao.removeStockisZero();
    }

    /**
     * 高级查询库存
     * @param sas
     * @return
     */
    public Pager<Stock> queryStockByAdvanced(StockAdvancedSearch sas){
        PageHelper.startPage(sas.getCurPage(),sas.getPageSize());
        List<Stock> list = istockDao.queryStockByAdvanced(sas);
        PageInfo<Stock> pager = new PageInfo<>(list);
        return new Pager<Stock>(pager.getTotal(),pager.getList());
    }

    /**
     * 通过库存ID查找库存
     * @param stockId
     * @return
     */
    public Stock queryStockByStockId(Integer stockId){
        return istockDao.queryStockByStockId(stockId);
    }

    /**
     * 根据规格ID查询库存
     * @param speId
     * @return
     */
    public Integer queryQuantityBySpeId(Integer speId){
        return istockDao.queryQuantityBySpeId(speId).getStockQuantity();
    }

    /**
     * 判断出库量是否大于库存量
     * @param outstockdetails
     * @return
     */
    public List<ProductDemandVo> queryIsBigStock(List<Outstockdetails> outstockdetails){
        boolean flag = false;
        List<Integer> speIdList=new ArrayList<>();
        List<ProductDemandVo> pdv = new ArrayList<>();
        for(Outstockdetails o:outstockdetails){
            ProductDemandVo p= new ProductDemandVo();
            Stock stock = queryStockByWarehouseAndSpeId(o.getProductspecification().getSpeId(), o.getOutstock().getWarehouse().getWarehouseId());
            if(stock!=null) {
                if (stock.getStockQuantity() < o.getOsdNumber()) {
                    flag = true;
                    p.setSpeId(o.getProductspecification());
                    p.setNumber(o.getOsdNumber()-stock.getStockQuantity());
                    p.setInwarehouseId(o.getOutstock().getWarehouse());
                    pdv.add(p);
                }
            }else{
                flag = true;
                p.setSpeId(o.getProductspecification());
                System.out.println(o.getProductspecification().getSpeId());
                p.setNumber(o.getOsdNumber());
                p.setInwarehouseId(o.getOutstock().getWarehouse());
                pdv.add(p);
            }
        }
        if(flag){
            for(ProductDemandVo  p:pdv){
                if(p.getInwarehouseId()==null||p.getOutwarehouseId()==null){
                    p.setInwarehouseId(new Warehouse());
                    p.setOutwarehouseId(new Warehouse());
                }
            }
            return pdv;
        }else{
            pdv=null;
            return pdv;
        }

    }



    /**
     * 查询库存根据规格ID
     * @param speId
     * @return
     */
    public Stock queryStockByWarehouseAndSpeId(Integer speId,Integer warehouseId){
        return istockDao.queryStockByWarehouseAndSpeId(speId,warehouseId);
    }

    /**
     * 根据规格和仓库查库存
     * @param warehouseallocationdetails
     * @return
     */
    public Map<String,Object> queryByAllWarehouse(List<Warehouseallocationdetail> warehouseallocationdetails){
        List list = new ArrayList();
        Map<String,Object> map=new HashMap<>();
        List<Warehouse> warehouses = iwarehouseDao.queryAllByPage();
        map.put("warehouses",warehouses);
        if(warehouses!=null){
            for(Warehouseallocationdetail i : warehouseallocationdetails){
                StockNumberVo stockNumberVo = new StockNumberVo();
                stockNumberVo.setProName(i.getProductspecification().getProName());
                stockNumberVo.setDnumber(i.getWadQuantity());
                List list2= new ArrayList();
                for(Warehouse w:warehouses){
                    Stock stock = istockDao.queryStockByWarehouseAndSpeId(i.getProductspecification().getSpeId(),w.getWarehouseId());
                    if(stock!=null){
                        list2.add(stock.getStockQuantity());
                    }else{
                        list2.add(0);
                    }
                }
                stockNumberVo.setPnumber(list2);
                list.add(stockNumberVo);
            }
            map.put("list",list);
        }
        return map;
    }



}
