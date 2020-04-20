package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcQuoteJDao;
import com.zktr.crmproject.dao.jpa.JrcQuteDetailsJDao;
import com.zktr.crmproject.dao.mybatis.JrcQuoteDetailsMDao;
import com.zktr.crmproject.pojos.Quote;
import com.zktr.crmproject.pojos.Quotedetails;
import com.zktr.crmproject.vo.JrcQuoteDetailsAdvance;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import jdk.nashorn.internal.runtime.QuotedStringTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class JrcQuoteDetailsService {

    @Autowired
    private JrcQuoteDetailsMDao quoteDetailsMDao;
    @Autowired
    private JrcQuteDetailsJDao quteDetailsJDao;
    @Autowired
    private JrcQuoteJDao quoteJDao;

    public List<Quotedetails> queryQuoteDetailsByQuoId(Integer quoId){
       return quoteDetailsMDao.queryQuoteDetailsByQuoId(quoId);
    }


    public Result deleteByQdId(Integer qdId){
        quteDetailsJDao.deleteById(qdId);
        return Result.SUCCESS;
    }

    public Result saveQuoteDetails(List<Quotedetails> list){
        quteDetailsJDao.saveAll(list);
        BigDecimal sum=new BigDecimal(0);
        for(Quotedetails q:list){
            sum=sum.add(q.getMoney());
        }
        Quote quote=quoteJDao.findById(list.get(0).getQuote().getQuoId()).get();
        quote.setGrossProfit(quote.getTotalMoney().subtract(sum));
        quoteJDao.save(quote);
        return Result.SUCCESS;
    }

    //分页
    public Pager<Quotedetails> queryAllQuotedatils(Integer curpage, Integer pageSize){
        PageHelper.startPage(curpage,pageSize);
        List<Quotedetails> list=quoteDetailsMDao.queryAllByPage();
        PageInfo<Quotedetails> quotePageInfo=new PageInfo<>(list);
        return new Pager(quotePageInfo.getTotal(),quotePageInfo.getList());
    }

    /**
     * 模糊搜索
     * @param curpage
     * @param pagesize
     * @param input
     * @return
     */
    public Pager<Quotedetails> queryLikeQuotedetails(Integer curpage,Integer pagesize,String input){
        PageHelper.startPage(curpage,pagesize);
        String inputs=input.trim()==""?"":"%"+input.trim()+"%";
        List<Quotedetails> list=quoteDetailsMDao.queryLikeQuotedetails(inputs);
        PageInfo<Quotedetails> quotePageInfo=new PageInfo<>(list);
        return new Pager(quotePageInfo.getTotal(),quotePageInfo.getList());
    }

    public Pager<Quotedetails> queryAdvanceQuotedetails(JrcQuoteDetailsAdvance quoteDetailsAdvance){
        PageHelper.startPage(quoteDetailsAdvance.getCurPage(),quoteDetailsAdvance.getPageSize());

        List<Quotedetails> list=quoteDetailsMDao.queryAdvanceQuotedetails(quoteDetailsAdvance);
        PageInfo<Quotedetails> quotePageInfo=new PageInfo<>(list);
        return new Pager(quotePageInfo.getTotal(),quotePageInfo.getList());
    }

}
