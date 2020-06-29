package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Customer;

import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.JrcSalesopportService;
import com.zktr.crmproject.utils.JrcCharType;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class JrcSalesOpportController {
    @Autowired
    private JrcSalesopportService jrcSalesopportService;

    @GetMapping("/query_all")
    public List<Salesopport> queryAll(){
        return jrcSalesopportService.queryAll();
    }

    @GetMapping("/query_salesopport_by_page")
    public Map querySalesopportByPage(int curpage, int pagesize){
        return jrcSalesopportService.queryAllSalesOppoerByPage(curpage,pagesize);
    }

    @GetMapping("/query_salesopport_by_like_page")
    public Map querySalesopportByLikePage(String value,String input,String select,int curpage,int pagesize){
        return jrcSalesopportService.querySalesOpportByLikeSearchPage(value, input, select, curpage,pagesize);
    }
    @PostMapping("/query_salesopport_by_advanced_search")
    public Map querySalesopportByAdvancedSearch(@RequestBody SalesOpportAdvancedSearch salesOpportAdvancedSearch){
        return jrcSalesopportService.querySalesOpportByAdvancedSearch(salesOpportAdvancedSearch);
    }

    @PostMapping("/add_salesopport")
    public Result addSalesOpport(@RequestBody Salesopport salesopport){
        jrcSalesopportService.addSalesOpport(salesopport);
        return Result.SUCCESS;
    }

    @GetMapping("/query_by_soid")
    public Salesopport queryBySoid(Integer soid){
        return jrcSalesopportService.queryBySoid(soid);
    }


    @GetMapping("/del_salesopport")
    public Result delSalesOpport( Integer soid){
        jrcSalesopportService.delSalesOpport(soid);
        return Result.SUCCESS;
    }

    @PostMapping("/del_batch_salesopport")
    public Result delBatchSalesopport(@RequestBody Integer[] salesopport){
        jrcSalesopportService.delBatchSalesopport(salesopport);
        return Result.SUCCESS;
    }

    @PostMapping("/query_salesopport_funnle")
    public Map querySalesOpportFunnle(@RequestBody List<User> users){
        System.out.println(users.toString());
        return jrcSalesopportService.querySalesOpportFunnle(users);
    }

    @PostMapping("/query_salesopport_by_customer")
    public List<Salesopport> querySalesOpportByCustomer(@RequestBody Customer customer){
        return jrcSalesopportService.querySalesOpportByCustomer(customer);
    }

    @GetMapping("/query_salesopport_by_cusid")
    public List<Salesopport> querySalesOpportByCusId(Integer cusId){
        return jrcSalesopportService.querySalesOpportByCusid(cusId);
    }

    @GetMapping("/query_salesopport_by_forecast")
    public Map querySalesOpportByForecast(@DateTimeFormat(pattern = "yyyy-MM-dd")Date timeStart, @DateTimeFormat(pattern = "yyyy-MM-dd")Date timeEnd, String possibity, Integer status, Integer curpage, Integer pagesize){
        return jrcSalesopportService.querySalesOpportByForecast(timeStart,timeEnd,possibity,status,curpage,pagesize);
    }

    @GetMapping("/query_finalll_sales_opport_by_forecast")
    public Map queryFinalllSalesOpportByForecast(@DateTimeFormat(pattern = "yyyy-MM-dd")Date timeStart,@DateTimeFormat(pattern = "yyyy-MM-dd")Date timeEnd,String possibity,Integer uId,Integer curpage,Integer pagesize){
        return jrcSalesopportService.queryFinalllSalesOpportByForecast(timeStart,timeEnd,uId,possibity,curpage,pagesize);
    }
    @GetMapping("/query_salesEarch1")
    public List<CountPie> querySalesEarch1(Integer op){
        return jrcSalesopportService.querySalesEarch1(op);
    }
    @GetMapping("/query_salesEarch2")
    public CountBar querySalesEarch2(Integer op){
        return jrcSalesopportService.querySalesEarch2(op);
    }

    @GetMapping("/query_salesEarch3")
    public Map   querySalesEarch3(Integer op){
        return jrcSalesopportService.querySalesEarch3(op);
    }
    @PostMapping("/query_salesFunnel1")
    public  List<Map> querySalesFunnel1(@RequestBody JrcSalesFunnelUO s){
        return jrcSalesopportService.querySalesFunnel1(s);
    }
}
