package com.zktr.crmproject.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTComplaintDao;
import com.zktr.crmproject.dao.mybatis.HTIComplaintDao;
import com.zktr.crmproject.dao.mybatis.HTIContactsDao;
import com.zktr.crmproject.dao.mybatis.HTIUserDao;
import com.zktr.crmproject.pojos.Complaint;
import com.zktr.crmproject.pojos.Customercare;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class HTComplaintService {
    @Autowired
    private HTComplaintDao complaintDao;
    @Autowired
    private HTIComplaintDao iComplaintDao;

    /**
     * 分页查询所有的客户关怀
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Complaint> queryAllComplaintByPage(Integer curpage, Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Complaint> list = iComplaintDao.queryAllByPage();
        PageInfo<Complaint> pager = new PageInfo<>(list);
        return new Pager<Complaint>(pager.getTotal(),pager.getList());
    }

    /**
     * 增加/编辑所有投诉
     * @param complaint
     */
    public void addAndEditComplaint(Complaint complaint){
        complaintDao.save(complaint);
    }

    /**
     * 通过客户投诉ID删除
     * @param comId
     */
    public void deleteByComId(Integer comId){
        complaintDao.deleteById(comId);
    }

    /**
     * 批量删除
     * @param comIds
     */
    public void deleteByComIds(Integer[] comIds){
        for(Integer c : comIds){
            complaintDao.deleteById(c);
        }
    }

    /**
     * 通过客户投诉ID查询客户关怀
     * @param comId
     * @return
     */
    public Complaint queryComplaintByComId(Integer comId){
        return iComplaintDao.queryById(comId);
    }



}
