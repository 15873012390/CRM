package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Warehouse;
import com.zktr.crmproject.vo.WareHouseAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HTIWarehouseDao {

    public List<Warehouse> queryAllByPage();

    public  Warehouse queryByWarehouseId(@Param("warehouseId") Integer warehouseId);

    public void updateWarehouse(Warehouse warehouse);

    public List<Warehouse> queryByAdvanced(WareHouseAdvancedSearch wareHouseAdvancedSearch);

    public List<Warehouse> querySelectOrInput(@Param("value") String value, @Param("input") String input, @Param("select") String select);

    public Warehouse querySameNameWarehouse(String warehouseName);

    public void insertWarehouse(Warehouse warehouse);
}
