package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Complaint;
import com.zktr.crmproject.pojos.Customercare;
import com.zktr.crmproject.service.HTComplaintService;
import com.zktr.crmproject.vo.ComplaintAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HTComplaintController {
    @Autowired
    private HTComplaintService complaintService;

    @GetMapping("/queryComplaintByPage")
    public Pager<Complaint> queryComplaintByPage(Integer curpage,Integer pagesize){
        return complaintService.queryAllComplaintByPage(curpage,pagesize);
    }

    @PostMapping("/queryComplaintByAdvancedSearch")
    public Pager<Complaint> queryComplaintByAdvancedSearch(@RequestBody ComplaintAdvancedSearch cas){
        return complaintService.queryComplaintByAdvancedSearch(cas);
    }

    @GetMapping("/queryLikeComplaint")
    public Pager<Complaint> queryLikeComplaint(Integer curpage, Integer pagesize, String value, String input, String select){
        return complaintService.queryLikeComplaint(value,input,select,curpage,pagesize);
    }

    @PostMapping("/addOrEditComplaint")
    public Result addOrEditComplaint(@RequestBody Complaint complaint){
        complaintService.addAndEditComplaint(complaint);
        return Result.SUCCESS;
    }

    @DeleteMapping("/deleteByComId")
    public Result deleteByComId(Integer comId){
        complaintService.deleteByComId(comId);
        return Result.SUCCESS;
    }

    @PostMapping("/deleteByComIds")
    public Result deleteByComIds(@RequestBody Integer[] comIds){
        complaintService.deleteByComIds(comIds);
        return Result.SUCCESS;
    }

    @GetMapping("/queryComplaintByComId")
    public Complaint queryComplaintByComId(Integer comId){
        return complaintService.queryComplaintByComId(comId);
    }

}
