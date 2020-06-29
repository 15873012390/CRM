package com.zktr.crmproject.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.mybatis.PLIOrdersDao;
import com.zktr.crmproject.dao.mybatis.PLInvoiceMDao;
import com.zktr.crmproject.dao.mybatis.TWCustomerMapperDao;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Invoice;
import com.zktr.crmproject.pojos.Orders;
import com.zktr.crmproject.vo.PLInvoiceAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PLInvoiceService {
    @Autowired
    private PLInvoiceMDao invoiceMDao;
    @Autowired
    private PLIOrdersDao ordersMDao;
    @Autowired
    private TWCustomerMapperDao customerMapperDao;
    /**
     * 查询全部
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Invoice> findAllInvoice(int curpage,int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Invoice> list=invoiceMDao.findAllInvoice();
        PageInfo<Invoice> page=new PageInfo<>(list);
        return new Pager<Invoice>(page.getTotal(),page.getList());
    }

    /**
     * 查找一个对象
     * @param invId
     * @return
     */
    public Invoice findAllByInvId(Integer invId){
        return invoiceMDao.findAllByInvId(invId);
    }

    /**
     * 新增/修改
     * @param invoice
     */
    public void insertInvoice(Invoice invoice){
        if(invoice.getInvId()==0){
            invoiceMDao.insertInvoice(invoice);
        }else {
            invoiceMDao.updateInvoice(invoice);
        }
    }

    /**
     * 删除
     * @param invid
     */
    public void deleteByInvId(Integer invid){
        invoiceMDao.deleteByInvId(invid);
    }

    /**
     * 批量删除
     * @param invIds
     */
    public void batchByInvId(Integer [] invIds){
        try {
            if(invIds.length>0){
                invoiceMDao.batchByInvId(invIds);
            }
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }catch (IncorrectResultSizeDataAccessException e){
            e.printStackTrace();
        }
    }

    /**
     * 统计金额
     * @return
     */
    public List<Map> statisticsByMoney(){
        return invoiceMDao.statisticsByMoney();
    }

    /**
     * 根据客户id查找订单
     * @param cusid
     * @return
     */
    public List<Orders> findOrdersByCusId(Integer cusid){

        return ordersMDao.findOrdersByCusId(cusid);
    }

    /**
     * 根据客户id 查找客户
     * @param cusid
     * @return
     */
    public Customer queryCustomerById(Integer cusid){
        return customerMapperDao.findCustomerById(cusid);
    }

    /**
     * 模糊条件查询
     * @param curpage
     * @param pagesize
     * @param value
     * @param input
     * @return
     */
    public Pager<Invoice> queryByLikeQuery(int curpage,int pagesize,String value,String input){
        PageHelper.startPage(curpage,pagesize);
        String dateInput=input.trim()+"%";
        List<Invoice> list=invoiceMDao.queryByLikeQuery(value,dateInput);
        PageInfo<Invoice> page=new PageInfo<>(list);
        return new Pager<Invoice>(page.getTotal(),page.getList());
    }

    /**
     * 高级查询
     * @param invoiceAdvancedSearch
     * @return
     */
    public Pager<Invoice> InvoiceAdvancedSearch(PLInvoiceAdvancedSearch invoiceAdvancedSearch){
        String uname="%"+invoiceAdvancedSearch.getUname().trim()+"%";
        String remark="%"+invoiceAdvancedSearch.getInvRemark().trim()+"%";
        String content="%"+invoiceAdvancedSearch.getInvContent().trim()+"%";
        invoiceAdvancedSearch.setUname(uname);
        invoiceAdvancedSearch.setInvRemark(remark);
        invoiceAdvancedSearch.setInvContent(content);
        PageHelper.startPage(invoiceAdvancedSearch.getCurpage(),invoiceAdvancedSearch.getPagesize());
        List<Invoice> list=invoiceMDao.InvoiceAdvancedSearch(invoiceAdvancedSearch);
        PageInfo<Invoice> page=new PageInfo<>(list);
        return new Pager<Invoice>(page.getTotal(),page.getList());
    }
}
