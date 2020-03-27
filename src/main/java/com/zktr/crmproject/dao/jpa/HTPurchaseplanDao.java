package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.Purchaseplan;
import org.springframework.data.repository.CrudRepository;

public interface HTPurchaseplanDao extends CrudRepository<Purchaseplan,Integer> {
}
