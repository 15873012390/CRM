package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public List<CountPie> querySalesEarch1(@Param("op") Integer op);

    public List<CountPie> querySalesEarch2(@Param("op") Integer op);

    public List<Map> querySalesEarch3(@Param("op") Integer op);

    public List<Map> querySalesFunnel1(JrcSalesFunnelUO s);

    public void deleteSalesBySoId(@Param("soId") Integer soId);

    /*客户需求  方案制定  报价  生产订单以后 改变销售机会的状态*/
    public void updateSales(@Param("soId") Integer soId, @Param("stage") String stage);


}
