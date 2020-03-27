package com.zktr.crmproject.dao.jpa;


import com.zktr.crmproject.pojos.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface llDeptDao extends CrudRepository<Department,Integer> {
    @Query("from Department d where d.dName=?1")
    public Department findByName(String name);
    @Query("from Department d where d.parentId=?1")
    public List<Department> findDeleteDept(Integer id);
}
