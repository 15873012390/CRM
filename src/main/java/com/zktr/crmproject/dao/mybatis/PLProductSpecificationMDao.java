package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Productspecification;
import com.zktr.crmproject.vo.ProductSpecificationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface PLProductSpecificationMDao {
    public List<Productspecification> queryAllByProid(Integer proid);

    public void insertSpe(ProductSpecificationVo productSpecificationVo);

    public void updateSpe(@Param("speSpecification") String speSpecification, @Param("speUnit") String speUnit, @Param("speUnitConversion") Integer speUnitConversion, @Param("speid") Integer speid);

    public Productspecification queryBySepId(@Param("speid") Integer speid);
    //合同 查询分类是服务的产品
    public List<Productspecification> queryByClaState();

    public void insertSpeProduct(Productspecification productspecification);
}
