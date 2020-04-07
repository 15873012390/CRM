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
    public List<PLCountPie> Countpie();
    //柱状图统计 根据每月统计订单金额
    public List<PLCountPie> CountBar();
    //查询分页查询全部
    public List<Orders> queryAllOrders();
    //统计总金额和发货金额
    public List<Map> statisticsByMoney();
    //查找最大id
    public int findMaxOrdid();
    //新增订单
    public void insertOrders(PLOrdersVo plOrdersVo);
    //修改订单
    public void updateOrders(PLOrdersVo plOrdersVo);
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
    public void deleteBydetId(@Param("detId") Integer detId);
    //添加订单详情 根据报价Id
    public void insertOrderdetailIn(PLOrdersDetailInVo plOrdersDetailInVo);
    public List<Orders> findAll();
    //HT 根据订单ID和规格ID查询详情
    public Orderdetail queryByOrdIdAndSpeId(Integer ordId, Integer speId);
    //修改出库状态 进行出库
    public void updateOutStatus(Integer ordId);

}
