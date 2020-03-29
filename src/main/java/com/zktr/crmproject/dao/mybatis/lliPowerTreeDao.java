package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.PowerManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface lliPowerTreeDao {
    public List<PowerManage> findAllPower();
}
