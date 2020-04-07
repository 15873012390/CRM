package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Audit;
import org.springframework.data.repository.CrudRepository;

public interface JrcAuditDao extends CrudRepository<Audit,Integer> {

}
