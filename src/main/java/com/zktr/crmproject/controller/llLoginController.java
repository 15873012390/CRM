package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.llUserService;
import com.zktr.crmproject.vo.MyLog;
import com.zktr.crmproject.vo.PowerAndDept;
import com.zktr.crmproject.vo.UserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class llLoginController {
    @Autowired
    private llUserService llUserService;
    //登录查询获得部门信息
    @MyLog(value = "用户登录")
    @PostMapping("/login")
    public PowerAndDept login(@RequestBody User user){
        PowerAndDept po = llUserService.login(user.getuName(), user.getuPass());
        UserName u=new UserName();
        u.uname=user.getuName();
        System.out.println(u.uname);
        return po;
    }
}
