package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Instockdetail;
import com.zktr.crmproject.pojos.Outstockdetails;
import com.zktr.crmproject.pojos.Stock;
import com.zktr.crmproject.pojos.Warehouseallocationdetail;
import com.zktr.crmproject.service.HTStockService;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.ProductDemandVo;
import com.zktr.crmproject.vo.Result;
import com.zktr.crmproject.vo.StockAdvancedSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/queryIsBigStock")
    public List<ProductDemandVo> queryIsBigStock(@RequestBody List<Outstockdetails> outstockdetails){
        return stockService.queryIsBigStock(outstockdetails);
    }

    @GetMapping("/queryStockByWarehouseAndSpeId")
    public Stock queryStockByWarehouseAndSpeId(Integer speId,Integer warehouseId){
        return  stockService.queryStockByWarehouseAndSpeId(speId,warehouseId);
    }
    @PostMapping("/queryStockByAllWarehouse")
    public Map<String,Object> queryStockByAllWarehouse(@RequestBody List<Warehouseallocationdetail> warehouseallocationdetails){
        return stockService.queryByAllWarehouse(warehouseallocationdetails);
    }


}
