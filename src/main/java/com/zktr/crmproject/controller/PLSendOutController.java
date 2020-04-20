package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Address;
import com.zktr.crmproject.pojos.Sendout;
import com.zktr.crmproject.pojos.Sendoutdetial;
import com.zktr.crmproject.service.PLSendOutService;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sendout")
public class PLSendOutController {
    @Autowired
    private PLSendOutService sendOutService;
    @GetMapping("/findSendOutByOrdid")
    public Sendout findSendOutByOrdid(Integer ordid){
        return sendOutService.findSendOutByOrdid(ordid);
    }
    @GetMapping("/findByAddidByOrders")
    public Address findByAddidByOrders(Integer addid){
        return sendOutService.findByAddidByOrders(addid);
    }
    @PostMapping("/updateSendOut")
    public Result updateSendOut(@RequestBody Sendout sendout){
         sendOutService.updateSendOut(sendout);
         return Result.SUCCESS;
    }
    @GetMapping("/findAllBySendOutDetailBySenId")
    public List<Sendoutdetial> findAllBySendOutDetailBySenId(Integer senId){
        return sendOutService.findAllBySendOutDetailBySenId(senId);
    }
    @PostMapping("/updateBySendOutBySenId")
    public Result updateBySendOutBySenId(@RequestBody Sendout sendout){
        sendOutService.updateBySendOutBySenId(sendout);
        return Result.SUCCESS;
    }
    @GetMapping("/updateStockAndSendOut")
    public Result updateStockAndSendOut(Integer senid,Integer outid){
        sendOutService.updateStockAndSendOut(senid,outid);
        return Result.SUCCESS;
    }
}
