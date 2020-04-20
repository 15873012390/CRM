package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Audit;
import com.zktr.crmproject.vo.JrcAdvancedAuditSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcAuditMDao {

    public List<Audit> queryAllAudit();

    public List<Audit> queryLikeAudit(@Param("select") String select, @Param("input") String input, @Param("uId") Integer uId, @Param("iftrue") Integer iftrue);

    public List<Audit> queryAdvanceAudit(JrcAdvancedAuditSearch advancedAuditSearch);

    public Audit queryAllAuditAndAuditDetails(@Param("audId") Integer audId);

}
