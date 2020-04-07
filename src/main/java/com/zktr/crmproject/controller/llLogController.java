package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Log;
import com.zktr.crmproject.service.llLogService;
import com.zktr.crmproject.vo.MyLog;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class llLogController {
    @Autowired
    private llLogService llLogService;
    //获取所有日志信息
//    @MyLog(value = "获取所有日志信息")
    @GetMapping("/findAllLog")
    public Pager<Log> findAllLog(Integer curpage, Integer pagesize){
        System.out.println(curpage+pagesize);
        return llLogService.findAllLogs(curpage, pagesize);
    }
}
