package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customerservice;
import com.zktr.crmproject.vo.CustomerServiceAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HTICustomerServiceDao {

    public List<Customerservice> queryAllByPage();

    public Customerservice queryById(Integer csId);

    public List<Customerservice> queryLikeCustomerService(String value,String input,String select);

    public List<CustomerServiceAdvancedSearch> queryConditionByPage(CustomerServiceAdvancedSearch csa);

    public List queryQueryDistribution(String selectValue);

    public List queryQueryMonth(String selectValue2);
}
