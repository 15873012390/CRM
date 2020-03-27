package com.zktr.crmproject.dao.jpa;


import com.zktr.crmproject.pojos.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface llPositionDao extends CrudRepository<Position,Integer> {
}
