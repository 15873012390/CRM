package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Qa;
import com.zktr.crmproject.service.HTQaService;

import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.QaAdvancedSearch;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HTQaController {
    @Autowired
    private HTQaService qaService;

    @GetMapping("/queryQaByPage")
    public Pager<Qa> queryQaByPage(Integer curpage,Integer pagesize){
        return qaService.queryAllQaByPage(curpage,pagesize);
    }

    @PostMapping("/queryQaByAdvancedSearch")
    public Pager<Qa> queryQaByAdvancedSearch(@RequestBody QaAdvancedSearch qas){
        return qaService.queryQaByAdvancedSearch(qas);
    }

    @GetMapping("/queryLikeQa")
    public Pager<Qa> queryLikeQa(Integer curpage, Integer pagesize, String value, String input, String select){
        System.err.println(value);
        return qaService.queryLikeQa(value,input,select,curpage,pagesize);
    }

    @PostMapping("/addOrEditQa")
    public Result addOrEditQa(@RequestBody Qa Qa){
        qaService.addAndEditQa(Qa);
        return Result.SUCCESS;
    }

    @DeleteMapping("/deleteByQaId")
    public Result deleteByQaId(Integer qaId){
        qaService.deleteByqaId(qaId);
        return Result.SUCCESS;
    }

    @PostMapping("/deleteByQaIds")
    public Result deleteByQaIds(@RequestBody Integer[] qaIds){
        qaService.deleteByqaIds(qaIds);
        return Result.SUCCESS;
    }

    @GetMapping("/queryQaByQaId")
    public Qa queryQaByQaId(Integer qaId){
        return qaService.queryQatByQaId(qaId);
    }

}
