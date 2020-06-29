package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.*;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.utils.UUIDUtils;
import com.zktr.crmproject.vo.OutStockAdvancedSearch;
import com.zktr.crmproject.vo.OutstockDetailVo;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private HTStockDao stockDao;
    @Autowired
    private PLOrderdetailsDao orderdetailsDao;
    @Autowired
    private PLISendOutDao sendOutDao;
    @Autowired
    private PLAddressMDao addressDao;

    /**
     * 查询所有的出库
     *
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Outstock> queryAllOutStockByPage(Integer curpage, Integer pagesize) {
        List<Outstock> list1 = iOutstockDao.queryAllOutstock();
        List list2 = new ArrayList();
        for (int i = 0; i < pagesize; i++) {
            //得到要显示的数据的下标
            int index = (curpage - 1) * pagesize + i;
            if (index < list1.size()) {
                if (list1.get(index) != null) {
                    list2.add(list1.get(index));
                }
            }
        }
        return new Pager<Outstock>(list1.size(), list2);
    }

    /**
     * 根据出库ID查询出库
     *
     * @param outId
     * @return
     */
    public Outstock queryOutstockByOutId(Integer outId) {
        return iOutstockDao.queryOutstockByOutId(outId);
    }

    /**
     * 查询订单所有未出库的订单
     *
     * @return
     */
    public List<Orders> queryAllNoOutStock() {
        return iOrdersDao.queryAllNoOutStock();
    }

    /**
     * 编辑或添加出库单
     *
     * @param outstock
     */
    public Integer editAndUpdateOutStock(Outstock outstock) {
        if (outstock.getOutId() == 0) {
            if(outstock.getTitle()==null||outstock.getTitle()==""){
                Date date = new Date();
                //设置要获取到什么样的时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                //获取String类型的时间
                String createdate = sdf.format(date);
                outstock.setTitle(createdate+"出库需求");
            }
            outstock.setStatus("未出库");
            outstock.setOutNumber(UUIDUtils.getId());
            iOutstockDao.insertOutstock(outstock);
            if (outstock.getOrders() != null && outstock.getOrders().getOrdId() != 0) {
                Orders order = iOrdersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
                Outstock outstock1 = iOutstockDao.queryOutstockByOutId(outstock.getOutId());
                outstock1.setCustomer(order.getCustomer());
                outstock1.setOrdNumber(order.getOrdNumber());
                Date date = new Date();
                //设置要获取到什么样的时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                //获取String类型的时间
                String createdate = sdf.format(date);
                outstock1.setRemarks(createdate+"加入订单");
                iOutstockDao.updateOutStock(outstock1);
                Outstockdetails od = new Outstockdetails();
                //循环遍历订单详情放入出库详情
                for (Orderdetail o : order.getOrderdetail()) {
                    od.setProductspecification(o.getProductspecification());
                    od.setOsdNumber(o.getDetNumber());
                    od.setStatus("未出库");
                    od.setOutstock(outstock);
                    iOutstockDao.insertOutStockDetails(od);
                }
                order.setOutStatus("进行出库");
                iOrdersDao.updateOrders(order);
            }
            return outstock.getOutId();
        } else {
            iOutstockDao.updateOutStock(outstock);
            return outstock.getOutId();
        }
    }

    /**
     * 查询所有出库详情单
     *
     * @param outId
     * @return
     */
    public List<Outstockdetails> queryAllOutdetailById(Integer outId) {
        return iOutstockDao.queryAllOutdetailById(outId);
    }

    /**
     * 根据出库ID删除出库及详情
     *
     * @param outId
     */
    public void deleteOutStockAndDetail(Integer outId) {
        iOutstockDao.deleteOutstockByOutId(outId);
        iOutstockDao.deleteOutstockDetailByOutId(outId);
    }

    /**
     * 修改出库的状态（修改库存数量）
     *
     * @param outId
     */
    public void updateOutStockStatus(Integer outId, Integer type) {
        Outstock outstock = iOutstockDao.queryOutstockByOutId(outId);
        //如type=1，则辙销出库
        if (type == 1) {
            outstock.setStatus("未出库");
            iOutstockDao.updateOutStock(outstock);
            List<Outstockdetails> outstockdetailsList = iOutstockDao.queryAllOutdetailById(outId);
            for (Outstockdetails o : outstockdetailsList) {
                o.setStatus("未出库");
                iOutstockDao.updateOutDeatails(o);
                Stock stock = istockDao.queryStockByWarehouseAndSpeId(o.getProductspecification().getSpeId(),outstock.getWarehouse().getWarehouseId());
                //库存为空则增加,否则修改
                if (stock != null) {
                    Integer num = istockDao.queryStockByWarehouseAndSpeId(o.getProductspecification().getSpeId(),outstock.getWarehouse().getWarehouseId()).getStockQuantity();
                    istockDao.updatestockQuantity((num + o.getOsdNumber()), o.getProductspecification().getSpeId(),stock.getWarehouse().getWarehouseId());
                } else {
                    Stock stock1 = new Stock();
                    stock1.setProductspecification(o.getProductspecification());
                    stock1.setWarehouse(outstock.getWarehouse());
                    stock1.setStockQuantity(o.getOsdNumber());
                    stockDao.save(stock);
                }
            }
            if(outstock.getOrders()!=null){
                System.out.println(123);
                Sendout sendOrders = sendOutDao.findSendOutByOrdid(outstock.getOrders().getOrdId());
                sendOrders.setSenDelState(1);
                sendOutDao.updateBySendOutBySenId(sendOrders);
            }
        } else {
            outstock.setStatus("已出库");
            outstock.setPassTime(new Timestamp(System.currentTimeMillis()));
            iOutstockDao.updateOutStock(outstock);
            List<Outstockdetails> outstockdetailsList = iOutstockDao.queryAllOutdetailById(outId);
            for (Outstockdetails o : outstockdetailsList) {
                o.setStatus("已出库");
                iOutstockDao.updateOutDeatails(o);
                Stock stock = istockDao.queryStockByWarehouseAndSpeId(o.getProductspecification().getSpeId(), outstock.getWarehouse().getWarehouseId());
                Integer num = stock.getStockQuantity();
                istockDao.updatestockQuantity((num - o.getOsdNumber()), o.getProductspecification().getSpeId(),stock.getWarehouse().getWarehouseId());
            }
            Orders orders = iOrdersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
            if(orders!=null){
                orders.setOutStatus("已出库");
                iOrdersDao.updateOrders(orders);
            }
            //若出库表的订单ID不为空，则添加发货表及发货详情表
            if (outstock.getOrders() != null&&outstock.getOrders().getOrdId()!=0) {
                //添加发货表
                Sendout sendout = new Sendout();
                //查询订单
                //根据订单查询地址
                Address address = addressDao.findByAddid(orders.getAddress().getAddId());
                sendout.setCustomer(orders.getCustomer());//客户
                sendout.setOrders(outstock.getOrders());//订单
                sendout.setSenReceiving(address.getAddName());//收货人
                sendout.setSenState("未发货");//发货状态
                sendout.setSenDelState(2);//是否被删除
                sendOutDao.insertSendOut(sendout);
                //添加发货明细表
                Sendoutdetial sendoutdetial = new Sendoutdetial();
                    for (Outstockdetails o : outstockdetailsList) {
                        sendoutdetial.setSendout(sendout);//发货ID
                        sendoutdetial.setProductspecification(o.getProductspecification());//规格
                        sendoutdetial.setSodNumber(o.getOsdNumber());//数量
                        //根据订单ID和规格ID查询详情得出金额
                        Orderdetail orderdetail = iOrdersDao.queryByOrdIdAndSpeId(outstock.getOrders().getOrdId(), o.getProductspecification().getSpeId());
                        sendoutdetial.setSodMoney(orderdetail.getDetMoney());//金额
                        sendOutDao.insertSendOutDetail(sendoutdetial);
                    }

            }
        }
    }




    /**
     * 增加（修改）订单/出库详情
     *
     * @param
     */
    public void addorEditOutDetails(OutstockDetailVo outstockDetailVo) {
        Orderdetail orderdetail = new Orderdetail();
        Outstock outstock = null;
        Orders orders = null;
        for (Outstockdetails o : outstockDetailVo.getList()) {
            //订单详情赋值
            outstock = iOutstockDao.queryOutstockByOutId(o.getOutstock().getOutId());
            orders = iOrdersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
            if (orders != null) {
                orderdetail.setOrders(outstock.getOrders());
                orderdetail.setProductspecification(o.getProductspecification());
                orderdetail.setOrders(orders);
                orderdetail.setUser(orders.getUser());
                orderdetail.setCustomer(orders.getCustomer());
                orderdetail.setDetNumber(o.getOsdNumber());
                orderdetail.setDetTime(new Timestamp(System.currentTimeMillis()));
            }
            if (o.getOsdId() == 0) {
                //增加出库详情
                iOutstockDao.insertOutStockDetails(o);
                if (orders != null) {
                    //增加订单详情
                    iOrdersDao.insertOrderdetail(orderdetail);
                }
            } else {
                //修改出库详情
                iOutstockDao.updateOutDeatails(o);
                if (orders != null) {
                    //修改订单详情
                    iOrdersDao.updateOrderdetail(orderdetail);
                }
            }
        }
        for (Integer id : outstockDetailVo.getDelList()) {
            if(outstock.getOrders()!=null&&outstock.getOrders().getOrdId()!=0){
                orderdetailsDao.deleteBySpeId(id,orders.getOrdId());
            }
            iOutstockDao.deleteOutstockDetailByOutIdAndSpeId(outstock.getOutId(),id);

        }
    }

    /**
     * 分页显示入库页面
     *
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Outstock> queryOutStockSelectAndInputByPage(String value, String input, String select, Integer curpage, Integer pagesize) {
        List<Outstock> clist2 = iOutstockDao.queryOutStockSelectAndInputByPage(value, input, select);
        List list2 = new ArrayList();
        for (int i = 0; i < pagesize; i++) {
            //得到要显示的数据的下标
            int index = (curpage - 1) * pagesize + i;
            if (index < clist2.size()) {
                if (clist2.get(index) != null) {
                    list2.add(clist2.get(index));
                }
            }
        }
        return new Pager<Outstock>(clist2.size(), list2);
    }

    /**
     * 高级查询出库
     *
     * @param oas
     * @return
     */
    public Pager<Outstock> queryOutstockByAdvancedSearch(OutStockAdvancedSearch oas) {
        if (oas.getFillTime() != null && oas.getFillTime().length != 0) {
            oas.setS1(oas.getFillTime()[0]);
            oas.setS2(oas.getFillTime()[1]);
        }
        if (oas.getPassTime() != null && oas.getPassTime().length != 0) {
            oas.setS3(oas.getPassTime()[0]);
            oas.setS4(oas.getPassTime()[1]);
        }
        List<Outstock> list = iOutstockDao.queryoutStockByAdvancedSearch(oas);
        System.out.println("320"+list);
        List list2 = new ArrayList();
        for (int i = 0; i < oas.getPageSize(); i++) {
            //得到要显示的数据的下标
            int index = (oas.getCurPage() - 1) * oas.getPageSize() + i;
            if (index < list.size()) {
                if (list.get(index) != null) {
                    list2.add(list.get(index));
                }
            }
        }
        return new Pager<Outstock>(list.size(), list2);
    }

    /**
     * 发货修改状态
     * @param outId
     */
    public void updateOutStatus(Integer outId){
        Outstock outstock = iOutstockDao.queryOutstockByOutId(outId);
        outstock.setStatus("已发货");
        iOutstockDao.updateOutStock(outstock);
    }

    /**
     * 查询未出库的数量
     * @return
     */
    public Integer queryNoOutstock(String uName){
        return iOutstockDao.queryNoOutstock(uName);
    }

    /**
     * 查询所有未出库的信息
     * @return
     */
    public List<Outstock> queryNoOutStockList(String uName){
        return iOutstockDao.queryNoOutStockList(uName);
    }



}
