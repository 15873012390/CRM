package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Instockdetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HTInstockDetailDao extends CrudRepository<Instockdetail,Integer> {
    @Modifying
    @Query(value = "delete from Instockdetail i where i.productspecification.speId = :speId")
    public void deleteBySpeId(@Param("speId") Integer speId);

}
