package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Returnedgoods;
import com.zktr.crmproject.pojos.Returnedgoodsdetial;
import com.zktr.crmproject.pojos.Returnedmoney;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PLReturnedGoodsMDao {
    //新增退货
    public void insertRG(Returnedgoods returnedgoods);
    //新增退货详情
    public void insertRGD(Returnedgoodsdetial returnedgoodsdetial);
    //查询全部退货
    public List<Returnedgoods> findAllRG();
    //根据退货id查询退货详情
    public List<Returnedgoodsdetial> findAllByRGDRegId(Integer regId);


}
