package com.zktr.crmproject.dao.mybatis;


import com.zktr.crmproject.pojos.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JrcUserMDao {

    public List<User> queryAll();

}
