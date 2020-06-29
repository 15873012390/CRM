package com.zktr.crmproject.service;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.zktr.crmproject.dao.jpa.PLProductJDao;
import com.zktr.crmproject.dao.jpa.PLProductSpecificationJDao;
import com.zktr.crmproject.dao.mybatis.HTIStockDao;
import com.zktr.crmproject.dao.mybatis.PLProductClassificationMDao;
import com.zktr.crmproject.dao.mybatis.PLProductSpecificationMDao;
import com.zktr.crmproject.dao.mybatis.PLproductMDao;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.utils.QiniuUtils;
import com.zktr.crmproject.vo.PLCountPie;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.ProductAdvancedSearch;
import com.zktr.crmproject.vo.ProductSpecificationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.*;

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
    private HTIStockDao stockDao;
    @Autowired
    private PLProductClassificationMDao productClassificationMDao;


    /**
     * 分页查询全部产品
     * @param curpage
     * @param sizepage
     * @return
     */
    public Pager<Product> queryByPageProduct(int curpage, int sizepage){

        //PageHelper.startPage(curpage,sizepage);
        List<Product> list1=pmpdao.queryAllProduct();
        List list2=new ArrayList();
        for (int i=0;i<sizepage;i++){
            //得到想要显示的下标
            int index=(curpage-1)*sizepage+i;
            if (index<list1.size()){
                if(list1.get(index)!=null){
                    list2.add(list1.get(index));
                }
            }
        }
        /*PageInfo<Product> pager=new PageInfo<>(productList);
        System.out.println("sss"+pager.getTotal());*/
        return new Pager<Product>(list1.size(),list2);
    }


    /**
     * 新增产品和修改产品
     * @param product
     */
    public Integer addAndUpdateProduct(Product product){
        System.out.println("76"+product.getProId());
            product.setProDelState(1);
            product.setProDate(new Timestamp(System.currentTimeMillis()));
            //保存
            if(product.getProId()==0){
                pmpdao.insertProduct(product);
                List<Productspecification> list=psmdao.queryAllByProid(product.getProId());
                System.out.println("83"+list);
                if(list.size()==0){
                        System.out.println(86);
                        Productspecification productspecification=new Productspecification();
                        productspecification.setProduct(product);
                        productspecification.setProName(product.getProName());
                        productspecification.setSpeSpecification("基准");
                        productspecification.setSpeUnit("个");
                        productspecification.setSpeUnitConversion(1);
                        psmdao.insertSpeProduct(productspecification);
                        return product.getProId();
                }else{
                    return 0;
                }
            }else{
                pmpdao.updateProduct(product);
            }
          return 0;


    }

    /**
     * 新增规格
     */
    public void addspe(){
        List<Product> list=pmpdao.queryAllProduct();
        Productspecification productspecification=new Productspecification();
        productspecification.setProduct(list.get(0));
        productspecification.setProName(list.get(0).getProName());
        productspecification.setSpeSpecification("基准");
        productspecification.setSpeUnit("个");
        productspecification.setSpeUnitConversion(1);
        psmdao.insertSpeProduct(productspecification);
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

    /**
     * 根据产品id查找
     * @param proid
     * @return
     */
    public Product findByids(Integer proid){
        return pjpdao.findById(proid).get();
    }

    /**
     * 根据产品id查找
     * @param proid
     * @return
     */
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
        List<Product> list1=pmpdao.queryByselect(value,"%"+input.trim()+"%");
        List list2=new ArrayList();
        for (int i=0;i<sizepage;i++){
            //得到想要显示的下标
            int index=(curpage-1)*sizepage+i;
            if (index<list1.size()){
                if(list1.get(index)!=null){
                    list2.add(list1.get(index));
                }
            }
        }

        return new Pager<Product>(list1.size(),list2);
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
       // PageHelper.startPage(productAdvancedSearch.getCurpage(),productAdvancedSearch.getSizepage());
        List<Product> list1=pmpdao.ProductAdvancedSearch(productAdvancedSearch);
        List list2=new ArrayList();
        for (int i=0;i<productAdvancedSearch.getSizepage();i++){
            //得到想要显示的下标
            int index=(productAdvancedSearch.getCurpage()-1)*productAdvancedSearch.getSizepage()+i;
            if (index<list1.size()){
                if(list1.get(index)!=null){
                    list2.add(list1.get(index));
                }
            }
        }
        return new Pager<Product>(list1.size(),list2);
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

    /**
     * 模糊查询
     * @param input
     * @return
     */
    public List<Product> likeByInput(String input){
        List<Product> like=pmpdao.likeByInput("%"+input.trim()+"%");
        return like;
    }
    public List<Product> selectByValue(String value){
        System.out.println(value);
        List<Product> select=pmpdao.selectByValue(value.trim());
        return select;
    }

    /**
     * 选择产品页面
     * @return
     */
    public List<Product> findAllBySepcification(){
        return pmpdao.findAll();
    }

    /**
     * 选择产品页面
     * @param speid
     * @return
     */
    public Product findBySpeid(Integer speid){
        return pmpdao.findBySpeid(speid);
    }

    /**
     * 选择产品页面
     * @return
     */
    public List<Productclassification> findAllByClaStock(){
        return productClassificationMDao.findAllByStock();
    }

    /**
     * 选择产品页面
     * @return
     */
    public List<Productclassification> findAllCla(){
        return productClassificationMDao.findAll();
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
