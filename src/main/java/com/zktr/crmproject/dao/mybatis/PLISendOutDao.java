package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Sendout;
import com.zktr.crmproject.pojos.Sendoutdetial;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PLISendOutDao {

    public void insertSendOut(Sendout sendout);

    public void insertSendOutDetail(Sendoutdetial sendoutdetial);
}
