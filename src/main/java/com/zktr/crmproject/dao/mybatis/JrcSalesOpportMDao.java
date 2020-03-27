package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.vo.SalesOpportAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcSalesOpportMDao {

    public List<Salesopport> queryAll();

    public List<Salesopport> queryByLikeSearch(@Param("value") String value, @Param("input") String input,
                                               @Param("select") String select);
    public List<Salesopport> queryByAdvancedSearch(SalesOpportAdvancedSearch salesOpportAdvancedSearch);

    public Salesopport queryBySoid(@Param("soid") Integer soid);

    public Salesopport deleteQueryById(@Param("soid") Integer soid);

}
