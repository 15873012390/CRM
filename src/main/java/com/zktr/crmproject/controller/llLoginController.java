package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.llUserService;
import com.zktr.crmproject.vo.PowerAndDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class llLoginController {
    @Autowired
    private llUserService llUserService;
    //登录查询获得部门信息
    @PostMapping("/login")
    public PowerAndDept login(@RequestBody User user){
        PowerAndDept po = llUserService.login(user.getuName(), user.getuPass());
        System.out.println(po+"dddddddddddddddddddddd");
        return po;
    }
}
