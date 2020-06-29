package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.service.JrcCustomerAndUserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JrcCustomerAndUserController {
    @Autowired
    private JrcCustomerAndUserService customerAndUserService;


    /**
     * 查看所有客户
     * @return
     */
    @GetMapping("/jrc_query_all_customer")
    public List<Customer> queryAllCustomer(){
       return customerAndUserService.queryAllCustomer();
    }

    /**
     * 根据客户id查找对应的联系人
     * @param cusid
     * @return
     */
    @GetMapping("/jrc_query_contact_by_cusId")
    public Customer queryContactByCusId(Integer cusid){
        return customerAndUserService.queryContactByCusId(cusid);
    }


    /**
     * 查找所有的用户
     * @return
     */
    @GetMapping("/jrc_query_all_user")
    public List<User> queryAllUser(){
        return customerAndUserService.queryAllUser();
    }

    /**
     * 查看所有部门底下的员工
     * @return
     */
    @GetMapping("/jrc_query_dept_all_user")
    public List<Department> queryDeptAllUser(){
        return customerAndUserService.queryDeptAllUser();
    }


    /**
     * 查找所有产品名称
     *
     * @return
     */
    @GetMapping("/query_all_product")
    public List<Product> queryAllProduct(){
        return customerAndUserService.queryAllProduct();
    }

    /**
     * 查询有审批权限的员工
     * @return
     */
    @GetMapping("/get_all_user")
    public List<User> getAllUser(){
        return customerAndUserService.getAllUserList();
    }


}
