package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.vo.JrcSalesFunnel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface JrcSalesFunnelMDao {

    public JrcSalesFunnel querySalesFunnel(@Param("users") List<User> users, @Param("stage") String stage);

    public JrcSalesFunnel querySalesOpportByStageNumberAndMoney(@Param("users") List<User> users, @Param("stage") String stage);
}
