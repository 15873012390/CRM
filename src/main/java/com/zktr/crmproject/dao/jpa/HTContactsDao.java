package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Contacts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HTContactsDao extends CrudRepository<Contacts,Integer> {

    public List<Contacts> findAllByCustomerCusId(Integer cusId);
}
