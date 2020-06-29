package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Solution;
import com.zktr.crmproject.service.JrcSolutionService;
import com.zktr.crmproject.vo.JrcSolutionAdvenceSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JrcSolutionController {

    @Autowired
    private JrcSolutionService solutionService;

    @GetMapping("/query_solution_all_by_page")
    @ResponseBody
    public Pager querySolutionAllByPage(int curpage, int pagesize){
        return solutionService.querySolutionAllByPage(curpage,pagesize);
    }

    @GetMapping("/query_solution_by_like")
    @ResponseBody
    public Pager querySolutionByLike(int curpage,int pagesize,String them){
        return solutionService.querySolutionByLike(curpage,pagesize,them);
    }

    @PostMapping("/query_solution_by_adven_search")
    @ResponseBody
    public Pager querySolutionByAdvenSearch(@RequestBody JrcSolutionAdvenceSearch solutionAdvenceSearch){
        return solutionService.querySolutionByAdvenSearch(solutionAdvenceSearch);
    }

    @GetMapping("/query_solution_by_id")
    @ResponseBody
    public Solution querySolutionById(Integer solId){
        return solutionService.querySolutionById(solId);
    }

    @PostMapping("/add_solution")
    @ResponseBody
    public Result addSolution(@RequestBody Solution solution){
        return solutionService.addSolution(solution);
    }

    @DeleteMapping("/del_solution_by_id")
    @ResponseBody
    public Result delSolutionById(Integer solId){
        return solutionService.delSolutionById(solId);
    }

    @PostMapping("/del_solution_all")
    @ResponseBody
    public Result del(@RequestBody Integer[] solIds){
        return solutionService.delSolutionAll(solIds);
    }


    @GetMapping("/flash_solution_bysoid")
    @ResponseBody
    public List<Solution> flashSolutionBySoid(Integer soId){
        return solutionService.flashSolutionBySoid(soId);
    }

}
