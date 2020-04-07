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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void editAndUpdateOutStock(Outstock outstock) {
        if (outstock.getOutId() == 0) {
            outstock.setStatus("未出库");
            outstock.setOutNumber(UUIDUtils.getId());
            iOutstockDao.insertOutstock(outstock);
            System.out.println(outstock.getOutId());
            if (outstock.getOrders() != null && outstock.getOrders().getOrdId() != 0) {
                Orders order = iOrdersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
                Outstockdetails od = new Outstockdetails();
                //循环遍历订单详情放入出库详情
                for (Orderdetail o : order.getOrderdetail()) {
                    od.setProductspecification(o.getProductspecification());
                    od.setOsdNumber(o.getDetNumber());
                    Integer num = istockDao.queryQuantityBySpeId(o.getProductspecification().getSpeId()).getStockQuantity();
                    istockDao.updatestockQuantity((num - o.getDetNumber()), o.getProductspecification().getSpeId());
                    od.setStatus("已出库");
                    od.setOutstock(outstock);
                    iOutstockDao.insertOutStockDetails(od);
                }
                //修改出库单
                Outstock outstock1 = iOutstockDao.queryOutstockByOutId(outstock.getOutId());
                outstock1.setStatus("已出库");
                outstock1.setPassTime(new Timestamp(System.currentTimeMillis()));
                iOutstockDao.updateOutStock(outstock1);
                //修改订单状态
                iOrdersDao.updateOrdersOutStatus(order.getOrdId());
                //若出库表的订单ID不为空，则添加发货表及发货详情表
                if (outstock.getOrders() != null) {
                    //添加发货表
                    Sendout sendout = new Sendout();
                    //查询订单
                    Orders orders = iOrdersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
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
                    for (Orderdetail o : order.getOrderdetail()) {
                        sendoutdetial.setSendout(sendout);//发货ID
                        sendoutdetial.setProductspecification(o.getProductspecification());//规格
                        sendoutdetial.setSodNumber(o.getDetNumber());//数量
                        //根据订单ID和规格ID查询详情得出金额
                        Orderdetail orderdetail = iOrdersDao.queryByOrdIdAndSpeId(outstock.getOrders().getOrdId(), o.getProductspecification().getSpeId());
                        sendoutdetial.setSodMoney(orderdetail.getDetMoney());//金额
                        sendOutDao.insertSendOutDetail(sendoutdetial);
                    }

                }
            }
        } else {
            iOutstockDao.updateOutStock(outstock);
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
                Stock stock = istockDao.queryQuantityBySpeId(o.getProductspecification().getSpeId());
                //库存为空则增加,否则修改
                if (stock != null) {
                    Integer num = istockDao.queryQuantityBySpeId(o.getProductspecification().getSpeId()).getStockQuantity();
                    istockDao.updatestockQuantity((num + o.getOsdNumber()), o.getProductspecification().getSpeId());
                } else {
                    Stock stock1 = new Stock();
                    stock1.setProductspecification(o.getProductspecification());
                    stock1.setWarehouse(outstock.getWarehouse());
                    stock1.setStockQuantity(o.getOsdNumber());
                    stockDao.save(stock);
                }

            }
        } else {
            outstock.setStatus("已出库");
            iOutstockDao.updateOutStock(outstock);
            List<Outstockdetails> outstockdetailsList = iOutstockDao.queryAllOutdetailById(outId);
            for (Outstockdetails o : outstockdetailsList) {
                o.setStatus("已出库");
                iOutstockDao.updateOutDeatails(o);
                Integer num = istockDao.queryQuantityBySpeId(o.getProductspecification().getSpeId()).getStockQuantity();
                istockDao.updatestockQuantity((num - o.getOsdNumber()), o.getProductspecification().getSpeId());

            }
            //若出库表的订单ID不为空，则添加发货表及发货详情表
            if (outstock.getOrders() != null&&outstock.getOrders().getOrdId()!=0) {
                //添加发货表
                Sendout sendout = new Sendout();
                //查询订单
                Orders orders = iOrdersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
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
        for (Outstockdetails o : outstockDetailVo.getList()) {
            //订单详情赋值
            Outstock outstock = iOutstockDao.queryOutstockByOutId(o.getOutstock().getOutId());
            Orders orders = iOrdersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
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
        for (Integer speId : outstockDetailVo.getDelList()) {
            outStockDetailsDao.deleteBySpeId(speId);
            orderdetailsDao.deleteBySpeId(speId);
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
        List<Outstock> clist2 = iOutstockDao.queryOutStockSelectAndInputByPage(value, "%" + input.trim() + "%", select);
        PageHelper.startPage(curpage, pagesize);
        List<Outstock> clist = iOutstockDao.queryOutStockSelectAndInputByPage(value, "%" + input.trim() + "%", select);
        PageInfo<Outstock> pager = new PageInfo<>(clist);
        return new Pager<Outstock>(clist2.size(), pager.getList());
    }

    /**
     * 高级查询入库
     *
     * @param oas
     * @return
     */
    public Pager<Outstock> queryOutstockByAdvancedSearch(OutStockAdvancedSearch oas) {
        List<Outstock> list2 = iOutstockDao.queryoutStockByAdvancedSearch(oas);
        PageHelper.startPage(oas.getCurPage(), oas.getPageSize());
        if (oas.getFillTime() != null && oas.getFillTime().length != 0) {
            oas.setS1(oas.getFillTime()[0]);
            oas.setS1(oas.getFillTime()[1]);
        }
        if (oas.getPassTime() != null && oas.getPassTime().length != 0) {
            oas.setS3(oas.getPassTime()[0]);
            oas.setS4(oas.getPassTime()[1]);
        }
        List<Outstock> list = iOutstockDao.queryoutStockByAdvancedSearch(oas);
        PageInfo<Outstock> pager = new PageInfo<>(list);
        return new Pager<Outstock>(list2.size(), pager.getList());
    }

}
