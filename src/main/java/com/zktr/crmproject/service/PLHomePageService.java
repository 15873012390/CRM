package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.Returnedgoods;
import com.zktr.crmproject.pojos.Returnedmoney;
import com.zktr.crmproject.pojos.Returnedmoneyplan;
import com.zktr.crmproject.vo.PLCountBar;
import com.zktr.crmproject.vo.PLCountPie;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PLHomePageService {
    @Autowired
    private PLReturnedMoneyMDao returnedMoneyMDao;
    @Autowired
    private PLISendOutDao sendOutDao;
    @Autowired
    private PLContractMDao contractMDao;
    @Autowired
    private PLReturnedMoneyPlanMDao returnedMoneyPlanMDao;
    @Autowired
    private PLReturnedGoodsMDao returnedGoodsMDao;
    @Autowired
    private PLIOrdersDao ordersDao;

    /**
     * 首页 统计回款表中未回款的
     * @return
     */
    public List<Map> statisticsHomePageRM(Integer uId){
        return returnedMoneyMDao.statisticsHomePageRM(uId);
    }

    /**
     * 首页 统计未回款的回款单
     * @return
     */
    public Map statisticsHomePageRMNum(Integer uId){
        return returnedMoneyMDao.statisticsHomePageRMNum(uId);
    }

    /**
     * 已出库未发货的发货单
     * @return
     */
    public List<Map> statisticsHomePageSO(){
        return sendOutDao.statisticsHomePageSO();
    }

    /**
     * 已出库未发货的发货单数量统计
     * @return
     */
    public Map statisticsHomePageSONum(){
        return sendOutDao.statisticsHomePageSONum();
    }

    /**
     * 本月签订合同前最新 top2020条
     * @return
     */
    public List<Map> statisticsHomePageCon(Integer uId){
        return contractMDao.statisticsHomePageCon(uId);
    }

    /**
     * 本月签订合同 top20条数量
     * @return
     */
    public Map statisticsHomePageConNum(Integer uId){
        return contractMDao.statisticsHomePageConNum(uId);
    }

    /**
     * 计划回款 top20
     * @return
     */
   public List<Returnedmoneyplan> findAllRMPTop(Integer uId){
        return returnedMoneyPlanMDao.findAllRMPTop(uId);
   }

    /**
     * 计划回款 top20 数量
     * @return
     */
   public Map findAllRMPTopNum(Integer uId){
       return returnedMoneyPlanMDao.findAllRMPTopNum(uId);
   }

    /**
     * 本月回款top20
     * @return
     */
    public List<Map> statisticsHomePageRMState(){
       return returnedMoneyMDao.statisticsHomePageRMState();
    }

    /**
     * 本月回款数量top20
     * @return
     */
    public Map statisticsHomePageRMStateNum(){
       return returnedMoneyMDao.statisticsHomePageRMStateNum();
    }

    /**
     * 本周未处理的退货单
     * @return
     */
    public List<Map> statisticsHomePageRGWeek(Integer uId){

        return returnedGoodsMDao.statisticsHomePageRGWeek(uId);
    }

    /**
     * 本周未处理的退货单的数量
     * @return
     */
    public Map statisticsHomePageRGWeekNum(Integer uId){
        return returnedGoodsMDao.statisticsHomePageRGWeekNum(uId);
    }

    /**
     * 统计当前月每天的销售额
     * @return
     */
    public List<PLCountPie> CountLine(){
        return ordersDao.CountLineOne();
    }
    public List<PLCountPie> CountLineTwo(){
        return ordersDao.CountLineTwo();
    }
    public Map<String,Object> two(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<PLCountPie> month=ordersDao.CountLineOne();
        List<PLCountPie> lastmonth=ordersDao.CountLineTwo();
        map.put("month",month);
        map.put("lastmonth",lastmonth);
        return map;
    }
    public PLCountBar countLineMonthByDay(){
        PLCountBar countBar=new PLCountBar();
        List<PLCountPie> list = this.CountLine();
        String[] name=new String[list.size()];
        int[] value=new int[list.size()];
        int count=0;
        for (PLCountPie p:list){
            name[count]=p.getName();
            value[count]=p.getValue();
            count++;
            countBar.setName(name);
            countBar.setValue(value);
        }
        return countBar;
    }

    /**
     * 首页 状态统计
     * @return
     */
    public List<PLCountPie> countPies(){
        return ordersDao.Countpie("1");
    }

}
