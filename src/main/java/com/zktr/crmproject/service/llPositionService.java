package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.llPositionDao;
import com.zktr.crmproject.dao.mybatis.llUserAndPositionDao;
import com.zktr.crmproject.dao.mybatis.lliPositionDao;
import com.zktr.crmproject.pojos.Position;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.UserAndPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class llPositionService {
    //获取所有职位信息
    @Autowired
    private llPositionDao llPositionDao;
    @Autowired
    private lliPositionDao lliPositionDao;
    @Autowired
    private llUserAndPositionDao llUserAndPositionDao;
    public Pager<Position> findAllPositons(Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Position> list=lliPositionDao.findAllPosition();
        PageInfo<Position> pager = new PageInfo<>(list);
        return new Pager<Position>(pager.getTotal(),pager.getList());
    }
    //获得职位信息
    public List<Position> qeryAllPosition(){
        return lliPositionDao.qeryAllPosition();
    }
    //新增职位
    public void addPosition(Position p){
        llPositionDao.save(p);
    }
    //修改职位信息
    public void updatePosition(Position p){
        Position po=llPositionDao.findById(p.getPostId()).get();
        po.setPostName(p.getPostName());
        po.setPostMes(p.getPostMes());
    }
    //获得该职位所有用户
    public List<UserAndPosition> positionUser(Integer postId){
        return llUserAndPositionDao.positionUser(postId);
    }
    //模糊查询
    public Pager<Position> queryLikePosition(String postName){
        PageHelper.startPage(1,5);
        List<Position> list=lliPositionDao.queryLikePosition(postName);
        PageInfo<Position> pager = new PageInfo<>(list);
        return new Pager<Position>(pager.getTotal(),pager.getList());
    }
}
