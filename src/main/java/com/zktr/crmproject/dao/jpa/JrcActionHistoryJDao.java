package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Actionhistory;
import org.springframework.data.repository.CrudRepository;

public interface JrcActionHistoryJDao extends CrudRepository<Actionhistory,Integer> {
}
