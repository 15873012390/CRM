package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Returnedmoneyplan;
import com.zktr.crmproject.vo.PLRmpAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PLReturnedMoneyPlanMDao {
    //查询订单的计划回款
    public List<Returnedmoneyplan> findAllRMP();
    //查找 订单的计划回款
    public Returnedmoneyplan findByRmpId(Integer rmpId);
    //新增 订单的计划回款
    public void insertRMPByOrders(Returnedmoneyplan returnedmoneyplan);
    //修改 订单的计划回款
    public void updateRMPByOrders(Returnedmoneyplan returnedmoneyplan);
    //模糊条件查询
    public List<Returnedmoneyplan> queryByLikeQuery(@Param("select") String select, @Param("input1") String input1, @Param("statevalue") String statevalue);
    public void deleteByrmpId(Integer rmpId);
    public void batchByrmpId(@Param("rmpId") Integer[] rmpId);
    //统计金额
    public List<Map> statisticsByMoney();
    //高级查询
    public List<Returnedmoneyplan> RMPAdvancedSearch(PLRmpAdvancedSearch rmpAdvancedSearch);


}
