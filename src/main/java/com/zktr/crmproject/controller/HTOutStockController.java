package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Orders;
import com.zktr.crmproject.pojos.Outstock;
import com.zktr.crmproject.pojos.Outstockdetails;
import com.zktr.crmproject.service.HTOustStockService;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HTOutStockController {

    @Autowired
    private HTOustStockService outStockService;


    @GetMapping("/queryAllOutStockByPage")
    public Pager<Outstock> queryAllOutStockByPage(Integer curpage, Integer pagesize){
        return outStockService.queryAllOutStockByPage(curpage,pagesize);
    }

    @GetMapping("/queryOutstockByOutId")
    public Outstock queryOutstockByOutId(Integer outId){
        return outStockService.queryOutstockByOutId(outId);
    }

    @GetMapping("/queryAllNoOutStock")
    public List<Orders> queryAllNoOutStock(){
        return outStockService.queryAllNoOutStock();
    }

    @PostMapping("/editAndUpdateOutStock")
    public void editAndUpdateOutStock(@RequestBody Outstock outstock){
        outStockService.editAndUpdateOutStock(outstock);
    }

    @GetMapping("/queryAllOutdetailById")
    public List<Outstockdetails> queryAllOutdetailById(Integer outId){
        return outStockService.queryAllOutdetailById(outId);
    }

    @DeleteMapping("/deleteOutStockAndDetail")
    public Result deleteOutStockAndDetail(Integer outId){
        outStockService.deleteOutStockAndDetail(outId);
        return Result.SUCCESS;
    }

    @GetMapping("/updateOutStockStatus")
    public void updateOutStockStatus(Integer outId,Integer type){
        outStockService.updateOutStockStatus(outId,type);
    }

    @PostMapping("/addorEditOutDetails")
    public void addorEditOutDetails(@RequestBody List<Outstockdetails> outstockdetailsList){
        outStockService.addorEditOutDetails(outstockdetailsList);
    }

    @GetMapping("/queryOutStockSelectAndInputByPage")
    public Pager<Outstock> queryOutStockSelectAndInputByPage(String value, String input, String select, Integer curpage, Integer pagesize){
        System.out.println("1111111111111111"+value);
        return outStockService.queryOutStockSelectAndInputByPage(value, input, select, curpage, pagesize);
    }
}
