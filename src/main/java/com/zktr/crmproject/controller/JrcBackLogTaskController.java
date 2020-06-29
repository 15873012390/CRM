package com.zktr.crmproject.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.Page;
import com.zktr.crmproject.pojos.Backlogtask;
import com.zktr.crmproject.pojos.Backlogtaskdetails;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.service.JrcBackLogTaskService;
import com.zktr.crmproject.utils.ExcelUtils;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class JrcBackLogTaskController {
    @Autowired
    private JrcBackLogTaskService backLogTaskService;

    @GetMapping("/owner_backlogtask_queryall_bypage")
    @ResponseBody
    public Pager<Backlogtask> queryAllByPage(int curpage,int pagesize){
        return backLogTaskService.queryAllByPage(curpage,pagesize);
    }

    @GetMapping("/ower_backlogtask_queryall_bylikepage")
    @ResponseBody
    public Pager<Backlogtask> queryLikeBackTaskLog(int curpage,int pagesize,String value,String input,String select){
        return backLogTaskService.queryLikeBackTaskLog(curpage,pagesize,value,input,select);
    }

    @PostMapping("/ower_backlogtask_queryadvendce")
    @ResponseBody
    public Pager<Backlogtask> queryAdvendceBackTaskLog(@RequestBody JrcBackLogTaskAdvancedSearch backLogTaskAdvancedSearch){
        System.out.println(backLogTaskAdvancedSearch.toString());
        return backLogTaskService.queryAdvendceBackTaskLog(backLogTaskAdvancedSearch);
    }

    @GetMapping("/ower_query_all_customer")
    @ResponseBody
    public List<Customer> queryAllCustomer(){
        return backLogTaskService.queryAllCustomer();
    }

    @GetMapping("/ower_queryall_contact_by_cusid")
    @ResponseBody
    public Customer queryAllContactByCusid(Integer cusid){
        return backLogTaskService.queryAllContactByCusid(cusid);
    }

    @GetMapping("/query_all_backLogTask_bycusId")
    @ResponseBody
    public Pager<Backlogtask> queryAllBackLogTaskByCusId(Integer cusId,Integer curpage,Integer pagesize){
        return backLogTaskService.queryAllBackLogTaskByCusId(cusId,curpage,pagesize);
    }

    @GetMapping("/push_backLogTask_by_cusid")
    @ResponseBody
    public List<Backlogtask> pushBackLogTask(Integer cusId){
        return backLogTaskService.pushBackLogTask(cusId);
    }

    @PostMapping("/add_backlogtask_and_detail")
    @ResponseBody
    public Result AddBackLogTaskAndDetail(@RequestBody BackLogTaskVo backLogTaskVo){
        return  backLogTaskService.AddBackLogTaskAndDetail(backLogTaskVo);
    }

    @GetMapping("/query_back_log_task_by_bltid")
    @ResponseBody
    public Map queryBackLogTaskByBltId(Integer bltid){
        return backLogTaskService.queryBackLogTaskByBltId(bltid);
    }

    @GetMapping("/finish_back_task_edit_details")
    @ResponseBody
    public Result finishBackTaskEditDetails(Integer bltid){
        return backLogTaskService.finishBackTaskEditDetails(bltid);
    }

    @GetMapping("/del_back_log_task_by_bltId")
    @ResponseBody
    public Result delBackLogTaskByBltId(Integer bltid){
        return backLogTaskService.delBackLogTaskByBltId(bltid);
    }

    @PostMapping("/del_backlogtask_by_bltid_all")
    @ResponseBody
    public Result delBackLogTaskByBltIdAll(@RequestBody Integer[] bltids){
        return backLogTaskService.delBackLogTaskByBltIdAll(bltids);
    }


    @PostMapping("/out_backLogTask")
    @ResponseBody
    public Map outBackLogTask(MultipartFile file){
        List<OutBackLogTaskVo> outBackLogTaskVos= ExcelUtils.importData(file,1,OutBackLogTaskVo.class);
        return backLogTaskService.outBackLogTask(outBackLogTaskVos);
    }

    @GetMapping("/query_cur_month")
    @ResponseBody
    public List<Backlogtask> queryCurMonth(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startStr,@DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
        return backLogTaskService.queryCurMonth(startStr,end);
    }

    @GetMapping("/querybaklogtask_detailsbyuid_finsh")
    @ResponseBody
    public List<Backlogtask> queryBakLogTaskDetailsByUidFinsh(Integer op,Integer uid){
        return backLogTaskService.queryBakLogTaskDetailsByUidFinsh(op,uid);
    }
}

