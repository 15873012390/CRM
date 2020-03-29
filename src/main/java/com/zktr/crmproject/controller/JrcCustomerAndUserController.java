package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.JrcCustomerAndUserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JrcCustomerAndUserController {
    @Autowired
    private JrcCustomerAndUserService customerAndUserService;

    /**
     * 查看所有客户
     * @return
     */
    @GetMapping("/jrc_query_all_customer")
    @ResponseBody
    public List<Customer> queryAllCustomer(){
       return customerAndUserService.queryAllCustomer();
    }

    /**
     * 根据客户id查找对应的联系人
     * @param cusid
     * @return
     */
    @GetMapping("/jrc_query_contact_by_cusId")
    @ResponseBody
    public Customer queryContactByCusId(Integer cusid){
        return customerAndUserService.queryContactByCusId(cusid);
    }

    /**
     * 查找所有的用户
     * @return
     */
    @GetMapping("/jrc_query_all_user")
    @ResponseBody
    public List<User> queryAllUser(){
        return customerAndUserService.queryAllUser();
    }

    /**
     * 查看所有部门底下的员工
     * @return
     */
    @GetMapping("/jrc_query_dept_all_user")
    @ResponseBody
    public List<Department> queryDeptAllUser(){
        return customerAndUserService.queryDeptAllUser();
    }


}
