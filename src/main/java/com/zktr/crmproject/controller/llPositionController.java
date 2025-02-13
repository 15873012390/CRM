package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Position;
import com.zktr.crmproject.pojos.PowerManage;
import com.zktr.crmproject.service.llAuthorityService;
import com.zktr.crmproject.service.llPositionService;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class llPositionController {
    @Autowired
    private llPositionService llPositionService;
    @Autowired
    private llAuthorityService llAuthorityService;
    //获取所有职业信息
//    @MyLog(value = "分页获取职位信息")
    @GetMapping("/findAllPosition")
    public Pager<Position> findAllPosition(Integer curpage,Integer pagesize){
        return llPositionService.findAllPositons(curpage,pagesize);
    }
    //获取所有职位信息
//    @MyLog(value = "获取职位信息")
    @GetMapping("/qeryAllPosition")
    public List<Position> qeryAllPosition(){
        return llPositionService.qeryAllPosition();
    }
    //新增职业
    @MyLog(value = "新增职业")
    @PostMapping("/addPosition")
    public Result addPosition(@RequestBody Position p){
        if(p.getPostId()>0){
            llPositionService.updatePosition(p);
        }else {
            llPositionService.addPosition(p);
        }
        return Result.SUCCESS;
    }
    //获得所有权限
//    @MyLog(value = "获得所有权限")
    @GetMapping("/findPowerTree")
    public List<PowerManage> findAllPower(){
        return llAuthorityService.findAllPower();
    }
    //获得当前职位所有权限
//    @MyLog(value = "获得职业所有权限")
    @GetMapping("/positionPower")
    public Integer[] positionPower(Integer postId){
        return llAuthorityService.positionPower(postId);
    }
    //给职位添加修改权限
    @MyLog(value = "修改职位权限")
    @PostMapping("/addUpdateRole")
    public Result addUpdateRole(@RequestBody UserAndPositionParam u){
        //这里uid代表职位id，postid代表权限数组
        llAuthorityService.addUpdateRole(u);
        return Result.SUCCESS;
    }
    //获得该职位所有用户
    @GetMapping("/positionUser")
    public List<UserAndPosition> positionUser(Integer postId){
        return llPositionService.positionUser(postId);
    }
    //删除用户某个职位
    @MyLog(value = "删除职位")
    @GetMapping("/removeUserP")
    public Result removeUserP(Integer uId,Integer postId){
        System.out.println(uId+"--"+postId);
        llAuthorityService.removeUserP(uId, postId);
        return Result.SUCCESS;
    }
    //模糊查询
    @GetMapping("/queryLikePosition")
    public Pager<Position> queryLikePosition(String name){
        return llPositionService.queryLikePosition(name);
    }
}
