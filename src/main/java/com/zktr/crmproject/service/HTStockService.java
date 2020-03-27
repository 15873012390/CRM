package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.mybatis.HTIStockDao;
import com.zktr.crmproject.pojos.Complaint;
import com.zktr.crmproject.pojos.Stock;
import com.zktr.crmproject.pojos.Warehouse;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.StockAdvancedSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class HTStockService {
    @Autowired
    private HTIStockDao istockDao;

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

}
