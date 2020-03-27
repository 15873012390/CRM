package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Repair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JrcRepairMDao {

    public List<Repair> queryRepairAllByCusId(Integer cusid);

    public Repair queryByRepairId(Integer repairid);
}
