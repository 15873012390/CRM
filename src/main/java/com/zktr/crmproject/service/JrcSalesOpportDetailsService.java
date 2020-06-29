package com.zktr.crmproject.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcBackLogTaskDetailsJDao;
import com.zktr.crmproject.dao.jpa.JrcBackLogTaskJDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.BackLogTaskVo;
import com.zktr.crmproject.vo.JrcActionHistoryVo;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    private JrcCustomerMDao customerMDao;
    @Autowired
    private JrcBackLogTaskMDao backLogTaskMDao;
    @Autowired
    private JrcRepairMDao repairMDao;
    @Autowired
    private JrcBackLogTaskService backLogTaskService;
    /**
     * 查找销售机会的所有信息（竞争对手、需求分析、报价单、解决方案）
     * 客户的所有待办任务
     * @param soId
     * @return
     */
    public Map querySalesOpportAndCustomeDetails(Integer soId){
        Map map=new HashMap();
        Salesopport salesopport=salesOpportMDao.queryBySoid(soId);

        List<Clientdemand> clientdemands=clientdemandMDao.queryClientdemandBySoid(soId);
        List<Quote> quotes=quoteMDao.queryQuoteBySoid(soId);
        List<Solution> solutions=solutionMDao.querySolutionBySoid(soId);
        Customer customer=customerMDao.queryContactByCusid(salesopport.getCustomer().getCusId());

        Pager<Backlogtask> pager=backLogTaskService.queryAllBackLogTaskByCusId(salesopport.getCustomer().getCusId(),1,5);
        map.put("salesopport",salesopport);

        map.put("clientdemands",clientdemands);
        map.put("quotes",quotes);
        map.put("solutions",solutions);
        map.put("backlogtasks",pager);
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




}
