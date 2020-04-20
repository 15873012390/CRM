package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.jpa.*;
import com.zktr.crmproject.dao.mybatis.JrcAuditMDao;
import com.zktr.crmproject.dao.mybatis.JrcQuoteDetailsMDao;
import com.zktr.crmproject.dao.mybatis.JrcQuoteMDao;
import com.zktr.crmproject.dao.mybatis.JrcUserMDao;
import com.zktr.crmproject.pojos.Audit;
import com.zktr.crmproject.pojos.Auditdetails;
import com.zktr.crmproject.pojos.Quote;
import com.zktr.crmproject.vo.JrcAuditAndDetailsAdd;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

@Service
@Transactional(rollbackFor = Exception.class)
public class JrcAuditAndDetailsService {
    @Autowired
    private JrcAuditJDao auditJDao;
    @Autowired
    private JrcAuditDetailsJDao auditDetailsJDao;
    @Autowired
    private JrcQuoteJDao quoteJDao;
    @Autowired
    private JrcQuoteMDao quoteMDao;
    @Autowired
    private JrcUserMDao userMDao;

    public Result addAuditAndDetails(JrcAuditAndDetailsAdd aduitAndDetailsAdd){

        System.out.println(aduitAndDetailsAdd.getUser().toString());
        //添加审核表
        Audit audit=new Audit();
        audit.setAudTheme(aduitAndDetailsAdd.getAudTheme());//审批主题
        audit.setAudType(2);//1.出差 2.报价 3.采购
        audit.setAudTime(new Timestamp(new Date().getTime()));//申请时间
        audit.setAudStatus(1);//审批状态 1待审、2、审核中、3同意、4否决、5撤销审核
        audit.setDelStatus(1);//1.正常 2.删除
        audit.setUser(userMDao.queryByUid(aduitAndDetailsAdd.getuId()));//提交申请人
        auditJDao.save(audit);
        //添加审核详情表
        Auditdetails auditdetails=new Auditdetails();
        auditdetails.setAudit(audit);
        auditdetails.setUser(aduitAndDetailsAdd.getUser());
        auditDetailsJDao.save(auditdetails);

        //在报价表添加报价实体
        Quote quote=quoteMDao.queryByQuotId(aduitAndDetailsAdd.getQuoId());
        quote.setAudit(audit);
        quote.setAuditStatus(2);
        quoteJDao.save(quote);

        return Result.SUCCESS;
    }

}
