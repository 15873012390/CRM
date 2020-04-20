package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Quote;
import com.zktr.crmproject.pojos.Quotedetails;
import com.zktr.crmproject.vo.JrcQuoteDetailsAdvance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcQuoteDetailsMDao {

    public List<Quotedetails> queryQuoteDetailsByQuoId(@Param("quoId") Integer quoId);

    public List<Quotedetails> queryAllByPage();

    //PL
    public List<Quotedetails> queryByQuoId(Integer quoid);
    //PL
    public List<Quotedetails> findAllByClaIdId();
    //PL
    public Quotedetails findByQuoteClaIdId(Integer qdid);


    public List<Quotedetails> queryLikeQuotedetails(@Param("input") String input);

    public List<Quotedetails> queryAdvanceQuotedetails(JrcQuoteDetailsAdvance jrcQuoteDetailsAdvance);

}
