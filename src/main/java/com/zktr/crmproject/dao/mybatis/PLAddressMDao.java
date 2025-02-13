package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PLAddressMDao {
    //根据id查找一个对象
    public Address findByAddid(@Param("addid") Integer addid);
    //查询全部
    public List<Address> queryAllAdress();
    //新增
    public void insertAddress(Address address);
    //根据id修改
    public void updateAddress(Address address);
    //查询订单中的地址
    public Address findByAddidByOrders(Integer addid);
}
