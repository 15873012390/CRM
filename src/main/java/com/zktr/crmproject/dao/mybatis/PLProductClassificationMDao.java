package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.pojos.Productclassification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PLProductClassificationMDao {
    public List<Productclassification> queryAllProductClassification();
    public Productclassification findByClaId(Integer claid);
}
