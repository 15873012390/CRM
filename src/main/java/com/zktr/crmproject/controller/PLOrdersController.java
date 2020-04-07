package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.service.PLOrdersService;
import com.zktr.crmproject.vo.*;
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
    public Pager<Orders> queryAllOrders(int curpage, int pagesize){
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
    public Integer saveAddress(@RequestBody Address address){
        return oservice.saveAddress(address);
    }

    @GetMapping("/findByOrdid")
    public Orders findByOrdid(Integer ordid){
        return oservice.findByOrdid(ordid);
    }

    @GetMapping("/findByAddid")
    public Address findByAddid(Integer addid){
        return oservice.findByAddid(addid);
    }

    @GetMapping("/delOrdersById")
    public Result delOrdersById(Integer ordid){
        //System.out.println(ordid);
        oservice.delOrdersById(ordid);
        return Result.SUCCESS;
    }
    @PostMapping("/BatchOrdids")
    public Result BatchOrdids(@RequestBody Integer[] ordids){
        oservice.BatchOrdids(ordids);
        return Result.SUCCESS;
    }

    @GetMapping("/queryByLikeQuery")
    public Pager<Orders> queryByLikeQuery(int curpage, int pagesize, String select, String value, String input1){
        //System.out.println("ssssss"+value);
        return oservice.queryByLikeQuery(curpage,pagesize,select,value,input1);
    }
    @PostMapping("/OrdersAdvancedSearch")
    public Pager<Orders> OrdersAdvancedSearch(@RequestBody PLOdersAdvancedSearch plOdersAdvancedSearch){
        for(String s: plOdersAdvancedSearch.getAddProvince()){
            System.out.println(s);
        }
        System.out.println(plOdersAdvancedSearch.toString());
        return oservice.OrdersAdvancedSearch(plOdersAdvancedSearch);
    }
    @PostMapping("/insetOdersDetail")
    public Result insetOdersDetail(@RequestBody PLordersDetailVo pLordersDetailVo){
        oservice.addAndEditOrderDdetail(pLordersDetailVo);
        return Result.SUCCESS;
    }
    @GetMapping("/queryOrderdetailByOrdId")
    public List<Orderdetail> queryOrderdetailByOrdId(Integer ordid){
        return oservice.queryOrderdetailByOrdid(ordid);
    }

}
