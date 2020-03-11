package com.zktr.crmproject.dao.jpa;


import com.zktr.crmproject.pojos.Complaint;
import org.springframework.data.repository.CrudRepository;

public interface HTComplaintDao extends CrudRepository<Complaint,Integer> {
}
