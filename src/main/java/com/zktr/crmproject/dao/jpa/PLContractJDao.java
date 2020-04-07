package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Contract;
import org.springframework.data.repository.CrudRepository;

public interface PLContractJDao extends CrudRepository<Contract,Integer> {
}
