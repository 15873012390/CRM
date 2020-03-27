package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.llDeptService;

import com.zktr.crmproject.vo.Result;
import com.zktr.crmproject.vo.UserAndPositionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class llDeptController {
    @Autowired
    private llDeptService llDeptService;
    //获取所有部门信息
    @GetMapping("/findAllDept")
    public List<Department> findAllDept(){
        return llDeptService.findAllDept();
    }
    //增加部门信息
    @PostMapping("/addDept")
    public Integer addDept(@RequestBody Department department){
        Integer i=llDeptService.addDept(department);
        return i>0?1:0;
    }
    //删除部门
    @GetMapping("/deleteDept")
    public Integer deleteDept(Integer dId){
        return llDeptService.deleteDept(dId);
    }
    //遣散部门内所有员工
    @GetMapping("/disbandUsers")
    public Integer disbandUsers(Integer dId){
        return llDeptService.disbandUser(dId);
    }
    //获得所有没有部门的在职员工
    @PostMapping("/queryAtUser")
    public List<User> queryAtUser(){
        return llDeptService.queryAtUser();
    }
    //批量移动员工
    @RequestMapping("/handleBatchMove")
    public Result deleteMore(@RequestBody UserAndPositionParam params){
        //postid是用户数组，uid是部门ID
        llDeptService.MoveUser(params.getPostId(),params.getuId());
        return Result.SUCCESS;
    }
}
