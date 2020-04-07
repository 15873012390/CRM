package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Quote;
import org.springframework.data.repository.CrudRepository;

public interface JrcQuoteJDao extends CrudRepository<Quote,Integer> {

}
