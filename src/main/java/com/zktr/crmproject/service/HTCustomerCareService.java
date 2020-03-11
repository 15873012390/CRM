package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTCustomerCareDao;
import com.zktr.crmproject.dao.mybatis.HTIContactsDao;
import com.zktr.crmproject.dao.mybatis.HTICustomerCareDao;
import com.zktr.crmproject.dao.mybatis.HTIUserDao;
import com.zktr.crmproject.pojos.Contacts;
import com.zktr.crmproject.pojos.Customercare;
import com.zktr.crmproject.pojos.Customerservice;
import com.zktr.crmproject.vo.CustomerCareAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class HTCustomerCareService {
    @Autowired
    private HTICustomerCareDao icustomerCareDao;
    @Autowired
    private HTCustomerCareDao customerCareDao;

    /**
     * 分页查询所有的客户关怀
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customercare> queryAllCustomerCareByPage(Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customercare> list = icustomerCareDao.queryAllByPage();
        PageInfo<Customercare> pager = new PageInfo<>(list);
        return new Pager<Customercare>(pager.getTotal(),pager.getList());
    }

    /**
     * 分页高级查询
     * @param ccs
     * @return
     */
    public Pager<CustomerCareAdvancedSearch> queryCustomercareByAdvancedSearch(CustomerCareAdvancedSearch ccs){
        PageHelper.startPage(ccs.getCurPage(),ccs.getPageSize());
        if(ccs.getCcDate()!=null && ccs.getCcDate().length>1){
            ccs.setS1(ccs.getCcDate()[0]);
            ccs.setS2(ccs.getCcDate()[1]);
        }
        List<CustomerCareAdvancedSearch> list = icustomerCareDao.queryConditionByPage(ccs);
        PageInfo<CustomerCareAdvancedSearch> pager = new PageInfo<>(list);
        return new Pager<CustomerCareAdvancedSearch>(pager.getTotal(),pager.getList());
    }

    /**
     * 分页显示客户服务页面
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customercare> queryLikeCustomerCare(String value, String input, String select, Integer curpage, Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customercare> clist = icustomerCareDao.queryLikeCustomerCare(value,"%"+input.trim()+"%",select);
        PageInfo<Customercare> pager = new PageInfo<>(clist);
        return new Pager<Customercare>(pager.getTotal(),pager.getList());
    }

    /**
     * 增加/编辑所有客户关怀
     * @param customercare
     */
    public void addAndEditCustomerCare(Customercare customercare){
      customerCareDao.save(customercare);
    }

    /**
     * 通过客户关怀ID删除
     * @param ccId
     */
    public void deleteByCcId(Integer ccId){
        customerCareDao.deleteById(ccId);
    }

    /**
     * 批量删除
     * @param ccIds
     */
    public void deleteByCcIds(Integer[] ccIds){
        for(Integer c : ccIds){
            customerCareDao.deleteById(c);
        }
    }

    /**
     * 通过客户关怀ID查询客户关怀
     * @param ccId
     * @return
     */
    public Customercare queryCustomerCareByCcId(Integer ccId){
        return icustomerCareDao.queryById(ccId);
    }








}
