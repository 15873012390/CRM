package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Warehouseallocation;
import com.zktr.crmproject.service.HTWarehouseallocationService;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HTWarehouseallocationController {
    @Autowired
    private HTWarehouseallocationService warehouseallocationService;

    @GetMapping("/selectWaByPage")
    public Pager<Warehouseallocation> selectWaByPage(Integer curpage, Integer pagesize){
        return warehouseallocationService.selectWaByPage(curpage, pagesize);
    }

    @PostMapping("/addAndEditWahouseallocation")
    public Result addAndEditWahouseallocation(@RequestBody Warehouseallocation warehouseallocation){
        warehouseallocationService.addAndEditWahouseallocation(warehouseallocation);
        return Result.SUCCESS;
    }

    @GetMapping("/queryWaByWaId")
    public Warehouseallocation queryWaByWaId(Integer waId){
        return warehouseallocationService.queryWaByWaId(waId);
    }

    @GetMapping("/queryWarehouseallocationBySelectAndInput")
    public Pager<Warehouseallocation> queryWarehouseallocationBySelectAndInput(String value, String input, String select, Integer curpage, Integer pagesize) {
        return warehouseallocationService.queryBySelectAndInput(value, input, select, curpage, pagesize);
    }

    @PostMapping("/queryWasehouseAllocationConditionByPage")
    public Pager<Warehouseallocation> queryWasehouseAllocationConditionByPage(@RequestBody WarehouseallocationAdvancedSearch waas){
        return warehouseallocationService.queryConditionByPage(waas);
    }

    @DeleteMapping("/deleteWaByWaId")
    public Result  deleteWaByWaId(Integer waId){
        warehouseallocationService.deleteWaByWaId(waId);
        return Result.SUCCESS;
    }

    @PostMapping("/addWaDemand")
    public void addWaDemand(@RequestBody List<ProductDemandVo> productDemandVos){
        warehouseallocationService.addWaDemand(productDemandVos);
    }

    @PostMapping("/addAndEditWad")
    public void addAndEditWad(@RequestBody WarehouseallocationdetailVo warehouseallocationdetailVos){
        warehouseallocationService.addAndEditWad(warehouseallocationdetailVos);
    }

    @GetMapping("/toConfirm")
    public void toConfirm(Integer waId,Integer type,Integer uId){
        warehouseallocationService.toConfirm(waId,type,uId);
    }

    @GetMapping("/toOutAndInStock")
    public String toOutAndInStock(Integer waId,String uName){
        return warehouseallocationService.toOutAndInStock(waId,uName);
    }

    @GetMapping("/removeWaStatus")
    public String removeWaStatus(Integer waId){
        return warehouseallocationService.removeWaStatus(waId);
    }

}
