package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Quote;
import com.zktr.crmproject.service.JrcQuoteService;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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



}
