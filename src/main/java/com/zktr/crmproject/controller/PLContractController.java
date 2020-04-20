package com.zktr.crmproject.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zktr.crmproject.pojos.Contract;
import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.pojos.Productspecification;
import com.zktr.crmproject.pojos.Quotedetails;
import com.zktr.crmproject.service.PLContractService;
import com.zktr.crmproject.vo.PLContractAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping("/contract")
@RestController
public class PLContractController {
    @Autowired
    private PLContractService contractService;
    @GetMapping("/queryByClaState")
    public List<Productspecification> queryByClaState(){
        return contractService.queryByClaState();
    }
    @GetMapping("/queryAllContracrByPage")
    public Pager queryAllContracrByPage(int curpage, int pagesize){
        return contractService.queryAllContracrByPage(curpage,pagesize);
    }
    @GetMapping("/queryByCtrId")
    public Contract queryByCtrId(Integer ctrid){
        return contractService.queryByCtrId(ctrid);
    }
    @PostMapping("/saveContract")
    public Result saveContract(@RequestBody Contract contract){
        contractService.saveContract(contract);
        return Result.SUCCESS;
    }
    @PostMapping("/insertContract")
    public Result insertContract(@RequestBody Contract contract){
        contractService.insertContract(contract);
        return Result.SUCCESS;
    }
    @GetMapping("/delByCtrId")
    public Result delByCtrId(Integer ctrid){
        contractService.delByCtrId(ctrid);
        return Result.SUCCESS;
    }
    @PostMapping("/batchCtrIds")
    public Result batchCtrIds(@RequestBody Integer [] ctrids){
        contractService.batchCtrIds(ctrids);
        return Result.SUCCESS;
    }
    @GetMapping("/statisticsByMoney")
    public List<Map> statisticsByMoney(){
        return contractService.statisticsByMoney();
    }
    @GetMapping("/findAllByClaIdId")
    public List<Quotedetails> findAllByClaIdId(){
        return contractService.findAllByClaIdId();
    }
    @GetMapping("/findByQuoteClaIdId")
    public Quotedetails findByQuoteClaIdId(Integer qdid){
        return contractService.findByQuoteClaIdId(qdid);
    }
    @GetMapping("/queryByLikeQuery")
    public Pager<Contract> queryByLikeQuery(int curpage, int pagesize,String select,String input,String value){
        return contractService.queryByLikeQuery(curpage,pagesize,select,input,value);
    }
    @PostMapping("/ContractAdvancedSearch")
    public Pager<Contract> ContractAdvancedSearch(@RequestBody PLContractAdvancedSearch contractAdvancedSearch){
        //System.out.println("bbbbbb"+contractAdvancedSearch.getConThemeSelect());
        return contractService.ContractAdvancedSearch(contractAdvancedSearch);
    }
}
