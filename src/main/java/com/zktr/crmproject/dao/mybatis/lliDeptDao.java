package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.vo.DepartmentMes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface lliDeptDao {
    public List<DepartmentMes> findAllDepartment();
}
