package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Orderdetail;
import com.zktr.crmproject.pojos.Orders;
import com.zktr.crmproject.vo.PLCountBar;
import com.zktr.crmproject.vo.PLCountPie;
import com.zktr.crmproject.vo.PLOrdersVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PLIOrdersDao {

    public List<Orders> queryAllNoOutStock();

    public Orders queryOrderdetailByOrdId(Integer ordId);

    public void updateOrdersOutStatus(Integer ordId);

    public void insertOrderdetail(Orderdetail orderdetail);

    public void updateOrderdetail(Orderdetail orderdetail);
    //饼状图统计 根据执行状态
    public List<PLCountPie> Countpie();
    //柱状图统计 根据每月统计订单金额
    public List<PLCountPie> CountBar();
    //查询分页查询全部
    public List<Orders> queryAllOrders();
    //统计总金额和发货金额
    public List<Map> statisticsByMoney();
    //查找最大id
    public int findMaxOrdid();
    //新增
    public void insertOrders(PLOrdersVo plOrdersVo);
    //修改
    public void updateOrders(PLOrdersVo plOrdersVo);
    //根据ordid查找对象
    public Orders findByOrdid(@Param("ordid") Integer ordid);
    //删除 状态修改为2
    public void delOrdersById(@Param("ordId") Integer ordId);


}
