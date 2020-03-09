package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTContactsDao;
import com.zktr.crmproject.dao.jpa.HTCustomerDao;
import com.zktr.crmproject.dao.jpa.HTCustomerServiceDao;
import com.zktr.crmproject.dao.jpa.HTUserDao;
import com.zktr.crmproject.dao.mybatis.HTIContactsDao;
import com.zktr.crmproject.dao.mybatis.HTICustomerDao;
import com.zktr.crmproject.dao.mybatis.HTICustomerServiceDao;
import com.zktr.crmproject.dao.mybatis.HTIUserDao;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.CustomerServiceAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class HTCustomerServiceService {
    @Autowired
    private HTCustomerServiceDao customerServiceDao;
    @Autowired
    private HTContactsDao contactsDao;
    @Autowired
    private HTUserDao userDao;
    @Autowired
    private HTICustomerServiceDao iCustomerServiceDao;
    @Autowired
    private HTICustomerDao iCustomerDao;
    @Autowired
    private HTIUserDao iUserDao;
    @Autowired
    private HTIContactsDao iContactsDao;

    /**
     * 查询所有的客户服务
     * @return
     */
    public List<Customerservice> findByAllCustomerService(){
        return customerServiceDao.findbyAll();
    }

    /**
     * 增加/编辑客户服务
     * @param cs
     */
    public void addorEditCustomerService(Customerservice cs){
        customerServiceDao.save(cs);
    }

    /**
     * 删除客户服务
     * @param csId
     */
    public void deleteCustomerService(int csId){
        customerServiceDao.deleteById(csId);
    }

    /**
     * 分页显示客户服务页面
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customerservice> queryAllCustomerServiceByPage(Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customerservice> clist = iCustomerServiceDao.queryAllByPage();
        PageInfo<Customerservice> pager = new PageInfo<>(clist);
        return new Pager<Customerservice>(pager.getTotal(),pager.getList());
    }

    /**
     * 分页显示客户服务页面
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customerservice> queryLikeCustomerService(String value,String input,String select,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customerservice> clist = iCustomerServiceDao.queryLikeCustomerService(value,"%"+input.trim()+"%",select);
        PageInfo<Customerservice> pager = new PageInfo<>(clist);
        return new Pager<Customerservice>(pager.getTotal(),pager.getList());
    }

    /**
     * 高级动态条件查询
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<CustomerServiceAdvancedSearch> queryConditionByPage(Integer curpage, Integer pagesize,CustomerServiceAdvancedSearch csa){
        PageHelper.startPage(curpage,pagesize);
        if(csa.getStartTime()!=null&&csa.getStartTime().length>1){
            csa.setS1(csa.getStartTime()[0]);
            csa.setS2(csa.getStartTime()[1]);
        }
        List<CustomerServiceAdvancedSearch> list = iCustomerServiceDao.queryConditionByPage(csa);
        PageInfo<CustomerServiceAdvancedSearch> pager = new PageInfo<>(list);
        return new Pager<CustomerServiceAdvancedSearch>(pager.getTotal(),pager.getList());
    }



    /**
     * 查询所有的客户
     * @return
     */
    public List<Customer> queryAllCustomer(){
        List<Customer> all = (List<Customer>)iCustomerDao.queryAllCustomer();
        return all;
    }

    /**
     * 根据客户查找所有的联系人
     * @param cusId
     * @return
     */
    public List<Contacts> queryContactsByCusId(Integer cusId){
       return iContactsDao.queryNameByCusId(cusId);
    }

    /**
     * 查询所有的用户
     * @return
     */
    public List<User> queryAllUser(){
        List<User> list=(List<User>)iUserDao.queryAllUser();
        return list;
    }

    /**
     * 根据客户服务ID查找所有的客户服务
     * @param csId
     * @return
     */
    public Customerservice queryByCsId(Integer csId){
        return iCustomerServiceDao.queryById(csId);
    }


    /**
     * 批量删除客户服务
     * @param ids
     */
    public void deleteCustomerServices(Integer[] ids){
        for(Integer id:ids){
            customerServiceDao.deleteById(id);
        }

    }



}
