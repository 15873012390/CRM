package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Returnedmoney;
import com.zktr.crmproject.vo.PLRemAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PLReturnedMoneyMDao {
    //新增回款
    public void insertRMPByOrders(Returnedmoney returnedmoney);
    //修改回款
    public void updateRMByOrders(Returnedmoney returnedmoney);
    //查询全部
    public List<Returnedmoney> findAllByRM();
    //根据id查询
    public Returnedmoney findAllByRMId(Integer remId);
    //删除
    public void deleteByremId(Integer remId);
    //批量删除
    public void batchByremId(@Param("remId") Integer[] remId);
    //统计金额
    public List<Map> statisticsByMoney();
    //模糊条件查询
    public List<Returnedmoney> queryByLikeQuery(@Param("select") String select, @Param("input") String input, @Param("statevalue") String statevalue);
    //高级查询
    public List<Returnedmoney> REMAdvancedSearch(PLRemAdvancedSearch remAdvancedSearch);
    //首页 回款统计
    public List<Map> statisticsHomePageRM(Integer uId);
    //首页
    public Map statisticsHomePageRMNum(Integer uId);
    //首页 本月回款top20
    public List<Map> statisticsHomePageRMState();
    //首页 本月回款数量top20
    public Map statisticsHomePageRMStateNum();
}
