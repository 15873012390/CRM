package com.zktr.crmproject.dao.mybatis;


import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.pojos.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface JrcUserMDao {

    public List<User> queryAll();

    public User queryByUid(@Param("uid") int uid);

    public List<User> queryByUserName(@Param("uName") String uName);

    public List<User> queryUserBySalesOpport(@Param("timeStart") Date timeStart,
                                             @Param("timeEnd") Date timeEnd,
                                             @Param("possibity") String possibity);

    /**
     * 获得有权限审核的员工
     * @return
     */
    public List<User> getAllUsrList();
}
