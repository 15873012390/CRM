package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcSalesOpportJDao;
import com.zktr.crmproject.dao.jpa.JrcStagelogJDao;
import com.zktr.crmproject.dao.mybatis.*;


import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.utils.JrcCharType;
import com.zktr.crmproject.vo.JrcSalesFunnel;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.SalesOpportAdvancedSearch;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

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
    private JrcCharTypeMDao charTypeMDao;
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
     * @param inputs 输入框的值
     * @param select 下拉列表【机会主题、客户名称】
     * @param pagesize 页大小
     * @return
     */
    public Pager<Salesopport> querySalesOpportByLikeSearchPage(String value,String inputs,String select,int curpage,int pagesize){
        PageHelper.startPage(curpage,pagesize);
        String input="";
        System.out.println(inputs.trim().length()!=0);
        if(inputs.trim().length()!=0){
           input="%"+inputs.trim()+"%";
        }else{
          input=inputs.trim();
        }
        List<Salesopport> list=salesOpportMDao.queryByLikeSearch(value,input,select);
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
        String opportunites="%"+salesOpportAdvancedSearch.getOpportunitiesThem().trim()+"%";
        salesOpportAdvancedSearch.setOpportunitiesThem(opportunites);
        PageHelper.startPage(salesOpportAdvancedSearch.getCurpage(),salesOpportAdvancedSearch.getPagesize());
        List<Salesopport> list=salesOpportMDao.queryByAdvancedSearch(salesOpportAdvancedSearch);
        PageInfo<Salesopport> pager=new PageInfo<>(list);
        return new Pager<Salesopport>(pager.getTotal(),pager.getList());
    }

    /**
     * 添加/编辑销售机会
     * 1.判断传进来的销售机会存不存在  存在则为修改   不存在则为添加
     * 2.修改时 判断有没有更改销售机会的阶段备注或者阶段
     * （a.修改了阶段备注/阶段 则新增一条阶段日志记录和修改销售机会表
     * （b.没有修改则仅仅修改销售机会表
     * @param salesopport
     */
    public void addSalesOpport(Salesopport salesopport){
        Stagelog stagelog=new Stagelog();
        if(salesopport.getSoId()!=0){
            Salesopport s=salesOpportMDao.queryBySoid(salesopport.getSoId());
            salesOpportJDao.save(salesopport);
            if(!((s.getStage().equals(salesopport.getStage()))&&
                    (s.getConPhone().equals(salesopport.getConPhone())))){
                stagelog.setSlNote(salesopport.getConPhone());
                stagelog.setRecordTime(new Timestamp(new Date().getTime()));
                stagelog.setStageName(salesopport.getStage());
                //当前登录员工
                stagelog.setUserName(salesopport.getUser().getuName());
                stagelog.setSalesopport(s);

            }
            //新增
        }else{
            Customer c=customerMDao.queryContactByCusid(salesopport.getCustomer().getCusId());
            salesopport.setUpdateDate(new Timestamp(new Date().getTime()));
            salesopport.setCustomer(c);
            salesOpportJDao.save(salesopport);
            Salesopport s2=salesOpportMDao.queryAll().get(0);
            stagelog.setSlNote(salesopport.getConPhone());
            stagelog.setRecordTime(new Timestamp(new Date().getTime()));
            stagelog.setStageName(salesopport.getStage());
            //操作人 为 当前登录的员工
            stagelog.setUserName(salesopport.getUser().getuName());
            stagelog.setSalesopport(s2);

        }
        stagelogJDao.save(stagelog);
    }

    /**
     * 根据销售机会id查找销售机会和销售阶段日志
     * @param soid
     * @return
     */
    public Salesopport queryBySoid(Integer soid){
        return salesOpportMDao.queryBySoid(soid);
    }

    /**
     * 删除销售机会
     * @param soid
     */
    public void delSalesOpport(Integer soid){
        Salesopport s=salesOpportMDao.deleteQueryById(soid);
        s.setDelStatus(2);
        salesOpportJDao.save(s);
    }

    /**
     * 批量删除销售机会
     * @param soids
     */
    public void delBatchSalesopport(Integer[] soids){
        for (Integer soid:soids){
            Salesopport s=salesOpportMDao.deleteQueryById(soid);
            s.setDelStatus(2);
            salesOpportJDao.save(s);
        }
    }

    /**
     * 销售漏斗（销售机会阶段个数）
     * @param users
     * @return
     */
    public List<JrcCharType> querySalesOpportByStageNumber(List<User> users){

        return charTypeMDao.querySalesOpportByStageNumber( users);
    }

    /**
     * 销售漏斗（销售机会总金额）
     * @param users
     * @return
     */
    public List<JrcCharType> querySalesOpportByStageSignMoney(List<User> users){
        return charTypeMDao.querySalesOpportByStageSignMoney(users);
    }

  /*  *//**
     * 生成表格数据
     * @return
     *//*
    public Map querySalesOpportByStageGenerneDate(List<User> users){

        List<JrcSalesFunnel> list=new ArrayList<>();
        JrcSalesFunnel salesFunnel=new JrcSalesFunnel();
        //数量转化率
        salesFunnel.setNumberConversion(charTypeMDao.numberConversion("初期沟通","需求分析",users));
        //数量历史转化率
        salesFunnel.setNmberHistoryConversion(charTypeMDao.);

    }*/
}
