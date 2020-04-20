package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.PLAddressJDao;
import com.zktr.crmproject.dao.jpa.PLOrdersJDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.utils.UUIDUtils;
import com.zktr.crmproject.vo.*;
import org.apache.poi.util.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

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
    private TWCustomerMapperDao customerMapperDao;
    @Autowired
    private PLAddressMDao addressMDao;
    @Autowired
    private PLAddressJDao addressJDao;
    @Autowired
    private JrcUserMDao userMDao;
    @Autowired
    private PLOdersDetailMDao orderDetailMDao;
    @Autowired
    private JrcQuoteDetailsMDao quoteDetailsMDao;
    @Autowired
    private HTIOutstockDao outstockDao;

    /**
     * 饼状图表 执行状态
     * @return
     */
    public List<PLCountPie> countPies(String pieValue){
        //List<PLCountPie> list=
        return omdao.Countpie(pieValue);
    }

    /**
     *  折线图 根据每天、每月、每年统计订单的总金额
     * @param
     * @return
     */
    public List<PLCountPie> countBars(String barValue){
        return  omdao.CountBar(barValue);
    }
    /**
     *  折线图 用数组形式返回
     * @param
     * @return
     */
    public PLCountBar countBar(String barValue){
        PLCountBar countBar=new PLCountBar();

            List<PLCountPie> list=this.countBars(barValue);
            String[] name=new String[list.size()];
            int[] value=new int[list.size()];
            int count=0;
            for (PLCountPie p:list){
                name[count]=p.getName();
                value[count]=p.getValue();
                count++;
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
    public Pager<Orders> queryAllOrders(int curpage, int pagesie){
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
        int quoid=0;
        List<Orders> ordersList=omdao.findAll();
        List<Quote> quoteList=quomdao.PLqueryAllQuote();
        //在订单中 如果报价已经存在 则不显示该报价
        /*for(int i=0;i<ordersList.size();i++){
            for (int j=0;j<quoteList.size();j++){
              if(quoteList.get(j).getQuoId().eq){

              }
            }
        }*/

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
        if(id==null&&id=="") {
            //String s=id.substring(id.length()-4);//截取最大id的后4位
            String equipmentNo = UUIDUtils.getNewNo("ORDER", id);
            System.out.println(equipmentNo);
            return equipmentNo;
        }else{
            return "ORDER00001"; //若没有id则返回这个
        }
    }
    /**
     * 自动生成订单编号
     * @return
     */
    public String getIds(){
        String id=String.valueOf(omdao.findMaxOrdid());
        //System.out.println("aaa"+id);
        String equipmentNo= JrcUUID.getNewNo(id);
        return equipmentNo;
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
     * mybatis 新增地址
     * @param address
     */
    public Address saveAddress(Address address) {
        if(address.getAddId()==0){
            addressMDao.insertAddress(address);
            return address;
        }else {
            addressMDao.updateAddress(address);
            return address;
        }
    }
    /**
     * mybatis 新增订单
     * @param orders
     */
    public void insertOrders(Orders orders){

        if(orders.getOrdId()==0){
            //PLOrdersVo orders=new PLOrdersVo();
            Orders orders1=new Orders();
            orders1.setOrdDelState(orders.getOrdDelState());//设置删除状态为1 未删除
            orders1.setAddress(orders.getAddress()); //
            orders1.setCustomer(orders.getCustomer());
            orders1.setUser(orders.getUser());
            orders1.setQuote(orders.getQuote());
            orders1.setOrdTheme(orders.getOrdTheme());
            orders1.setOrdNumber(this.getIds()); //订单自动编号
            //System.out.println("sss"+this.getId());
            orders1.setOrdClassify(orders.getOrdClassify());
            orders1.setOrdPayment(orders.getOrdPayment());
            orders1.setOrdTotalAmount(orders.getOrdTotalAmount());
            orders1.setOrdSendOutMoney(orders.getOrdSendOutMoney());
            orders1.setOrdMargin(orders.getOrdMargin());
            orders1.setOrdTime(orders.getOrdTime());
            orders1.setOrdExecutingState(orders.getOrdExecutingState());
            orders1.setOrdPurchaseWay(orders.getOrdPurchaseWay());
            orders1.setOrdHabit(orders.getOrdHabit());
            orders1.setOutStatus("未出库");
            orders1.setOrdSendOutState("未发货");
            orders1.setOrdRemark(orders.getOrdRemark());
            omdao.insertOrders(orders1);
            //如果是获取报价的产品 就把报价的产品详情都添加进订单详情
            if(orders.getQuote().getQuoId()!=0) {
                //把报价详情中的产品查询出来
                List<Quotedetails> quotedetails=quoteDetailsMDao.queryByQuoId(orders.getQuote().getQuoId());
                for(Quotedetails q:quotedetails){
                    Orderdetail orderdetail=new Orderdetail();
                    orderdetail.setOrders(orders);
                    orderdetail.setCustomer(orders.getCustomer());
                    orderdetail.setUser(orders.getUser());
                    orderdetail.setProductspecification(q.getProductspecification());
                    orderdetail.setDetNumber(q.getQuantity());
                    orderdetail.setDetTime(new Timestamp(System.currentTimeMillis()));
                    orderdetail.setDetRequire("报价产品");
                    orderdetail.setDetCondition("报价");
                    orderdetail.setDetMoney(q.getMoney());
                    //添加报价中的产品进订单详情
                    omdao.insertOrderdetail(orderdetail);
                }
                //根据订单id 把订单详情中的详情金额统计出来
                Integer m=omdao.findByOrdersDetailMonery(orders.getOrdId());
                //把订单的总金额重新修改赋值
                omdao.updateTotalMoney(m,orders.getOrdId());
                //改为待出库
                omdao.updateOutStatus(orders1.getOrdId());
                //选择后把报价的Id修改成3表示已经转成订单了
                quomdao.PLupdateByQutId(orders.getQuote().getQuoId());
            }
        }else {
            //修改
            omdao.updateOrders(orders);
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
     * mybatis 修改作为删除
     * @param ordid
     */
    public void delOrdersById(Integer ordid){
        omdao.delOrdersById(ordid);
    }

    /**
     * 批量删除
     * @param ordids
     */
    public void BatchOrdids(Integer[] ordids){
        omdao.BatchOrdids(ordids);
    }

    /**
     * 条件模糊查询
     * @param select
     * @param value
     * @param input1
     * @return
     */
    public Pager<Orders> queryByLikeQuery(int curpage, int pagesize, String select, String value, String input1){
        PageHelper.startPage(curpage,pagesize);
        String input="%"+input1+"%";
        List<Orders> list=omdao.queryByLikeQuery(select,input,value);
        PageInfo<Orders> page=new PageInfo<>(list);
        return new Pager<>(page.getTotal(),page.getList());
    }

    /**
     * 高级查询
     * @param plOdersAdvancedSearch
     * @return
     */
    public Pager<Orders> OrdersAdvancedSearch(PLOdersAdvancedSearch plOdersAdvancedSearch){
        String ordTheme="%"+plOdersAdvancedSearch.getOrdTheme().trim()+"%";
        String ordNumber="%"+plOdersAdvancedSearch.getOrdNumber().trim()+"%";
        String uIdSingle="%"+plOdersAdvancedSearch.getuIdSingle().trim()+"%";
        String addCity="%"+plOdersAdvancedSearch.getAddCity().trim()+"%";
        plOdersAdvancedSearch.setOrdTheme(ordTheme);
        plOdersAdvancedSearch.setOrdNumber(ordNumber);
        plOdersAdvancedSearch.setuIdSingle(uIdSingle);
        plOdersAdvancedSearch.setAddCity(addCity);

        PageHelper.startPage(plOdersAdvancedSearch.getCurpage(),plOdersAdvancedSearch.getPagesize());
        List<Orders> list=omdao.OrdersAdvancedSearch(plOdersAdvancedSearch);
        PageInfo<Orders> page=new PageInfo<>(list);
        return new Pager<Orders>(page.getTotal(),page.getList());
    }

    /**
     * 批量添加订单详情
     * @param
     */
    public void addAndEditOrderDdetail(List<Orderdetail> orderdetail){
        for (Orderdetail orderdetail1:orderdetail){
            if (orderdetail1.getDetId()==0){
                omdao.insertOrderdetail(orderdetail1);
            }else {
                omdao.updateOrderdetail(orderdetail1);
            }
        }
        //根据订单id 把订单详情中的详情金额统计出来
        Integer m=omdao.findByOrdersDetailMonery(orderdetail.get(0).getOrders().getOrdId());
        //把订单的总金额重新修改赋值
        omdao.updateTotalMoney(m,orderdetail.get(0).getOrders().getOrdId());
        //有详情就修改出库状态 待出库
        omdao.updateOutStatus(orderdetail.get(0).getOrders().getOrdId());

    }
    //批量删除订单详情
    public void deleteBydetId(Integer[] detIds){
        if(detIds.length>0){
            omdao.deleteBydetId(detIds);
        }else {
            System.out.println("传入长度为0");
        }

    }

    /**
     * 根据订单Id查询订单详情
     * @param ordid
     * @return
     */
    public List<Orderdetail> queryOrderdetailByOrdid(Integer ordid){
        return orderDetailMDao.queryOrderdetailByOrdid(ordid);
    }
    /**
     * 取消订单 HT
     * @param ordId
     */
    public void cancelOrder(Integer ordId){
        omdao.cancelOrders(ordId);
        Outstock outstock = outstockDao.queryOutstockByOrdId(ordId);
        outstock.setStatus("订单终止");
        outstockDao.updateOutStock(outstock);
    }

}
