package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.IContactsDao;
import com.zktr.crmproject.dao.mybatis.IContactsMapperDao;
import com.zktr.crmproject.pojos.Contacts;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.vo.AdvancedQueryContactsData;
import com.zktr.crmproject.vo.AdvancedQueryCustomerData;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TWContactsService {
    @Autowired
    private IContactsDao iContactsDao;
    @Autowired(required = false)
    private IContactsMapperDao iContactsMapperDao;

    /**
     * 排序联系人
     * @param prop
     * @param order
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Contacts> queryAllContactsByIdASC(String prop,String order, Integer curpage,Integer pagesize){
        List<Contacts> list=null;
        PageHelper.startPage(curpage,pagesize);
        if (prop.equals("conId")&&order.equals("ascending")){
            list=iContactsMapperDao.queryAllContactsByIdASC();
        }else if (prop.equals("conId")&&order.equals("descending")){
            list=iContactsMapperDao.queryAllContacts();
        }
        else {
            list=iContactsMapperDao.queryAllContacts();
        }
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据数据查询客户
     * @param ShuJu
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Contacts> queryContactsByShuJu(Integer ShuJu,Integer curpage,Integer pagesize){
        List<Contacts> list=null;
        PageHelper.startPage(curpage,pagesize);
        if (ShuJu==1){
           list=iContactsMapperDao.queryContactsByShuJu1();
        }else if (ShuJu==2){
            list=iContactsMapperDao.queryContactsByShuJu2();
        }
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 高级查询联系人
     * @param advancedQueryContactsData
     * @return
     */
    public Pager<Contacts> queryContactsSenior(AdvancedQueryContactsData advancedQueryContactsData){
        PageHelper.startPage(advancedQueryContactsData.getCurpage(),advancedQueryContactsData.getPagesize());
        List<Contacts> list=iContactsMapperDao.queryContactsSenior(advancedQueryContactsData);
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据名称模糊查询客户
     * @param name
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Contacts> queryContactsByName(String name,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Contacts> list=iContactsMapperDao.queryContactsByName(name);
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据id查询联系人
     * @param id
     * @return
     */
    public Pager<Contacts> queryContactsById(Integer id,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Contacts> list=iContactsMapperDao.queryContactsById(id);
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据id加载联系人
     * @param conid
     * @return
     */
    public Contacts findContacts(Integer conid){
        return iContactsMapperDao.findContactsById(conid);
    }

    /**
     * 查询所有联系人
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Contacts> queryAllContacts(Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Contacts> list=iContactsMapperDao.queryAllContacts();
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加/修改联系人
     * @param contacts
     */
    public void saveContacts(Contacts contacts){
        iContactsDao.save(contacts);
    }

    /**
     * 删除联系人
     * @param conId
     */
    public void deleteContacts(Integer conId){
        iContactsDao.deleteById(conId);
    }


}
