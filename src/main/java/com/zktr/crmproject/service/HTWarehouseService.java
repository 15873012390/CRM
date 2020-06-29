package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTWarehouseDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.CustomerServiceAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.WareHouseAdvancedSearch;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.record.DVALRecord;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class HTWarehouseService {
    @Autowired
    private HTWarehouseDao warehouseDao;
    @Autowired
    private HTIWarehouseDao iwarehouseDao;
    @Autowired
    private HTIPurchaseplanDao purchaseplanDao;
    @Autowired
    private HTIOutstockDao iOutstock;
    @Autowired
    private HTIStockDao istockDao;
    @Autowired
    private HTIInstockDao instockDao;
    @Autowired
    private HTIReturnedgoodsDao iReturnedgoodsDao;


    /**
     * 根据仓库ID删除仓库
     * @param warehouseId
     * @return
     */
    public String deleteByWarehouseId(Integer warehouseId){
        Warehouse warehouse=iwarehouseDao.queryByWarehouseId(warehouseId);
        if(warehouse==null){
            return "1";
        }
        if(warehouse.getPurchaseplan()!=null&&warehouse.getPurchaseplan().size()>0){
            return "采购计划有该仓库不能删除！";
        }
        if(warehouse.getInstock()!=null&&warehouse.getInstock().size()>0){
            return "入库单有该仓库不能删除！";
        }
        if(warehouse.getOutstock()!=null&&warehouse.getOutstock().size()>0){
            return "有要出库的产品不能删除";
        }
        if(warehouse.getStock()!=null&&warehouse.getStock().size()>0){
            return "库存有该仓库不能删除";
        }
        if(warehouse.getReturnedgoods()!=null&&warehouse.getReturnedgoods().size()>0){
            return "产品退货有该仓库不能删除";
        }
        //***
        warehouseDao.deleteById(warehouseId);
        return "1";
    }

    /**
     * 批量删除仓库
     * @param ids
     * @return
     */
    public String deleteByWarehouseIds(Integer[] ids){
        for(Integer id:ids){
            Warehouse warehouse = iwarehouseDao.queryByWarehouseId(id);
            if(warehouse.getPurchaseplan()!=null&&warehouse.getPurchaseplan().size()>0){
                return "采购计划有该仓库不能删除！";
            }
            if(warehouse.getInstock()!=null&&warehouse.getInstock().size()>0){
                return "入库单有该仓库不能删除！";
            }
            if(warehouse.getOutstock()!=null&&warehouse.getOutstock().size()>0){
                return "有要出库的产品不能删除";
            }
            if(warehouse.getStock()!=null&&warehouse.getStock().size()>0){
                return "库存有该仓库不能删除";
            }
            if(warehouse.getReturnedgoods()!=null&&warehouse.getReturnedgoods().size()>0){
                return "产品退货有该仓库不能删除";
            }
            warehouseDao.deleteById(id);
        }
        return "1";

    }

    /**
     * 查询所有的仓库
     * @return
     */
    public List<Warehouse> queryAllWarehouse(){
        return iwarehouseDao.queryAllByPage();
    }

    /**
     * 分页显示仓库
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Warehouse> queryAllWarehouseByPage(Integer curpage, Integer pagesize){
        List<Warehouse> list = iwarehouseDao.queryAllByPage();
        List list2 = new ArrayList();
        for(int i = 0; i < pagesize; i ++){
            int index = (curpage - 1) * pagesize + i;
            if(index<list.size()) {
                if(list.get(index)!=null) {
                    list2.add(list.get(index));
                }
            }
        }
        return new Pager<Warehouse>(list.size(),list2);
    }

    /**
     * 保存或编辑仓库
     * @param warehouse
     */
    public void addOreditWarehouse(Warehouse warehouse){
        Warehouse save = warehouseDao.save(warehouse);
    }


    public void updateWarehouse(Warehouse warehouse){
        iwarehouseDao.updateWarehouse(warehouse);
    }

    /**
     * 通过仓库ID查询仓库
     * @param warehouseId
     * @return
     */
    public Warehouse queryByWarehouseId(Integer warehouseId){
        Warehouse warehouse = iwarehouseDao.queryByWarehouseId(warehouseId);
        return iwarehouseDao.queryByWarehouseId(warehouseId);
    }

    /**
     * 高级查询
     * @param was
     * @return
     */
    public Pager<Warehouse> queryConditionByPage(WareHouseAdvancedSearch was){
        PageHelper.startPage(was.getCurPage(),was.getPageSize());
        was.setWarehouseName("%"+was.getWarehouseName()+"%");
        List<Warehouse> list = iwarehouseDao.queryByAdvanced(was);
        PageInfo<Warehouse> pager = new PageInfo<>(list);
        return new Pager<Warehouse>(pager.getTotal(),pager.getList());
    }

    /**
     * 根据 下拉选项以及名称模糊查询
     * @param value
     * @param input
     * @param select
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Warehouse> querySelectOrInputWarehouse(String value,String input,String select,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Warehouse> clist = iwarehouseDao.querySelectOrInput(value,"%"+input.trim()+"%",select);
        PageInfo<Warehouse> pager = new PageInfo<>(clist);
        return new Pager<Warehouse>(pager.getTotal(),pager.getList());
    }

    /**
     * 批量插入
     * @param warehouses
     */
    public void insertAllWarehouse(List<Warehouse> warehouses) {
        for(Warehouse w:warehouses){
            if(w!=null){
                iwarehouseDao.insertWarehouse(w);
            }
        }
    }

    /**
     * 查询是否有相同的仓库名称
     * @param warehouseName
     * @return
     */
    public Integer querySameNameWarehouse(String warehouseName){
        Warehouse warehouse = iwarehouseDao.querySameNameWarehouse(warehouseName);
        if(warehouse!=null){
            return 1;
        }else{
            return 0;
        }
    }




}
