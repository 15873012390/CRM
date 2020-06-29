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
    @Autowired
    private JrcStagelogMDao stagelogMDao;
    @Autowired
    private JrcClientdemandMDao clientdemandMDao;
    @Autowired
    private JrcSolutionMDao solutionMDao;
    @Autowired
    private JrcQuoteMDao quoteMDao;
    @Autowired
    private JrcQuoteDetailsMDao quoteDetailsMDao;

    List<JrcSalesOpportStage> sos1=new ArrayList<>();

    /**
     * 查看所有
     * @return
     */
    public List<Salesopport> queryAll(){
        return salesOpportMDao.queryAll();
    }

    /**
     * 分页查看全部
     * @param curpage
     * @param pagesize
     * @return
     */
    public Map queryAllSalesOppoerByPage(int curpage, int pagesize) {
        List<Salesopport> sumList=salesOpportMDao.queryAll();
        PageHelper.startPage(curpage, pagesize);
        List<Salesopport> slist = salesOpportMDao.queryAll();
        BigDecimal s=sum(sumList);
        PageInfo<Salesopport> pager = new PageInfo<>(slist);
        return backDate(pager,s);
    }

    /**
     * 模糊搜索
     * @param value    下拉框的值
     * @param inputs   输入框的值
     * @param select   下拉列表【机会主题、客户名称】
     * @param pagesize 页大小
     * @return
     */
    public Map querySalesOpportByLikeSearchPage(String value, String inputs, String select, int curpage, int pagesize) {
        List<Salesopport> sumList=salesOpportMDao.queryByLikeSearch(value,inputs.trim()!=""?"%"+inputs.trim()+"%":"", select);
        PageHelper.startPage(curpage, pagesize);
        List<Salesopport> list = salesOpportMDao.queryByLikeSearch(value,inputs.trim()!=""?"%"+inputs.trim()+"%":"", select);
        PageInfo<Salesopport> pager = new PageInfo<>(list);
        BigDecimal s=sum(sumList);
        return backDate(pager,s);
    }
    /**
     * 高级搜索员工
     * @param  s
     * @return
     */
    public Map querySalesOpportByAdvancedSearch(SalesOpportAdvancedSearch s) {
        s.setOpportunitiesThem(s.getOpportunitiesThem().trim()!=""?"%"+s.getOpportunitiesThem().trim()+"%":"");
        List<Salesopport> sumList=salesOpportMDao.queryByAdvancedSearch(s);
        PageHelper.startPage(s.getCurpage(), s.getPagesize());
        List<Salesopport> list = salesOpportMDao.queryByAdvancedSearch(s);
        BigDecimal su=sum(sumList);
        PageInfo<Salesopport> pager = new PageInfo<>(list);
        return backDate(pager,su);
    }


    /**
     * 计算全部数据
     * @param list
     * @return
     */
    public static BigDecimal sum(List<Salesopport> list){
        BigDecimal s=new BigDecimal(0);
        for(Salesopport sa:list){
            s=(s.add(sa.getAmount()==null?new BigDecimal(0):sa.getAmount())).setScale(2);
        }
        return s;
    }

    /**
     * 返回数据
     * @param pageInfo
     * @param sum
     * @return
     */
    public static Map backDate(PageInfo pageInfo,BigDecimal sum){
        Map map=new HashMap();
        map.put("sum",sum);
        map.put("list",new Pager<>(pageInfo.getTotal(), pageInfo.getList()));
        return map;
    }
    /**
     * 添加/编辑销售机会
     * 1.判断传进来的销售机会存不存在  存在则为修改   不存在则为添加
     * 2.修改时 判断有没有更改销售机会的阶段备注或者阶段
     * （a.修改了阶段备注/阶段 则新增一条阶段日志记录和修改销售机会表
     * （b.没有修改则仅仅修改销售机会表
     *
     * @param s
     */
    public void addSalesOpport(Salesopport s) {
        Stagelog stagelog = new Stagelog();
        Salesopport s2 = salesOpportMDao.queryBySoid(s.getSoId());
        if (s2!=null) {
            //编辑
            Salesopport sales=salesOpportJDao.save(s);

            if (!((s2.getStage().equals(s.getStage())) &&
                    (s2.getConPhone().equals(s.getConPhone())))) {
                stagelog.setSlNote(s.getConPhone());
                stagelog.setRecordTime(new Timestamp(new Date().getTime()));
                stagelog.setStageName(s.getStage());
                //当前登录员工
                stagelog.setUserName(s.getUser().getuName());
                stagelog.setSalesopport(sales);
                stagelogJDao.save(stagelog);
            }
            //新增
        } else {
            Customer c = customerMDao.queryContactByCusid(s.getCustomer().getCusId());
            s.setUpdateDate(new Timestamp(new Date().getTime()));
            s.setCustomer(c);
            Salesopport saves=salesOpportJDao.save(s);
            //Salesopport s2 = salesOpportMDao.queryAll().get(0);
            stagelog.setSlNote(s.getConPhone());
            stagelog.setRecordTime(new Timestamp(new Date().getTime()));
            stagelog.setStageName(s.getStage());

            //操作人 为 当前登录的员工
            stagelog.setUserName(s.getUser().getuName());

            stagelog.setSalesopport(saves);
            stagelogJDao.save(stagelog);

        }

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
        if(s!=null){
            stagelogMDao.deleteStageLogBySoid(soid);
            clientdemandMDao.deleteClientdemandBySoid(soid);
            solutionMDao.deleteSolutionBySoid(soid);
            List<Quote> quotes=quoteMDao.queryQuoteBySoid(soid);
            for(Quote q:quotes){
                quoteDetailsMDao.deleteQuoteDetailsByquoId(q.getQuoId());
            }
            quoteMDao.deleteQuoteBySoid(soid);
            salesOpportMDao.deleteSalesBySoId(soid);
        }

    }

    /**
     * 批量删除销售机会
     *
     * @param soids
     */
    public void delBatchSalesopport(Integer[] soids) {
        for (Integer soid : soids) {
            delSalesOpport(soid);
        }
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

    //图表1
    public List<CountPie> querySalesEarch1(Integer op){
        return salesOpportMDao.querySalesEarch1(op);
    }

    //图表2
    public CountBar querySalesEarch2(Integer op){
        CountBar countBar=new CountBar();

        List<CountPie> list=salesOpportMDao.querySalesEarch2(op);
        String[] name=new String[list.size()];
        int[] value=new int[list.size()];
        int count=0;
        for (CountPie countPie:list){

            name[count]=countPie.getName();
            value[count]=countPie.getValue();
            count++;

        }
        countBar.setName(name);
        countBar.setValue(value);

        return countBar;
    }

    //图表3
    public Map querySalesEarch3(Integer op){

        List<Map> map = salesOpportMDao.querySalesEarch3(op);
        Integer size=map.size();
        System.out.println(map.toString());

        List<String> des=new ArrayList<>();
        List<String> names=new ArrayList<>();
        List<Long> numbers=new ArrayList<>();
        List<JrcSerices> listSerices = new ArrayList<>();
        String d="";
        System.out.println(map.size());
        for(int i=0;i<map.size();i++){
            String de=(String)map.get(i).get("de");
            if(!de.equals(d)){
                des.add(de);
                for(int j=0;j<map.size();j++){
                    if(de.equals(map.get(j).get("de"))){
                        String n="";
                        if(op==1 || op==3){
                            Integer name=(Integer) map.get(j).get("name");
                            n=oP(name);
                        }else if(op==2||op==4) {
                            n = (String) map.get(j).get("name");
                        }
                        names.add(n);
                        numbers.add((Long)map.get(j).get("number"));
                    }
                }
            }
            d=de;
        }

        //移除重复的数据
        for ( int x = 0 ; x < names.size() - 1 ; x ++ ) {
            for ( int y = names.size() - 1 ; y > x; y -- ) {
                if (names.get(y).equals(names.get(x))) {
                    names.remove(y);
                }
            }
        }
        for(int i=0;i<names.size();i++){
            JrcSerices serices=new JrcSerices();
            List<Long> list1=new ArrayList<>();
            serices.setName(names.get(i));
            serices.setType("line");
            serices.setStack("总数");
            for(int j=0;j<map.size();j++){
                String n="";
                if(op==1 || op==3){
                    Integer name=(Integer) map.get(j).get("name");
                    n=oP(name);
                }else if(op==2||op==4) {
                    n = (String) map.get(j).get("name");
                }
                if(n.equals(names.get(i))){
                    list1.add((Long)map.get(j).get("number"));
                }
            }
            serices.setData(list1);
            listSerices.add(serices);
        }

        Map map1=new HashMap();
        map1.put("des",des);
        map1.put("names",names);
        map1.put("numbers",numbers);
        map1.put("listSerices",listSerices);
       return map1;

     }


     public static String oP(Integer op){
        String n="";
         switch (op){
             case 1:
                 n="跟踪";
                 break;
             case 2:
                 n="成功";
                 break;
             case 3:
                 n="失败";
                 break;
             case 4:
                 n="搁置";
                 break;
             case 5:
                 n="失效";
                 break;
         }
         return n;
     }

    /**
     * 销售漏斗图
     * @param s
     * @return
     */
     public List<Map> querySalesFunnel1(JrcSalesFunnelUO s){
       return salesOpportMDao.querySalesFunnel1(s);
     }



}
