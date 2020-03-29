package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.vo.TWCustomertransfer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TWCustomerTransferMapperDao {
    //查询所有客户转移日志
    public List<TWCustomertransfer> findAllCustomerTransfer();
    //根据用户id查询客户转出日志
    public List<TWCustomertransfer> findCustomerTransferById1(Integer uId);
    //根据用户id查询客户转入日志
    public List<TWCustomertransfer> findCustomerTransferById2(Integer uId);
}
