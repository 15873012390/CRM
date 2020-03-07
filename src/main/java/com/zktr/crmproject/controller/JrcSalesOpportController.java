package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Customer;

import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.JrcSalesopportService;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import com.zktr.crmproject.vo.SalesOpportAdvancedSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class JrcSalesOpportController {
    @Autowired
    private JrcSalesopportService jrcSalesopportService;

    @GetMapping("/query_salesopport_by_page")
    @ResponseBody
    public Pager<Salesopport> querySalesopportByPage(int curpage, int pagesize){
        return jrcSalesopportService.queryAllSalesOppoerByPage(curpage,pagesize);
    }

    @GetMapping("/query_salesopport_by_like_page")
    @ResponseBody
    public Pager<Salesopport> querySalesopportByLikePage(String value,String input,String select,int curpage,int pagesize){
        return jrcSalesopportService.querySalesOpportByLikeSearchPage(value, input, select, curpage,pagesize);
    }

    @GetMapping("/query_customer_all")
    @ResponseBody
    public List<Customer> queryCustomerAll(){
        return jrcSalesopportService.queryAllCustomer();
    }

    @GetMapping("/query_user_all")
    @ResponseBody
    public List<User> queryUserAll(){
        return jrcSalesopportService.queryAllUser();
    }

    @PostMapping("/query_salesopport_by_advanced_search")
    @ResponseBody
    public Pager<Salesopport> querySalesOpportByAdvancedSearch(@RequestBody SalesOpportAdvancedSearch salesOpportAdvancedSearch){
        return jrcSalesopportService.querySalesOpportByAdvancedSearch(salesOpportAdvancedSearch);
    }

    @PostMapping("/add_salesopport")
    @ResponseBody
    public Result addSalesOpport(@RequestBody Salesopport salesopport){
        jrcSalesopportService.addSalesOpport(salesopport);
        return Result.SUCCESS;
    }

    @GetMapping("/query_by_soid")
    @ResponseBody
    public Map queryBySoid(int soid){
        return jrcSalesopportService.queryBySoid(soid);
    }

    @PostMapping("/del_salesopport")
    @ResponseBody
    public Result delSalesOpport(@RequestBody Salesopport salesopport){
        jrcSalesopportService.delSalesOpport(salesopport);
        return Result.SUCCESS;
    }
}
