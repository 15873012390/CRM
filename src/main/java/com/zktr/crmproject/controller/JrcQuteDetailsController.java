package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Quotedetails;
import com.zktr.crmproject.service.JrcQuoteDetailsService;
import com.zktr.crmproject.vo.JrcQuoteDetailsAdvance;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JrcQuteDetailsController {
    @Autowired
    private JrcQuoteDetailsService quoteDetailsService;
    @GetMapping("/query_quote_details_by_quoId")
    public List<Quotedetails> queryQuoteDetailsByQuoId(Integer quoId){
        return quoteDetailsService.queryQuoteDetailsByQuoId(quoId);
    }

    @DeleteMapping("/delete_by_qdId")
    public Result deleteByQdId(Integer qdId){
        return quoteDetailsService.deleteByQdId(qdId);
    }

    @PostMapping("/save_quote_details")
    public Result saveQuoteDetails(@RequestBody List<Quotedetails> list){
        return quoteDetailsService.saveQuoteDetails(list);
    }

    @GetMapping("/query_all_quotedatils")
    public Pager<Quotedetails> queryAllQuotedatils(Integer curPage, Integer pageSize){
        return quoteDetailsService.queryAllQuotedatils(curPage,pageSize);
    }

    @GetMapping("/query_like_quotedetails")
    public Pager<Quotedetails> queryLikeQuotedetails(Integer curpage,Integer pagesize,String input){
        return quoteDetailsService.queryLikeQuotedetails(curpage,pagesize,input);
    }

    @PostMapping("/query_advance_quotedetails")
    public Pager<Quotedetails> queryAdvanceQuotedetails(@RequestBody JrcQuoteDetailsAdvance quoteDetailsAdvance){
        return quoteDetailsService.queryAdvanceQuotedetails(quoteDetailsAdvance);
    }


}
