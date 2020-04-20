package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Auditdetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JrcAuditDetailsMDao {

    public Auditdetails queryAuditDetailsByAudid(Integer audId);

}
