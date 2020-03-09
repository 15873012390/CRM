package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Customercare;
import com.zktr.crmproject.service.HTCustomerCareService;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HTCustomerCareController {
    @Autowired
    private HTCustomerCareService customerCareService;

    @GetMapping("/queryAllCustomerCareByPage")
    public Pager<Customercare> queryAllCustomerCareByPage(Integer curpage,Integer pagesize){
        return customerCareService.queryAllCustomerCareByPage(curpage,pagesize);
    }

    @PostMapping("/addOrEditCustomerCare")
    public Result addOrEditCustomerCare(@RequestBody Customercare customercare){
        customerCareService.addAndEditCustomerCare(customercare);
        return Result.SUCCESS;
    }

    @DeleteMapping("/deleteByCcId")
    public Result deleteByCcId(Integer ccId){
        customerCareService.deleteByCcId(ccId);
        return Result.SUCCESS;
    }

    @PostMapping("/deleteByCcIds")
    public Result deleteByCcIds(@RequestBody Integer[] ccIds){
        customerCareService.deleteByCcIds(ccIds);
        return Result.SUCCESS;
    }

    @GetMapping("/queryCustomerCareByCcId")
    public Customercare queryCustomerCareByCcId(Integer ccId){
        return customerCareService.queryCustomerCareByCcId(ccId);
    }

}
