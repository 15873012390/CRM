package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HTISupplierDao {

    public List<Supplier> queryAllSupplier();
}
