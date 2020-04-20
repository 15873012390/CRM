package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.vo.AdvancedQueryCustomerData;
import com.zktr.crmproject.vo.CountPie;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface TWCustomerMapperDao {
    //删除客户
    public void deleteCustomer(Integer cusId);
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
    //查看是否有重名客户
    public Integer countCustomerByName(String cusName);
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
    //根据cusId查询客户详情(左)
    public Customer queryCustomerDetailsById(Integer cusId);
    //根据cusId查询客户详情（全）
    public Customer findCustomerDetailsById(Integer cusId);
    //根据cusId查询客户详情（右）1
    public Customer findCustomerDetailsById1(Integer cusId);
    //根据cusId查询客户详情（右）2
    public Customer findCustomerDetailsById2(Integer cusId);
    //根据cusId查询客户详情（右）3
    public Customer findCustomerDetailsById3(Integer cusId);
    //根据cusId查询客户详情（右）4
    public Customer findCustomerDetailsById4(Integer cusId);
    //根据cusId查询客户详情（右）5
    public Customer findCustomerDetailsById5(Integer cusId);
    //根据cusId查询客户详情（右）6
    public Customer findCustomerDetailsById6(Integer cusId);
    //根据cusId查询客户详情（右）7
    public Customer findCustomerDetailsById7(Integer cusId);
    //根据cusId查询客户详情（右）8
    public Customer findCustomerDetailsById8(Integer cusId);

}
