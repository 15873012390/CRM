package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Customer;

import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.JrcSalesopportService;
import com.zktr.crmproject.utils.JrcCharType;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import com.zktr.crmproject.vo.SalesOpportAdvancedSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/query_salesopport_by_advanced_search")
    @ResponseBody
    public Pager<Salesopport> querySalesopportByAdvancedSearch(@RequestBody SalesOpportAdvancedSearch salesOpportAdvancedSearch){
        System.out.println(salesOpportAdvancedSearch.toString());
        return jrcSalesopportService.querySalesOpportByAdvancedSearch(salesOpportAdvancedSearch);
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

    @PostMapping("/add_salesopport")
    @ResponseBody
    public Result addSalesOpport(@RequestBody Salesopport salesopport){
        jrcSalesopportService.addSalesOpport(salesopport);
        return Result.SUCCESS;
    }

    @GetMapping("/query_by_soid")
    @ResponseBody
    public Salesopport queryBySoid(Integer soid){
        return jrcSalesopportService.queryBySoid(soid);
    }


    @GetMapping("/del_salesopport")
    @ResponseBody
    public Result delSalesOpport( Integer soid){
        jrcSalesopportService.delSalesOpport(soid);
        return Result.SUCCESS;
    }

    @PostMapping("/del_batch_salesopport")
    @ResponseBody
    public Result delBatchSalesopport(@RequestBody Integer[] salesopport){
        jrcSalesopportService.delBatchSalesopport(salesopport);
        return Result.SUCCESS;
    }

    @PostMapping("/query_salesOpport_byStage_number")
    @ResponseBody
    public List<JrcCharType> querySalesOpportByStageNumber(@RequestBody List<User> users){
        return jrcSalesopportService.querySalesOpportByStageNumber(users);
    }

    @PostMapping("/query_salesOpport_byStage_signMoney")
    @ResponseBody
    public List<JrcCharType> querySalesOpportByStageSignMoney(@RequestBody List<User> users){
        return jrcSalesopportService.querySalesOpportByStageSignMoney(users);
    }

//    @PostMapping("/query_salesOpport_byStage_generneDate")
//    @ResponseBody
//    public Map querySalesOpportByStageGenerneDate(@RequestBody List<User> users){
//
//    }
}
