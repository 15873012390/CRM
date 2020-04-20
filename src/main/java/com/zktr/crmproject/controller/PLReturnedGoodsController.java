package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Warehouse;
import com.zktr.crmproject.service.PLReturnedGoodsService;
import com.zktr.crmproject.vo.PLReturnedGoodsVo;
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
}
