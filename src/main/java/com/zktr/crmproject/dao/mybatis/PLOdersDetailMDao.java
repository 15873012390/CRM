package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Orderdetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PLOdersDetailMDao {
    public List<Orderdetail> queryOrderdetailByOrdid(Integer ordId);
}
