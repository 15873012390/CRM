package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Quote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcQuoteMDao {

    public List<Quote> queryQuoteBySoid(@Param("soId") Integer soId);
    public List<Quote> PLqueryAllQuote();
    //把报价状态修改成3
    public void PLupdateByQutId(Integer quoId);
    public List<Quote> queryAllByPage();

}
