package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Backlogtask;
import org.springframework.data.repository.CrudRepository;

public interface JrcBackLogTaskJDao extends CrudRepository<Backlogtask,Integer> {

}
