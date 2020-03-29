package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.service.PLOrdersService;
import com.zktr.crmproject.vo.*;
import jdk.nashorn.internal.ir.LiteralNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class PLOrdersController {
    @Autowired
    private PLOrdersService oservice;
    @GetMapping("/ordersCountPies")
    public List<PLCountPie> countPies(Integer n){
        return oservice.countPies(n);
    }
    @GetMapping("/ordersCountBar")
    public PLCountBar countBars(Integer n){
        return oservice.countBar(n);
    }
    @GetMapping("/queryAllOrders")
    public Pager<Orders> queryAllOrders(int curpage,int pagesize){
        return oservice.queryAllOrders(curpage,pagesize);
    }
    @GetMapping("/statisticsByMoney")
    public List<Map> statisticsByMoney(){
        return oservice.statisticsByMoney();
    }
    @GetMapping("/queryAllCustomer")
    public List<Customer> queryAllCustomer(){
        return oservice.queryAllCustomer();
    }
    @GetMapping("/queryAllQuote")
    public List<Quote> queryAllQuote(){
        return oservice.queryAllQuote();
    }
    @GetMapping("/findByCusid")
    public Customer findByCusid(Integer cusid){
        return oservice.findByCusid(cusid);
    }
    @GetMapping("/queryAllUser")
    public List<User> queryAllUser(){
        return oservice.queryAllUser();
    }
    @PostMapping("/insertOrders")
    public Result insertOrders(@RequestBody PLOrdersVo plOrdersVo){

        oservice.insertOrders(plOrdersVo);

        return Result.SUCCESS;
    }

    @PostMapping("/saveAddress")
    public Result saveAddress(@RequestBody PLaddressVo pLaddressVo){
        oservice.saveAddress(pLaddressVo);
        return Result.SUCCESS;
    }

    @GetMapping("/findByOrdid")
    public Orders findByOrdid(Integer ordid){
        return oservice.findByOrdid(ordid);
    }

    @GetMapping("/findByAddid")
    public Address findByAddid(Integer addid){
        return oservice.findByAddid(addid);
    }

    @PostMapping("/delOrdersById")
    public Result delOrdersById(Integer ordid){
        oservice.delOrdersById(ordid);
        return Result.SUCCESS;
    }

}
