package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.jpa.PLProductClassificationJDao;
import com.zktr.crmproject.dao.mybatis.PLProductClassificationMDao;
import com.zktr.crmproject.pojos.Productclassification;
import com.zktr.crmproject.vo.PLClassificationChild;
import com.zktr.crmproject.vo.PLClassificationParent;
import com.zktr.crmproject.vo.PLClassificationResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PLProductClassificationService {
    @Autowired
    private PLProductClassificationMDao ppcmdao;
    @Autowired
    private PLProductClassificationJDao ppcjdao;
    /**
     * 查询所有分类
     * @return
     */
    public List<Productclassification> queryall(){
        List<Productclassification> list=ppcmdao.queryAllProductClassification();

        return ppcmdao.queryAllProductClassification();
    }

    /**
     *  新增和编辑分类
     * @param productclassification
     */
    public void addClassification(Productclassification productclassification){
        productclassification.setClaDatetime(new Timestamp(new Date().getTime()));
        productclassification.setClaState("正常");
        ppcjdao.save(productclassification);
    }

    /**
     * 修改作为删除
     * @param claid
     */
    public void delClassification(Integer claid){
        Productclassification cla=new Productclassification();
        cla=ppcmdao.findByClaId(claid);
        cla.setClaState("禁用");
        ppcjdao.save(cla);
    }

    /**
     * 修改分类名
     * @param claid
     * @param claname
     */
    public void updateClassification(Integer claid,String claname){
        Productclassification cla=new Productclassification();
        cla=ppcmdao.findByClaId(claid);
        cla.setClaName(claname);
        ppcjdao.save(cla);
    }

    /**
     * 查找一个对象 编辑
     * @param claid
     * @return
     */
    public Productclassification findByClaId(Integer claid){
        return ppcmdao.findByClaId(claid);
    }
    public PLClassificationResponse getAllClassification(){
        //返回结果对象
        PLClassificationResponse response=new PLClassificationResponse();
        //1.查询所有分类
        List<Productclassification> allClassification=ppcmdao.queryAllProductClassification();
        //如果分类存在
        if(allClassification.size()>0) {
            //2.放入父级
            List<PLClassificationParent> parents=new ArrayList<>();
            for(Productclassification p:allClassification){
                if(p.getClaIdId()==0){
                    //复制父级属性
                    PLClassificationParent parent=new PLClassificationParent();
                    BeanUtils.copyProperties(p,parent);
                    //存入父级中
                    parents.add(parent);
                }
            }
            //如果存在父级集合
            if(parents.size()>0){
                //遍历父级，把父级下的所有子级放入当前当前遍历父级的子级集合中
                for(PLClassificationParent parentFor:parents){
                    //每一个父级 new 一个子级集合
                    List<PLClassificationChild> childs=new ArrayList<>();
                    //遍历所有的分类
                    for(Productclassification classificationFor:allClassification){
                        if(parentFor.getClaId()==classificationFor.getClaIdId()){
                            //复制子级属性值
                            PLClassificationChild child =new PLClassificationChild();
                            //对象之间的属性赋值
                            BeanUtils.copyProperties(classificationFor,child);
                            //System.out.println("child..."+child.getClaName());
                            childs.add(child);
                        }
                    }
                    //每个父级遍历结束后都存入子级
                    parentFor.setChildList(childs);
                }
                //父级遍历结束，父级集合放入响应对象
                response.setParentList(parents);
            }
        }
        //返回结果集
        return response;
    }
}
