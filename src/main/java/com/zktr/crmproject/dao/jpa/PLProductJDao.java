package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Product;
import org.springframework.data.repository.CrudRepository;

public interface PLProductJDao extends CrudRepository<Product,Integer> {

}
