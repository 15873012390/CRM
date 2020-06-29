package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.PLProductSpecificationJDao;
import com.zktr.crmproject.dao.mybatis.PLProductSpecificationMDao;
import com.zktr.crmproject.dao.mybatis.PLproductMDao;
import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.pojos.Productspecification;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.ProductSpecificationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PLProductSepcificationService {
    @Autowired
    private PLProductSpecificationJDao psjdao;
    @Autowired
    private PLProductSpecificationMDao psmdao;
    @Autowired
    private PLproductMDao pmdao;


    /**
     * 分页根据产品id查询该产品的所有规格
     * @param proid
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Productspecification> queryAllByProid(Integer proid,int curpage,int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Productspecification> productspecificationList=psmdao.queryAllByProid(proid);
        PageInfo<Productspecification> page=new PageInfo<>(productspecificationList);
        return new Pager<Productspecification>(page.getTotal(),page.getList());
    }


    /**
     * mybatis 新增
     * @param productSpecificationVo
     */
    public void addEditSpecification(ProductSpecificationVo productSpecificationVo){
        Product p=new Product();
        //查找存不存在产品id
        p=pmdao.findByid(productSpecificationVo.getProId());
        if(p!=null){
            //先把传进来的vo对象中的speid值赋值给一个变量
            int speone= productSpecificationVo.getSpeId();
            System.out.println(speone);
            Productspecification spe=new Productspecification();
            System.out.println("传进来的speid"+speone);
            //把变量去查找一遍
            if(speone==0 ){
                //如果不存在就新增
                psmdao.insertSpe(productSpecificationVo);
            }else {
                //存在就编辑
                psmdao.updateSpe(productSpecificationVo.getSpeSpecification(),productSpecificationVo.getSpeUnit(),productSpecificationVo.getSpeUnitConversion(),productSpecificationVo.getSpeId());
            }

        }else {
            System.out.println("产品id不存在！");
        }
    }

    /**
     * 编辑 查找id
     * @param speid
     * @return
     */
    public Productspecification queryBySepId(Integer speid){
        return psmdao.queryBySepId(speid);
    }

    /**
     * 删除
     * @param speid
     */
    public void delSpe(Integer speid){
        psmdao.delBySpeId(speid);
        //psjdao.deleteById(speid);
    }


}
