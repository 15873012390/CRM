package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Customerservice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HTCustomerServiceDao extends CrudRepository<Customerservice,Integer> {
    @Query(nativeQuery = true,value = "select * from customerservice order by cs_Id desc")
    public List<Customerservice> findbyAll();

    @Query("from Customerservice c order by c.csId desc")
    public List<Customerservice> queryAllByPage(Pageable pageable);

    @Query("select count(c.csId) from Customerservice c")
    public long queryByAllPageCount();
}
