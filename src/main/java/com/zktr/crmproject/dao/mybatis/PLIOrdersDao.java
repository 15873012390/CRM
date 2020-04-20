package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Orderdetail;
import com.zktr.crmproject.pojos.Orders;
import com.zktr.crmproject.vo.PLCountPie;
import com.zktr.crmproject.vo.PLOdersAdvancedSearch;
import com.zktr.crmproject.vo.PLOrdersDetailInVo;
import com.zktr.crmproject.vo.PLOrdersVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface PLIOrdersDao {

    public List<Orders> queryAllNoOutStock();
    //根据订单id查询订单详情
    public Orders queryOrderdetailByOrdId(Integer ordId);
    //修改出库状态
    public void updateOrdersOutStatus(Integer ordId);
    //添加订单详情
    public void insertOrderdetail(Orderdetail orderdetail);
    //修改订单详情
    public void updateOrderdetail(Orderdetail orderdetail);
    //饼状图统计 根据执行状态
    public List<PLCountPie> Countpie(String pieValue);
    //折现图统计 根据每月统计订单金额
    public List<PLCountPie> CountBar(String barValue);
    //查询分页查询全部
    public List<Orders> queryAllOrders();
    //统计总金额和发货金额
    public List<Map> statisticsByMoney();
    //查找最大id
    public Integer findMaxOrdid();
    //新增订单
    public void insertOrders(Orders orders);
    //修改订单
    public void updateOrders(Orders orders);
    //根据ordid查找对象
    public Orders findByOrdid(@Param("ordid") Integer ordid);
    //删除 状态修改为2
    public void delOrdersById(@Param("ordId") Integer ordId);
    //批量修改
    public void BatchOrdids(@Param("ordids") Integer[] ordids);
    //条件模糊查询
    public List<Orders> queryByLikeQuery(@Param("select") String select, @Param("input1") String input1, @Param("value") String value);
    //高级查询
    public List<Orders> OrdersAdvancedSearch(PLOdersAdvancedSearch plOdersAdvancedSearch);
    //删除
    public void deleteBydetId(@Param("detId") Integer[] detId);
    public List<Orders> findAll();
    //HT 根据订单ID和规格ID查询详情
    public Orderdetail queryByOrdIdAndSpeId(Integer ordId, Integer speId);
    //修改出库状态 进行出库
    public void updateOutStatus(Integer ordId);
    //回款和计划回款 当o.rm_or_rmp为空时 表示并未被计划回款和回款记录
    public List<Orders> OqueryAllOrdersByRM();
    //如果是计划回款 则表示被计划回款已记录 选择订单时不显示 根据订单id修改状态
    public void updateRmOrRmp1(Integer ordId);
    //如果是回款 则表示被款已记录 选择订单时不显示 根据订单id修改状态
    public void updateRmOrRmp2(Integer ordId);
    //
    public Orders OqueryByOrdersidByRM(Integer ordid);
    //根据客户id查找订单
    public List<Orders> findOrdersByCusId(Integer cusid);
    //修改订单总价 根据订单详情产品统计赋值
    public void updateTotalMoney(@Param("ordTotalAmount") Integer ordTotalAmount, @Param("ordid") Integer ordid);
    //根据订单id统计订单详情的金额之和
    public Integer findByOrdersDetailMonery(Integer ordid);
    //取消订单 HT
    public int cancelOrders(Integer ordId);
    //修改发货金额和发货状态
    public void updateSendOut(@Param("ordId") Integer ordId, @Param("ordSendOutMoney") Integer ordSendOutMoney, @Param("ordSendOutState") String ordSendOutState);

}
