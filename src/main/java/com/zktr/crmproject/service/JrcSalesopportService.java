package com.zktr.crmproject.service;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcSalesOpportJDao;
import com.zktr.crmproject.dao.jpa.JrcStagelogJDao;
import com.zktr.crmproject.dao.mybatis.JrcCustomerMDao;
import com.zktr.crmproject.dao.mybatis.JrcSalesOpportMDao;
import com.zktr.crmproject.dao.mybatis.JrcStagelogMDao;
import com.zktr.crmproject.dao.mybatis.JrcUserMDao;

import com.zktr.crmproject.pojos.Customer;

import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.pojos.Stagelog;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.SalesOpportAdvancedSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackOn = Exception.class)
public class JrcSalesopportService {

    @Autowired
    private JrcSalesOpportMDao salesOpportMDao;
    @Autowired
    private JrcCustomerMDao customerMDao;
    @Autowired
    private JrcUserMDao userMDao;
    @Autowired
    private JrcSalesOpportJDao salesOpportJDao;
    @Autowired
    private JrcStagelogJDao stagelogJDao;
    @Autowired
    private JrcStagelogMDao stagelogMDao;


    /**
     * 分页查看全部
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Salesopport> queryAllSalesOppoerByPage(int curpage, int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Salesopport> slist=salesOpportMDao.queryAll();
        PageInfo<Salesopport> pager=new PageInfo<>(slist);
        return new Pager<Salesopport>(pager.getTotal(),pager.getList());
    }

    /**
     * 模糊搜索
     * @param value 下拉框的值
     * @param input 输入框的值
     * @param select 下拉列表【机会主题、客户名称】
     * @param pagesize 页大小
     * @return
     */
    public Pager<Salesopport> querySalesOpportByLikeSearchPage(String value,String input,String select,int curpage,int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Salesopport> list=salesOpportMDao.queryByLikeSearch(value,"%"+input.trim()+"%",select);
        PageInfo<Salesopport> pager=new PageInfo<>(list);
        return new Pager<Salesopport>(pager.getTotal(),pager.getList());
    }

    /**
     * 查看所有客户
     * @return
     */
    public List<Customer> queryAllCustomer(){
        return customerMDao.queryAll();
    }

    /**
     * 查看所有员工
     * @return
     */
    public List<User> queryAllUser(){
        return userMDao.queryAll();
    }

    /**
     * 高级搜索员工
     * @param salesOpportAdvancedSearch
     * @return
     */
    public Pager<Salesopport> querySalesOpportByAdvancedSearch(SalesOpportAdvancedSearch salesOpportAdvancedSearch){
        System.out.println(salesOpportAdvancedSearch.toString());
        PageHelper.startPage(1,5);
        List<Salesopport> list=salesOpportMDao.queryByAdvancedSearch(salesOpportAdvancedSearch);
        PageInfo<Salesopport> pager=new PageInfo<>(list);
        return new Pager<Salesopport>(pager.getTotal(),pager.getList());
    }

    /**
     * 添加销售机会
     * @param salesopport
     */
    public void addSalesOpport(Salesopport salesopport){
        Stagelog stagelog=new Stagelog();
        salesopport.setDelStatus(1);
        salesopport.setUpdateDate(new Timestamp(new Date().getTime()));
        if(salesopport.getSoId()==0){
            salesOpportJDao.save(salesopport);
            //查找出最新的对象
            Salesopport s1=salesOpportMDao.queryAll().get(0);
            stagelog.setSlNote(salesopport.getConPhone());
            stagelog.setRecordTime(new Timestamp(new Date().getTime()));
            stagelog.setStageName(salesopport.getStage());
            stagelog.setUser(salesopport.getUser());
            stagelog.setSalesopport(s1);
            stagelogJDao.save(stagelog);

        }else{
            salesopport.setDelStatus(1);
            Salesopport salesopport2=salesOpportJDao.findById(salesopport.getSoId()).get();
            if((salesopport2.getStage().equals(salesopport.getStage()))&&
                    (salesopport2.getConPhone().equals(salesopport.getConPhone()))){
                    salesOpportJDao.save(salesopport);
            }else{
                salesOpportJDao.save(salesopport);
                stagelog.setSlNote(salesopport.getConPhone());
                stagelog.setRecordTime(new Timestamp(new Date().getTime()));
                stagelog.setStageName(salesopport.getStage());
                stagelog.setUser(salesopport.getUser());
                stagelog.setSalesopport(salesopport);
                stagelogJDao.save(stagelog);
            }
        }
    }

    /**
     * 根据销售机会id查找销售机会和销售阶段日志
     * @param soid
     * @return
     */
    public Map queryBySoid(int soid){
        Map map=new HashMap();
        map.put("salesOpport",salesOpportMDao.queryBySoid(soid));
        map.put("stageLogList",stagelogMDao.queryStageLogBySoid(soid));
        return map;
    }

    /**
     * 删除销售机会
     * @param salesopport
     */
    public void delSalesOpport(Salesopport salesopport){
        salesopport.setDelStatus(2);
        salesOpportJDao.save(salesopport);
    }




}
