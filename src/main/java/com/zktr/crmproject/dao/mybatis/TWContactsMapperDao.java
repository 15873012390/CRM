package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Contacts;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.vo.AdvancedQueryContactsData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TWContactsMapperDao {
    //查询所有联系人
    public List<Contacts> queryAllContacts();
    //根据ID查询联系人
    public List<Contacts> queryContactsById(Integer id);
    //根据名称查询联系人
    public List<Contacts> queryContactsByName(String name);
    //根据ID加载联系人
    public Contacts findContactsById(Integer id);
    //高级查询联系人
    public List<Contacts> queryContactsSenior(AdvancedQueryContactsData advancedQueryContactsData);
    //根据数据查询联系人
    public List<Contacts> queryContactsByShuJu1();
    public List<Contacts> queryContactsByShuJu2();
    //根据id排序（正序）
    public List<Contacts> queryAllContactsByIdASC();

}
