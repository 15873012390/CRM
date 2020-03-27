package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Productspecification;
import com.zktr.crmproject.service.PLProductSepcificationService;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.ProductSpecificationVo;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/sepcification")
@RestController
public class PLProductSepcificationController {
    @Autowired
    private PLProductSepcificationService psService;

    @GetMapping("/query_all_by_proid_page")
    public Pager<Productspecification> queryAllByProidPage(Integer proid,int curpage,int pagesize){
        return psService.queryAllByProid(proid,curpage,pagesize);
    }

    @PostMapping("/add_edit_specification")
    public Result addEditSpecification(@RequestBody ProductSpecificationVo productSpecificationVo){
        psService.addEditSpecification(productSpecificationVo);
        return Result.SUCCESS;
    }
    @GetMapping("/find_by_speid")
    public Productspecification findBySpeid(Integer speid){
       return psService.queryBySepId(speid);
    }

    @DeleteMapping("/del_by_speid")
    public Result delSpe(Integer speid){
        psService.delSpe(speid);
        return Result.SUCCESS;
    }

}
