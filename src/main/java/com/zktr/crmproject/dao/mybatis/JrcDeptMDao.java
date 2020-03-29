package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JrcDeptMDao {

    public List<Department> queryAllDeptBelow();

}
