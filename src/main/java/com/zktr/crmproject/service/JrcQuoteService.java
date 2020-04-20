package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcQuoteJDao;
import com.zktr.crmproject.dao.jpa.JrcQuteDetailsJDao;
import com.zktr.crmproject.dao.mybatis.JrcCustomerMDao;
import com.zktr.crmproject.dao.mybatis.JrcQuoteDetailsMDao;
import com.zktr.crmproject.dao.mybatis.JrcQuoteMDao;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Quote;
import com.zktr.crmproject.pojos.Quotedetails;
import com.zktr.crmproject.vo.JrcQuoteAdvancedQuery;
import com.zktr.crmproject.vo.JrcUUID;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class JrcQuoteService {
    @Autowired
    private JrcQuoteJDao quoteJDao;
    @Autowired
    private JrcQuoteMDao quoteMDao;
    @Autowired
    private JrcQuoteDetailsMDao quoteDetailsMDao;
    @Autowired
    private JrcQuteDetailsJDao quteDetailsJDao;
    @Autowired
    private JrcCustomerMDao customerMDao;

    /**
     * 添加报价记录
     * @param quote
     * @return
     */
    public Result addQuote(Quote quote){
        if(quoteMDao.queryByQuotId(quote.getQuoId())==null){
            quote.setAudit(null);
            quote.setAuditStatus(1);
            quote.setQuotationNo(JrcUUID.getNewNo("Q"));
        }else{
            Quote q=quoteMDao.queryByQuotId(quote.getQuoId());
            if(quote.getAudit().getAudId()==0){
                quote.setAudit(null);
            }
            if(q.getTotalMoney().compareTo(quote.getTotalMoney())!=0){
                List<Quotedetails> list=quoteDetailsMDao.queryQuoteDetailsByQuoId(quote.getQuoId());
                BigDecimal sum=new BigDecimal(0);
                for(Quotedetails qs:list){
                    System.out.println(qs.toString());
                    sum=sum.add(qs.getMoney());
                }
                quote.setGrossProfit(list.size()==0?new BigDecimal(0):quote.getTotalMoney().subtract(sum));

            }

        }
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

    /**
     * 模糊分页搜索
     * @param curpage
     * @param pagesize
     * @param select
     * @param input
     * @return
     */
    public Pager queryAllByLikePage(Integer curpage,Integer pagesize,String select,String input){
        PageHelper.startPage(curpage,pagesize);
        String inputs=input.trim()==""?"":"%"+input.trim()+"%";
        List<Quote> list=quoteMDao.queryAllByLikePage(select,inputs);
        PageInfo<Quote>  quotePageInfo=new PageInfo<>(list);
        return new Pager(quotePageInfo.getTotal(),quotePageInfo.getList());
    }

    /**
     * 根据id删除
     * @param quoId
     * @return
     */
    public Result deleteByQuoId(Integer quoId){
        quoteJDao.deleteById(quoId);
        List<Quotedetails> list=quoteDetailsMDao.queryQuoteDetailsByQuoId(quoId);
        quteDetailsJDao.deleteAll(list);
        return Result.SUCCESS;
    }

    /**
     * 批量删除
     * @param quoIds
     * @return
     */
    public Result deleteByQuoIds(Integer[] quoIds){
        for(Integer i:quoIds){
            quoteJDao.deleteById(i);
            List<Quotedetails> list=quoteDetailsMDao.queryQuoteDetailsByQuoId(i);
            quteDetailsJDao.deleteAll(list);
        }
        return Result.SUCCESS;
    }

    /**
     * 根据id查询
     * @param quoId
     * @return
     */
    public Quote queryByQuoId(Integer quoId){
        return quoteMDao.queryByQuotId(quoId);
    }

    /**
     * 高级搜索
     * @param quoteAdvancedQuery
     * @return
     */
    public Pager queryQuoteByAdvancedSearch(JrcQuoteAdvancedQuery quoteAdvancedQuery){
        PageHelper.startPage(quoteAdvancedQuery.getCurPage(),quoteAdvancedQuery.getPageSize());
        quoteAdvancedQuery.setQuoTheme(quoteAdvancedQuery.getQuoTheme().trim()==""?"":"%"+quoteAdvancedQuery.getQuoTheme().trim()+"%");
        quoteAdvancedQuery.setQuotationNo(quoteAdvancedQuery.getQuotationNo().trim()==""?"":"%"+quoteAdvancedQuery.getQuotationNo().trim()+"%");

        List<Quote> list= quoteMDao.queryQuoteByAdvancedSearch(quoteAdvancedQuery);
        PageInfo<Quote> pageInfo=new PageInfo<>(list);
        return new Pager(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 复制报价单
     * @param quotationNo
     * @param cusId
     * @return
     */
    public Result saveCopyQuote(String quotationNo,Integer uId,Integer cusId){
        List<Quote> list=quoteMDao.copyQuote(quotationNo.trim());
        if(list.size()>0){
            Quote quote=list.get(0);
            quote.setQuoId(0);
            quote.setQuotationNo(JrcUUID.getNewNo("Q"));
            Customer customer=customerMDao.queryContactByCusid(cusId);
            quote.setCustomer(customer);
            quote.setCreatedId(uId);//创建人
            quote.setToOrder(2);
            quote.setAuditStatus(1);
            quote.setInstructions("");
            quote.setRemarks("");
            quote.setQuoDate(new Timestamp(System.currentTimeMillis()));
            quote.setSalesopport(null);
            quote.setAudit(null);
            quoteJDao.save(quote);
            //添加报价详情
            List<Quotedetails> list1= quote.getQuotedetails();
            for(Quotedetails q:list1){
                q.setQuote(quote);
                quteDetailsJDao.save(q);
            }
            return Result.SUCCESS;
        }else{
            return Result.FAILURE;
        }
    }
}
