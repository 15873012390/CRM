package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.PLOrdersDao;
import com.zktr.crmproject.dao.jpa.PLReturnedMoneyPlanJDao;
import com.zktr.crmproject.dao.mybatis.PLIOrdersDao;
import com.zktr.crmproject.dao.mybatis.PLReturnedMoneyPlanMDao;
import com.zktr.crmproject.pojos.Contract;
import com.zktr.crmproject.pojos.Orders;
import com.zktr.crmproject.pojos.Returnedmoneyplan;
import com.zktr.crmproject.vo.PLRmpAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class PLReturnedMoneyPlanService {

    @Autowired
    private PLReturnedMoneyPlanJDao returnedMoneyPlanJDao;
    @Autowired
    private PLIOrdersDao ordersDao;
    @Autowired
    private PLReturnedMoneyPlanMDao returnedMoneyPlanMDao;


    public void saveRMP(Returnedmoneyplan returnedmoneyplan){
        returnedMoneyPlanJDao.save(returnedmoneyplan);
    }

    /**
     * 回款和计划回款 订单查询 当o.rm_or_rmp为空时 表示并未被计划回款和回款记录
     * @return
     */
    public List<Orders> queryAllOrdersByRM(){
        return ordersDao.OqueryAllOrdersByRM();
    }


    /**
     * 分页查询全部
     * @return
     */
    public Pager findAllRMP(int curpage, int pagesie){
        PageHelper.startPage(curpage,pagesie);
        List<Returnedmoneyplan> list=returnedMoneyPlanMDao.findAllRMP();
        PageInfo<Returnedmoneyplan> page=new PageInfo<>(list);
        return new Pager<>(page.getTotal(),page.getList());
    }
    /**
     * 新增或编辑
     * @param returnedmoneyplan
     */
    public void insertRMP(Returnedmoneyplan returnedmoneyplan){
        if(returnedmoneyplan.getRmpId()==0){
            returnedMoneyPlanMDao.insertRMPByOrders(returnedmoneyplan);
            //System.out.println("dddddddd"+returnedmoneyplan.getOrders().getOrdId());
            //修改订单回款状态为1 表示已有计划回款
            ordersDao.updateRmOrRmp1(returnedmoneyplan.getOrders().getOrdId());
        }else {
            returnedMoneyPlanMDao.updateRMPByOrders(returnedmoneyplan);
        }
    }

    /**
     * 查找 一个对象
     * @param rmpid
     * @return
     */
    public Returnedmoneyplan findByRmpId(Integer rmpid){
        return returnedMoneyPlanMDao.findByRmpId(rmpid);
    }

    /**
     * 编辑 重新查找赋值
     * @param ordid
     * @return
     */
    public Orders OqueryByOrdersidByRM(Integer ordid){
        return ordersDao.OqueryByOrdersidByRM(ordid);
    }
    /**
     * mybatis 删除
     * @param rmpid
     */
    public void deleteRmpId(Integer rmpid){
        try {
            if(rmpid!=0){
                returnedMoneyPlanMDao.deleteByrmpId(rmpid);
                //returnedMoneyPlanJDao.deleteById(rmpid);
            }

        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }catch (IncorrectResultSizeDataAccessException e){
            e.printStackTrace();
        }
    }

    /**
     * mybatis 批量删除
     * @param rmpid
     */
    public void batchRmpid(Integer[] rmpid){
        /*for (Integer integer:rmpid){
            returnedMoneyPlanJDao.deleteById(integer);
        }*/
        returnedMoneyPlanMDao.batchByrmpId(rmpid);
    }

    /**
     * 统计
     * @return
     */
    public List<Map> statisticsByMoney(){
        return returnedMoneyPlanMDao.statisticsByMoney();
    }

    /**
     * 条件模糊查询
     * @param curpage
     * @param pagesize
     * @param select
     * @param input
     * @param value
     * @return
     */
    public Pager<Returnedmoneyplan> queryByLikeQuery(int curpage,int pagesize,String select,String input,String value){
        PageHelper.startPage(curpage,pagesize);
        String inputDate=input+"%";
        List<Returnedmoneyplan> list=returnedMoneyPlanMDao.queryByLikeQuery(select,inputDate,value);

        PageInfo<Returnedmoneyplan> page=new PageInfo<>(list);
        return new Pager<Returnedmoneyplan>(page.getTotal(),page.getList());
    }

    /**
     * 高级查询
     * @param rmpAdvancedSearch
     * @return
     */
    public Pager<Returnedmoneyplan> RMPAdvancedSearch(PLRmpAdvancedSearch rmpAdvancedSearch){
        System.out.println("ddddd"+rmpAdvancedSearch.getUname());
        String Uname="%"+rmpAdvancedSearch.getUname().trim()+"%";
        String rmpRemark="%"+rmpAdvancedSearch.getRmpRemark().trim()+"%";
        rmpAdvancedSearch.setUname(Uname);
        rmpAdvancedSearch.setRmpRemark(rmpRemark);
        PageHelper.startPage(rmpAdvancedSearch.getCurpage(),rmpAdvancedSearch.getPagesize());
        List<Returnedmoneyplan> list=returnedMoneyPlanMDao.RMPAdvancedSearch(rmpAdvancedSearch);
        PageInfo<Returnedmoneyplan> page=new PageInfo<>(list);
        return new Pager<Returnedmoneyplan>(page.getTotal(),page.getList());
    }
}
