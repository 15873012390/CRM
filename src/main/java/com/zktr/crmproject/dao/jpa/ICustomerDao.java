package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Customer;
import org.springframework.data.repository.CrudRepository;



public interface ICustomerDao extends CrudRepository<Customer, Integer> {

}
