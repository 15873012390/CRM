package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Customercare;
import org.springframework.data.repository.CrudRepository;

public interface HTCustomerCareDao extends CrudRepository<Customercare,Integer> {
    
}
