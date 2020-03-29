package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTInstockDao;
import com.zktr.crmproject.dao.jpa.HTStockDao;
import com.zktr.crmproject.dao.mybatis.HTIInstockDao;
import com.zktr.crmproject.dao.mybatis.HTIStockDao;
import com.zktr.crmproject.dao.mybatis.HTIWarehouseDao;
import com.zktr.crmproject.dao.mybatis.PLproductMDao;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.InstockAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class HTInstockService {

    @Autowired
    private HTIInstockDao iIstockDao;
    @Autowired
    private PLproductMDao iproductMDao;
    @Autowired
    private HTIStockDao istockDao;
    @Autowired
    private HTStockDao stockDao;


    /**
     * 分页查询所有的入库
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Instock> queryAllInstockByPage(Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Instock> list = iIstockDao.selectAllInstock();
        PageInfo<Instock> pager = new PageInfo<>(list);
        return new Pager<Instock>(pager.getList().size(),pager.getList());
    }



    /**
     * 添加入库信息
     * @param instock
     */
    public void insertInstock(Instock instock){
        instock.setStatus("未入库");
        iIstockDao.insertInstock(instock);
    }

    /**
     * 修改入库信息
     * @param instock
     */
    public void updateInstock(Instock instock){
        iIstockDao.updateInstock(instock);
    }

    /**
     * 删除入库单
     * @param
     */
    public void deleteByInstockId(Integer instockId){
        iIstockDao.deleteInstockById(instockId);
        iIstockDao.deleteInstockDetailById(instockId);
    }

    /**
     * 修改入库状态
     * @param insId
     */
    public void updateInstockStatus(Integer insId,Integer type){
        Instock instock = iIstockDao.queryByInsId(insId);
        ////如type=1，则辙销入库
        if(type==1){
            instock.setStatus("未入库");
            iIstockDao.updateInstock(instock);
            List<Instockdetail> instockdetails = iIstockDao.queryInstockDetailByInsId(insId);
            for(Instockdetail ins : instockdetails){
                ins.setStatus("未入库");
                iIstockDao.updateInstockDetail(ins);
                Integer num = istockDao.queryQuantityBySpeId(ins.getProductspecification().getSpeId()).getStockQuantity();
                istockDao.updatestockQuantity((num - ins.getInsdQuantity()), ins.getProductspecification().getSpeId());
            }
        }else{
            instock.setStatus("已入库");
            iIstockDao.updateInstock(instock);
            List<Instockdetail> instockdetails = iIstockDao.queryInstockDetailByInsId(insId);
            for(Instockdetail ins : instockdetails){
                ins.setStatus("已入库");
                iIstockDao.updateInstockDetail(ins);
                Stock s1 = istockDao.queryQuantityBySpeId(ins.getProductspecification().getSpeId());
                if(s1!=null){
                    Integer num = istockDao.queryQuantityBySpeId(ins.getProductspecification().getSpeId()).getStockQuantity();
                    istockDao.updatestockQuantity((num + ins.getInsdQuantity()), ins.getProductspecification().getSpeId());
                }else{
                    Stock stock = new Stock();
                    stock.setProductspecification(ins.getProductspecification());
                    stock.setWarehouse(instock.getWarehouse());
                    stock.setStockQuantity(ins.getInsdQuantity());
                    stockDao.save(stock);
                }

            }
        }
    }

    /**
     * 查询入库单
     * @param insId
     * @return
     */
    public Instock queryInstockByInsId(Integer insId){
        return iIstockDao.queryByInsId(insId);
    }

    /**
     * 分页显示入库页面
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Instock> queryInstockSelectAndInputByPage(String value, String input, String select, Integer curpage, Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Instock> clist = iIstockDao.querySelectAndInputByPage(value,"%"+input.trim()+"%",select);
        PageInfo<Instock> pager = new PageInfo<>(clist);
        return new Pager<Instock>(pager.getList().size(),pager.getList());
    }

    /**
     * 查询全部产品
     * @return
     */
    public List<Product> queryAllProductByInstockDetail(){
        return iproductMDao.queryAllProduct();
    }

    /**
     * 高级查询入库
     * @param ias
     * @return
     */
    public Pager<Instock> queryInstockByAdvancedSearch(InstockAdvancedSearch ias){
        PageHelper.startPage(ias.getCurPage(),ias.getPageSize());
        if(ias.getFillTime()!=null && ias.getFillTime().length!=0){
            ias.setS1(ias.getFillTime()[0]);
            ias.setS1(ias.getFillTime()[0]);
        }
       if(ias.getExecutionTime()!=null && ias.getExecutionTime().length!=0){
           ias.setS3(ias.getExecutionTime()[0]);
           ias.setS4(ias.getExecutionTime()[1]);
       }
        List<Instock> list = iIstockDao.queryInstockByAdvancedSearch(ias);
        PageInfo<Instock> pager = new PageInfo<>(list);
        return new Pager<Instock>(pager.getTotal(),pager.getList());
    }

    /**
     * 通过入库单查询入库详情
     * @param insId
     * @return
     */
    public List<Instockdetail> queryInstockDetailByInsId(Integer insId){
        return iIstockDao.queryInstockDetailByInsId(insId);
    }

    /**
     * 编辑或编辑入库详情单
     * @param instockdetails
     */
    public void addorEditInstockdetails(List<Instockdetail> instockdetails){
        for(Instockdetail insd : instockdetails){
            if(insd.getInsdId()==0){
                iIstockDao.insertInstockDetail(insd);
            }else{
                iIstockDao.updateInstockDetail(insd);
            }
        }
    }




}
