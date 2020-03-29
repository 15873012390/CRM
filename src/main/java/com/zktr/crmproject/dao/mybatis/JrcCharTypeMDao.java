package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.utils.JrcCharType;
import com.zktr.crmproject.vo.JrcSalesFunnel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Mapper
public interface JrcCharTypeMDao {

    public JrcCharType querySalesOpportByStageNumber(@Param("users") List<User> users, String stage);


}
