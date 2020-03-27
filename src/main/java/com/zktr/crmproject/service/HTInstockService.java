package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTInstockDao;
import com.zktr.crmproject.dao.jpa.HTStockDao;
import com.zktr.crmproject.dao.mybatis.HTIInstockDao;
import com.zktr.crmproject.dao.mybatis.HTIStockDao;
import com.zktr.crmproject.dao.mybatis.HTIWarehouseDao;
import com.zktr.crmproject.dao.mybatis.PLproductMDao;
import com.zktr.crmproject.pojos.Complaint;
import com.zktr.crmproject.pojos.Instock;
import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.pojos.Warehouse;
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
        return new Pager<Instock>(pager.getTotal(),pager.getList());
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
        iIstockDao.updateInvokeStatus(instock);
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
    public void updateInvockStatus(Integer insId){
       Instock instock = iIstockDao.queryByInsId(insId);
        instock.setStatus("未入库");
        iIstockDao.updateInvokeStatus(instock);
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
        return new Pager<Instock>(pager.getTotal(),pager.getList());
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


}
