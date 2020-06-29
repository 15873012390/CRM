package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Productspecification;
import com.zktr.crmproject.vo.ProductSpecificationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface PLProductSpecificationMDao {
    //根据产品id查询全部规格
    public List<Productspecification> queryAllByProid(Integer proid);
    //新增vo
    public void insertSpe(ProductSpecificationVo productSpecificationVo);
    //修改
    public void updateSpe(@Param("speSpecification") String speSpecification, @Param("speUnit") String speUnit, @Param("speUnitConversion") Integer speUnitConversion, @Param("speid") Integer speid);
    //根据规格id查找规格对象
    public Productspecification queryBySepId(@Param("speid") Integer speid);
    //合同 查询分类是服务的产品
    public List<Productspecification> queryByClaState();
    //新增
    public void insertSpeProduct(Productspecification productspecification);
    //合同页面 根据规格id查找产品销售金额 赋值给合同金额
    public Productspecification findBySpeIdPrice(Integer speId);
    //删除
    public void delBySpeId(Integer speId);
}
