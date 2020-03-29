package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.TWUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TWUserController {
    @Autowired
    private TWUserService twUserService;

    @ResponseBody
    @RequestMapping("/query_all_user")
    public List<User> queryAllUsers(){
        return twUserService.queryAllUsers();
    }
}
