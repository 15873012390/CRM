package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Stock;
import com.zktr.crmproject.service.HTStockService;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import com.zktr.crmproject.vo.StockAdvancedSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HTStockController {

    @Autowired
    private HTStockService stockService;

    @GetMapping("/queryAllStockByPage")
    public Pager<Stock> queryAllStockByPage(Integer curpage, Integer pagesize){
        return stockService.queryAllStockByPage(curpage, pagesize);
    }

    @DeleteMapping("/removeStockisZero")
    public Result removeStockisZero(){
        stockService.removeStockisZero();
        return Result.SUCCESS;
    }

    @PostMapping("/queryStockByAdvanced")
    public Pager<Stock> queryStockByAdvanced(@RequestBody StockAdvancedSearch sas){
        return stockService.queryStockByAdvanced(sas);
    }

    @GetMapping("/queryStockByStockId")
    public Stock queryStockByStockId(Integer stockId){
        return stockService.queryStockByStockId(stockId);
    }

    @GetMapping("/queryQuantityBySpeId")
    public Integer queryQuantityBySpeId(Integer speId){
        return stockService.queryQuantityBySpeId(speId);
    }
}
