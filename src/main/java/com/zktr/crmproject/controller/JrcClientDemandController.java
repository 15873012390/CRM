package com.zktr.crmproject.controller;

import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.pojos.Clientdemand;
import com.zktr.crmproject.service.JrcClientDemandService;
import com.zktr.crmproject.vo.JrcClientDemandAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class JrcClientDemandController {

    @Autowired
    private JrcClientDemandService clientDemandService;

    @GetMapping("/query_all_client_demand")
    @ResponseBody
    public Pager queryAllClientDemand(int curpage, int pagesize){
        return clientDemandService.queryAllClientDemand(curpage,pagesize);
    }

    @PostMapping("/add_client_demand")
    @ResponseBody
    public Result addClientDemand(@RequestBody Clientdemand clientdemand){
        return clientDemandService.addClientDemand(clientdemand);
    }

    @GetMapping("/query_client_demand_by_cdId")
    @ResponseBody
    public Clientdemand queryClientDemandByCdId(Integer cdId){
        return clientDemandService.queryClientDemandByCdId(cdId);
    }

    @GetMapping("/query_client_demand_by_like")
    @ResponseBody
    public Pager queryClentDemandByLike(int curpage,int pagesize,String value,String input){
        return clientDemandService.queryClientDemandByLike(curpage,pagesize,value,input);
    }

    @PostMapping("/query_client_demand_advenced")
    @ResponseBody
    public Pager queryClientDemandAdvenced(@RequestBody JrcClientDemandAdvancedSearch clientDemandAdvancedSearch){
        return clientDemandService.queryClientDemandAdvenced(clientDemandAdvancedSearch);
    }

    @DeleteMapping("/del_client_demand_by_cdid")
    @ResponseBody
    public Result delClientDemandByCdId(Integer cdId){
        return clientDemandService.delClientDemandByCdId(cdId);
    }

    @PostMapping("/del_client_demand_by_cdid_all")
    @ResponseBody
    public Result delClientDemandByCdIdAll(@RequestBody Integer[] cdids){
        return clientDemandService.delClientDemandByCdIdAll(cdids);
    }

}
