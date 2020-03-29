package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.vo.AdvancedQueryCustomerData;
import com.zktr.crmproject.vo.CountPie;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface ICustomerMapperDao {
    //查询所有客户
    public List<Customer> queryAllCustomer();
    //根据id排序（正序）
    public List<Customer> queryAllCustomerByIdASC();
    //根据更新时间正序
    public List<Customer> queryAllCustomerBycusUpdateTimeASC();
    //根据更新时间降序
    public List<Customer> queryAllCustomerBycusUpdateTimeDESC();
    //根据ID查询客户
    public List<Customer> queryCustomerById(Integer id);
    //根据名称模糊查询客户
    public List<Customer> queryCustomerByName(String name);
    //根据名称加载客户
    public Customer findCustomerByName(String name);
    //根据ID加载客户
    public Customer findCustomerById(Integer id);
    //高级查询客户
    public List<Customer> queryCustomerSenior(AdvancedQueryCustomerData advancedQueryCustomerData);
    //查询更新时间一周内的客户
    public List<Customer> queryCustomerBy1();
    //查询更新时间一个月内的客户
    public List<Customer> queryCustomerBy2();
    //查询更新时间一年内的客户
    public List<Customer> queryCustomerBy3();
    //查询客户来源
    public List<Customer> queryCustomerBy4(String value);
    //统计客户来源饼图数据
    public List<CountPie> countCusSourcePie();
    //统计信用等级饼图数据
    public List<CountPie> countCusCreditPie();
    //统计定级饼图数据
    public List<CountPie> countCusGradingPie();
    //根据cusId查询客户详情
    public Customer queryCustomerDetailsById(Integer cusId);
}
