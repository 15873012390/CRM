package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Instock;
import org.springframework.data.repository.CrudRepository;

public interface HTInstockDao extends CrudRepository<Instock,Integer> {
}
