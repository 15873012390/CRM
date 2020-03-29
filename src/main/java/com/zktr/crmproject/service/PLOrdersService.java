package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.PLAddressJDao;
import com.zktr.crmproject.dao.jpa.PLOrdersJDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.utils.UUIDUtils;
import com.zktr.crmproject.vo.*;
import jdk.nashorn.internal.ir.LiteralNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class PLOrdersService {
    @Autowired
    private PLIOrdersDao omdao;
    @Autowired
    private PLOrdersJDao ojdao;
    @Autowired
    private HTICustomerDao cusmdao;
    @Autowired
    private JrcQuoteMDao quomdao;
    @Autowired
    private ICustomerMapperDao customerMapperDao;
    @Autowired
    private PLAddressMDao addressMDao;
    @Autowired
    private PLAddressJDao addressJDao;
    @Autowired
    private JrcUserMDao userMDao;

    /**
     * 饼状图表 执行状态
     * @return
     */
    public List<PLCountPie> countPies(Integer n){
        List<PLCountPie> list=null;
        if(n==1){
            list=omdao.Countpie();
        }
        return list;
    }

    /**
     *  柱状图 根据每月统计订单的总金额
     * @param n
     * @return
     */
    public List<PLCountPie> countBars(Integer n){
        List<PLCountPie> list=null;
        if(n==1){
            list=omdao.CountBar();//每月统计sql
        }
        return list;
    }
    /**
     *  柱状图 用数组形式返回
     * @param n
     * @return
     */
    public PLCountBar countBar(Integer n){
        PLCountBar countBar=new PLCountBar();
        if(n==1){
            List<PLCountPie> list=this.countBars(n);
            String[] name=new String[list.size()];
            int[] value=new int[list.size()];
            int count=0;
            for (PLCountPie p:list){
                name[count]=p.getName();
                value[count]=p.getValue();
                count++;
            }
            countBar.setName(name);
            countBar.setValue(value);
        }
        return countBar;
    }

    /**
     * 分页查询所有
     * @param curpage
     * @param pagesie
     * @return
     */
    public Pager<Orders> queryAllOrders(int curpage,int pagesie){
        PageHelper.startPage(curpage,pagesie);
        List<Orders> ordersList=omdao.queryAllOrders();
        PageInfo<Orders> page=new PageInfo<>(ordersList);
        return new Pager<>(page.getTotal(),page.getList());
    }

    /**
     *  合计金额
     * @return
     */
    public List<Map> statisticsByMoney(){
        return omdao.statisticsByMoney();
    }

    /**
     * 查询所有客户
     * @return
     */
    public List<Customer> queryAllCustomer(){
        return cusmdao.queryAllCustomer();
    }

    /**
     * 查询报价
     * @return
     */
    public List<Quote> queryAllQuote(){
        return quomdao.PLqueryAllQuote();
    }

    /**
     * 查找客户
     * @param cusid
     * @return
     */
    public Customer findByCusid(Integer cusid){
        return customerMapperDao.findCustomerById(cusid);
    }

    /**
     * 查找用户
     * @return
     */
    public List<User> queryAllUser(){
        return userMDao.queryAll();
    }
    /**
     * 自动生成订单编号
     * @return
     */
    public String getId(){
        String id=String.valueOf(omdao.findMaxOrdid());
        try {
            String s=id.substring(id.length()-4);//截取最大id的后4位
            String equipmentNo= UUIDUtils.getNewNo("ORDER",s);
            System.out.println(equipmentNo);
            return equipmentNo;
        }catch (Exception e){
            return "ORDER00001"; //若没有id则返回这个
        }

    }

    /**
     * mybatis 新增地址
     * @param pLaddressVo
     */
    public void saveAddress(PLaddressVo pLaddressVo){

        if(pLaddressVo.getAddId()==0){
            addressMDao.insertAddress(pLaddressVo);
        }else {
            addressMDao.updateAddress(pLaddressVo);
        }

    }

    /**
     * mybatis 地址编辑查找一个对象
     * @param addid
     * @return
     */
    public Address findByAddid(Integer addid){
        return addressMDao.findByAddid(addid);
    }

    /**
     * mybatis 新增订单
     * @param plOrdersVo
     */
    public void insertOrders(PLOrdersVo plOrdersVo){

        List<Address> list=addressMDao.queryAllAdress();
        int ordidif=plOrdersVo.getOrdId();
        if(ordidif==0){
           PLOrdersVo orders=new PLOrdersVo();
           orders.setOrdDelState(plOrdersVo.getOrdDelState());//设置删除状态为1 未删除
           orders.setAddId(list.get(0).getAddId()); //
           orders.setCusId(plOrdersVo.getCusId());
           orders.setuId(plOrdersVo.getuId());
           orders.setQuoId(plOrdersVo.getQuoId());
           orders.setOrdTheme(plOrdersVo.getOrdTheme());
           orders.setOrdNumber(this.getId()); //订单自动编号
           orders.setOrdClassify(plOrdersVo.getOrdClassify());
           orders.setOrdPayment(plOrdersVo.getOrdPayment());
           orders.setOrdTotalAmount(plOrdersVo.getOrdTotalAmount());
           orders.setOrdSendOutMoney(plOrdersVo.getOrdSendOutMoney());
           orders.setOrdMargin(plOrdersVo.getOrdMargin());
           orders.setOrdTime(plOrdersVo.getOrdTime());
           orders.setOrdExecutingState(plOrdersVo.getOrdExecutingState());
           orders.setOrdPurchaseWay(plOrdersVo.getOrdPurchaseWay());
           orders.setOrdHabit(plOrdersVo.getOrdHabit());
           orders.setOutStatus("未出库");
           orders.setOrdSendOutState("未发货");
           orders.setOrdRemark(plOrdersVo.getOrdRemark());

            omdao.insertOrders(orders);

        }else {
            omdao.updateOrders(plOrdersVo);
        }
    }

    /**
     * mybatis 订单编辑 根据id查找一个对象
     * @param ordid
     * @return
     */
    public Orders findByOrdid(Integer ordid){
        return omdao.findByOrdid(ordid);
    }

    /**
     * 修改作为删除
     * @param ordid
     */
    public void delOrdersById(Integer ordid){
        omdao.delOrdersById(ordid);
    }


}
