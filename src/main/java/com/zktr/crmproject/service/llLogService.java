package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.llLogDao;
import com.zktr.crmproject.dao.mybatis.lliLogDao;
import com.zktr.crmproject.pojos.Log;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class llLogService {
    @Autowired
    private llLogDao llLogDao;
    @Autowired
    private lliLogDao lliLogDao;
    public void save(Log log){
        llLogDao.save(log);
    }
    public Pager<Log> findAllLogs(Integer curpage, Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Log> list=lliLogDao.qeryAllLog();
        PageInfo<Log> pager = new PageInfo<>(list);
        return new Pager<Log>(pager.getTotal(),pager.getList());
    }
    public Pager<Log> findLogsByName(Integer curpage, Integer pagesize,String uname){
        PageHelper.startPage(curpage,pagesize);
        List<Log> list=lliLogDao.qeryLogByName(uname);
        PageInfo<Log> pager = new PageInfo<>(list);
        return new Pager<Log>(pager.getTotal(),pager.getList());
    }
}
