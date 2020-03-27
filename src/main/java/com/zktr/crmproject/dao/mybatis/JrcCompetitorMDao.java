package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Competitor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcCompetitorMDao {

    public List<Competitor> queryComptitorBySoid(@Param("soId") Integer soId);

}
