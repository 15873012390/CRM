package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Contacts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HTIContactsDao {

    public List<Contacts> queryNameByCusId(Integer cusId);
}
