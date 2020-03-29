package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Position;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface lliPositionDao {
    public List<Position> findAllPosition();
    public List<Position> qeryAllPosition();
}
