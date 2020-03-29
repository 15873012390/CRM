package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Address;
import org.springframework.data.repository.CrudRepository;

public interface PLAddressJDao extends CrudRepository<Address,Integer> {
}
