package com.zktr.crmproject.controller;


import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.llAuthorityService;
import com.zktr.crmproject.service.llUserService;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class llUserAndMessageController {
    @Autowired
    private llUserService llUserService;
    @Autowired
    private llAuthorityService llAuthorityService;
    private static String f="";
    private static User user1;

    //添加修改用户
    @PostMapping("/add_and_update_user")
    public int addUser(@RequestBody UserAndDeptParm param){
        System.out.println("bm："+param.getdId());
        param.getUser().setuImg(f);
        if(param.getUser().getuId()>0){
            user1=llUserService.updateUser(param.getUser(),param.getdId());
        }else {
            user1=llUserService.addUser(param.getUser(),param.getdId());
        }
        System.out.println(user1);
        return user1!=null?user1.getuId():0;
    }
    //模糊查询
    @GetMapping("/query_likename")
    public Pager<PowerAndDept> likeName(String name){
        System.out.println(name);
        return llUserService.queryLikeName(name);
    }
    //用户职位
    @PostMapping("/add_and_update_userposition")
    public Result addUserPosition(@RequestBody UserAndPositionParam param){
        llAuthorityService.addAndUserPosition(param.getuId(),param.getPostId());
        return Result.SUCCESS;
    }
    //图片路径
    @ResponseBody
    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        String filename = "@/assets/"+file.getOriginalFilename();
//        System.out.println(filename);
        f=filename;
    }
    //名字查重
    @PostMapping("/query_users")
    public int queryName(@RequestBody User user){
        int i=llUserService.checkName(user.getuName());
        System.out.println(user.getuName());
        System.out.println(i);
        return i>0?1:0;
    }
    //获取所有用户信息
    @GetMapping("/query_allusers")
    public Pager<PowerAndDept> findAllUsers(Integer curpage,Integer pagesize) {
        return llUserService.findAllUsers(curpage,pagesize);
    }
    //单个离职
    @GetMapping("/deleteOne")
    public Result deleteOne(Integer id){
        System.out.println(id);
        llUserService.deleteOne(id);
        return Result.SUCCESS;
    }
    //批量离职
    @RequestMapping("/deleteMore")
    public Result deleteMore(@RequestBody UserAndPositionParam params){
        System.out.println(params);
        llUserService.deleteMore(params.getPostId());
        return Result.SUCCESS;
    }
}
