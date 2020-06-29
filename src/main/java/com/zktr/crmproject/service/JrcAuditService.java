package com.zktr.crmproject.service;
import com.zktr.crmproject.dao.jpa.JrcAuditDetailsJDao;
import com.zktr.crmproject.dao.jpa.JrcAuditJDao;
import com.zktr.crmproject.dao.jpa.JrcQuoteJDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.Audit;
import com.zktr.crmproject.pojos.Auditdetails;
import com.zktr.crmproject.pojos.Quote;
import com.zktr.crmproject.pojos.User;
import com.zktr.crmproject.vo.JrcAdvancedAuditSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class JrcAuditService {
    @Autowired
    private JrcAuditMDao auditMDao;
    @Autowired
    private JrcQuoteMDao quoteMDao;
    @Autowired
    private JrcAuditDetailsMDao auditDetailsMDao;
    @Autowired
    private JrcAuditJDao auditJDao;
    @Autowired
    private JrcQuoteJDao quoteJDao;
    @Autowired
    private JrcAuditDetailsJDao auditDetailsJDao;
    @Autowired
    private JrcUserMDao userMDao;
    /**
     * 分页查看所有
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Audit> queryAllAudit(Integer curpage,Integer pagesize){
        List<Audit> list=auditMDao.queryAllAudit();
        List list1=new ArrayList();
        for(int i=0;i<pagesize;i++){
            int index=(curpage-1)*pagesize+i;
            if(index<list.size()){
                if(list.get(index)!=null){
                    list1.add(list.get(index));
                }
            }
        }
        return new Pager<Audit>(list.size(),list1);

    }

    /**
     * 模糊搜索
     * @param curpage
     * @param pagesize
     * @param value
     * @param input
     * @param uId
     * @return
     */
    public  Pager<Audit>  queryLikeAudit(Integer curpage,Integer pagesize,String value,String input,Integer uId){
        String[] date=input.trim().split("-");
        String inputs="";
        int iftrue=1;
        if(input.trim()==""){
            inputs=input.trim();
        }else{
            if(date.length==1){
                inputs="%"+date[0]+"%";
                iftrue=1;
            }else if(date.length==2){
                date[1]=date[1].length()==1?"0"+ date[1]:date[1];
                inputs="%"+date[0]+"-"+date[1]+"%";
                iftrue=1;
            }else if(date.length==3){
                 date[1]=date[1].length()==1?"0"+ date[1]:date[1];
                 date[2]=date[2].length()==1?"0"+ date[2]:date[2];
                 inputs=date[0]+"-"+date[1]+"-"+date[2];
                 iftrue=2;
            }
        }
        List<Audit> list=auditMDao.queryLikeAudit(value,inputs,uId,iftrue);
        List list1=new ArrayList();
        for(int i=0;i<pagesize;i++){
            int index=(curpage-1)*pagesize+i;
            if(index<list.size()){
                if(list.get(index)!=null){
                    list1.add(list.get(index));
                }
            }
        }
        return new Pager<Audit>(list.size(),list1);

    }

    /**
     * 高级搜索
     * @param advancedAuditSearch
     * @return
     */
    public Pager<Audit> queryAdvanceAudit(JrcAdvancedAuditSearch advancedAuditSearch){
        if(advancedAuditSearch.getCreateDate()!=null&&advancedAuditSearch.getCreateDate().length>0){
            advancedAuditSearch.setCreateStart(advancedAuditSearch.getCreateDate()[0]);
            advancedAuditSearch.setCreateEnd(advancedAuditSearch.getCreateDate()[1]);
        }
        List<Audit> list=auditMDao.queryAdvanceAudit(advancedAuditSearch);
        List list1=new ArrayList();
        for(int i=0;i<advancedAuditSearch.getPageSize();i++){
            int index=(advancedAuditSearch.getCurPage()-1)*advancedAuditSearch.getPageSize()+i;
            if(index<list.size()){
                if(list.get(index)!=null){
                    list1.add(list.get(index));
                }
            }
        }
        return new Pager<Audit>(list.size(),list1);

    }

    /**
     * 根据审核id查询
     * @param audId
     * @return
     */
    public Audit queryAllAuditAndAuditDetails(Integer audId){
        return auditMDao.queryAllAuditAndAuditDetails(audId);
    }

    /**
     * 审批报价申请
     * @param audId
     * @param suggest
     * @param opreation
     * @param uId
     * @return
     */
    public Result suggestAudit(Integer audId, String suggest, Integer opreation, Integer uId){
        Audit audit=auditMDao.queryAllAuditAndAuditDetails(audId);

        if(audId!=null){
            Quote quote=quoteMDao.queryQuoteByAudId(audId);
            Auditdetails auditdetails=auditDetailsMDao.queryAuditDetailsByAudid(audId);
            if(opreation==1){
                //审核表状态修改为 3同意
                audit.setAudStatus(3);
                //报价表状态修改为 4 审核完成
                quote.setAuditStatus(4);
                quote.setAudit(audit);
                //审核详情表
                auditdetails.setAdTime(new Timestamp(System.currentTimeMillis()));
                auditdetails.setAdOpinion(suggest);
                auditdetails.setAdOperation(opreation);
            }else if(opreation==2){
                //审核表状态修改为 2 审核中
                audit.setAudStatus(2);
                //报价表 状态修改为 3 审核中
                quote.setAuditStatus(3);
                quote.setAudit(audit);
                //审核详情表
                auditdetails.setAdTime(new Timestamp(System.currentTimeMillis()));
                auditdetails.setAdOpinion(suggest);
                auditdetails.setAdOperation(opreation);
                //再添加一条新的审核详情表记录
                Auditdetails newa=new Auditdetails();
                User u=userMDao.queryByUid(uId);
                newa.setAdOperation(0);
                newa.setAudit(audit);
                newa.setUser(u);
                auditDetailsJDao.save(newa);
            }else if(opreation==3){
                //审核表状态修改为 4否决
                audit.setAudStatus(4);
                if(quote!=null){
                    //报价表状态修改为 4 审核完成
                    quote.setAuditStatus(4);
                    quote.setAudit(audit);
                }
                //审核详情表
                auditdetails.setAdTime(new Timestamp(System.currentTimeMillis()));
                auditdetails.setAdOpinion(suggest);
                auditdetails.setAdOperation(opreation);
            }
            auditJDao.save(audit);
            if(quote!=null){
                quoteJDao.save(quote);
            }
            auditDetailsJDao.save(auditdetails);
            return Result.SUCCESS;
        }else{
            return Result.FAILURE;
        }

    }


    public Result deleteAuditAndAudit(Integer audId){
        List<Auditdetails> auditdetails=auditDetailsMDao.queryAuditListByAudId(audId);
        if(auditdetails.size()>0){
            //先删除审核详情
            auditDetailsMDao.deleteAuditByAudId(audId);
        }
        //再删除审核
        auditMDao.deleteAuditByAudId(audId);

        return Result.SUCCESS;
    }
}
