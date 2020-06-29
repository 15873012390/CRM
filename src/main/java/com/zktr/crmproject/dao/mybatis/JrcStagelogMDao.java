package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Stagelog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface JrcStagelogMDao {

    public List<Stagelog> queryStageLogBySoid(@Param("soid") int soid);

    //删除销售机会时关联删除数据
    public void deleteStageLogBySoid(@Param("soId") int soid);

}
