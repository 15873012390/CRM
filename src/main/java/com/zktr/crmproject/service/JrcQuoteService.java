package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcAuditDao;
import com.zktr.crmproject.dao.jpa.JrcQuoteJDao;
import com.zktr.crmproject.dao.mybatis.JrcQuoteMDao;
import com.zktr.crmproject.pojos.Audit;
import com.zktr.crmproject.pojos.Quote;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class JrcQuoteService {
    @Autowired
    private JrcQuoteJDao quoteJDao;
    @Autowired
    private JrcQuoteMDao quoteMDao;
    @Autowired
    private JrcAuditDao auditDao;


    /**
     * 添加报价记录
     * @param quote
     * @return
     */
    public Result addQuote(Quote quote){
        Audit audit=new Audit();
        audit.setAudTheme(quote.getQuoTheme());
        audit.setAudType(2);
        audit.setDelStatus(1);
        auditDao.save(audit);
        quote.setAudit(audit);
        quoteJDao.save(quote);
        return Result.SUCCESS;
    }

    /**
     * 分页查看全部
     * @param curpage
     * @param pageSize
     * @return
     */
    public Pager queryAllByPage(Integer curpage,Integer pageSize){
        PageHelper.startPage(curpage,pageSize);
        List<Quote> list=quoteMDao.queryAllByPage();
        PageInfo<Quote>  quotePageInfo=new PageInfo<>(list);
        return new Pager(quotePageInfo.getTotal(),quotePageInfo.getList());
    }


}
