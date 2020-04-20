package com.zktr.crmproject.controller;

import com.zktr.crmproject.service.JrcAuditAndDetailsService;
import com.zktr.crmproject.vo.JrcAuditAndDetailsAdd;
import com.zktr.crmproject.vo.Result;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JrcAuditAndDetailsController {
    @Autowired
    private JrcAuditAndDetailsService auditAndDetailsService;

    @PostMapping("/add_audit_and_details")
    @ResponseBody
    public Result addAuditAndDetails(@RequestBody JrcAuditAndDetailsAdd auditAndDetailsAdd){
        return auditAndDetailsService.addAuditAndDetails(auditAndDetailsAdd);
    }

}
