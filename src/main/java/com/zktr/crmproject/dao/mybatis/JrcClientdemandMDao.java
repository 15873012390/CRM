package com.zktr.crmproject.dao.mybatis;

import ch.qos.logback.core.net.server.Client;
import com.zktr.crmproject.pojos.Clientdemand;
import com.zktr.crmproject.vo.JrcClientDemandAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcClientdemandMDao {

    public List<Clientdemand> queryAllClientDemand();

    public Clientdemand queryClientDemandByCdId(@Param("cdId") Integer cdId);

    public List<Clientdemand> queryClientDemandByLike(@Param("value") String value, @Param("inputs") String input);

    public List<Clientdemand> queryClientDemandAdvenced(JrcClientDemandAdvancedSearch clientDemandAdvancedSearch);

    public List<Clientdemand> queryClientdemandBySoid(@Param("soId") Integer soId);


    //删除销售机会时关联删除数据
    public void deleteClientdemandBySoid(@Param("soId") Integer soId);



}
