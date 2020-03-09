package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customercare;
import com.zktr.crmproject.pojos.Customerservice;
import com.zktr.crmproject.vo.CustomerCareAdvancedSearch;
import com.zktr.crmproject.vo.CustomerServiceAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HTICustomerCareDao {

    public List<Customercare> queryAllByPage();

    public Customercare queryById(Integer csId);

    public List<Customercare> queryLikeCustomerCare(String value,String input,String select);

    public List<CustomerCareAdvancedSearch> queryConditionByPage(CustomerCareAdvancedSearch cca);
}
