package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Returnedgoods;
import com.zktr.crmproject.pojos.Returnedmoney;
import com.zktr.crmproject.pojos.Returnedmoneyplan;
import com.zktr.crmproject.service.PLHomePageService;
import com.zktr.crmproject.vo.PLCountBar;
import com.zktr.crmproject.vo.PLCountPie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/PLHomePage")
public class PLHomePageController {
    @Autowired
    private PLHomePageService homePageService;

    @GetMapping("/statisticsHomePageRM")
    public List<Map> statisticsHomePageRM(Integer uId){
        return homePageService.statisticsHomePageRM(uId);
    }
    @GetMapping("/statisticsHomePageRMNum")
    public Map statisticsHomePageRMNum(Integer uId){
        return homePageService.statisticsHomePageRMNum(uId);
    }
    @GetMapping("/statisticsHomePageSO")
    public List<Map> statisticsHomePageSO(){
        return homePageService.statisticsHomePageSO();
    }
    @GetMapping("/statisticsHomePageSONum")
    public Map statisticsHomePageSONum(){
        return homePageService.statisticsHomePageSONum();
    }
    @GetMapping("/statisticsHomePageCon")
    public List<Map> statisticsHomePageCon(Integer uId){
        return homePageService.statisticsHomePageCon(uId);
    }
    @GetMapping("/statisticsHomePageConNum")
    public Map statisticsHomePageConNum(Integer uId){
        return homePageService.statisticsHomePageConNum(uId);
    }
    @GetMapping("/findAllRMPTop")
    public List<Returnedmoneyplan> findAllRMPTop(Integer uId){
        return homePageService.findAllRMPTop(uId);
    }
    @GetMapping("/findAllRMPTopNum")
    public Map findAllRMPTopNum(Integer uId){
        return homePageService.findAllRMPTopNum(uId);
    }
    @GetMapping("/statisticsHomePageRMState")
    public List<Map> statisticsHomePageRMState(){
        return homePageService.statisticsHomePageRMState();
    }
    @GetMapping("/statisticsHomePageRMStateNum")
    public Map statisticsHomePageRMStateNum(){
        return homePageService.statisticsHomePageRMStateNum();
    }
    @GetMapping("/statisticsHomePageRGWeek")
    public List<Map> statisticsHomePageRGWeek(Integer uId){
        return homePageService.statisticsHomePageRGWeek(uId);
    }
    @GetMapping("/statisticsHomePageRGWeekNum")
    public Map statisticsHomePageRGWeekNum(Integer uId){
        return homePageService.statisticsHomePageRGWeekNum(uId);
    }
    @GetMapping("/countLineMonthByDay")
    public PLCountBar countLineMonthByDay(){
        return homePageService.countLineMonthByDay();
    }
    @GetMapping("/CountLineTwo")
    public List<PLCountPie> CountLineTwo(){
        return homePageService.CountLineTwo();
    }
    @GetMapping("/CountLine")
    public List<PLCountPie> CountLine(){
        return homePageService.CountLine();
    }
    @GetMapping("/twoLine")
    public Map<String,Object> two(){
        return homePageService.two();
    }
    @GetMapping("/countPies")
    public List<PLCountPie> countPies(){
        return homePageService.countPies();
    }

}
