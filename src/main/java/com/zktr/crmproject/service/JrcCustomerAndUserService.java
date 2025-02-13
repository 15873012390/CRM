package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.mybatis.JrcCustomerMDao;
import com.zktr.crmproject.dao.mybatis.JrcDeptMDao;
import com.zktr.crmproject.dao.mybatis.JrcProductMDao;
import com.zktr.crmproject.dao.mybatis.JrcUserMDao;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.pojos.User;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class JrcCustomerAndUserService {
    @Autowired
    private JrcCustomerMDao customerMDao;
    @Autowired
    private JrcUserMDao userMDao;
    @Autowired
    private JrcDeptMDao deptMDao;
    @Autowired
    private JrcProductMDao productMDao;
    /**
     * 查看所有的客户
     * @return
     */
    public List<Customer> queryAllCustomer(){
        return customerMDao.queryAll();
    }

    /**
     * 根据客户id查找联系人id
     * @param cusid
     * @return
     */
    public Customer queryContactByCusId(Integer cusid){
        return customerMDao.queryContactByCusid(cusid);
    }


    /**
     * 查找所有的员工
     * @return
     */
    public List<User> queryAllUser(){
        return userMDao.queryAll();
    }

    /**
     * 根据员工id查找员工
     * @param uid
     * @return
     */
    public User queryByUid(Integer uid){
        return userMDao.queryByUid(uid);
    }
    /**
     * 根据客户名字和联系人名字查找数据
     */
    public Customer queryByCusNameAndConName(String cusName,String conName){
        return customerMDao.queryByCusNameAndConName(cusName,conName);
    }

    /**
     * 根据员工名字查找数据
     * @param uName
     * @return
     */
    public List<User> queryByUserName(String uName){
        return userMDao.queryByUserName(uName);
    }

    /**
     * 查询所有部门底下的员工
     * @return
     */
    public List<Department> queryDeptAllUser(){
       return deptMDao.queryAllDeptBelow();
    }

    /**
     * 查找所有产品名称
     * @return
     */
    public List<Product> queryAllProduct(){
        return productMDao.queryAllProduct();
    }

    /**
     * 查找所有有权限的员工
     * @return
     */
    public List<User> getAllUserList(){
        return userMDao.getAllUsrList();
    }
}
