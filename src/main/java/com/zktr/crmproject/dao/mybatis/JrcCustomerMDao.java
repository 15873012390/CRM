package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcCustomerMDao {

    public List<Customer> queryAll();

    public Customer queryContactByCusid(@Param("cusid") Integer cusid);

    public Customer queryByCusNameAndConName(@Param("cusName") String cusName, @Param("conName") String conName);
}
