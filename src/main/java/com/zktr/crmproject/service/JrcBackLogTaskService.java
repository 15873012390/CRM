package com.zktr.crmproject.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcBackLogTaskDetailsJDao;
import com.zktr.crmproject.dao.jpa.JrcBackLogTaskJDao;
import com.zktr.crmproject.dao.mybatis.JrcBackLogTaskDetailsMDao;
import com.zktr.crmproject.dao.mybatis.JrcBackLogTaskMDao;
import com.zktr.crmproject.pojos.Backlogtask;
import com.zktr.crmproject.pojos.Backlogtaskdetails;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class JrcBackLogTaskService {
    @Autowired
    private JrcBackLogTaskJDao backLogTaskJDao;
    @Autowired
    private JrcBackLogTaskMDao backLogTaskMDao;
    @Autowired
    private JrcBackLogTaskDetailsJDao backLogTaskDetailsJDao;
    @Autowired
    private JrcBackLogTaskDetailsMDao backLogTaskDetailsMDao;
    @Autowired
    private JrcCustomerAndUserService customerAndUserService;
    /**
     * 刷新待办任务
     * @param cusId
     * @return
     */
    public List<Backlogtask> pushBackLogTask(Integer cusId){
        return backLogTaskMDao.queryBackLogTaskByCusId(cusId);
    }

    /**
     * 添加任务表和任务详情表
     * @param backLogTaskVo
     * @return
     */
    public Result AddBackLogTaskAndDetail(BackLogTaskVo backLogTaskVo){
        Backlogtask b1=new Backlogtask();
        b1=backLogTaskMDao.queryBackLogTaskByBltId(backLogTaskVo.getBltId());

        Backlogtask b2=new Backlogtask();
        b2.setBltDescription(backLogTaskVo.getBltDescription());
        b2.setFinishDate(backLogTaskVo.getFinishDate());
        b2.setFinishTime(backLogTaskVo.getFinishTime());
        b2.setPrecedence(backLogTaskVo.getPrecedence());
        b2.setConName(backLogTaskVo.getConName());
        b2.setStatus(backLogTaskVo.getStatus());
        b2.setDelStatus(1);
        //判断详情id为不为空
        if(b1!=null){
            b2.setBltId(backLogTaskVo.getBltId());
            b2.setUser(b1.getUser());
            b2.setCustomer(b1.getCustomer());
            b2.setCreationTime(b1.getCreationTime());
            List<Backlogtaskdetails> bd2=backLogTaskDetailsMDao.queryBackLogTaskUserBybltId(b1.getBltId());
            System.out.println(bd2.size());
            for(int i=0;i<bd2.size();i++){
                backLogTaskDetailsJDao.delete(bd2.get(i));
            }

        }else{
            b2.setCreationTime(new Timestamp(new Date().getTime()));
            //创建人目前是1号员工 有了session改session里当前登录的员工
            User user = customerAndUserService.queryByUid(1);
            b2.setUser(user);
            //客户
            Customer customer =customerAndUserService.queryContactByCusId(backLogTaskVo.getCusId());
            b2.setCustomer(customer);
        }
        //保存待办任务
        backLogTaskJDao.save(b2);

        //保存待办任务详情记录
        System.out.println(backLogTaskVo.getUserList().size());
        for(int i=0;i<backLogTaskVo.getUserList().size();i++){
            Backlogtaskdetails bd1=new Backlogtaskdetails();
            User u=backLogTaskVo.getUserList().get(i);
            User user1=customerAndUserService.queryByUid(u.getuId());
            if(user1!=null){
                bd1.setStatus(1);//待办任务详情状态默认为未完成  完成时间默认为空
                bd1.setUser(user1);
                bd1.setBacklogtask(b2);
                backLogTaskDetailsJDao.save(bd1);
            }
        }
        return Result.SUCCESS;
    }

    /**
     * 根据任务id找任务详情
     * @param bltid
     * @return
     */
    public Map queryBackLogTaskByBltId(Integer bltid){
        Map map=new HashMap();
        List<Backlogtaskdetails> backlogtaskdetailslist=backLogTaskDetailsMDao.queryBackLogTaskUserBybltId(bltid);
        Backlogtask backlogtask=backLogTaskMDao.queryBackLogTaskByBltId(bltid);
        map.put("backlogtaskdetailslist",backlogtaskdetailslist);
        map.put("backlogtask",backlogtask);
        return map;
    }

    /**
     * 根据待办任务id修改状态
     * @param bltid
     * @return
     */
    public Result finishBackTaskEditDetails(Integer bltid){
        Backlogtask backlogtask=backLogTaskMDao.delBackLogQuery(bltid);
        backlogtask.setStatus(2);
        backLogTaskJDao.save(backlogtask);
        return Result.SUCCESS;
    }

    /**
     * 根据待办任务id删除
     * @param bltid
     * @return
     */
    public Result delBackLogTaskByBltId(Integer bltid){
        Backlogtask backlogtask=backLogTaskMDao.delBackLogQuery(bltid);
        backlogtask.setDelStatus(2);
        backLogTaskJDao.save(backlogtask);
        return Result.SUCCESS;
    }

    /**
     * 批量删除待办任务id
     * @param bltIds
     * @return
     */
    public Result delBackLogTaskByBltIdAll(Integer[] bltIds){
        Backlogtask backlogtask=new Backlogtask();
        for(Integer i:bltIds){
            backlogtask=backLogTaskMDao.delBackLogQuery(i);
            backlogtask.setDelStatus(2);
            backLogTaskJDao.save(backlogtask);
        }
        return Result.SUCCESS;
    }
    /**
     * 查看全部
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager queryAllByPage(int curpage, int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Backlogtask> list=backLogTaskMDao.queryAllByPage();
        PageInfo<Backlogtask> pager=new PageInfo<>(list);
        return new Pager<Backlogtask>(pager.getTotal(),pager.getList());
    }

    /**
     * 模糊搜索
     * @param curpage
     * @param pagesize
     * @param value
     * @param input
     * @param select
     * @return
     */
    public Pager queryLikeBackTaskLog(int curpage,int pagesize,String value,String input,String select){
        PageHelper.startPage(curpage,pagesize);
        String inputs="";
        if(null!=input && !"".equals(input)){
            inputs = "%"+input.replaceAll("^[　*| *| *|//s*]*", "").replaceAll("[　*| *| *|//s*]*$", "")+"%";
        }
        List<Backlogtask> list=backLogTaskMDao.queryLikeBackTaskLog(value,inputs,select);
        PageInfo<Backlogtask> pager=new PageInfo<>(list);
        return new Pager<Backlogtask>(pager.getTotal(),pager.getList());
    }

    /**
     * 高级搜索
     * @param backLogTaskAdvancedSearch
     * @return
     */
    public Pager queryAdvendceBackTaskLog(JrcBackLogTaskAdvancedSearch backLogTaskAdvancedSearch){
        if(null!=backLogTaskAdvancedSearch.getThem() && !"".equals(backLogTaskAdvancedSearch.getThem())){
            backLogTaskAdvancedSearch.setThem("%"+backLogTaskAdvancedSearch.getThem().replaceAll("^[　*| *| *|//s*]*", "").replaceAll("[　*| *| *|//s*]*$", "")+"%");
        }
        PageHelper.startPage(backLogTaskAdvancedSearch.getCurPage(),backLogTaskAdvancedSearch.getPageSize());
        List<Backlogtask> list=backLogTaskMDao.queryAdvendceBackTaskLog(backLogTaskAdvancedSearch);
        PageInfo<Backlogtask> pager=new PageInfo<>(list);
        return new Pager<Backlogtask>(pager.getTotal(),pager.getList());
    }

    /**
     * 查看所有客户列表
     * @return
     */
    public List<Customer> queryAllCustomer(){
        return customerAndUserService.queryAllCustomer();
    }

    /**
     * 根据一个客户id找到对象的客户联系人
     * @param cusid
     * @return
     */
    public Customer queryAllContactByCusid(Integer cusid){
        return customerAndUserService.queryContactByCusId(cusid);
    }

    /**
     * 导入
     * @param outBackLogTaskVos
     * @return
     * 根据客户和客户联系人查找一个对象 判断对象为空就是不合格数据
     * 再判断执行人为不为空为空就是不合格数据
     * 主题为空也是不合格数据
     * 输入的优先级不是高也不是低也是不合格数据
     * 状态不是未结束，已结束，意外取消也是不合格数据
     */
    public Map outBackLogTask(List<OutBackLogTaskVo> outBackLogTaskVos){
        boolean qualifi=true;
        int numer=0;
        List<BackLogTaskVo> qualifiBackLogTaskVo=new ArrayList<>();
       for(OutBackLogTaskVo o:outBackLogTaskVos){
            qualifi=true;
            BackLogTaskVo b=new BackLogTaskVo();
            while (qualifi){
                if((o.getCusName()==null||o.getCusName().length()<=0)||(o.getUserList()== null ||o.getUserList().length() <= 0)||
                   (o.getBltDescription()==null||o.getBltDescription().length()<=0)||(o.getPrecedence()==null||o.getPrecedence().length()<=0)||
                        (o.getPrecedence()==null||o.getPrecedence().length()<=0)||(o.getStatus()==null||o.getStatus().length()<=0)
                ){
                    qualifi=false;
                    numer++;
                    break;
               }else{
                    Customer customers=customerAndUserService.queryByCusNameAndConName(o.getCusName(),o.getConName());
                    System.out.println(customers!=null);
                    if(customers!=null){
                        b.setCusId(customers.getCusId());
                        b.setConName(o.getConName());
                    }else{
                        qualifi=false;
                        numer++;
                        break;
                    }
                    List<String> users=new ArrayList<>();
                    if(o.getUserList().indexOf(",")!=-1){
                        users=Arrays.asList(o.getUserList().split(","));
                    }else{
                        users.add(o.getUserList());
                    }
                    List<User> users1=new ArrayList<>();
                    for(String s:users){
                        List<User> list=customerAndUserService.queryByUserName(s);
                        if (list.size() == 0) {
                            numer++;
                            qualifi = false;
                            break;
                        } else {
                            users1.add(list.get(0));
                        }
                    }
                    b.setUserList(users1);
                    b.setBltDescription(o.getBltDescription());
                    b.setFinishDate(o.getFinishDate());
                    b.setFinishTime(o.getFinishTime());
                    if(o.getPrecedence().equals("低")){
                        b.setPrecedence(1);
                    }else if(o.getPrecedence().equals("高")){
                        b.setPrecedence(2);
                    }else{
                        qualifi=false;
                        numer++;
                        break;
                    }
                    if(o.getStatus().equals("未结束")){
                        b.setStatus(1);
                    }else if(o.getStatus().equals("已结束")){
                        b.setStatus(2);
                    }else if(o.getStatus().equals("意外终止")){
                        b.setStatus(3);
                    }else{
                        qualifi=false;
                        numer++;
                        break;
                    }
                    qualifiBackLogTaskVo.add(b);
                    break;
                }
             }

        }
        Map map=new HashMap();

        if(qualifiBackLogTaskVo.size()==0){
            map.put("success",outBackLogTaskVos.size()+"条数据均不合格数据，未导入");
        }else{
            for(BackLogTaskVo vo:qualifiBackLogTaskVo){
                AddBackLogTaskAndDetail(vo);
            }
            map.put("success","成功导入了"+(outBackLogTaskVos.size()-numer)+"条数据"+numer+"不合格数据未导入");
        }
        return map;
    }

    public List<Backlogtask> queryCurMonth(Date startStr,Date end){
        return backLogTaskMDao.queryCurMoth(startStr,end);
    }
}
