package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.mybatis.lliUserDao;
import com.zktr.crmproject.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TWUserService {
    @Autowired(required = false)
    private lliUserDao lliUserDao;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryAllUsers(){
        return lliUserDao.findAllUsers();
    }
}
