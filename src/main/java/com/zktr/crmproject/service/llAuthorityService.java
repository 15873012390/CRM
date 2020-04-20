package com.zktr.crmproject.service;


import com.zktr.crmproject.dao.jpa.llPositionDao;
import com.zktr.crmproject.dao.jpa.llPowerDao;
import com.zktr.crmproject.dao.mybatis.llUserAndPositionDao;
import com.zktr.crmproject.dao.mybatis.lliPowerTreeDao;
import com.zktr.crmproject.pojos.Position;
import com.zktr.crmproject.pojos.Power;
import com.zktr.crmproject.pojos.PowerManage;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.vo.UserAndPositionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class llAuthorityService {
    @Autowired
    private llPositionDao llPositionDao;
    @Autowired
    private com.zktr.crmproject.dao.jpa.llUserDao llUserDao;
    @Autowired
    private llUserAndPositionDao llUserAndPositionDao;
    @Autowired
    private lliPowerTreeDao lliPowerTreeDao;
    @Autowired
    private llPowerDao llPowerDao;
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
    //将用户的某个职位删除
    public void removeUserP(Integer uId,Integer postId){
        User user=llUserDao.findById(uId).get();
        for(Position p:user.getPosition()){
            if(p.getPostId()==postId) {
                p.getUser().remove(user);
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
        //用户对象
        User user= llUserDao.findById(uid).get();
        //该用户的职位
        List<Position> p=user.getPosition();
        Integer[] i=new Integer[200];
        int j=0;
        for(Position p1:p) {
            //职位所有的权限
            List<Power> po = p1.getPower();
            for (Power pow : po) {
                i[j] = pow.getPowerId();
                j++;
            }
        }
        return i;
    }
    //获得所有权限
    public List<PowerManage> findAllPower(){
        List<PowerManage> list=lliPowerTreeDao.findAllPower();
        System.out.println(list);
        return list;
    }
    //获得职位上的所有权限
    public Integer[] positionPower(Integer pid){
        Position p=llPositionDao.findById(pid).get();
        List<Power> po=p.getPower();
        if(po.size()>0){
            Integer i[]=new Integer[po.size()];
            int j=0;
            for(Power pow:po){
                i[j]=pow.getPowerId();
                j++;
            }
            return i;
        }else {
            return null;
        }
    }
    //给职位添加修改权限
    public void addUpdateRole(UserAndPositionParam u){
        //将需要的权限id挑出来
        Integer i[]=new Integer[u.getPostId().length];
        int k=0;
        for(int j=0;j<u.getPostId().length;j++){
            if(u.getPostId()[j]>100){
                i[k]=u.getPostId()[j];
                k++;
            }
        }
        //将职位原有的权限全部删除
        Position p=llPositionDao.findById(u.getuId()).get();
        System.out.println(p);
        for(Power po:p.getPower()){
            po.getPosition().remove(p);
        }
        //然后将权限加上去
        for(Integer powerId:i){
            if(powerId!=null) {
                Power power = llPowerDao.findById(powerId).get();
                System.out.println(power);
                power.getPosition().add(p);
            }
        }
    }
}
