package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Purchaseplan;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HTIPurchaseplanDao {

    public List<Purchaseplan> queryByPcId(String warehouseId);
}
