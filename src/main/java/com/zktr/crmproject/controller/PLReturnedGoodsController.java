package com.zktr.crmproject.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zktr.crmproject.pojos.Returnedgoods;
import com.zktr.crmproject.pojos.Warehouse;
import com.zktr.crmproject.service.PLReturnedGoodsService;
import com.zktr.crmproject.vo.PLReturnedGoodsVo;
import com.zktr.crmproject.vo.PLReturnedgoodsAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/returnedgoods")
public class PLReturnedGoodsController {
    @Autowired
    private PLReturnedGoodsService returnedGoodsService;

    @RequestMapping("/insertRG")
    public Result dealService(@RequestBody PLReturnedGoodsVo returnedGoodsVo){
        returnedGoodsService.dealService(returnedGoodsVo);
        return Result.SUCCESS;
    }
    @GetMapping("/statisticsMoney")
    public Map statisticsMoney(Integer senId){
        return returnedGoodsService.statisticsMoney(senId);
    }

    @GetMapping("/findAllWarehouse")
    public List<Warehouse> findAllWarehouse(){
        return returnedGoodsService.findAllWarehouse();
    }
    @GetMapping("/findAllRG")
    public Pager<Returnedgoods> findAllRG(int curpage,int pagesize){
        return returnedGoodsService.findAllRG(curpage,pagesize);
    }
    @GetMapping("/queryByLikeQuery")
    public Pager<Returnedgoods> queryByLikeQuery(int curpage,int pagesize,String value,String input){
        return returnedGoodsService.queryByLikeQuery(curpage,pagesize,value,input);
    }
    @PostMapping("/RGAdvancedSearch")
    public Pager<Returnedgoods> RGAdvancedSearch(@RequestBody PLReturnedgoodsAdvancedSearch returnedgoodsAdvancedSearch) {
        return returnedGoodsService.RGAdvancedSearch(returnedgoodsAdvancedSearch);
    }
    @GetMapping("/statisticsByMoney")
    public List<Map> statisticsByMoney(){
        return returnedGoodsService.statisticsByMoney();
    }
    @PostMapping("/batchByregId")
    public Result batchByregId(@RequestBody Integer[] regId){
        returnedGoodsService.batchByregId(regId);
        return Result.SUCCESS;
    }
}
