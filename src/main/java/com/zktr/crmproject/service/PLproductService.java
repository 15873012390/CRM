package com.zktr.crmproject.service;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.PLProductJDao;
import com.zktr.crmproject.dao.jpa.PLProductSpecificationJDao;
import com.zktr.crmproject.dao.mybatis.HTIStockDao;
import com.zktr.crmproject.dao.mybatis.PLProductSpecificationMDao;
import com.zktr.crmproject.dao.mybatis.PLproductMDao;
import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.pojos.Productclassification;
import com.zktr.crmproject.pojos.Salesopport;
import com.zktr.crmproject.vo.PLCountPie;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.ProductAdvancedSearch;
import com.zktr.crmproject.vo.ProductSpecificationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class PLproductService {
    @Autowired
    private PLproductMDao pmpdao;
    @Autowired
    private PLProductJDao pjpdao;
    @Autowired
    private PLProductSpecificationMDao psmdao;
    @Autowired
    private PLProductSpecificationJDao psjdao;
    @Autowired
    private HTIStockDao stockDao;

    /**
     * 分页查询全部产品
     * @param curpage
     * @param sizepage
     * @return
     */
    public Pager<Product> queryByPageProduct(int curpage, int sizepage){
        PageHelper.startPage(curpage,sizepage);
        List<Product> productList=pmpdao.queryAllProduct();
        PageInfo<Product> pager=new PageInfo<>(productList);
        return new Pager<Product>(pager.getTotal(),pager.getList());
    }



    /**
     * 新增和修改
     * @param product
     */
    public Integer addAndUpdateProduct(Product product){
       product.setProDelState(1);
       //保存
       pjpdao.save(product);
        ProductSpecificationVo productSpecificationVo=new ProductSpecificationVo();
        //找到最大的id添加进去
        //Integer proid=pmpdao.findMaxProid();
        List<Product> list=pmpdao.queryAllProduct();
        productSpecificationVo.setProId(list.get(0).getProId());
        productSpecificationVo.setProName(product.getProName());
        productSpecificationVo.setSpeSpecification("基准");
        productSpecificationVo.setSpeUnit("个");
        productSpecificationVo.setSpeUnitConversion(1);
        psmdao.insertSpe(productSpecificationVo);
       return product.getProId();

    }

    public void addSpe(){

    }

    /**
     * 删除
     * @param pid
     */
    public void deleteProudct(Integer pid){
        Product p=new Product();
        p=pmpdao.findByid(pid);
        p.setProDelState(2);
        pjpdao.save(p);
    }

    /**
     * 批量删除
     * @param pids
     */
    public void deleteProducts(Integer[] pids){
        Product p=new Product();
        for (Integer pid:pids){
            p=pmpdao.findByid(pid);
            p.setProDelState(2);
            pjpdao.save(p);
        }
    }
    public Product findByids(Integer proid){
        return pjpdao.findById(proid).get();
    }

    public Product findByid(int proid){
        return pmpdao.findByid(proid);
    }

    /**
     *
     * @param value 下拉框的值
     * @param input 输入框的值
     * @param curpage 当前页
     * @param sizepage 页大小
     * @return
     */
    public Pager<Product> queryByselect(String value,String input,int curpage,int sizepage){

        PageHelper.startPage(curpage,sizepage);
        List<Product> productList=pmpdao.queryByselect(value,"%"+input.trim()+"%");
        PageInfo<Product> page=new PageInfo<>(productList);
        return  new Pager<Product>(page.getTotal(),page.getList());
    }

    /**
     * 高级查询
     * @param productAdvancedSearch
     * @return
     */
    public Pager<Product> ProductAdvancedSearch(ProductAdvancedSearch productAdvancedSearch){
        String proName="%"+productAdvancedSearch.getProName().trim()+"%";
        String proMode="%"+productAdvancedSearch.getProMode().trim()+"%";
        productAdvancedSearch.setProName(proName);
        productAdvancedSearch.setProMode(proMode);
        if(productAdvancedSearch.getProPrice()==0.0 || productAdvancedSearch.getProCostprice()==0.0){
            productAdvancedSearch.setProPrice(null);
            productAdvancedSearch.setProCostprice(null);
        }
        PageHelper.startPage(productAdvancedSearch.getCurpage(),productAdvancedSearch.getSizepage());
        List<Product> productList=pmpdao.ProductAdvancedSearch(productAdvancedSearch);
        PageInfo<Product> page=new PageInfo<>(productList);
        System.out.println(productAdvancedSearch.getProState()+"\t"+productAdvancedSearch.getProPrice()+"\t"+productAdvancedSearch.getProCostprice());
        return new Pager<Product>(page.getTotal(),page.getList());
    }

    /**
     * 产品表格价格和成本价格合计
     * @return
     */
    public List<Map> statisticsByMoney(){
        return pmpdao.statisticsByMoney();
    }

    /**
     * 打印页面
     * @return
     */
    public List<Product> findAll(){
        return pmpdao.queryAllProduct();
    }

    /**
     * 导入excel
     * @param products
     */
    public void insertAllProduct(List<Product> products){
        for(Product p:products){
            if (p!=null){
                pjpdao.save(p);
            }
        }
    }

    public List<Product> test(){
        return pmpdao.test();
    }

    /**
     * 模糊查询
     * @param input
     * @return
     */
    public List<Product> likeByInput(String input){
        //System.out.println(input);
        List<Product> like=pmpdao.likeByInput("%"+input.trim()+"%");
        return like;
    }
    public List<Product> selectByValue(String value){
        System.out.println(value);
        List<Product> select=pmpdao.selectByValue(value.trim());
        return select;
    }
    public List<Product> findAllBySepcification(){
        return pmpdao.findAll();
    }
    public Product findBySpeid(Integer speid){
        return pmpdao.findBySpeid(speid);
    }

    /** HT
     * 入库所需的产品
     * @return
     */
    public List<Product> queryAllProductInstock(){
        return pmpdao.queryAllProductInstock();
    }

    /** HT
     * 选择入库所需的产品
     * @param speid
     * @return
     */
    public Product findBySpeidInstock(Integer speid){
        return pmpdao.findBySpeidInstock(speid);
    }
    //产品详情页上 统计每个仓库还有多少库存
    public List<PLCountPie> PLQueryByStock(){
        return stockDao.PLQueryByStock();
    }
}
