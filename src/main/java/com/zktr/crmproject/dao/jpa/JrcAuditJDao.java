package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Audit;
import org.springframework.data.repository.CrudRepository;

public interface JrcAuditJDao extends CrudRepository<Audit, Integer> {
}
