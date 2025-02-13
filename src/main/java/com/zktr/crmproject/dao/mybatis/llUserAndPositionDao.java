package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.PowerAndDept;
import com.zktr.crmproject.vo.UserAndPosition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface llUserAndPositionDao {
//    public User findById(@Param("uid") Integer uid);
//    public User findByNameAndPass(@Param("uname") String uname, @Param("upass") String upass);
    public List<UserAndPosition> findAllUsers();
    public List<PowerAndDept> queryLikeName(@Param("uname") String name);
    public List<PowerAndDept> screenUser(@Param("value") String value);
    public List<UserAndPosition> positionUser(@Param("postId") Integer postId);
}
