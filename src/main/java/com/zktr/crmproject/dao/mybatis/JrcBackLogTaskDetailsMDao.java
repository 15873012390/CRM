package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Backlogtask;
import com.zktr.crmproject.pojos.Backlogtaskdetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcBackLogTaskDetailsMDao {

    public List<Backlogtaskdetails> queryBackLogTaskUserBybltId(@Param("bltId") Integer bltId);

/*
    public List<Backlogtaskdetails> queryBakLogTaskDetailsByUidFinsh(@Param("op") Integer op,@Param("uid") Integer uid);
*/

}
