package com.zktr.crmproject.dao.jpa;


import com.zktr.crmproject.pojos.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface llUserDao extends CrudRepository<User,Integer> {
    @Query("from User u where u.uName=?1")
    public User findByName(String name);
    @Query("select u from User u where u.uName=?1 and u.uPass=?2")
    public User queryByNameAndPwd(String name, String pass);
//    @Query("update User u set =?1 where uId=?2")
//    public User adddept(Integer did,Integer uid);
    @Query("select u from User u where u.department.dId=?1 and u.uStatus=1")
    public List<User> findDeleteDept(Integer did);
    @Query("from User u where u.department.dId=?1")
    public List<User> disbandUsers(Integer id);
}