package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Warehouseallocation;
import com.zktr.crmproject.pojos.Warehouseallocationdetail;
import com.zktr.crmproject.vo.WarehouseallocationAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HTIWarehouseAllocationDao {

    public List<Warehouseallocation> selectWaByPage();

    public void insertWa(Warehouseallocation warehouseallocation);

    public void updateWa(Warehouseallocation warehouseallocation);

    public void insertWad(Warehouseallocationdetail warehouseallocationdetail);

    public void updateWad(Warehouseallocationdetail warehouseallocationdetail);

    public Warehouseallocation queryWaByWaId(Integer waId);

    public List<Warehouseallocationdetail> queryWadByWaId(Integer wadId);

    public List<Warehouseallocation> queryBySelectAndInput(String value,String input,String select);

    public List<Warehouseallocation> queryByAdvanced(WarehouseallocationAdvancedSearch waad);

    public void deleteWaByWaId(Integer waId);

    public void deleteWaByWaIdAndSpeId(Integer waId,Integer speId);

}
