package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Outstockdetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HTOutStockDetailsDao extends CrudRepository<Outstockdetails,Integer> {

    @Modifying
    @Query(value = "delete from Outstockdetails o where o.productspecification.speId =  :speId")
    public void deleteBySpeId(@Param("speId") Integer speId);
}
