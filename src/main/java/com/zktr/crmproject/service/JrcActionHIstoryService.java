package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.jpa.JrcActionHistoryDetailJDao;
import com.zktr.crmproject.dao.jpa.JrcActionHistoryJDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.JrcActionHistoryVo;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class JrcActionHIstoryService {
    @Autowired
    private JrcActionHistoryMDao actionHistoryMDao;
    @Autowired
    private JrcActionHistoryJDao actionHistoryJDao;
    @Autowired
    private JrcCustomerMDao customerMDao;
    @Autowired
    private JrcUserMDao userMDao;
    @Autowired
    private JrcActionHistoryDetailJDao actionHistoryDetailJDao;
    @Autowired
    private JrcActionHistoryDetailMDao actionHistoryDetailMDao;
    @Autowired
    private JrcRepairMDao repairMDao;

    public Result addActionHistory(JrcActionHistoryVo actionHistoryVo){
        Actionhistory actionhistory=new Actionhistory();
        Actionhistory b=actionHistoryMDao.queryActionHistoryByAhid(actionHistoryVo.getAhId());
        actionhistory.setActDescribe(actionHistoryVo.getActDescribe());
        actionhistory.setAction(actionHistoryVo.getAction());
        actionhistory.setConName(actionHistoryVo.getConName());
        actionhistory.setActDate(new Timestamp(actionHistoryVo.getActDate().getTime()));
        actionhistory.setDelStatus(1);
        //维修工单对象
        Repair repair=repairMDao.queryByRepairId(actionHistoryVo.getRepair().getRepairId());
        if(repair!=null){
            actionhistory.setRepair(repair);
        }
        if(b!=null){
            //编辑
            actionhistory.setCustomer(b.getCustomer());
            actionhistory.setUser(b.getUser());
            actionhistory.setAhId(b.getAhId());
            //找到所有的行动历史详情
            List<Actionhistorydetails> actionhistorydetailsList=actionHistoryDetailMDao.queryActionHistoryDetailsByAhid(b.getAhId());
            //先删除所有的行动历史记录 再添加
            for(int i=0;i<actionhistorydetailsList.size();i++){
                actionHistoryDetailJDao.delete(actionhistorydetailsList.get(i));
            }
        }else{
            //新增  行动历史记录数据
            Customer customer=customerMDao.queryContactByCusid(actionHistoryVo.getCusId());
            actionhistory.setCustomer(customer);
            //创建人目前是1号员工 有了session改session里当前登录的员工
            User user = userMDao.queryByUid(1);
            actionhistory.setUser(user);
            //查找最上面的一条数据
            /*报错再查找所有的行动历史记录找到最上面那一条*/
        }
        actionHistoryJDao.save(actionhistory);
        //添加行动历史记录
        for(int i=0;i<actionHistoryVo.getUserList().size();i++){
            Actionhistorydetails actionhistorydetails=new Actionhistorydetails();
            User u=userMDao.queryByUid(actionHistoryVo.getUserList().get(i).getuId());
            if (u!= null) {
                actionhistorydetails.setUser(u);
                actionhistorydetails.setActionhistory(actionhistory);
                actionHistoryDetailJDao.save(actionhistorydetails);
            }
        }
        return Result.SUCCESS;
    }

    /**
     * 根据行动历史记录id找行动历史记录及详情
     * @param ahid
     * @return
     */
    public Actionhistory queryActionHistoryByAhid(Integer ahid){
        return actionHistoryMDao.queryActionHistoryByAhid(ahid);
    }

    /**
     * 刷新行动历史记录
     * @param cusid
     * @return
     */
    public List<Actionhistory> queryAcitonHistoryByCusid(Integer cusid){
        return actionHistoryMDao.queryActionhistoryByCusId(cusid);
    }

    /**
     * 删除行动历史记录
     * @param ahid
     * @return
     */
    public Result deleteActionHistoryByAhid(Integer ahid){
        Actionhistory a=actionHistoryMDao.queryActionHistoryByAhid(ahid);
        a.setDelStatus(2);
        actionHistoryJDao.save(a);
        return Result.SUCCESS;
    }


}
