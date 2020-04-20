package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface lliUserDao {
    public User findById(@Param("uid") Integer uid);
    public List<User> findAllUsers();
    public User findByNameAndPass(@Param("uname") String uname, @Param("upass") String upass);
    public List<User> queryAtUser();
    public int countDeptUser(@Param("did") Integer did);
    public List<User> findDeptUser(@Param("dId") Integer dId);
}
