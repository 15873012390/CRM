package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Returnedmoney;
import com.zktr.crmproject.service.PLReturnedMoneyService;
import com.zktr.crmproject.vo.PLRemAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/REM")
public class PLReturnedMoneyController {
    @Autowired
    private PLReturnedMoneyService returnedMoneyService;

    @PostMapping("/insertREM")
    public Result insertREM(@RequestBody Returnedmoney returnedmoney){
        returnedMoneyService.insertREM(returnedmoney);
        return Result.SUCCESS;
    }
    @DeleteMapping("/deleteByremId")
    public Result deleteByremId(Integer remid){
        returnedMoneyService.deleteByremId(remid);
        return Result.SUCCESS;
    }
    @PostMapping("/batchByremId")
    public Result batchByremId(@RequestBody Integer[] remids){
        returnedMoneyService.batchByremId(remids);
        return Result.SUCCESS;
    }

    @GetMapping("/findByid")
    public Returnedmoney findByid(Integer remid){
        return returnedMoneyService.findByid(remid);
    }
    @GetMapping("/findAllByRM")
    public Pager<Returnedmoney> findAllByRM(int curpage, int pagesize){
        return returnedMoneyService.findAllByRM(curpage,pagesize);
    }
    @GetMapping("/statisticsByMoney")
    public List<Map> statisticsByMoney(){
        return returnedMoneyService.statisticsByMoney();
    }

    @GetMapping("/queryByLikeQuery")
    public Pager<Returnedmoney> queryByLikeQuery(int curpage,int pagesize,String select,String input,String value){
        return returnedMoneyService.queryByLikeQuery(curpage,pagesize,select,input,value);
    }
    @PostMapping("/REMAdvancedSearch")
    public Pager<Returnedmoney> REMAdvancedSearch(@RequestBody PLRemAdvancedSearch remAdvancedSearch){
        return returnedMoneyService.REMAdvancedSearch(remAdvancedSearch);
    }
}
