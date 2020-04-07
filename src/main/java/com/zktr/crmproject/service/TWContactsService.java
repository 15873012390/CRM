package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.TWIContactsDao;
import com.zktr.crmproject.dao.mybatis.TWContactsMapperDao;
import com.zktr.crmproject.pojos.Contacts;
import com.zktr.crmproject.vo.AdvancedQueryContactsData;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TWContactsService {
    @Autowired
    private TWIContactsDao TWIContactsDao;
    @Autowired(required = false)
    private TWContactsMapperDao TWContactsMapperDao;

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
            list= TWContactsMapperDao.queryAllContactsByIdASC();
        }else if (prop.equals("conId")&&order.equals("descending")){
            list= TWContactsMapperDao.queryAllContacts();
        }
        else {
            list= TWContactsMapperDao.queryAllContacts();
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
           list= TWContactsMapperDao.queryContactsByShuJu1();
        }else if (ShuJu==2){
            list= TWContactsMapperDao.queryContactsByShuJu2();
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
        List<Contacts> list= TWContactsMapperDao.queryContactsSenior(advancedQueryContactsData);
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
        List<Contacts> list= TWContactsMapperDao.queryContactsByName(name);
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
        List<Contacts> list= TWContactsMapperDao.queryContactsById(id);
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据id加载联系人
     * @param conid
     * @return
     */
    public Contacts findContacts(Integer conid){
        return TWContactsMapperDao.findContactsById(conid);
    }

    /**
     * 查询所有联系人
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Contacts> queryAllContacts(Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Contacts> list= TWContactsMapperDao.queryAllContacts();
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加/修改联系人
     * @param contacts
     */
    public void saveContacts(Contacts contacts){
        TWIContactsDao.save(contacts);
    }

    public void saveContactsByIds(Contacts contacts){
        TWIContactsDao.save(contacts);
    }

    /**
     * 删除联系人
     * @param conId
     */
    public void deleteContacts(Integer conId){
        TWIContactsDao.deleteById(conId);
    }

    /**
     * 批量删除联系人
     * @param conIds
     */
    public void deleteContactsByIds(Integer[] conIds){
        for (Integer conId:conIds){
            TWIContactsDao.deleteById(conId);
        }
    }
}
