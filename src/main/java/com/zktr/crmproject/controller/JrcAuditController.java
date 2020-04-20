package com.zktr.crmproject.controller;

import com.github.pagehelper.Page;
import com.zktr.crmproject.pojos.Audit;
import com.zktr.crmproject.service.JrcAuditService;
import com.zktr.crmproject.vo.JrcAdvancedAuditSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JrcAuditController {
    @Autowired
    private JrcAuditService jrcAuditService;

    @GetMapping("/query_all_audit")
    public Pager<Audit> queryAllAudit(Integer curpage, Integer pagesize){
        return jrcAuditService.queryAllAudit(curpage,pagesize);
    }

    @GetMapping("/query_like_audit")
    public Pager<Audit> queryLikeAudit(Integer curpage,Integer pagesize,String value,String input,Integer uId){
        return jrcAuditService.queryLikeAudit(curpage,pagesize,value,input,uId);
    }
    @PostMapping("/query_advance_audit")
    public Pager<Audit> queryAdvanceAudit(@RequestBody JrcAdvancedAuditSearch advancedAuditSearch){
        return jrcAuditService.queryAdvanceAudit(advancedAuditSearch);
    }
    @GetMapping("/queryall_audit_and_auditDetails")
    public Audit queryAllAuditAndAuditDetails(Integer audId){
        return jrcAuditService.queryAllAuditAndAuditDetails(audId);
    }

    @GetMapping("/suggest_audit")
    public Result suggestAudit(Integer audId,String suggest,Integer opreation,Integer uId){
        return jrcAuditService.suggestAudit(audId,suggest,opreation,uId);
    }
}
