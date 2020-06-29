package com.zktr.crmproject.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zktr.crmproject.pojos.Orders;
import com.zktr.crmproject.pojos.Returnedmoneyplan;
import com.zktr.crmproject.service.PLReturnedMoneyPlanService;
import com.zktr.crmproject.vo.PLRmpAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rmp")
public class PLReturnedMoneyPlanController {
   @Autowired
    private PLReturnedMoneyPlanService returnedMoneyPlanService;

    @PostMapping("/savaRMP")
    public Result saveRMP(@RequestBody Returnedmoneyplan returnedmoneyplan){
        returnedMoneyPlanService.saveRMP(returnedmoneyplan);
        return Result.SUCCESS;
    }

    @PostMapping("/insertRMP")
    public Result insertRMP(@RequestBody Returnedmoneyplan returnedmoneyplan){
        returnedMoneyPlanService.insertRMP(returnedmoneyplan);
        return Result.SUCCESS;
    }
    @GetMapping("/findByRmpId")
    public Returnedmoneyplan findByRmpId(Integer rmpid){
        return returnedMoneyPlanService.findByRmpId(rmpid);
    }
    @DeleteMapping("/deleteRmpId")
    public Result deleteRmpId(Integer rmpid){
        returnedMoneyPlanService.deleteRmpId(rmpid);
        return Result.SUCCESS;
    }
    @PostMapping("/batchRmpid")
    public Result batchRmpid(@RequestBody Integer [] rmpids){
        returnedMoneyPlanService.batchRmpid(rmpids);
        return Result.SUCCESS;
    }
    @GetMapping("/queryAllOrdersByRM")
    public List<Orders> queryAllOrdersByRM(){
        return returnedMoneyPlanService.queryAllOrdersByRM();
    }
    @GetMapping("/findAllRMP")
    public Pager findAllRMP(int curpage,int pagesize){
        return returnedMoneyPlanService.findAllRMP(curpage,pagesize);
    }
    @GetMapping("/OqueryByOrdersidByRM")
    public Orders OqueryByOrdersidByRM(Integer ordid){
        return returnedMoneyPlanService.OqueryByOrdersidByRM(ordid);
    }
    @GetMapping("/queryByLikeQuery")
    public Pager<Returnedmoneyplan> queryByLikeQuery(int curpage,int pagesize,String select,String input,String value){
        return returnedMoneyPlanService.queryByLikeQuery(curpage,pagesize,select,input,value);
    }
    @GetMapping("/statisticsByMoney")
    public List<Map> statisticsByMoney(){
        return returnedMoneyPlanService.statisticsByMoney();
    }
    @PostMapping("/RMPAdvancedSearch")
    public Pager<Returnedmoneyplan> RMPAdvancedSearch(@RequestBody PLRmpAdvancedSearch rmpAdvancedSearch){
        return returnedMoneyPlanService.RMPAdvancedSearch(rmpAdvancedSearch);
    }
    @GetMapping("/findByRmpIdByContract")
    public Returnedmoneyplan findByRmpIdByContract(Integer rmpId){
       return returnedMoneyPlanService.findByRmpIdByContract(rmpId);
    }
    @PostMapping("/insertRMPByContract")
    public Result insertRMPByContract(@RequestBody Returnedmoneyplan returnedmoneyplan){
        returnedMoneyPlanService.insertRMPByContract(returnedmoneyplan);
        return Result.SUCCESS;
    }
    @GetMapping("/findByRmpIdContractAll")
    public Returnedmoneyplan findByRmpIdContractAll(Integer ctrId){
        return returnedMoneyPlanService.findByRmpIdContractAll(ctrId);
    }
 }
