package com.zktr.crmproject.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zktr.crmproject.dao.jpa.JrcBackLogTaskDetailsJDao;
import com.zktr.crmproject.dao.jpa.JrcBackLogTaskJDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.BackLogTaskVo;
import com.zktr.crmproject.vo.JrcActionHistoryVo;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class JrcSalesOpportDetailsService {
    @Autowired
    private JrcSalesOpportMDao salesOpportMDao;
    @Autowired
    private JrcCompetitorMDao competitorMDao;
    @Autowired
    private JrcClientdemandMDao clientdemandMDao;
    @Autowired
    private JrcQuoteMDao quoteMDao;
    @Autowired
    private JrcSolutionMDao solutionMDao;
    @Autowired
    private JrcActionHistoryMDao actionHistoryMDao;
    @Autowired
    private JrcUserMDao userMDao;
    @Autowired
    private JrcCustomerMDao customerMDao;
    @Autowired
    private JrcBackLogTaskJDao backLogTaskJDao;
    @Autowired
    private JrcBackLogTaskMDao backLogTaskMDao;
    @Autowired
    private JrcBackLogTaskDetailsJDao backLogTaskDetailsJDao;
    @Autowired
    private JrcBackLogTaskDetailsMDao backLogTaskDetailsMDao;
    @Autowired
    private JrcRepairMDao repairMDao;
    @Autowired
    private JrcBackLogTaskService backLogTaskService;
    @Autowired
    private JrcActionHIstoryService actionHIstoryService;
    /**
     * 查找销售机会的所有信息（竞争对手、需求分析、报价单、解决方案）
     * 以及客户的所有待办任务、行动历史记录
     * @param soId
     * @param cusId
     * @return
     */
    public Map querySalesOpportAndCustomeDetails(Integer soId,Integer cusId){
        Map map=new HashMap();
        Salesopport salesopport=salesOpportMDao.queryBySoid(soId);
        List<Competitor> competitors=competitorMDao.queryComptitorBySoid(soId);
        List<Clientdemand> clientdemands=clientdemandMDao.queryClientdemandBySoid(soId);
        List<Quote> quotes=quoteMDao.queryQuoteBySoid(soId);
        List<Solution> solutions=solutionMDao.querySolutionBySoid(soId);
        List<Backlogtask> backlogtasks=backLogTaskMDao.queryBackLogTaskByCusId(cusId);
        List<Actionhistory> actionhistories=actionHistoryMDao.queryActionhistoryByCusId(cusId);
        Customer customer=customerMDao.queryContactByCusid(cusId);
        map.put("salesopport",salesopport);
        map.put("competitors",competitors);
        map.put("quotes",quotes);
        map.put("solutions",solutions);
        map.put("backlogtasks",backlogtasks);
        map.put("actionhistories",actionhistories);
        map.put("customer",customer);
        return map;
    }

    /**
     * 刷新销售机会数据
     * @param soId
     * @return
     */
    public Salesopport pushSalesOpport(Integer soId){
        return salesOpportMDao.queryBySoid(soId);
    }

    /**
     * 刷新待办任务
     * @param cusId
     * @return
     */
    public List<Backlogtask> pushBackLogTask(Integer cusId){
        return backLogTaskService.pushBackLogTask(cusId);
    }
    /**
     * 添加任务表和任务详情表
     * @param backLogTaskVo
     * @return
     */
    public Result AddBackLogTaskAndDetail(BackLogTaskVo backLogTaskVo){
        backLogTaskService.AddBackLogTaskAndDetail(backLogTaskVo);
        return Result.SUCCESS;
    }

    /**
     * 根据任务id找任务详情
     * @param bltid
     * @return
     */
    public Map queryBackLogTaskByBltId(Integer bltid){
       return backLogTaskService.queryBackLogTaskByBltId(bltid);
    }

    /**
     * 根据待办任务id修改状态
     * @param bltid
     * @return
     */
    public Result finishBackTaskEditDetails(Integer bltid){
        return backLogTaskService.finishBackTaskEditDetails(bltid);
    }

    /**
     * 根据待办任务id删除待办任务
     * @param bltid
     * @return
     */
    public Result delBackLogTaskByBltId(Integer bltid){
      return  backLogTaskService.delBackLogTaskByBltId(bltid);
    }

    /**
     * 查看所有的维修工单列表
     * @return
     */
    public List<Repair> queryRepairAllByCusId(Integer cusid){
        return repairMDao.queryRepairAllByCusId(cusid);
    }

    /**
     * 添加行动历史记录和行动历史详情记录
     * @param actionHistoryVo
     * @return
     */
    public Result addActionHistory(JrcActionHistoryVo actionHistoryVo){
        return actionHIstoryService.addActionHistory(actionHistoryVo);
    }

    /**
     * 根据行动历史id找行动历史记录以及详情记录
     * @param ahid
     * @return
     */
    public Actionhistory queryActionHistoryByAhid(Integer ahid){
        return actionHIstoryService.queryActionHistoryByAhid(ahid);
    }

    /**
     * 刷新行动历史记录
     * @param cusid
     * @return
     */
    public List<Actionhistory> queryAcitonHistoryByCusid(Integer cusid){
        return actionHIstoryService.queryAcitonHistoryByCusid(cusid);
    }

    /**
     * 删除行动历史记录
     * @param ahid
     * @return
     */
    public Result deleteActionHistoryByAhid(Integer ahid){
        return actionHIstoryService.deleteActionHistoryByAhid(ahid);
    }
}
