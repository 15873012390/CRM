package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.pojos.Productclassification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PLProductClassificationMDao {
    //查询全部分类
    public List<Productclassification> queryAllProductClassification();
    //根据分类id查询分类
    public Productclassification findByClaId(Integer claid);
    //连接库存 不显示服务类 产品选择
    public List<Productclassification> findAllByStock();
    //不连接库存 不显示服务类 产品选择
    public List<Productclassification> findAll();
}
