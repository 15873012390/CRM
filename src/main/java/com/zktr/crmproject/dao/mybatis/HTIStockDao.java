package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Purchaseplan;
import com.zktr.crmproject.pojos.Stock;
import com.zktr.crmproject.vo.PLCountPie;
import com.zktr.crmproject.vo.StockAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HTIStockDao {

    public List<Stock> queryAllStock();

    public void removeStockisZero();

    public List<Stock> queryStockByAdvanced(StockAdvancedSearch sds);

    public Stock queryStockByStockId(Integer stockId);

    public void updatestockQuantity(Integer stockQuantity,Integer speId,Integer warehouseId);

    public Stock queryQuantityBySpeId(Integer speId);

    public List<PLCountPie> PLQueryByStock();

    public Stock queryStockByWarehouseAndSpeId(Integer speId,Integer warehouseId);
}
