package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTInstockDetailDao;
import com.zktr.crmproject.dao.jpa.HTStockDao;
import com.zktr.crmproject.dao.mybatis.HTIInstockDao;
import com.zktr.crmproject.dao.mybatis.HTIStockDao;
import com.zktr.crmproject.dao.mybatis.PLproductMDao;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.InstockAdvancedSearch;
import com.zktr.crmproject.vo.InstockDetailVo;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.ProductDemandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class HTInstockService {

    @Autowired(required=false)
    private HTIInstockDao iIstockDao;
    @Autowired(required=false)
    private PLproductMDao iproductMDao;
    @Autowired(required=false)
    private HTIStockDao istockDao;
    @Autowired
    private HTStockDao stockDao;
    @Autowired
    private HTInstockDetailDao instockDetailDao;


    /**
     * 分页查询所有的入库
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Instock> queryAllInstockByPage(Integer curpage,Integer pagesize){
        List<Instock> list1 = iIstockDao.selectAllInstock();
        List list2 = new ArrayList();
        for(int i = 0; i < pagesize; i ++){
            int index = (curpage - 1) * pagesize + i;
            if(index<list1.size()) {
                if(list1.get(index)!=null) {
                    list2.add(list1.get(index));
                }
            }
        }
        return new Pager<Instock>(list1.size(),list2);
    }



    /**
     * 添加入库信息
     * @param instock
     */
    public void insertInstock(Instock instock){
        if(instock.getTitle()==null||instock.getTitle()==""){
            Date date = new Date();
            //设置要获取到什么样的时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            //获取String类型的时间
            String createdate = sdf.format(date);
            instock.setTitle(createdate+"库存入库需求");
        }
        instock.setStatus("未入库");
        iIstockDao.insertInstock(instock);
    }

    /**
     * 修改入库信息
     * @param instock
     */
    public void updateInstock(Instock instock){
        iIstockDao.updateInstock(instock);
    }

    /**
     * 删除入库单
     * @param
     */
    public void deleteByInstockId(Integer instockId){
        iIstockDao.deleteInstockById(instockId);
        iIstockDao.deleteInstockDetailById(instockId);
    }

    /**
     * 修改入库状态
     * @param insId
     */
    public void updateInstockStatus(Integer insId,Integer type,String uName){
        Instock instock = iIstockDao.queryByInsId(insId);
        ////如type=1，则辙销入库
        if(type==1){
            instock.setStatus("未入库");
            iIstockDao.updateInstock(instock);
            List<Instockdetail> instockdetails = iIstockDao.queryInstockDetailByInsId(insId);
            for(Instockdetail ins : instockdetails){
                ins.setStatus("未入库");
                iIstockDao.updateInstockDetail(ins);
                Stock stock = istockDao.queryStockByWarehouseAndSpeId(ins.getProductspecification().getSpeId(), instock.getWarehouse().getWarehouseId());
                Integer num = stock.getStockQuantity();
                istockDao.updatestockQuantity((num + ins.getInsdQuantity()), ins.getProductspecification().getSpeId(),stock.getWarehouse().getWarehouseId());
            }
        }else{
            instock.setStatus("已入库");
            instock.setKeeper(uName);
            instock.setExecutionTime(new Timestamp(System.currentTimeMillis()));
            iIstockDao.updateInstock(instock);
            List<Instockdetail> instockdetails = iIstockDao.queryInstockDetailByInsId(insId);
            for(Instockdetail ins : instockdetails){
                ins.setStatus("已入库");
                iIstockDao.updateInstockDetail(ins);
                Stock s1 = istockDao.queryStockByWarehouseAndSpeId(ins.getProductspecification().getSpeId(),instock.getWarehouse().getWarehouseId());
                if(s1!=null){
                    Integer num = istockDao.queryStockByWarehouseAndSpeId(ins.getProductspecification().getSpeId(),instock.getWarehouse().getWarehouseId()).getStockQuantity();
                    istockDao.updatestockQuantity((num + ins.getInsdQuantity()), ins.getProductspecification().getSpeId(),s1.getWarehouse().getWarehouseId());
                }else{
                    Stock stock = new Stock();
                    stock.setProductspecification(ins.getProductspecification());
                    stock.setWarehouse(instock.getWarehouse());
                    stock.setStockQuantity(ins.getInsdQuantity());
                    stockDao.save(stock);
                }

            }
        }
    }

    /**
     * 查询入库单
     * @param insId
     * @return
     */
    public Instock queryInstockByInsId(Integer insId){
        return iIstockDao.queryByInsId(insId);
    }

    /**
     * 分页显示入库页面
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Instock> queryInstockSelectAndInputByPage(String value, String input, String select, Integer curpage, Integer pagesize){
        List<Instock> clist2 = iIstockDao.querySelectAndInputByPage(value,"%"+input.trim()+"%",select);
        PageHelper.startPage(curpage,pagesize);
        List<Instock> clist = iIstockDao.querySelectAndInputByPage(value,"%"+input.trim()+"%",select);
        PageInfo<Instock> pager = new PageInfo<>(clist);
        return new Pager<Instock>(clist2.size(),pager.getList());
    }

    /**
     * 查询全部产品
     * @return
     */
    public List<Product> queryAllProductByInstockDetail(){
        return iproductMDao.queryAllProduct();
    }

    /**
     * 高级查询入库
     * @param ias
     * @return
     */
    public Pager<Instock> queryInstockByAdvancedSearch(InstockAdvancedSearch ias){
        List<Instock> list2 = iIstockDao.queryInstockByAdvancedSearch(ias);
        PageHelper.startPage(ias.getCurPage(),ias.getPageSize());
        if(ias.getFillTime()!=null && ias.getFillTime().length!=0){
            ias.setS1(ias.getFillTime()[0]);
            ias.setS1(ias.getFillTime()[1]);
        }
       if(ias.getExecutionTime()!=null && ias.getExecutionTime().length!=0){
           ias.setS3(ias.getExecutionTime()[0]);
           ias.setS4(ias.getExecutionTime()[1]);
       }
        List<Instock> list = iIstockDao.queryInstockByAdvancedSearch(ias);
        PageInfo<Instock> pager = new PageInfo<>(list);
        return new Pager<Instock>(list2.size(),pager.getList());
    }

    /**
     * 通过入库单查询入库详情
     * @param insId
     * @return
     */
    public List<Instockdetail> queryInstockDetailByInsId(Integer insId){
        return iIstockDao.queryInstockDetailByInsId(insId);
    }

    /**
     * 增加或编辑入库详情单
     * @param
     */
    public void addorEditInstockdetails(InstockDetailVo instockDetailVo){
        for(Instockdetail insd : instockDetailVo.getList()){
            if(insd.getInsdId()==0){
                iIstockDao.insertInstockDetail(insd);
            }else{
                iIstockDao.updateInstockDetail(insd);
            }
        }
        for(Integer speId:instockDetailVo.getDelList()){
            iIstockDao.deleteInstockDetailBySpeIdAndInsId(speId,instockDetailVo.getList().get(0).getInstock().getInsId());
        }
    }

    /**
     * 根据订单需求提交入库单
     * @param productDemandVos
     */
    public void addInstockDemand(List<ProductDemandVo> productDemandVos){
        Instock instock = new Instock();
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        instock.setTitle(createdate+"订单入库需求");
        instock.setWarehouse(productDemandVos.get(0).getInwarehouseId());
        instock.setFillTime(new Timestamp(System.currentTimeMillis()));
        instock.setStatus("未入库");
        instock.setFiller(productDemandVos.get(0).getuName());
        iIstockDao.insertInstock(instock);
        Instockdetail instockdetail = new Instockdetail();
        for(ProductDemandVo p:productDemandVos){
            instockdetail.setProductspecification(p.getSpeId());
            instockdetail.setInsdQuantity(p.getNumber());
            instockdetail.setStatus("未入库");
            instockdetail.setInstock(instock);
            instockdetail.setRemarks(createdate+"订单入库需求");
            iIstockDao.insertInstockDetail(instockdetail);
        }
    }




}
