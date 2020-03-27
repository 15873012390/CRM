package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Productclassification;
import com.zktr.crmproject.service.PLProductClassificationService;
import com.zktr.crmproject.service.PLproductService;
import com.zktr.crmproject.vo.PLClassificationResponse;
import com.zktr.crmproject.vo.PLTreeUtils;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification")
public class PLProductClassificationController {
    @Autowired
    private PLProductClassificationService ppcservice;

    @RequestMapping("/queryAllClassification")
    public PLClassificationResponse queryAllClassification(){
        return ppcservice.getAllClassification();
    }

    @RequestMapping("/queryall")
    public List<Productclassification> queryall(){
        return ppcservice.queryall();
    }

    @RequestMapping("/query_by_node")
    public List<PLTreeUtils> cateList() throws Exception {
        List<Productclassification> productclassifications=ppcservice.queryall();
        List<PLTreeUtils> treeList=PLTreeUtils.getTreeList(productclassifications,"claId","claIdId","claName");
        return treeList;
    }

    @PostMapping("/add_cla")
    public Result addAndEditCla(@RequestBody Productclassification productclassification){
        ppcservice.addClassification(productclassification);
        return Result.SUCCESS;
    }
    @RequestMapping("/edit_cla")
    public Result editCla(Integer claid,String claName){
        ppcservice.updateClassification(claid,claName);
        return Result.SUCCESS;
    }
    @DeleteMapping("/del_cla")
    public Result delCla(Integer claid){
        ppcservice.delClassification(claid);
        return Result.SUCCESS;
    }


}
