package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.utils.JrcCharType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Mapper
public interface JrcCharTypeMDao {

    public List<JrcCharType> querySalesOpportByStageNumber(@Param("users") List<User> users);

    public List<JrcCharType> querySalesOpportByStageSignMoney(@Param("users") List<User> users);
    //数量转化率
    public String numberConversion(@Param("one") String one, @Param("two") String two, @Param("users") List<User> users);
    //数量历史转化率
    public String numberHistoryConversion(@Param("one") String one, @Param("two") String two, @Param("users") List<User> users);
    //数量全局转化率
    public String numberAvgConversion(@Param("one") String one, @Param("two") String two);
    //金额转化率
    public String moneyConversion(@Param("one") String one, @Param("two") String two, @Param("users") List<User> users);
    //金额历史转化率
    public String moneyHistoryConversion(@Param("one") String one, @Param("two") String two, @Param("users") List<User> users);
    //金额全局转化率
    public String moneyAvgConversion(@Param("one") String one, @Param("two") String two);

}
