package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Clientdemand;
import com.zktr.crmproject.pojos.Solution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcSolutionMDao {

    public List<Solution> querySolutionBySoid(@Param("soId") Integer soId);

}
