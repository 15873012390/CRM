package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.ICustomerDao;
import com.zktr.crmproject.dao.jpa.TWCustomerTransferDao;
import com.zktr.crmproject.dao.mybatis.ICustomerMapperDao;
import com.zktr.crmproject.dao.mybatis.TWCustomerTransfer2MapperDao;
import com.zktr.crmproject.dao.mybatis.TWCustomerTransferMapperDao;
import com.zktr.crmproject.dao.mybatis.lliUserDao;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Customertransfer;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class TWCustomerService {
    @Autowired
    private ICustomerDao customerDao;
    @Autowired(required = false)
    private ICustomerMapperDao iCustomerMapperDao;
    @Autowired
    private TWCustomerTransferDao twCustomerTransferDao;
    @Autowired(required = false)
    private TWCustomerTransferMapperDao twCustomerTransferMapperDao;
    @Autowired(required = false)
    private com.zktr.crmproject.dao.mybatis.lliUserDao lliUserDao;
    @Autowired(required = false)
    private TWCustomerTransfer2MapperDao twCustomerTransfer2MapperDao;

    /**
     * 根据用户id查询客户转移日志
     * @param uId
     * @param num
     * @param curpage
     * @param pagesize
     * @return
     * @throws ParseException
     */
    public Pager<Customertransfer> queryCustomerTransferById(Integer uId,Integer num, Integer curpage, Integer pagesize) throws ParseException {
        List<TWCustomertransfer> list=null;
        List<Customertransfer> list1=null;
        //判断是否为转出
        if (num==1){
            PageHelper.startPage(curpage,pagesize);
            list=twCustomerTransferMapperDao.findCustomerTransferById1(uId);
            PageHelper.startPage(curpage,pagesize);
            list1=twCustomerTransfer2MapperDao.findCustomerTransferById1(uId);
        }
        //判断是否为转入
        else if (num==2){
            PageHelper.startPage(curpage,pagesize);
            list=twCustomerTransferMapperDao.findCustomerTransferById2(uId);
            PageHelper.startPage(curpage,pagesize);
            list1=twCustomerTransfer2MapperDao.findCustomerTransferById2(uId);
        }


        int i=0;
        User user1=null;
        User user2=null;
        User user3=null;

        for (TWCustomertransfer tw:list){
            list1.get(i).setCustomer(tw.getCustomer());
            list1.get(i).setCtTime(tw.getCtTime());
            list1.get(i).setCtId(tw.getCtId());
            user1=lliUserDao.findById(tw.getOperation_u_id());
            user2=lliUserDao.findById(tw.getNow_u_id());
            user3=lliUserDao.findById(tw.getOriginal_u_id());
            list1.get(i).setUser3(user3);
            list1.get(i).setUser2(user2);
            list1.get(i).setUser1(user1);
            i++;
        }


        PageInfo<Customertransfer> pageInfo=new PageInfo<>(list1);
        return new Pager<Customertransfer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 查询所有客户转移日志
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customertransfer> queryAllCustomerTransfer(Integer curpage, Integer pagesize) throws ParseException {
        PageHelper.startPage(curpage,pagesize);
        List<TWCustomertransfer> list=twCustomerTransferMapperDao.findAllCustomerTransfer();
        PageHelper.startPage(curpage,pagesize);
        List<Customertransfer> list1=twCustomerTransfer2MapperDao.findAllCustomerTransfer();
        int i=0;
        User user1=null;
        User user2=null;
        User user3=null;

        for (TWCustomertransfer tw:list){
            list1.get(i).setCustomer(tw.getCustomer());
            list1.get(i).setCtTime(tw.getCtTime());
            list1.get(i).setCtId(tw.getCtId());
            user1=lliUserDao.findById(tw.getOperation_u_id());
            user2=lliUserDao.findById(tw.getNow_u_id());
            user3=lliUserDao.findById(tw.getOriginal_u_id());
            list1.get(i).setUser3(user3);
            list1.get(i).setUser2(user2);
            list1.get(i).setUser1(user1);
            i++;
        }


        PageInfo<Customertransfer> pageInfo=new PageInfo<>(list1);
        return new Pager<Customertransfer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加客户转移日志
     * @param customertransfer
     */
    public void saveCustomerTransfer(Customertransfer customertransfer){
        Customer customer=findCustomer(customertransfer.getCustomer().getCusId());
        customer.setUser(customertransfer.getUser2());
        saveCustomer(customer);
        twCustomerTransferDao.save(customertransfer);
    }

    /**
     * 添加/修改客户
     * @param customer
     */
    public void saveCustomer(Customer customer){
        customerDao.save(customer);
    }

    /**
     * 批量添加客户
     * @param list
     */
    public void InsertAllCustomer(List<Customer> list){
        customerDao.saveAll(list);
    }

    /**
     * 删除客户
     * @param cusid
     */
    public void deleteCustomer(Integer cusid){
        customerDao.deleteById(cusid);
    }

    /**
     * 加载客户
     * @param cusid
     * @return
     */
    public Customer findCustomerById(Integer cusid){
        return customerDao.findById(cusid).get();
    }

    /**
     * 根据id加载客户
     * @param cusid
     * @return
     */
    public Customer findCustomer(Integer cusid){
        return iCustomerMapperDao.findCustomerById(cusid);
    }

    /**
     * 根据名称加载客户
     * @param cusName
     * @return
     */
    public Customer findCustomerByName(String cusName){
        return iCustomerMapperDao.findCustomerByName(cusName);
    }

    /**
     * 根据id查询客户详情
     * @param cusId
     * @return
     */
    public Customer queryCustomerDetailsById(Integer cusId){
        return iCustomerMapperDao.queryCustomerDetailsById(cusId);
    }

    /**
     * 分页查询所有客户
     * @return
     */
    public Pager<Customer> queryAllCustomers(Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customer> list=iCustomerMapperDao.queryAllCustomer();
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 查询所有客户
     * @return
     */
    public List<Customer> queryAllCustomers2(){
        List<Customer> list=iCustomerMapperDao.queryAllCustomer();
        return list;
    }

    /**
     * 排序
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customer> queryAllCustomerByIdASC(String prop,String order, Integer curpage,Integer pagesize){
        List<Customer> list=null;
        PageHelper.startPage(curpage,pagesize);
        if (prop.equals("cusId")&&order.equals("ascending")){
            list=iCustomerMapperDao.queryAllCustomerByIdASC();
        }else if (prop.equals("cusId")&&order.equals("descending")){
            list=iCustomerMapperDao.queryAllCustomer();
        }else if (prop.equals("cusUpdateTime")&&order.equals("ascending")){
            list=iCustomerMapperDao.queryAllCustomerBycusUpdateTimeASC();
        }else if (prop.equals("cusUpdateTime")&&order.equals("descending")){
            list=iCustomerMapperDao.queryAllCustomerBycusUpdateTimeDESC();
        }
        else {
            list=iCustomerMapperDao.queryAllCustomer();
        }
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 高级查询客户
     * @param advancedQueryCustomerData
     * @return
     */
    public Pager<Customer> queryCustomerSenior(AdvancedQueryCustomerData advancedQueryCustomerData){
        PageHelper.startPage(advancedQueryCustomerData.getCurpage(),advancedQueryCustomerData.getPagesize());
        List<Customer> list=iCustomerMapperDao.queryCustomerSenior(advancedQueryCustomerData);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }
    /**
     * 根据id查询客户
     * @param id
     * @return
     */
    public Pager<Customer> queryCustomerById(Integer id,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customer> list=iCustomerMapperDao.queryCustomerById(id);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据名称模糊查询客户
     * @param name
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customer> queryCustomerByName(String name,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customer> list=iCustomerMapperDao.queryCustomerByName(name);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据数据查询客户
     * @param value
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customer> queryCustomerByShuJu(String value,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customer> list=null;
        if (value.equals("一周内")){
            list=iCustomerMapperDao.queryCustomerBy1();
        }else if (value.equals("一个月内")){
            list=iCustomerMapperDao.queryCustomerBy2();
        }else if (value.equals("一年内")){
            list=iCustomerMapperDao.queryCustomerBy3();
        }else{
            list=iCustomerMapperDao.queryCustomerBy4(value);
        }
        System.out.println(value);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 统计饼图数据
     * @param num
     * @return
     */
    public List<CountPie> countPie(Integer num){
        List<CountPie> list=null;
        if (num==1){
            list=iCustomerMapperDao.countCusSourcePie();
        }else if (num==2){
            list=iCustomerMapperDao.countCusCreditPie();
        }
        else if (num==3){
            list=iCustomerMapperDao.countCusGradingPie();
        }
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName()==null||list.get(i).getName().equals("")){
                list.remove(i);
            }
        }
        return list;
    }

    /**
     * 统计柱状图数据
     * @param num
     * @return
     */
    public CountBar countBar(Integer num){
        CountBar countBar=new CountBar();

            List<CountPie> list=this.countPie(num);
            String[] name=new String[list.size()];
            int[] value=new int[list.size()];
            int count=0;
            for (CountPie countPie:list){

                name[count]=countPie.getName();
                value[count]=countPie.getValue();
                count++;

            }
            countBar.setName(name);
            countBar.setValue(value);

        return countBar;
    }
}
