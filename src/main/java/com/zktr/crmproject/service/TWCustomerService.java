package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.ICustomerDao;
import com.zktr.crmproject.dao.jpa.TWCustomerTransferDao;
import com.zktr.crmproject.dao.mybatis.TWCustomerMapperDao;
import com.zktr.crmproject.dao.mybatis.TWCustomerTransfer2MapperDao;
import com.zktr.crmproject.dao.mybatis.TWCustomerTransferMapperDao;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Customertransfer;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional(rollbackFor = Exception.class)
public class TWCustomerService {
    @Autowired
    private ICustomerDao customerDao;
    @Autowired(required = false)
    private TWCustomerMapperDao TWCustomerMapperDao;
    @Autowired
    private TWCustomerTransferDao twCustomerTransferDao;
    @Autowired(required = false)
    private TWCustomerTransferMapperDao twCustomerTransferMapperDao;
    @Autowired(required = false)
    private com.zktr.crmproject.dao.mybatis.lliUserDao lliUserDao;
    @Autowired(required = false)
    private TWCustomerTransfer2MapperDao twCustomerTransfer2MapperDao;

    /**
     * 导入验证
     * @param list
     * @return
     */
    public String[] CustomerExcle(List<Customer> list){
        String[] strings= new String[list.size()];
        String str="";
        int num=0;
        for (Customer customer:list){
            str="";
            //客户名称重复
            if (!this.countCustomerName(customer.getCusName())){
                str+="客户名称重复<br/>";
            }
            //客户等级是否错误
            if (!customer.getCusLevel().equals("潜在客户") &&
                    !customer.getCusLevel().equals("普通客户") &&
                    !customer.getCusLevel().equals("重点客户") &&
                    !customer.getCusLevel().equals("大客户") &&
                    !customer.getCusLevel().equals("") &&
                    customer.getCusLevel()!=null){
                str+="客户等级错误<br/>";
            }
            //电话号码是否正确
            if (!customer.getCusTel().equals("") &&
                    customer.getCusTel()!=null &&
                    !this.phoneYanZheng(customer.getCusTel())){
                str+="电话号码错误<br/>";
            }
            //客户来源是否错误
            if (!customer.getCusSource().equals("电话来访") &&
                    !customer.getCusSource().equals("客户介绍") &&
                    !customer.getCusSource().equals("媒体宣传") &&
                    !customer.getCusSource().equals("网站填表") &&
                    !customer.getCusSource().equals("其他") &&
                    !customer.getCusSource().equals("") &&
                    customer.getCusSource()!=null){
                str+="客户来源错误<br/>";
            }
            //信用等级是否错误
            if (!customer.getCusCredit().equals("高") &&
                    !customer.getCusCredit().equals("较高") &&
                    !customer.getCusCredit().equals("中") &&
                    !customer.getCusCredit().equals("较低") &&
                    !customer.getCusCredit().equals("低") &&
                    !customer.getCusCredit().equals("") &&
                    customer.getCusCredit()!=null){
                str+="信用等级错误<br/>";
            }
            //生命周期是否错误
            if (!customer.getCusLifeCycle().equals("一次性") &&
                    !customer.getCusLifeCycle().equals("重复购买") &&
                    !customer.getCusLifeCycle().equals("长期合作") &&
                    !customer.getCusLifeCycle().equals("") &&
                    customer.getCusLifeCycle()!=null){
                str+="生命周期错误<br/>";
            }
            //客户状态是否错误
            if (!customer.getCusState().equals("正常") &&
                    !customer.getCusState().equals("预警") &&
                    !customer.getCusState().equals("流失") &&
                    !customer.getCusState().equals("") &&
                    customer.getCusState()!=null){
                str+="客户状态错误<br/>";
            }
            //定级是否错误
            if (!customer.getCusState().equals("特级") &&
                    !customer.getCusState().equals("大单") &&
                    !customer.getCusState().equals("正常") &&
                    !customer.getCusState().equals("小单") &&
                    !customer.getCusState().equals("") &&
                    customer.getCusState()!=null){
                str+="定级错误<br/>";
            }
            if (!str.equals("")){
                strings[num]=str;
            }
            num++;
        }
        return strings;
    }

    /**
     * 验证电话号码
     * @param phone
     * @return
     */
    public boolean phoneYanZheng(String phone){
        String regex = "0\\d{2,3}[-]?\\d{7,8}|0\\d{2,3}\\s?\\d{7,8}|13[0-9]\\d{8}|15[1089]\\d{8}";
        Pattern pattern = Pattern.compile(regex);    // 编译正则表达式
        Matcher matcher = pattern.matcher(phone);    // 创建给定输入模式的匹配器
        boolean bool = matcher.matches();
        return bool;
    }

    /**
     * 查看是否有重名客户
     * @param cusName
     * @return
     */
    public boolean countCustomerName(String cusName){
        int num=TWCustomerMapperDao.countCustomerByName(cusName);
        if (num>0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 根据用户id查询客户转移日志
     * @param uId
     * @param num
     * @param curpage
     * @param pagesize
     * @return
     * @throws ParseException
     */
    public Pager<Customertransfer> queryCustomerTransferById(Integer uId,Integer num, Integer curpage, Integer pagesize) throws ParseException {
        List<TWCustomertransfer> list=null;
        List<Customertransfer> list1=null;
        //判断是否为转出
        if (num==1){
            PageHelper.startPage(curpage,pagesize);
            list=twCustomerTransferMapperDao.findCustomerTransferById1(uId);
            PageHelper.startPage(curpage,pagesize);
            list1=twCustomerTransfer2MapperDao.findCustomerTransferById1(uId);
        }
        //判断是否为转入
        else if (num==2){
            PageHelper.startPage(curpage,pagesize);
            list=twCustomerTransferMapperDao.findCustomerTransferById2(uId);
            PageHelper.startPage(curpage,pagesize);
            list1=twCustomerTransfer2MapperDao.findCustomerTransferById2(uId);
        }


        int i=0;
        User user1=null;
        User user2=null;
        User user3=null;

        for (TWCustomertransfer tw:list){
            list1.get(i).setCustomer(tw.getCustomer());
            list1.get(i).setCtTime(tw.getCtTime());
            list1.get(i).setCtId(tw.getCtId());
            user1=lliUserDao.findById(tw.getOperation_u_id());
            user2=lliUserDao.findById(tw.getNow_u_id());
            user3=lliUserDao.findById(tw.getOriginal_u_id());
            list1.get(i).setUser3(user3);
            list1.get(i).setUser2(user2);
            list1.get(i).setUser1(user1);
            i++;
        }


        PageInfo<Customertransfer> pageInfo=new PageInfo<>(list1);
        return new Pager<Customertransfer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 查询所有客户转移日志
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customertransfer> queryAllCustomerTransfer(Integer curpage, Integer pagesize) throws ParseException {
        PageHelper.startPage(curpage,pagesize);
        List<TWCustomertransfer> list=twCustomerTransferMapperDao.findAllCustomerTransfer();
        PageHelper.startPage(curpage,pagesize);
        List<Customertransfer> list1=twCustomerTransfer2MapperDao.findAllCustomerTransfer();
        int i=0;
        User user1=null;
        User user2=null;
        User user3=null;

        for (TWCustomertransfer tw:list){
            list1.get(i).setCustomer(tw.getCustomer());
            list1.get(i).setCtTime(tw.getCtTime());
            list1.get(i).setCtId(tw.getCtId());
            user1=lliUserDao.findById(tw.getOperation_u_id());
            user2=lliUserDao.findById(tw.getNow_u_id());
            user3=lliUserDao.findById(tw.getOriginal_u_id());
            list1.get(i).setUser3(user3);
            list1.get(i).setUser2(user2);
            list1.get(i).setUser1(user1);
            i++;
        }


        PageInfo<Customertransfer> pageInfo=new PageInfo<>(list1);
        return new Pager<Customertransfer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加客户转移日志
     * @param customertransfer
     */
    public void saveCustomerTransfer(Customertransfer customertransfer){
        Customer customer=findCustomer(customertransfer.getCustomer().getCusId());
        customer.setUser(customertransfer.getUser2());
        customer.setCusUpdateTime(customertransfer.getCtTime());
        saveCustomer(customer);
        twCustomerTransferDao.save(customertransfer);
    }

    /**
     * 添加/修改客户
     * @param customer
     */
    public void saveCustomer(Customer customer){
        customerDao.save(customer);
    }

    /**
     * 批量添加客户
     * @param list
     */
    public void InsertAllCustomer(List<Customer> list){
        customerDao.saveAll(list);
    }

    /**
     * 删除客户
     * @param cusid
     */
    public void deleteCustomer(Integer cusid){
        customerDao.deleteById(cusid);
    }

    /**
     * 删除客户连带客户转移日志
     * @param cusid
     */
    public void deleteCustomer2(Integer cusid){
        TWCustomerMapperDao.deleteCustomer(cusid);
    }
    /**
     * 加载客户
     * @param cusid
     * @return
     */
    public Customer findCustomerById(Integer cusid){
        return customerDao.findById(cusid).get();
    }

    /**
     * 根据id加载客户
     * @param cusid
     * @return
     */
    public Customer findCustomer(Integer cusid){
        return TWCustomerMapperDao.findCustomerById(cusid);
    }

    /**
     * 根据名称加载客户
     * @param cusName
     * @return
     */
    public Customer findCustomerByName(String cusName){
        return TWCustomerMapperDao.findCustomerByName(cusName);
    }

    /**
     * 根据id查询客户详情（左）
     * @param cusId
     * @return
     */
    public Customer queryCustomerDetailsById(Integer cusId){
        return TWCustomerMapperDao.queryCustomerDetailsById(cusId);
    }
    /**
     * 根据id查询客户详情（全）
     * @param cusId
     * @return
     */
    public Customer findCustomerDetailsById(Integer cusId){
        return TWCustomerMapperDao.findCustomerDetailsById(cusId);
    }

    /**
     * 根据id查询客户详情（右）
     * @param cusId
     * @return
     */
    public Customer findCustomerDetailsById1(Integer cusId){
        return TWCustomerMapperDao.findCustomerDetailsById1(cusId);
    }
    public Customer findCustomerDetailsById2(Integer cusId){
        return TWCustomerMapperDao.findCustomerDetailsById2(cusId);
    }
    public Customer findCustomerDetailsById3(Integer cusId){
        return TWCustomerMapperDao.findCustomerDetailsById3(cusId);
    }
    public Customer findCustomerDetailsById4(Integer cusId){
        return TWCustomerMapperDao.findCustomerDetailsById4(cusId);
    }
    public Customer findCustomerDetailsById5(Integer cusId){
        return TWCustomerMapperDao.findCustomerDetailsById5(cusId);
    }
    public Customer findCustomerDetailsById6(Integer cusId){
        return TWCustomerMapperDao.findCustomerDetailsById6(cusId);
    }
    public Customer findCustomerDetailsById7(Integer cusId){
        return TWCustomerMapperDao.findCustomerDetailsById7(cusId);
    }
    public Customer findCustomerDetailsById8(Integer cusId){
        return TWCustomerMapperDao.findCustomerDetailsById8(cusId);
    }

    /**
     * 分页查询所有客户
     * @return
     */
    public Pager<Customer> queryAllCustomers(Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customer> list= TWCustomerMapperDao.queryAllCustomer();
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 查询所有客户
     * @return
     */
    public List<Customer> queryAllCustomers2(){
        List<Customer> list= TWCustomerMapperDao.queryAllCustomer();
        return list;
    }

    /**
     * 排序
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customer> queryAllCustomerByIdASC(String prop,String order, Integer curpage,Integer pagesize){
        List<Customer> list=null;
        PageHelper.startPage(curpage,pagesize);
        if (prop.equals("cusId")&&order.equals("ascending")){
            list= TWCustomerMapperDao.queryAllCustomerByIdASC();
        }else if (prop.equals("cusId")&&order.equals("descending")){
            list= TWCustomerMapperDao.queryAllCustomer();
        }else if (prop.equals("cusUpdateTime")&&order.equals("ascending")){
            list= TWCustomerMapperDao.queryAllCustomerBycusUpdateTimeASC();
        }else if (prop.equals("cusUpdateTime")&&order.equals("descending")){
            list= TWCustomerMapperDao.queryAllCustomerBycusUpdateTimeDESC();
        }
        else {
            list= TWCustomerMapperDao.queryAllCustomer();
        }
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 高级查询客户
     * @param advancedQueryCustomerData
     * @return
     */
    public Pager<Customer> queryCustomerSenior(AdvancedQueryCustomerData advancedQueryCustomerData){
        PageHelper.startPage(advancedQueryCustomerData.getCurpage(),advancedQueryCustomerData.getPagesize());
        List<Customer> list= TWCustomerMapperDao.queryCustomerSenior(advancedQueryCustomerData);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }
    /**
     * 根据id查询客户
     * @param id
     * @return
     */
    public Pager<Customer> queryCustomerById(Integer id,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customer> list= TWCustomerMapperDao.queryCustomerById(id);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据名称模糊查询客户
     * @param name
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customer> queryCustomerByName(String name,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customer> list= TWCustomerMapperDao.queryCustomerByName(name);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据数据查询客户
     * @param value
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Customer> queryCustomerByShuJu(String value,Integer curpage,Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customer> list=null;
        if (value.equals("一周内")){
            list= TWCustomerMapperDao.queryCustomerBy1();
        }else if (value.equals("一个月内")){
            list= TWCustomerMapperDao.queryCustomerBy2();
        }else if (value.equals("一年内")){
            list= TWCustomerMapperDao.queryCustomerBy3();
        }else{
            list= TWCustomerMapperDao.queryCustomerBy4(value);
        }
        System.out.println(value);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 统计饼图数据
     * @param num
     * @return
     */
    public List<CountPie> countPie(Integer num){
        List<CountPie> list=null;
        if (num==1){
            list= TWCustomerMapperDao.countCusSourcePie();
        }else if (num==2){
            list= TWCustomerMapperDao.countCusCreditPie();
        }
        else if (num==3){
            list= TWCustomerMapperDao.countCusGradingPie();
        }
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName()==null||list.get(i).getName().equals("")){
                list.remove(i);
            }
        }
        return list;
    }

    /**
     * 统计柱状图数据
     * @param num
     * @return
     */
    public CountBar countBar(Integer num){
        CountBar countBar=new CountBar();

            List<CountPie> list=this.countPie(num);
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
}
