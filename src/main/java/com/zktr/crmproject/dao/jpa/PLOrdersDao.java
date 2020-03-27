package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Orders;
import org.springframework.data.repository.CrudRepository;

public interface PLOrdersDao extends CrudRepository<Orders,Integer> {

}
