package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Auditdetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcAuditDetailsMDao {

    public Auditdetails queryAuditDetailsByAudid(Integer audId);

    public List<Auditdetails> queryAuditListByAudId(@Param("audId") Integer audId);

    public void deleteAuditByAudId(@Param("audId") Integer audId);
}
