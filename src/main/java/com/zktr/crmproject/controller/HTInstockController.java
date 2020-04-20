package com.zktr.crmproject.controller;

import com.zktr.crmproject.dao.mybatis.HTIWarehouseDao;
import com.zktr.crmproject.pojos.Instock;
import com.zktr.crmproject.pojos.Instockdetail;
import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.service.HTInstockService;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HTInstockController {
    @Autowired
    private HTInstockService instockService;


    @GetMapping("/queryAllInstockByPage")
    public Pager<Instock> queryAllInstockByPage(Integer curpage,Integer pagesize){
        return instockService.queryAllInstockByPage(curpage,pagesize);
    }


    @PostMapping("/insertInstock")
    public Result insertInstock(@RequestBody Instock instock){
        instockService.insertInstock(instock);
        return Result.SUCCESS;
    }
    @PostMapping("/updateInstock")
    public Result updateInstock(@RequestBody Instock instock){
        instockService.updateInstock(instock);
        return Result.SUCCESS;
    }


    @DeleteMapping("/deleteByInstockId")
    public Result deleteByInstockId(Integer insId){
        instockService.deleteByInstockId(insId);
        return Result.SUCCESS;
    }

    @GetMapping("/updateInstockStatus")
    public Result updateInstockStatus(Integer insId,Integer type,String uName){
        instockService.updateInstockStatus(insId,type,uName);
        return Result.SUCCESS;
    }

    @GetMapping("/queryInstockByInstock")
    public Instock queryInstockByInstock(Integer insId){
        return instockService.queryInstockByInsId(insId);
    }

    @GetMapping("/queryInstockSelectAndInputByPage")
    public Pager<Instock> queryInstockSelectAndInputByPage(String value, String input, String select, Integer curpage, Integer pagesize){
        return instockService.queryInstockSelectAndInputByPage(value, input, select, curpage, pagesize);
    }

    @GetMapping("/queryAllProductByInstockDetail")
    public List<Product> queryAllProductByInstockDetail(){
        return instockService.queryAllProductByInstockDetail();
    }

    @PostMapping("/queryInstockByAdvancedSearch")
    public Pager<Instock> queryInstockByAdvancedSearch(@RequestBody InstockAdvancedSearch ias){
        return instockService.queryInstockByAdvancedSearch(ias);
    }

    @GetMapping("/queryInstockDetailByInsId")
    public List<Instockdetail> queryInstockDetailByInsId(Integer insId){
        return instockService.queryInstockDetailByInsId(insId);
    }

    @PostMapping("/addorEditInstockdetails")
    public void addorEditInstockdetails(@RequestBody InstockDetailVo instockDetailVo){
        instockService.addorEditInstockdetails(instockDetailVo);
    }

    @PostMapping("/addInstockDemand")
    public Result addInstockDemand(@RequestBody List<ProductDemandVo> productDemandVos){
        instockService.addInstockDemand(productDemandVos);
        return Result.SUCCESS;
    }



}

