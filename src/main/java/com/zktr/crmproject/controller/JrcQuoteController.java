package com.zktr.crmproject.controller;

import com.github.pagehelper.Page;
import com.sun.org.apache.xpath.internal.operations.Quo;
import com.zktr.crmproject.pojos.Quote;
import com.zktr.crmproject.service.JrcQuoteService;
import com.zktr.crmproject.vo.JrcQuoteAdvancedQuery;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JrcQuoteController {
    @Autowired
    private JrcQuoteService quoteService;

    @PostMapping("/add_quote")
    @ResponseBody
    public Result addQuote(@RequestBody Quote quote){
        return quoteService.addQuote(quote);
    }

    @GetMapping("/query_all_by_page")
    @ResponseBody
    public Pager queryAllByPage(Integer curpage,Integer pagesize){
        return quoteService.queryAllByPage(curpage,pagesize);
    }

    @GetMapping("/query_all_by_like_page")
    @ResponseBody
    public Pager queryAllByLikePage(Integer curpage,Integer pagesize,String value,String input){
        return quoteService.queryAllByLikePage(curpage,pagesize,value,input);
    }

    @DeleteMapping("/delete_by_quoId")
    @ResponseBody
    public Result deleteByQuoId(Integer quoId){
        return quoteService.deleteByQuoId(quoId);
    }

    @PostMapping("/delete_by_quoIds")
    @ResponseBody
    public Result deleteByQuoIds(@RequestBody Integer[] quoIds){
        return quoteService.deleteByQuoIds(quoIds);
    }

    @GetMapping("/query_by_quoId")
    @ResponseBody
    public Quote queryByQuoId(Integer quoId){
        return quoteService.queryByQuoId(quoId);
    }

    @PostMapping("/query_quote_by_advanced_search")
    @ResponseBody
    public Pager queryQuoteByAdvancedSearch(@RequestBody JrcQuoteAdvancedQuery quoteAdvancedQuery){
        return quoteService.queryQuoteByAdvancedSearch(quoteAdvancedQuery);
    }

    @GetMapping("/save_copy_quote")
    @ResponseBody
    public Result saveCopyQuote(String quotationNo,Integer uId,Integer cusId){
        return quoteService.saveCopyQuote(quotationNo,uId,cusId);
    }

    @GetMapping("/flash_quote_bysoid")
    @ResponseBody
    public List<Quote> flashQuoteBysoid(Integer soId){
        return quoteService.flashQuoteBysoid(soId);
    }

}
