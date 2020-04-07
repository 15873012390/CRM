package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Quotedetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JrcQuoteDetailsMDao {
    //PL
    public List<Quotedetails> queryByQuoId(Integer quoid);
    //PL
    public List<Quotedetails> findAllByClaIdId();
    //PL
    public Quotedetails findByQuoteClaIdId(Integer qdid);
}
