package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Contacts;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Customerservice;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.HTCustomerServiceService;
import com.zktr.crmproject.vo.CustomerServiceAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class HTCustomerServiceController {
    @Autowired
    private HTCustomerServiceService customerServiceService;

    @ResponseBody
    @GetMapping("/query_all_customerService")
    public List<Customerservice> query_all_customerService(){
        return customerServiceService.findByAllCustomerService();
    }

    @ResponseBody
    @GetMapping("/query_all_customerService_byPage")
    public Pager<Customerservice>  query_all_customerService_byPage(Integer curpage,Integer pagesize){
        Pager<Customerservice> customerservicePager = customerServiceService.queryAllCustomerServiceByPage(curpage, pagesize);
        return customerservicePager;
    }

    @ResponseBody
    @PostMapping("/queryConditionByPage")
    public Pager<CustomerServiceAdvancedSearch> queryConditionByPage(@RequestBody CustomerServiceAdvancedSearch customerServiceAdvancedSearch){
        return customerServiceService.queryConditionByPage(customerServiceAdvancedSearch.getCurPage(),customerServiceAdvancedSearch.getPageSize(),customerServiceAdvancedSearch);
    }

    @ResponseBody
    @GetMapping("/queryLikeCustomerService")
    public Pager<Customerservice> queryLikeCustomerService(Integer curpage,Integer pagesize,String value,String input,String select){
        return customerServiceService.queryLikeCustomerService(value,input,select,curpage,pagesize);
    }

    @ResponseBody
    @PostMapping("/addorEdit_customerService")
    public Result addorEdit_customerService(@RequestBody Customerservice customerservice){
        customerServiceService.addorEditCustomerService(customerservice);
        return Result.SUCCESS;
    }

    @ResponseBody
    @GetMapping("/queryAllCustomer")
    public List<Customer> queryAllCustomer(){
        return customerServiceService.queryAllCustomer();
    }

    @ResponseBody
    @GetMapping("/queryContactsByCusId")
    public List<Contacts> queryContactsByCusId(Integer cusId){
        return customerServiceService.queryContactsByCusId(cusId);
    }

    @ResponseBody
    @GetMapping("/queryAllUser")
    public List<User> queryAllUser(){
        return customerServiceService.queryAllUser();
    }

    @ResponseBody
    @DeleteMapping("/delete_customerSerice")
    public Result deleteCustomerServiceItem(Integer csId){
        customerServiceService.deleteCustomerService(csId);
        return Result.SUCCESS;
    }

    @ResponseBody
    @GetMapping("/queryCustomerServiceByCsId")
    public Customerservice queryByCsId(Integer csId){
        return customerServiceService.queryByCsId(csId);
    }

    @ResponseBody
    @PostMapping("/deleteCustomerServices")
    public Result deleteCustomerServices(@RequestBody  Integer[] ids){
        customerServiceService.deleteCustomerServices(ids);
        return Result.SUCCESS;
    }

}
