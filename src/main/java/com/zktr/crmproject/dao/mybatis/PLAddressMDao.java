package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Address;
import com.zktr.crmproject.pojos.Plandetail;
import com.zktr.crmproject.vo.PLaddressVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PLAddressMDao {
    //根据id查找一个对象
    public Address findByAddid(@Param("addid") Integer addid);
    //查询全部
    public List<Address> queryAllAdress();
    //新增
    public void insertAddress(PLaddressVo pLaddressVo);
    //根据id修改
    public void updateAddress(PLaddressVo pLaddressVo);
}
