package com.zktr.crmproject.dao.mybatis;

import ch.qos.logback.core.net.server.Client;
import com.zktr.crmproject.pojos.Clientdemand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcClientdemandMDao {

    public List<Clientdemand> queryClientdemandBySoid(@Param("soId") Integer soId);

}
