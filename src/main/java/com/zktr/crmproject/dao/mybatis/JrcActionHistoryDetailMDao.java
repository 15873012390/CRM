package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Actionhistorydetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JrcActionHistoryDetailMDao {

    public List<Actionhistorydetails> queryActionHistoryDetailsByAhid(Integer ahid);
}
