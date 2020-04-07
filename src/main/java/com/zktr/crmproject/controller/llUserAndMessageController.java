package com.zktr.crmproject.controller;


import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.llAuthorityService;
import com.zktr.crmproject.service.llUserService;
import com.zktr.crmproject.utils.ExcelUtils;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
//    @MyLog(value = "添加修改用户")
    @PostMapping("/add_and_update_user")
    public int addUser(@RequestBody UserAndDeptParm param){
        System.out.println("bm："+param.getdId());
        if(param.getUser().getuId()>0){
            user1=llUserService.updateUser(param.getUser(),param.getdId());
        }else {
            user1=llUserService.addUser(param.getUser(),param.getdId());
        }
        return user1!=null?user1.getuId():0;
    }
    //模糊查询
    @MyLog(value = "模糊查询")
    @GetMapping("/query_likename")
    public Pager<PowerAndDept> likeName(String name){
        System.out.println(name);
        return llUserService.queryLikeName(name);
    }
    //用户职位
//    @MyLog(value = "用户职位")
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
//    @MyLog(value = "名字查重")
    @PostMapping("/query_users")
    public int queryName(@RequestBody User user){
        int i=llUserService.checkName(user.getuName());
        System.out.println(user.getuName());
        System.out.println(i);
        return i>0?1:0;
    }
    //获取所有用户信息
    @GetMapping("/query_allusers")
    public Pager<UserAndPosition> findAllUsers(Integer curpage,Integer pagesize) {
        return llUserService.findAllUsers(curpage,pagesize);
    }
    //单个离职
    @MyLog(value = "解雇")
    @GetMapping("/deleteOne")
    public Result deleteOne(Integer id){
        System.out.println(id);
        llUserService.deleteOne(id);
        return Result.SUCCESS;
    }
    //批量离职
    @MyLog(value = "批量离职")
    @RequestMapping("/deleteMore")
    public Result deleteMore(@RequestBody UserAndPositionParam params){
        System.out.println(params);
        llUserService.deleteMore(params.getPostId());
        return Result.SUCCESS;
    }
    //导出用户表的数据
//    @GetMapping("/expUser")
//    public void expUser(HttpServletResponse response){
//        List<User> users = llUserService.exportUser();
//        if(users != null && users.size() > 0){
//            ExcelUtils.exportExcel(users, null, "用户数据", User.class, "用户"+new Date()+".xlsx", response);
//        }
//    }
//    @MyLog(value = "导入用户")
    @PostMapping("/uploadExcel")
    public String impUser(MultipartFile file){
        List<UserAndPosition> users = ExcelUtils.importData(file, 1, UserAndPosition.class);
        for(UserAndPosition up:users){
            User user=new User();
            user.setuPass(up.getuPass());
            user.setuStatus(up.getuStatus());
            user.setuImg(up.getuImg());
            user.setuName(up.getuName());
            user.setuSex(up.getuSex());
            user.setuBirth(up.getuBirth());
            user.setuJoindate(up.getuJoindate());
            user1=llUserService.addUser(user,up.getdId());
        }
        return "succes";
    }
    //修改密码
    //判断密码是否正确
    @MyLog(value = "修改密码1")
    @GetMapping("/passtrue")
    public Integer passTrue(Integer uid,String pass){
        return llUserService.passTrue(uid,pass);
    }
    //修改密码
    @MyLog(value = "修改密码2")
    @GetMapping("/updatepass")
    public Result updatePass(Integer uid,String pass){
        llUserService.updatePass(uid, pass);
        return Result.SUCCESS;
    }
    //编辑资料
    @MyLog(value = "编辑资料")
    @PostMapping("/editMes")
    public Result editMes(@RequestBody UserMes userMes){
        System.out.println(userMes.getuBirth());
        System.out.println(userMes.getuImg());
        llUserService.editMes(userMes);
        return Result.SUCCESS;
    }
}
