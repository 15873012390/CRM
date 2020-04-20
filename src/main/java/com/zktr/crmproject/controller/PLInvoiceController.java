package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Invoice;
import com.zktr.crmproject.pojos.Orders;
import com.zktr.crmproject.service.PLInvoiceService;
import com.zktr.crmproject.vo.PLInvoiceAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invoice")
public class PLInvoiceController {
    @Autowired
    private PLInvoiceService invoiceService;

    @GetMapping("/findAllInvoice")
    public Pager<Invoice> findAllInvoice(int curpage,int pagesize){
        return invoiceService.findAllInvoice(curpage,pagesize);
    }
    @GetMapping("/findAllByInvId")
    public Invoice findAllByInvId(Integer invid){
        return invoiceService.findAllByInvId(invid);
    }
    @GetMapping("/statisticsByMoney")
    public List<Map> statisticsByMoney(){
        return invoiceService.statisticsByMoney();
    }
    @PostMapping("/insertInvoice")
    public Result insertInvoice(@RequestBody Invoice invoice){
        invoiceService.insertInvoice(invoice);
        return Result.SUCCESS;
    }
    @DeleteMapping("/deleteByInvId")
    public Result deleteByInvId(Integer invid){
        invoiceService.deleteByInvId(invid);
        return Result.SUCCESS;
    }
    @PostMapping("/batchByInvId")
    public Result batchByInvId(@RequestBody Integer[] invids){
      invoiceService.batchByInvId(invids);
      return Result.SUCCESS;
    }
    @GetMapping("/findOrdersByCusId")
    public List<Orders> findOrdersByCusId(Integer cusid){
        return invoiceService.findOrdersByCusId(cusid);
    }
    @GetMapping("/queryByLikeQuery")
    public Pager<Invoice> queryByLikeQuery(int curpage,int pagesize,String value,String input){
        return invoiceService.queryByLikeQuery(curpage,pagesize,value,input);
    }
    @PostMapping("/InvoiceAdvancedSearch")
    public Pager<Invoice> InvoiceAdvancedSearch(@RequestBody PLInvoiceAdvancedSearch invoiceAdvancedSearch){
        return invoiceService.InvoiceAdvancedSearch(invoiceAdvancedSearch);
    }

}
