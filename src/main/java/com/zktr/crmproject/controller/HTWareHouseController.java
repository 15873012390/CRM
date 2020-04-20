package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Warehouse;
import com.zktr.crmproject.service.HTWarehouseService;
import com.zktr.crmproject.utils.ExcelUtils;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import com.zktr.crmproject.vo.WareHouseAdvancedSearch;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class HTWareHouseController {
    @Autowired
    private HTWarehouseService warehouseService;

    @GetMapping("/queryAllWarehouseByPage")
    public Pager<Warehouse> queryAllWarehouseByPage(Integer curpage, Integer pagesize){
       return warehouseService.queryAllWarehouseByPage(curpage,pagesize);
    }

    @DeleteMapping("/deleteByWarehouseId")
    public String deleteByWarehouseId(Integer warehouseId){
        return warehouseService.deleteByWarehouseId(warehouseId);
    }

    @PostMapping("/addOrEditWarehouse")
    public Result addOrEditWarehouse(@RequestBody Warehouse warehouse){
        warehouseService.addOreditWarehouse(warehouse);
        return Result.SUCCESS;
    }

    @PostMapping("/updateWarehouse")
    public Result updateWarehouse(@RequestBody Warehouse warehouse){
        warehouseService.updateWarehouse(warehouse);
        return Result.SUCCESS;
    }

    @GetMapping("/queryByWarehouseId")
    public Warehouse queryByWarehouseId(Integer warehouseId){
        return warehouseService.queryByWarehouseId(warehouseId);
    }

    @PostMapping("/deleteByWarehouseIds")
    public String deleteByWarehouseIds(@RequestBody Integer[] ids){
        return warehouseService.deleteByWarehouseIds(ids);
    }

    @PostMapping("/queryWarehouseAdvanced")
    public Pager<Warehouse> queryWarehouseAdvanced(@RequestBody WareHouseAdvancedSearch wds){
        return warehouseService.queryConditionByPage(wds);
    }

    @GetMapping("/querySelectOrInputWarehouse")
    public Pager<Warehouse> querySelectOrInputWarehouse(Integer curpage, Integer pagesize, String value, String input, String select){
        return warehouseService.querySelectOrInputWarehouse(value,input,select,curpage,pagesize);
    }

    @PostMapping("/importWarehouse")
    public String impUser(MultipartFile file){
        List<Warehouse> warehouses = ExcelUtils.importData(file, 1, Warehouse.class);
        if(warehouses!=null){
            warehouseService.insertAllWarehouse(warehouses);
        }else{
            return "false";
        }
        return "success";
    }

    @GetMapping("/queryAllWarehouse")
    public List<Warehouse> queryAllWarehouse(){
        return warehouseService.queryAllWarehouse();
    }






 }
