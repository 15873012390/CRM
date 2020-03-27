package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Orderdetail;
import com.zktr.crmproject.pojos.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PLIOrdersDao {

    public List<Orders> queryAllNoOutStock();

    public Orders queryOrderdetailByOrdId(Integer ordId);

    public void updateOrdersOutStatus(Integer ordId);

    public void insertOrderdetail(Orderdetail orderdetail);

    public void updateOrderdetail(Orderdetail orderdetail);
}
