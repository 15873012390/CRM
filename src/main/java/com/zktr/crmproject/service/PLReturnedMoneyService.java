package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.mybatis.PLIOrdersDao;
import com.zktr.crmproject.dao.mybatis.PLReturnedMoneyMDao;
import com.zktr.crmproject.pojos.Orders;
import com.zktr.crmproject.pojos.Returnedmoney;
import com.zktr.crmproject.vo.PLRemAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.util.Length;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class PLReturnedMoneyService {
    @Autowired
    private PLReturnedMoneyMDao returnedMoneyMDao;
    @Autowired
    private PLIOrdersDao ordersDao;

    /**
     * 新增/编辑
     * @param returnedmoney
     */
    public void insertREM(Returnedmoney returnedmoney){
        if(returnedmoney.getRemId()==0){
            returnedMoneyMDao.insertRMPByOrders(returnedmoney);
            //如果已选择订单 订单状态标识为回款
            ordersDao.updateRmOrRmp2(returnedmoney.getOrders().getOrdId());

        }else {
            returnedMoneyMDao.updateRMByOrders(returnedmoney);
        }
    }

    /**
     * 删除
     * @param remid
     */
    public void deleteByremId(Integer remid){
        if(remid!= 0){
            returnedMoneyMDao.deleteByremId(remid);
        }
    }

    /**
     * 批量删除
     * @param remids
     */
    public void batchByremId(Integer[] remids){
        try {
            if(remids.length>0){
                returnedMoneyMDao.batchByremId(remids);
                //returnedMoneyPlanJDao.deleteById(rmpid);
            }

        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }catch (IncorrectResultSizeDataAccessException e){
            e.printStackTrace();
        }
    }
    /**
     * 查找一个对象
     * @param remid
     * @return
     */
    public Returnedmoney findByid(Integer remid){
        return returnedMoneyMDao.findAllByRMId(remid);
    }

    /**
     * 分页查询全部
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Returnedmoney> findAllByRM(int curpage,int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Returnedmoney> list=returnedMoneyMDao.findAllByRM();
        PageInfo<Returnedmoney> page=new PageInfo<>(list);
        return new Pager<Returnedmoney>(page.getTotal(),page.getList());
    }

    /**
     * 迷糊条件搜索
     * @param curpage
     * @param pagesize
     * @param select
     * @param input
     * @param value
     * @return
     */
    public Pager<Returnedmoney> queryByLikeQuery(int curpage,int pagesize,String select,String input,String value){
        //System.out.println("ddd"+input);
        PageHelper.startPage(curpage,pagesize);
        String inputDate="%"+input+"%";
        List<Returnedmoney> list=returnedMoneyMDao.queryByLikeQuery(select,inputDate,value);
        System.out.println("dddss"+inputDate);
        PageInfo<Returnedmoney> page=new PageInfo<>(list);
        return new Pager<Returnedmoney>(page.getTotal(),page.getList());

    }

    /**
     * 高级查询
     * @param remAdvancedSearch
     * @return
     */
    public Pager<Returnedmoney> REMAdvancedSearch(PLRemAdvancedSearch remAdvancedSearch){
        String uname="%"+remAdvancedSearch.getUname()+"%";
        String remark="%"+remAdvancedSearch.getRemRemark()+"%";
        remAdvancedSearch.setUname(uname);
        remAdvancedSearch.setRemRemark(remark);
        //System.out.println("zzzz"+remAdvancedSearch.getRemRemark());
        PageHelper.startPage(remAdvancedSearch.getCurpage(),remAdvancedSearch.getPagesize());
        List<Returnedmoney> list=returnedMoneyMDao.REMAdvancedSearch(remAdvancedSearch);
        PageInfo<Returnedmoney> page=new PageInfo<>(list);
        return new Pager<Returnedmoney>(page.getTotal(),page.getList());
    }
    /**
     * 统计表格下方金额
     * @return
     */
    public List<Map> statisticsByMoney(){
        return returnedMoneyMDao.statisticsByMoney();
    }
}
