package com.zktr.crmproject.dao.mybatis;


import com.zktr.crmproject.pojos.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JrcUserMDao {

    public List<User> queryAll();

    public User queryByUid(@Param("uid") int uid);

    public List<User> queryByUserName(@Param("uName") String uName);
}
