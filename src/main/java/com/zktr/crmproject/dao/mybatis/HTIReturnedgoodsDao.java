package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Returnedgoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface HTIReturnedgoodsDao {

    public List<Returnedgoods> queryByRGId(String warehouseId);
}
