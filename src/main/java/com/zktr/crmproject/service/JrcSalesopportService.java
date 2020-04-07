package com.zktr.crmproject.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcSalesOpportJDao;
import com.zktr.crmproject.dao.jpa.JrcStagelogJDao;
import com.zktr.crmproject.dao.mybatis.*;


import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.utils.JrcCharType;
import com.zktr.crmproject.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

@Service
@Transactional(rollbackOn = Exception.class)
public class JrcSalesopportService {

    @Autowired
    private JrcSalesOpportMDao salesOpportMDao;
    @Autowired
    private JrcCustomerMDao customerMDao;
    @Autowired
    private JrcUserMDao userMDao;
    @Autowired
    private JrcSalesOpportJDao salesOpportJDao;
    @Autowired
    private JrcStagelogJDao stagelogJDao;
    @Autowired
    private JrcCharTypeMDao charTypeMDao;

    @Autowired
    private JrcSalesFunnelMDao salesFunnelMDao;


    List<JrcSalesOpportStage> sos1=new ArrayList<>();

    /**
     * 查看销售机会
     * @return
     */
    public List<Salesopport> queryAll(){
        return salesOpportMDao.queryAll();
    }

    /**
     * 分页查看全部
     *
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Salesopport> queryAllSalesOppoerByPage(int curpage, int pagesize) {
        PageHelper.startPage(curpage, pagesize);
        List<Salesopport> slist = salesOpportMDao.queryAll();
        PageInfo<Salesopport> pager = new PageInfo<>(slist);
        return new Pager<Salesopport>(pager.getTotal(), pager.getList());
    }

    /**
     * 模糊搜索
     *
     * @param value    下拉框的值
     * @param inputs   输入框的值
     * @param select   下拉列表【机会主题、客户名称】
     * @param pagesize 页大小
     * @return
     */
    public Pager<Salesopport> querySalesOpportByLikeSearchPage(String value, String inputs, String select, int curpage, int pagesize) {
        PageHelper.startPage(curpage, pagesize);
        String input = "";
        System.out.println(inputs.trim().length() != 0);
        if (inputs.trim().length() != 0) {
            input = "%" + inputs.trim() + "%";
        } else {
            input = inputs.trim();
        }
        List<Salesopport> list = salesOpportMDao.queryByLikeSearch(value, input, select);
        PageInfo<Salesopport> pager = new PageInfo<>(list);
        return new Pager<Salesopport>(pager.getTotal(), pager.getList());
    }

    /**
     * 查看所有客户
     *
     * @return
     */
    public List<Customer> queryAllCustomer() {
        return customerMDao.queryAll();
    }

    /**
     * 查看所有员工
     *
     * @return
     */
    public List<User> queryAllUser() {
        return userMDao.queryAll();
    }

    /**
     * 高级搜索员工
     *
     * @param salesOpportAdvancedSearch
     * @return
     */
    public Pager<Salesopport> querySalesOpportByAdvancedSearch(SalesOpportAdvancedSearch salesOpportAdvancedSearch) {
        String opportunites = "%" + salesOpportAdvancedSearch.getOpportunitiesThem().trim() + "%";
        salesOpportAdvancedSearch.setOpportunitiesThem(opportunites);
        PageHelper.startPage(salesOpportAdvancedSearch.getCurpage(), salesOpportAdvancedSearch.getPagesize());
        List<Salesopport> list = salesOpportMDao.queryByAdvancedSearch(salesOpportAdvancedSearch);
        PageInfo<Salesopport> pager = new PageInfo<>(list);
        return new Pager<Salesopport>(pager.getTotal(), pager.getList());
    }

    /**
     * 添加/编辑销售机会
     * 1.判断传进来的销售机会存不存在  存在则为修改   不存在则为添加
     * 2.修改时 判断有没有更改销售机会的阶段备注或者阶段
     * （a.修改了阶段备注/阶段 则新增一条阶段日志记录和修改销售机会表
     * （b.没有修改则仅仅修改销售机会表
     *
     * @param salesopport
     */
    public void addSalesOpport(Salesopport salesopport) {
        Stagelog stagelog = new Stagelog();
        if (salesopport.getSoId() != 0) {
            Salesopport s = salesOpportMDao.queryBySoid(salesopport.getSoId());
            salesOpportJDao.save(salesopport);
            if (!((s.getStage().equals(salesopport.getStage())) &&
                    (s.getConPhone().equals(salesopport.getConPhone())))) {
                stagelog.setSlNote(salesopport.getConPhone());
                stagelog.setRecordTime(new Timestamp(new Date().getTime()));
                stagelog.setStageName(salesopport.getStage());
                //当前登录员工
                stagelog.setUserName(salesopport.getUser().getuName());
                stagelog.setSalesopport(s);

            }
            //新增
        } else {
            Customer c = customerMDao.queryContactByCusid(salesopport.getCustomer().getCusId());
            salesopport.setUpdateDate(new Timestamp(new Date().getTime()));
            salesopport.setCustomer(c);
            salesOpportJDao.save(salesopport);
            Salesopport s2 = salesOpportMDao.queryAll().get(0);
            stagelog.setSlNote(salesopport.getConPhone());
            stagelog.setRecordTime(new Timestamp(new Date().getTime()));
            stagelog.setStageName(salesopport.getStage());
            //操作人 为 当前登录的员工
            stagelog.setUserName(salesopport.getUser().getuName());
            stagelog.setSalesopport(s2);

        }
        stagelogJDao.save(stagelog);
    }

    /**
     * 根据销售机会id查找销售机会和销售阶段日志
     *
     * @param soid
     * @return
     */
    public Salesopport queryBySoid(Integer soid) {
        return salesOpportMDao.queryBySoid(soid);
    }

    /**
     * 删除销售机会
     *
     * @param soid
     */
    public void delSalesOpport(Integer soid) {
        Salesopport s = salesOpportMDao.deleteQueryById(soid);
        s.setDelStatus(2);
        salesOpportJDao.save(s);
    }

    /**
     * 批量删除销售机会
     *
     * @param soids
     */
    public void delBatchSalesopport(Integer[] soids) {
        for (Integer soid : soids) {
            Salesopport s = salesOpportMDao.deleteQueryById(soid);
            s.setDelStatus(2);
            salesOpportJDao.save(s);
        }
    }

    /**
     * 销售漏斗（销售机会阶段个数）
     *
     * @param users
     * @return
     */
    public Map querySalesOpportByStageNumberAndMoney(List<User> users) {
        HashMap map=new HashMap();
        List<JrcSalesFunnel> salesFunnels=new ArrayList<>();
        //个数
        List<JrcCharType> charTypes=new ArrayList<>();
        //金额
        List<JrcCharType> charTypeMoneys=new ArrayList<>();

        String stage = "";
        for (int i = 1; i <= 6; i++) {
            if (i == 1) {
                stage = "初期沟通";
            } else if (i == 2) {
                stage = "需求分析";
            } else if (i == 3) {
                stage = "方案制定";
            } else if (i == 4) {
                stage = "招投标竞争";
            } else if (i == 5) {
                stage = "商务谈判";
            } else if (i == 6) {
                stage = "合同签约";
            }
            JrcSalesFunnel salesFunnel= salesFunnelMDao.querySalesOpportByStageNumberAndMoney(users,stage);
            if(salesFunnel!=null){
                salesFunnels.add(salesFunnel);
            }
        }
        BigDecimal length=new BigDecimal(100);
        BigDecimal lengthMoney=new BigDecimal(100);
        for(int i=0;i<salesFunnels.size();i++){
            JrcCharType charType=new JrcCharType();
            JrcCharType charTypeMoney=new JrcCharType();
            if(i==0){
                //个数
                charType.setValue(length.doubleValue());
                charType.setName(salesFunnels.get(i).getStage()+","+salesFunnels.get(i).getNumbers());
                charTypes.add(charType);

                //金额
                charTypeMoney.setValue(length.doubleValue());
                charTypeMoney.setName(salesFunnels.get(i).getStage()+","+salesFunnels.get(i).getMoney());
                charTypeMoneys.add(charTypeMoney);

            }else{
                //个数
                if(!(new BigDecimal(salesFunnels.get(i).getNumbers()).divide(new BigDecimal(salesFunnels.get(i-1).getNumbers()),2,BigDecimal.ROUND_HALF_UP).compareTo(new BigDecimal("1"))==1)){
                    length=(new BigDecimal(salesFunnels.get(i).getNumbers()).divide(new BigDecimal(salesFunnels.get(i-1).getNumbers()),2,BigDecimal.ROUND_HALF_UP).multiply(length)).setScale(0,BigDecimal.ROUND_HALF_UP);
                }
                charType.setValue(length.doubleValue());
                charType.setName(salesFunnels.get(i).getStage()+","+salesFunnels.get(i).getNumbers());
                charTypes.add(charType);
                //金额
                if(!(salesFunnels.get(i).getMoney().divide(salesFunnels.get(i-1).getMoney(),2,BigDecimal.ROUND_HALF_UP).compareTo(new BigDecimal("1"))==1)){
                    lengthMoney=(salesFunnels.get(i).getMoney().divide(salesFunnels.get(i-1).getMoney(),2,BigDecimal.ROUND_HALF_UP).multiply(lengthMoney)).setScale(0,BigDecimal.ROUND_HALF_UP);
                }
                charTypeMoney.setValue(lengthMoney.doubleValue());
                charTypeMoney.setName(salesFunnels.get(i).getStage()+","+salesFunnels.get(i).getMoney());
                charTypeMoneys.add(charTypeMoney);

            }
        }
        map.put("charTypeNumbers",charTypes);
        map.put("charTypeMoneys",charTypeMoneys);
        return map;
    }

    /**
     * 销售漏斗表格数据
     */
    public Map querySalesOpportFunnle(List<User> users) {
        Map map = new HashMap();
        List<JrcSalesFunnel> lists = new ArrayList<>();
        String stage = "";
        for (int i = 1; i <= 6; i++) {
            if (i == 1) {
                stage = "初期沟通";
            } else if (i == 2) {
                stage = "需求分析";
            } else if (i == 3) {
                stage = "方案制定";
            } else if (i == 4) {
                stage = "招投标竞争";
            } else if (i == 5) {
                stage = "商务谈判";
            } else if (i == 6) {
                stage = "合同签约";
            }

            JrcSalesFunnel s2 = salesFunnelMDao.querySalesFunnel(users, stage);
            if (s2 == null) {
                JrcSalesFunnel s1=new JrcSalesFunnel();
                s1.setStage(stage);
                s1.setNumbers(0);
                s1.setNmberHistoryConversion(0);
                s1.setNumberAvgen(0);
                s1.setMoney(new BigDecimal(0));
                s1.setMoneyHistoryConversion(new BigDecimal(0));
                s1.setMoneyAvgen(new BigDecimal(0));
                lists.add(s1);
            }else{
                lists.add(s2);
            }
        }
        List<JrcSalesFunnelSourceDate> listSourceDate = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            JrcSalesFunnelSourceDate ssd = new JrcSalesFunnelSourceDate();
            while (i != lists.size() - 1) {
                lists.get(i).setNumbers(integerIfNull(lists.get(i).getNumbers()));
                lists.get(i+1).setNumbers(integerIfNull(lists.get(i+1).getNumbers()));
                lists.get(i).setNmberHistoryConversion(integerIfNull(lists.get(i).getNmberHistoryConversion()));
                lists.get(i+1).setNmberHistoryConversion(integerIfNull(lists.get(i+1).getNmberHistoryConversion()));
                lists.get(i).setNumberAvgen(integerIfNull(lists.get(i).getNumberAvgen()));
                lists.get(i+1).setNumberAvgen(integerIfNull(lists.get(i+1).getNumberAvgen()));

                lists.get(i).setMoney(bigDecimalIfNull(lists.get(i).getMoney()));
                lists.get(i+1).setMoney(bigDecimalIfNull(lists.get(i+1).getMoney()));
                lists.get(i).setMoneyHistoryConversion(bigDecimalIfNull(lists.get(i).getMoneyHistoryConversion()));
                lists.get(i+1).setMoneyHistoryConversion(bigDecimalIfNull(lists.get(i+1).getMoneyHistoryConversion()));
                lists.get(i).setMoneyAvgen(bigDecimalIfNull(lists.get(i).getMoneyAvgen()));
                lists.get(i+1).setMoneyAvgen(bigDecimalIfNull(lists.get(i+1).getMoneyAvgen()));

                ssd.setStage(lists.get(i).getStage());
                ssd.setNumbers(lists.get(i).getNumbers());
                BigDecimal numberConversion = bigDecimalDivide(BigDecimal.valueOf(lists.get(i + 1).getNumbers()), BigDecimal.valueOf(lists.get(i).getNumbers()),1);
                ssd.setNumberConversion(numberConversion.toString() + "%");

                BigDecimal numberHistoryConversion = bigDecimalDivide(BigDecimal.valueOf(lists.get(i + 1).getNmberHistoryConversion()), BigDecimal.valueOf(lists.get(i).getNmberHistoryConversion()),1);
                ssd.setNmberHistoryConversion(numberHistoryConversion + "%");

                BigDecimal numberAvgen = bigDecimalDivide(BigDecimal.valueOf(lists.get(i + 1).getNumberAvgen()), BigDecimal.valueOf(lists.get(i).getNumberAvgen()),1);
                ssd.setNumberAvgen(numberAvgen + "%");

                ssd.setMoney(lists.get(i).getMoney());

                BigDecimal moneyConversion = bigDecimalDivide(lists.get(i + 1).getMoney(), lists.get(i).getMoney(),1);
                ssd.setMoneyConversion(moneyConversion + "%");

                BigDecimal moneyHistoryConversion = bigDecimalDivide(lists.get(i + 1).getMoneyHistoryConversion(), lists.get(i).getMoneyHistoryConversion(),1);
                ssd.setMoneyHistoryConversion(moneyHistoryConversion + "%");

                BigDecimal moneyAvgen = bigDecimalDivide(lists.get(i + 1).getMoneyAvgen(), lists.get(i).getMoneyAvgen(),1);
                ssd.setMoneyAvgen(moneyAvgen + "%");

                listSourceDate.add(ssd);
                break;
            }
            if (i == lists.size() - 1) {
                ssd.setStage(lists.get(i).getStage());
                ssd.setNumbers(lists.get(i).getNumbers());
                ssd.setMoney(lists.get(i).getMoney());
                listSourceDate.add(ssd);
            }
        }
        map.put("listSourceDate", listSourceDate);
        return map;
    }

    /**
     * 两个BigDecimal数相除保留一位小数
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal bigDecimalDivide(BigDecimal a, BigDecimal b,int scale) {
        if (a.compareTo(BigDecimal.ZERO) == 0 || b.compareTo(BigDecimal.ZERO) == 0) {
            return new BigDecimal(0);
        }else {
            return (a.multiply(new BigDecimal(100))).divide(b, scale, BigDecimal.ROUND_HALF_UP);
        }
    }

    /**
     * 判断BigDecimal类型为不为空
     * @param bigDecimal
     * @return
     */
    public BigDecimal  bigDecimalIfNull(BigDecimal bigDecimal){
        if(bigDecimal==null){
            return new BigDecimal(0);
        }else{
            return bigDecimal;
        }
    }

    /**
     * 判断integer类型为不为空
     * @param integer
     * @return
     */
    public Integer integerIfNull(Integer integer){
        if(integer==null){
            return 0;
        }else{
            return integer;
        }
    }

    /**
     * 根据客户找到对应的销售机会
     * @param customer
     * @return
     */
    public List<Salesopport> querySalesOpportByCustomer(Customer customer){
        return salesOpportMDao.querySalesOpportByCustomer(customer);
    }

    /**
     * 根据客户id查找对应的记录
     * @param cusid
     * @return
     */
    public List<Salesopport> querySalesOpportByCusid(Integer cusid){
        return salesOpportMDao.querySalesOpportByCusId(cusid);
    }
    /**
     * 销售预测
     * @param timeStart
     * @param timeEnd
     * @param possibity
     * @param status
     * @return
     */
    public Map querySalesOpportByForecast(Date timeStart,Date timeEnd,String possibity,Integer status,Integer curpage,Integer pagesize){
        Map map=new HashMap();
        PageHelper.startPage(curpage,pagesize);
        List<Salesopport> list=salesOpportMDao.querySalesOpportByForecast(timeStart,timeEnd,possibity,status);
        PageInfo<Salesopport> pageInfo=new PageInfo<>(list);

        List<User> users=userMDao.queryUserBySalesOpport(timeStart,timeEnd,possibity);
        map.put("list",new Pager(pageInfo.getTotal(),pageInfo.getList()));
        map.put("users",users);

        return map;
    }

    //根据阶段最终转化率预测
    public Map queryFinalllSalesOpportByForecast(Date timeStart,Date timeEnd,Integer uId,String possibity,Integer curpage,Integer pagesize){
        Map map=new HashMap();
        PageHelper.startPage(curpage,pagesize);
        List<Salesopport> list=salesOpportMDao.queryFinalllSalesOpportByForecast(timeStart,timeEnd,possibity,uId);
        PageInfo<Salesopport> pageInfo=new PageInfo<>(list);
        map.put("list",new Pager(pageInfo.getTotal(),pageInfo.getList()));
        List<JrcSalesOpportStage> stages=salesOpportMDao.queryFinallStage(uId);
        //清空sos1
        sos1.clear();
        if(stages!=null){
            addStages(stages,"初期沟通");
            addStages(stages,"需求分析");
            addStages(stages,"方案制定");
            addStages(stages,"招投标竞争");
            addStages(stages,"商务谈判");
            addStages(stages,"合同签约");
        }else{
            sos1.add(new JrcSalesOpportStage("初期沟通",0L));
            sos1.add(new JrcSalesOpportStage("需求分析",0L));
            sos1.add(new JrcSalesOpportStage("方案制定",0L));
            sos1.add(new JrcSalesOpportStage("招投标竞争",0L));
            sos1.add(new JrcSalesOpportStage("商务谈判",0L));
            sos1.add(new JrcSalesOpportStage("合同签约",0L));
        }
        List<JrcSalesFunnelSourceDate> sfsd1=new ArrayList<>();
        for(int i=0;i<sos1.size();i++){
            JrcSalesFunnelSourceDate ssd = new JrcSalesFunnelSourceDate();
            while (i!=sos1.size()-1){
                ssd.setStage(sos1.get(i).getStage());
                ssd.setNumberConversion(bigDecimalDivide(new BigDecimal(sos1.get(i+1).getCounts()),new BigDecimal(sos1.get(i).getCounts()),2).toString()+"%");
                sfsd1.add(ssd);
                break;
            }
            if(i==sos1.size()-1){
                ssd.setStage(sos1.get(i).getStage());
                ssd.setNumberConversion("");
                sfsd1.add(ssd);
            }
        }
        map.put("finallSalesForster",sfsd1);
        return map;
    }

    //封装方法
    public void addStages(List<JrcSalesOpportStage> stages,String stage){
        int i=0;
        for (JrcSalesOpportStage sos:stages){
            if(sos.getStage().equals(stage)) {
                sos1.add(new JrcSalesOpportStage(stage, sos.getCounts()));
                break;
            }else{
                i++;
            }
            if(i==stages.size()){
                sos1.add(new JrcSalesOpportStage(stage,0L));
            }

        }
    }

}
