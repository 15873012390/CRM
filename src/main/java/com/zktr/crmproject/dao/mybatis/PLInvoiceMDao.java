package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Invoice;
import com.zktr.crmproject.vo.PLInvoiceAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PLInvoiceMDao {
    public List<Invoice> findAllInvoice();
    public Invoice findAllByInvId(Integer invId);
    public void insertInvoice(Invoice invoice);
    public void updateInvoice(Invoice invoice);
    public void deleteByInvId(Integer invId);
    public void batchByInvId(@Param("invIds") Integer[] invIds);
    public List<Map> statisticsByMoney();
    public List<Invoice> queryByLikeQuery(@Param("value") String value, @Param("input") String input);
    public List<Invoice> InvoiceAdvancedSearch(PLInvoiceAdvancedSearch invoiceAdvancedSearch);
}
