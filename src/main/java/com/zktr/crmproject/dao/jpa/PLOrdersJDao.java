package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Orders;
import org.springframework.data.repository.CrudRepository;

public interface PLOrdersJDao extends CrudRepository<Orders,Integer> {
}
