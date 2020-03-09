package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTCustomerCareDao;
import com.zktr.crmproject.dao.mybatis.HTIContactsDao;
import com.zktr.crmproject.dao.mybatis.HTICustomerCareDao;
import com.zktr.crmproject.dao.mybatis.HTIUserDao;
import com.zktr.crmproject.pojos.Contacts;
import com.zktr.crmproject.pojos.Customercare;
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
    private HTIContactsDao icontactsDao;
    @Autowired
    private HTIUserDao iUserDao;
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
     * 通过客户ID查询所有的联系人
     * @param cusId
     * @return
     */
    public List<Contacts> queryAllContactsByCusId(Integer cusId){
        return icontactsDao.queryNameByCusId(cusId);
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
