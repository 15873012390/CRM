package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.mybatis.llUserAndPositionDao;
import com.zktr.crmproject.dao.mybatis.lliUserDao;
import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.PowerAndDept;
import com.zktr.crmproject.vo.UserAndPosition;
import com.zktr.crmproject.vo.UserMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class llUserService {
    @Autowired
    private com.zktr.crmproject.dao.jpa.llUserDao llUserDao;
    @Autowired
    private llUserAndPositionDao llUserAndPositionDao;
    @Autowired
    private lliUserDao lliUserDao;
    @Autowired
    private com.zktr.crmproject.dao.jpa.llDeptDao llDeptDao;

    @Autowired
    private com.zktr.crmproject.dao.jpa.llPositionDao llPositionDao;
    @Autowired
    private llAuthorityService llAuthorityService;
    //添加用户
    public User addUser(User user,Integer dId){
        User user1=llUserDao.save(user);
        Department d=llDeptDao.findById(dId).get();
        user1.setDepartment(d);
        return user1;
    }
    //修改用户
    public User updateUser(User user,Integer dId){
        User user1=llUserDao.findById(user.getuId()).get();
        Department d=llDeptDao.findById(dId).get();
        user1.setuName(user.getuName());
        user1.setuSex(user.getuSex());
        user1.setuImg(user.getuImg());
        user1.setDepartment(d);
        return user1;
    }
    //名字查重
    public int checkName(String name){
        System.out.println(llUserDao.findByName(name));
        return llUserDao.findByName(name)==null?1:0;
    }
    //登录
    public PowerAndDept login(String name, String pass){
        PowerAndDept po=new PowerAndDept();
        User user=llUserDao.queryByNameAndPwd(name,pass);
        if(user!=null && user.getuStatus()!=0){
            //用户存在后获得他的权限
            Integer[] a=llAuthorityService.checkPower(user.getuId());
            //获得职位名
            po.setPostName(user.getPosition().get(0).getPostName());
            //获得部门名
            String dept=user.getDepartment().getdName();
            //获得用户id
            po.setuId(user.getuId());
            //获得用户信息
            User user1= lliUserDao.findById(user.getuId());
            po.setuName(user1.getuName());
            po.setuSex(user1.getuSex());
            po.setuBrith(user1.getuBirth());
            po.setuJoindate(user1.getuJoindate());
            po.setuImg(user1.getuImg());
            po.setPower(a);
            po.setDeptName(dept);
            return po!=null?po:null;
        }else {
            return null;
        }
    }
    //获取用户所有信息
    public Pager<UserAndPosition> findAllUsers(Integer curpage,Integer pagesize){
//        System.out.println("首页"+curpage+"大小"+pagesize);
        PageHelper.startPage(curpage,pagesize);
        List<UserAndPosition> user= llUserAndPositionDao.findAllUsers();
        PageInfo<UserAndPosition> pager = new PageInfo<>(user);
        return new Pager<UserAndPosition>(pager.getTotal(),pager.getList());
    }
    //名字模糊查询
    public Pager<PowerAndDept> queryLikeName(String name){
        PageHelper.startPage(1,5);
        List<PowerAndDept> user=llUserAndPositionDao.queryLikeName(name);
        PageInfo<PowerAndDept> pager=new PageInfo<>(user);
        return new Pager<PowerAndDept>(pager.getTotal(),pager.getList());
    }
    //单个离职
    public void deleteOne(Integer id){
        llUserDao.findById(id).get().setuStatus(0);
    }
    //批量离职
    public void deleteMore(Integer[] params){
        for (Integer i:params){
            llUserDao.findById(i).get().setuStatus(0);
        }
    }
    //导出用户信息
    public List<User> exportUser(){
        return lliUserDao.queryAtUser();
//        return llUserAndPositionDao.findAllUsers();
    }
    //判断密码
    public Integer passTrue(Integer id,String pass){
        User user=lliUserDao.findById(id);
        if (pass.equals(user.getuPass())){
            return 1;
        }else {
            return 0;
        }
    }
    //修改密码
    public void updatePass(Integer id,String pass){
        User user=lliUserDao.findById(id);
        user.setuPass(pass);
    }
    //编辑资料
    public void editMes(UserMes userMes){
        User user=llUserDao.findById(userMes.getuId()).get();
        user.setuBirth(userMes.getuBirth());
        user.setuSex(userMes.getuSex());
        user.setuName(userMes.getuName());
        user.setuImg(userMes.getuImg());
    }
}
