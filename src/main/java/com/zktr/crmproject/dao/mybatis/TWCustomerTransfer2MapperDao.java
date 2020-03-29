package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Customertransfer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TWCustomerTransfer2MapperDao {
    //查询所有客户转移日志
    public List<Customertransfer> findAllCustomerTransfer();
    //根据用户id查询客户转出日志
    public List<Customertransfer> findCustomerTransferById1(Integer uId);
    //根据用户id查询客户转入日志
    public List<Customertransfer> findCustomerTransferById2(Integer uId);
}
