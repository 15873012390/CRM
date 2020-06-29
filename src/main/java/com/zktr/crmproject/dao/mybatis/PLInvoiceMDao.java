package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Invoice;
import com.zktr.crmproject.vo.PLInvoiceAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PLInvoiceMDao {
    //查找全部开票记录
    public List<Invoice> findAllInvoice();
    //根据开票id查找开票记录
    public Invoice findAllByInvId(Integer invId);
    //新增
    public void insertInvoice(Invoice invoice);
    //修改
    public void updateInvoice(Invoice invoice);
    //删除
    public void deleteByInvId(Integer invId);
    //批量删除
    public void batchByInvId(@Param("invIds") Integer[] invIds);
    //金额统计
    public List<Map> statisticsByMoney();
    //模糊条件查询
    public List<Invoice> queryByLikeQuery(@Param("value") String value, @Param("input") String input);
    //高级查询
    public List<Invoice> InvoiceAdvancedSearch(PLInvoiceAdvancedSearch invoiceAdvancedSearch);
}
