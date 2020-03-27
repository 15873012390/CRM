package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTOutstockDao;
import com.zktr.crmproject.dao.jpa.HTOutStockDetailsDao;
import com.zktr.crmproject.dao.jpa.PLOrdersDao;
import com.zktr.crmproject.dao.mybatis.HTIOutstockDao;
import com.zktr.crmproject.dao.mybatis.HTIStockDao;
import com.zktr.crmproject.dao.mybatis.PLIOrdersDao;
import com.zktr.crmproject.dao.mybatis.PLproductMDao;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.utils.UUIDUtils;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class HTOustStockService {
    @Autowired
    private HTIOutstockDao iOutstockDao;
    @Autowired
    private PLproductMDao iproductMDao;
    @Autowired
    private PLIOrdersDao iOrdersDao;
    @Autowired
    private HTIStockDao istockDao;
    @Autowired
    private HTOutStockDetailsDao outStockDetailsDao;
    /**
     * 查询所有的出库
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Outstock> queryAllOutStockByPage(Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Outstock> list = iOutstockDao.queryAllOutstock();
        PageInfo<Outstock> pager = new PageInfo<>(list);
        return new Pager<Outstock>(pager.getTotal(),pager.getList());
    }

    /**
     * 根据出库ID查询出库
     * @param outId
     * @return
     */
    public Outstock queryOutstockByOutId(Integer outId){
        return iOutstockDao.queryOutstockByOutId(outId);
    }

    /**
     * 查询订单所有未出库的订单
     * @return
     */
    public List<Orders> queryAllNoOutStock(){
        return iOrdersDao.queryAllNoOutStock();
    }

    /**
     * 编辑或添加出库单
     * @param outstock
     */
    public void editAndUpdateOutStock(Outstock outstock){
        if(outstock.getOutId()==0){
            outstock.setStatus("未出库");
            outstock.setOutNumber(UUIDUtils.getId());
            iOutstockDao.insertOutstock(outstock);
            System.out.println(outstock.getOutId());
            if(outstock.getOrders()!=null && outstock.getOrders().getOrdId()!=0){
                Orders order = iOrdersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
                Outstockdetails od = new Outstockdetails();
                for(Orderdetail o: order.getOrderdetail()){
                    od.setProductspecification(o.getProductspecification());
                    od.setOsdNumber(o.getDetNumber());
                    Integer num = istockDao.queryQuantityBySpeId(o.getProductspecification().getSpeId());
                    istockDao.updatestockQuantity((num-o.getDetNumber()),o.getProductspecification().getSpeId());
                    od.setStatus("已出库");
                    od.setOutstock(outstock);
                    iOutstockDao.insertOutStockDetails(od);
                }
                Outstock outstock1 = iOutstockDao.queryOutstockByOutId(outstock.getOutId());
                outstock1.setStatus("已出库");
                outstock1.setPassTime(new Timestamp(System.currentTimeMillis()) );
                iOutstockDao.updateOutStock(outstock1);
                iOrdersDao.updateOrdersOutStatus(order.getOrdId());
            }
        }else {
            iOutstockDao.updateOutStock(outstock);
        }
    }

    /**
     * 查询所有出库详情单
     * @param outId
     * @return
     */
    public List<Outstockdetails> queryAllOutdetailById(Integer outId){
        return iOutstockDao.queryAllOutdetailById(outId);
    }

    /**
     * 根据出库ID删除出库及详情
     * @param outId
     */
    public void deleteOutStockAndDetail(Integer outId){
        iOutstockDao.deleteOutstockByOutId(outId);
        iOutstockDao.deleteOutstockDetailByOutId(outId);
    }

    /**
     * 修改出库的状态（修改库存数量）
     * @param outId
     */
    public void updateOutStockStatus(Integer outId,Integer type){
        Outstock outstock = iOutstockDao.queryOutstockByOutId(outId);
        //如type=1，则辙销出库
        if(type==1) {
            outstock.setStatus("未出库");
            iOutstockDao.updateOutStock(outstock);
            List<Outstockdetails> outstockdetailsList = iOutstockDao.queryAllOutdetailById(outId);
            for (Outstockdetails o : outstockdetailsList) {
                o.setStatus("未出库");
                iOutstockDao.updateOutDeatails(o);
                Integer num = istockDao.queryQuantityBySpeId(o.getProductspecification().getSpeId());
                istockDao.updatestockQuantity((num + o.getOsdNumber()), o.getProductspecification().getSpeId());
            }
        }else{
            outstock.setStatus("已出库");
            iOutstockDao.updateOutStock(outstock);
            List<Outstockdetails> outstockdetailsList = iOutstockDao.queryAllOutdetailById(outId);
            for (Outstockdetails o : outstockdetailsList) {
                o.setStatus("已出库");
                iOutstockDao.updateOutDeatails(o);
                Integer num = istockDao.queryQuantityBySpeId(o.getProductspecification().getSpeId());
                istockDao.updatestockQuantity((num - o.getOsdNumber()), o.getProductspecification().getSpeId());
            }
        }
    }

    /**
     * 增加（修改）订单/出库详情
     * @param outstockdetailsList
     */
    public void addorEditOutDetails(List<Outstockdetails> outstockdetailsList){
        Orderdetail orderdetail = new Orderdetail();
        for(Outstockdetails o:outstockdetailsList){
            //订单详情赋值
            Outstock outstock = iOutstockDao.queryOutstockByOutId(o.getOutstock().getOutId());
            Orders orders = iOrdersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
            if(orders!=null) {
                orderdetail.setOrders(outstock.getOrders());
                orderdetail.setProductspecification(o.getProductspecification());
                orderdetail.setOrders(orders);
                orderdetail.setUser(orders.getUser());
                orderdetail.setCustomer(orders.getCustomer());
                orderdetail.setDetNumber(o.getOsdNumber());
                orderdetail.setDetTime(new Timestamp(System.currentTimeMillis()));
            }
            if(o.getOsdId()==0){
                //增加出库详情
                iOutstockDao.insertOutStockDetails(o);
                if(orders!=null) {
                    //增加订单详情
                    iOrdersDao.insertOrderdetail(orderdetail);
                }
            }else{
                //修改出库详情
                iOutstockDao.updateOutDeatails(o);
                if(orders!=null) {
                    //修改订单详情
                    iOrdersDao.updateOrderdetail(orderdetail);
                }
            }
        }
    }

    /**
     * 分页显示入库页面
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Outstock> queryOutStockSelectAndInputByPage(String value, String input, String select, Integer curpage, Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Outstock> clist = iOutstockDao.queryOutStockSelectAndInputByPage(value,"%"+input.trim()+"%",select);
        PageInfo<Outstock> pager = new PageInfo<>(clist);
        return new Pager<Outstock>(pager.getTotal(),pager.getList());
    }

}
