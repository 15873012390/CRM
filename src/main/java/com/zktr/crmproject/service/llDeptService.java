package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.jpa.llDeptDao;
import com.zktr.crmproject.dao.jpa.llUserDao;
import com.zktr.crmproject.dao.mybatis.lliDeptDao;
import com.zktr.crmproject.dao.mybatis.lliUserDao;
import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class llDeptService {
    @Autowired
    private lliDeptDao lliDeptDao;
    @Autowired
    private llDeptDao llDeptDao;
    @Autowired
    private llUserDao llUserDao;
    @Autowired
    private lliUserDao lliUserDao;
    //获取所有部门信息
    public List<Department> findAllDept(){
        List<Department> list=lliDeptDao.findAllDepartment();
        return list;
    }
    //新增部门
    public Integer addDept(Department department){
//        Department de=llDeptDao.findById(department.getdId()).get();
        Department d=llDeptDao.findByName(department.getdName());
        if (department.getdId()>0){
            return this.updateDept(department);
        }else{
            if (d==null) {
                llDeptDao.save(department);
                return 1;
            }else {
                return 0;
            }
        }
    }
    //修改部门
    public Integer updateDept(Department department){
        Department d=llDeptDao.findById(department.getdId()).get();
        d.setdName(department.getdName());
        d.setdFunction(department.getdFunction());
        d.setParentId(department.getParentId());
        return 1;
    }
    //删除部门
    public Integer deleteDept(Integer id){
        //如果部门有成员（在职），或是子部门，不能删
        List<User> u=llUserDao.findDeleteDept(id);
        List<Department> d=llDeptDao.findDeleteDept(id);
        System.out.println(u);
        System.out.println(d);
        if(u.size()==0 && d.size()==0){
            llDeptDao.deleteById(id);
            return 1;
        }else {
            return 0;
        }
    }
    //遣散部门内所有员工
    public Integer disbandUser(Integer id){
        List<User> list=llUserDao.disbandUsers(id);
        if(list.size()>0){
            for (User user:list){
                user.setDepartment(null);
            }
            return 1;
        }else {
            return 0;
        }
    }
    //获得所有没有部门的在职员工
    public List<User> queryAtUser(){
        List<User> list=lliUserDao.queryAtUser();
        return list;
    }
    //批量移动员工
    public void MoveUser(Integer[] uid,Integer dId){
        Department d=llDeptDao.findById(dId).get();
        for (Integer u:uid){
            llUserDao.findById(u).get().setDepartment(d);
        }
    }
}
