package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Stock;
import org.springframework.data.repository.CrudRepository;

public interface HTStockDao extends CrudRepository<Stock,Integer> {
}
