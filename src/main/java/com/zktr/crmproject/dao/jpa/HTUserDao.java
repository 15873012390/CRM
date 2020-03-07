package com.zktr.crmproject.dao.jpa;

import com.zktr.crmproject.pojos.User;
import org.springframework.data.repository.CrudRepository;

public interface HTUserDao extends CrudRepository<User,Integer> {
}
