package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customerservice;
import com.zktr.crmproject.vo.CustomerServiceAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

@Mapper
public interface HTICustomerServiceDao {

    public List<Customerservice> queryAllByPage();

    public Customerservice queryById(Integer csId);

    public List<Customerservice> queryByCsTitle(String csTitle);

    public List<CustomerServiceAdvancedSearch> queryConditionByPage(CustomerServiceAdvancedSearch csa);
}
