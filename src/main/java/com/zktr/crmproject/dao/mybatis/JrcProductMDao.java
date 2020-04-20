package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JrcProductMDao {

    public List<Product> queryAllProduct();
}
