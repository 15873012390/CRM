package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.vo.ProductAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PLproductMDao {
    public List<Product> queryAllProduct();
    public Product findByid(@Param("proid") Integer proid);
    public List<Product> queryByselect(@Param("value") String value, @Param("input") String input);
    public List<Product> ProductAdvancedSearch(ProductAdvancedSearch productAdvancedSearch);
    public List<Map> statisticsByMoney();
    public List<Product> test();
    public List<Product> likeByInput(@Param("input") String input);
    public List<Product> selectByValue(@Param("value") String value);
    public void insertProduct(Product product);
    public void updateProduct(Product product);
    //查询产品页面
    public List<Product> findAll();
    public Product findBySpeid(@Param("speid") Integer speid);
    public int findMaxProid();

    //HT
    public List<Product> queryAllProductInstock();
    public Product findBySpeidInstock(@Param("speid") Integer speid);



}
