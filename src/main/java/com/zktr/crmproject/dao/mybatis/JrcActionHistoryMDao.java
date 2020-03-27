package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Actionhistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JrcActionHistoryMDao {

    public List<Actionhistory> queryActionhistoryByCusId(Integer cusid);

    public Actionhistory queryActionHistoryByAhid(Integer ahid);

}
