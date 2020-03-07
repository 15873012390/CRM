package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JrcCustomerMDao {

    public List<Customer> queryAll();
}
