package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface lliLogDao {
    public List<Log> qeryAllLog();
    public List<Log> qeryLogByName(@Param("uname") String uname);
}
