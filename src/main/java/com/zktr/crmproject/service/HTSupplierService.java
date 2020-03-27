package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.mybatis.HTISupplierDao;
import com.zktr.crmproject.pojos.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class HTSupplierService {
    @Autowired
    private HTISupplierDao iSupplierDao;

    public List<Supplier> queryAllSupplier(){
        return iSupplierDao.queryAllSupplier();
    }
}
