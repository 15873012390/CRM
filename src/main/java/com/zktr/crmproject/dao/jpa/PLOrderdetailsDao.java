package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Orderdetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PLOrderdetailsDao extends CrudRepository<Orderdetail,Integer> {

    @Modifying
    @Query(value = "delete from Orderdetail o where o.productspecification.speId = :speId and o.orders.ordId = :ordId")
    public void deleteBySpeId(@Param("speId") Integer speId,@Param("ordId") Integer ordId);
}
