package com.zktr.crmproject.service;


import com.zktr.crmproject.dao.mybatis.llUserAndPositionDao;
import com.zktr.crmproject.pojos.Position;
import com.zktr.crmproject.pojos.Power;
import com.zktr.crmproject.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class llAuthorityService {
    @Autowired
    private com.zktr.crmproject.dao.jpa.llPositionDao llPositionDao;
    @Autowired
    private com.zktr.crmproject.dao.jpa.llUserDao llUserDao;
    @Autowired
    private llUserAndPositionDao llUserAndPositionDao;
    //用户增加修改职位
    public void addAndUserPosition(Integer uid,Integer[] postids){
        User user=llUserDao.findById(uid).get();
        //如果用户有职位，先将相同全部清除，再重新增加
        if(user.getPosition()!=null){
            for(Position p:user.getPosition()){
                p.getUser().remove(user);
            }
            for(Integer i:postids){
                Position p=llPositionDao.findById(i).get();
                p.getUser().add(user);
            }
        }
    }
    //获得用户权限
    /*
    1,获得所有职位
    2，获得职位权限
    3，将其返回
     */
    public Integer[] checkPower(Integer uid){
        List<Power> po=new ArrayList<>();
        Position p1=new Position();
        Integer i[]=new Integer[10];
        int j=0;
        User user= llUserDao.findById(uid).get();
        System.out.println(user+"3");
        for (Position p:user.getPosition()){
            po=p.getPower();
            i[j]=po.get(0).getPowerId();
//            System.out.println("来了");
//            System.out.println(i[j]+"j");
            j++;
        }
        return i;
    }
}
