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
        try {
            //String s=id.substring(id.length()-4);//截取最大id的后4位
            String equipmentNo= UUIDUtils.getNewNo("ORDER",id);
            System.out.println(equipmentNo);
            return equipmentNo;
        }catch (Exception e){
            return "ORDER00001"; //若没有id则返回这个
        }
    }

    /**
     * mybatis 新增地址
     * @param address
     */
    public Integer saveAddress(Address address) {
        if(address.getAddId()==0){
            addressMDao.insertAddress(address);
            return address.getAddId();
        }else {
            addressMDao.updateAddress(address);
            return 0;
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
           orders.setAddId(plOrdersVo.getAddId()); //
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
          //如果是获取报价的产品 就把报价的产品详情都添加进订单详情
          if(plOrdersVo.getQuoId()!=0) {
              int orderid=omdao.findMaxOrdid();
              //把报价详情中的产品查询出来
              List<Quotedetails> quotedetails=quoteDetailsMDao.queryByQuoId(plOrdersVo.getQuoId());
              for(Quotedetails q:quotedetails){
                  PLOrdersDetailInVo ordersDetailInVo=new PLOrdersDetailInVo();
                  ordersDetailInVo.setOrdId(orderid);
                  ordersDetailInVo.setCusId(plOrdersVo.getCusId());
                  ordersDetailInVo.setuId(plOrdersVo.getuId());
                  ordersDetailInVo.setSpeId(q.getProductspecification().getSpeId());
                  ordersDetailInVo.setDetNumber(q.getQuantity());
                  ordersDetailInVo.setDetTime(new Timestamp(System.currentTimeMillis()));
                  ordersDetailInVo.setDetRequire("报价产品");
                  ordersDetailInVo.setDetCondition("报价");
                  ordersDetailInVo.setDetMoney(q.getMoney());
                  omdao.insertOrderdetailIn(ordersDetailInVo);
              }
              //选择后把报价的Id修改成3表示已经转成订单了
              quomdao.PLupdateByQutId(plOrdersVo.getQuoId());
          }


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
     * @param pLordersDetailVo
     */
    public void addAndEditOrderDdetail(PLordersDetailVo pLordersDetailVo){
        Orderdetail dea=new Orderdetail();
        for(Orderdetail detail:pLordersDetailVo.getList()){
            if(detail.getDetId()==0){
                omdao.insertOrderdetail(detail);
            }else {
                omdao.updateOrderdetail(detail);
            }
        }
        //删除
        for (Integer detid:pLordersDetailVo.getDel()){
            if(pLordersDetailVo.getDel().length>0){
                omdao.deleteBydetId(detid);
            }else {
                System.out.println("传入的长度为0");
            }
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
}
