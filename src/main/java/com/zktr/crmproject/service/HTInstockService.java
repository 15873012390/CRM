package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTInstockDetailDao;
import com.zktr.crmproject.dao.jpa.HTStockDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.*;
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
    @Autowired
    private HTIWarehouseDao warehouseDao;
    @Autowired
    private JrcUserMDao userMDao;
    @Autowired
    private PLProductSpecificationMDao productSpecificationMDao;


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
        List list2 = new ArrayList();
        for (int i = 0; i < pagesize; i++) {
            //得到要显示的数据的下标
            int index = (curpage - 1) *pagesize + i;
            if (index < clist2.size()) {
                if (clist2.get(index) != null) {
                    list2.add(clist2.get(index));
                }
            }
        }
        return new Pager<Instock>(clist2.size(), list2);
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
        if(ias.getFillTime()!=null && ias.getFillTime().length!=0){
            ias.setS1(ias.getFillTime()[0]);
            ias.setS2(ias.getFillTime()[1]);
        }
       if(ias.getExecutionTime()!=null && ias.getExecutionTime().length!=0){
           ias.setS3(ias.getExecutionTime()[0]);
           ias.setS4(ias.getExecutionTime()[1]);
       }
        List<Instock> list = iIstockDao.queryInstockByAdvancedSearch(ias);
        List list2 = new ArrayList();
        for (int i = 0; i < ias.getPageSize(); i++) {
            //得到要显示的数据的下标
            int index = (ias.getCurPage() - 1) * ias.getPageSize() + i;
            if (index < list.size()) {
                if (list.get(index) != null) {
                    list2.add(list.get(index));
                }
            }
        }
        return new Pager<Instock>(list.size(), list2);
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

    /**
     * 查询未入库的总数
     * @return
     */
    public Integer queryNoInstock(String uName){
        return iIstockDao.queryNoInstock(uName);
    }

    /**
     * 查询未入库的信息
     * @return
     */
    public List<Instock> queryNoInstockList(String uName){
        return iIstockDao.queryNoInstockList(uName);
    }

    /**
     * 导入入库
     * @param instockAndDeatilVo
     */
    public String  insertInstocks(List<InstockAndDeatilVo> instockAndDeatilVo) {
        System.out.println(instockAndDeatilVo);
        StringBuffer sb = new StringBuffer();
        List<Instock> instockList = new ArrayList<>();
        Integer errorcount = 0;
        Integer successcount = 0;
        for(InstockAndDeatilVo instockvo : instockAndDeatilVo){
            if(instockvo.getTitle()!=null){
                Instock instock = new Instock();
                List<Instockdetail> Instockdetails = new ArrayList<>();
                Instockdetail instockdetail = new Instockdetail();
                instock.setTitle(instockvo.getTitle());
                instock.setStatus("未入库");
                instock.setFillTime(new Timestamp(System.currentTimeMillis()));
                List<User> users = userMDao.queryByUserName(instockvo.getFiller());
                Warehouse warehouse = warehouseDao.querySameNameWarehouse(instockvo.getWarehouseName());
                Productspecification productspecification = productSpecificationMDao.queryBySepId(instockvo.getSpeId());
                if(users.size()==0 || warehouse==null||productspecification ==null){
                    errorcount++;
                    continue;
                }
                instock.setWarehouse(warehouse);
                instock.setFiller(instockvo.getFiller());
                instockdetail.setStatus("未入库");
                instockdetail.setInstock(instock);
                instockdetail.setProductspecification(productspecification);
                instockdetail.setInsdQuantity(instockvo.getInsdQuantity());
                Instockdetails.add(instockdetail);
                boolean flag = false;
                for(InstockAndDeatilVo instockvo2 : instockAndDeatilVo){
                    if(instockvo.getTitle().equals(instockvo2.getTitle())){
                        flag = true;
                        continue;
                    }
                    if((instockvo2.getTitle() != null) && flag){
                        break;
                    }else if(flag){
                        flag = true;
                        Instock instock2 = new Instock();
                        Instockdetail instockdetail2 = new Instockdetail();
                        instock2.setTitle(instockvo.getTitle());
                        instock2.setFillTime(new Timestamp(System.currentTimeMillis()));
                        instock2.setStatus("未入库");
                        instock2.setWarehouse(warehouse);
                        instock2.setFiller(instockvo.getFiller());
                        Productspecification productspecification2 = productSpecificationMDao.queryBySepId(instockvo2.getSpeId());
                        if(productspecification.getSpeId() == productspecification2.getSpeId()){
                            continue;
                        }
                        instockdetail2.setStatus("未入库");
                        instockdetail2.setInstock(instock2);
                        instockdetail2.setProductspecification(productspecification2);
                        instockdetail2.setInsdQuantity(instockvo2.getInsdQuantity());
                        Instockdetails.add(instockdetail2);
                    }
                }
                instock.setInstockdetail(Instockdetails);
                successcount++;
                iIstockDao.insertInstock(instock);
                for(Instockdetail insd : instock.getInstockdetail()){
                    successcount++;
                    insd.setInstock(instock);
                    iIstockDao.insertInstockDetail(insd);
                }
            }


        }
        sb.append("成功导入"+successcount+"条数据"+"\n"+"失败导入"+errorcount+"条数据");
        return sb.toString();
    }
}
