package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Actionhistory;
import com.zktr.crmproject.pojos.Backlogtask;
import com.zktr.crmproject.pojos.Repair;
import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.service.JrcSalesOpportDetailsService;
import com.zktr.crmproject.vo.BackLogTaskVo;
import com.zktr.crmproject.vo.JrcActionHistoryVo;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@Controller
public class JrcSalesOpportDetailsController {
    @Autowired
    JrcSalesOpportDetailsService backLogTaskService;

    @GetMapping("/query_salesOpport_and_customer_details")
    @ResponseBody
    public Map querySalesOpportAndCustomeDetails(Integer soId,Integer cusId){
        return backLogTaskService.querySalesOpportAndCustomeDetails(soId,cusId);
    }
    @GetMapping("/push_salesOpport_by_soid")
    @ResponseBody
    public Salesopport pushSalesOpport(Integer soId){
        return backLogTaskService.pushSalesOpport(soId);
    }

    @GetMapping("/query_repair_all_by_cusid")
    @ResponseBody
    public List<Repair> queryRepairAllByCusId(Integer cusid){
        return backLogTaskService.queryRepairAllByCusId(cusid);
    }


    @PostMapping("/add_actionhistory_and_details")
    @ResponseBody
    public Result addActionHistory(@RequestBody JrcActionHistoryVo actionHistoryVo){
        System.out.println(actionHistoryVo.toString());
        return backLogTaskService.addActionHistory(actionHistoryVo);
    }

    @GetMapping("/query_action_history_by_ahid")
    @ResponseBody
    public Actionhistory queryActionHistoryByAhid(Integer ahid){
        return backLogTaskService.queryActionHistoryByAhid(ahid);
    }

    @GetMapping("/query_acitonHistory_by_cusid")
    @ResponseBody
    public List<Actionhistory> queryAcitonHistoryByCusid(Integer cusid){
        return backLogTaskService.queryAcitonHistoryByCusid(cusid);
    }

    @GetMapping("/delete_action_history_by_ahid")
    @ResponseBody
    public Result deleteActionHistoryByAhid(Integer ahid){
        return backLogTaskService.deleteActionHistoryByAhid(ahid);
    }

}
