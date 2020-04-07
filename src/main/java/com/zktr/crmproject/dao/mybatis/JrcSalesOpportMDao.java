package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.vo.JrcSalesOpportStage;
import com.zktr.crmproject.vo.SalesOpportAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Mapper
public interface JrcSalesOpportMDao {

    public List<Salesopport> queryAll();

    public List<Salesopport> queryByLikeSearch(@Param("value") String value, @Param("input") String input,
                                               @Param("select") String select);
    public List<Salesopport> queryByAdvancedSearch(SalesOpportAdvancedSearch salesOpportAdvancedSearch);

    public Salesopport queryBySoid(@Param("soid") Integer soid);

    public Salesopport deleteQueryById(@Param("soid") Integer soid);


    public List<Salesopport> querySalesOpportByCustomer(@Param("customer") Customer customer);

    public List<Salesopport> querySalesOpportByCusId(@Param("cusid") Integer cusid);

    public List<Salesopport> querySalesOpportByForecast(@Param("timeStart") Date timeStart,
                                                        @Param("timeEnd") Date timeEnd,
                                                        @Param("possibolty") String possibolty,
                                                        @Param("status") Integer status);


    public List<Salesopport> queryFinalllSalesOpportByForecast(@Param("timeStart") Date timeStart,
                                                               @Param("timeEnd") Date timeEnd,
                                                               @Param("possibolty") String possibolty,
                                                               @Param("uId") Integer uId);

    public List<JrcSalesOpportStage> queryFinallStage(@Param("uId") Integer uId);

}
