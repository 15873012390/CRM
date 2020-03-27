package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Contacts;
import org.springframework.data.repository.CrudRepository;

public interface IContactsDao extends CrudRepository<Contacts, Integer> {
}
