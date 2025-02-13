package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Customertransfer;
import com.zktr.crmproject.service.TWCustomerService;
import com.zktr.crmproject.utils.ExcelUtils;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

@RestController
public class TWCustomerController {
    @Autowired
    private TWCustomerService TWCustomerService;

    /**
     * 加载客户详情（右）
     * @param cusId
     * @return
     */
    @ResponseBody
    @GetMapping("/find_customer_by_id1")
    public Customer findCustomerById1(Integer cusId){
        return TWCustomerService.findCustomerDetailsById1(cusId);
    }
    @ResponseBody
    @GetMapping("/find_customer_by_id2")
    public Customer findCustomerById2(Integer cusId){
        return TWCustomerService.findCustomerDetailsById2(cusId);
    }
    @ResponseBody
    @GetMapping("/find_customer_by_id3")
    public Customer findCustomerById3(Integer cusId){
        return TWCustomerService.findCustomerDetailsById3(cusId);
    }
    @ResponseBody
    @GetMapping("/find_customer_by_id4")
    public Customer findCustomerById4(Integer cusId){
        return TWCustomerService.findCustomerDetailsById4(cusId);
    }
    @ResponseBody
    @GetMapping("/find_customer_by_id5")
    public Customer findCustomerById5(Integer cusId){
        return TWCustomerService.findCustomerDetailsById5(cusId);
    }
    @ResponseBody
    @GetMapping("/find_customer_by_id6")
    public Customer findCustomerById6(Integer cusId){
        return TWCustomerService.findCustomerDetailsById6(cusId);
    }
    @ResponseBody
    @GetMapping("/find_customer_by_id7")
    public Customer findCustomerById7(Integer cusId){
        return TWCustomerService.findCustomerDetailsById7(cusId);
    }
    @ResponseBody
    @GetMapping("/find_customer_by_id8")
    public Customer findCustomerById8(Integer cusId){
        return TWCustomerService.findCustomerDetailsById8(cusId);
    }

    /**
     * 根据用户id查询客户转移日志
     * @param uId
     * @param num
     * @param curpage
     * @param pagesize
     * @return
     * @throws ParseException
     */
    @ResponseBody
    @GetMapping("/query_customertransfer_byId")
    public Pager<Customertransfer> queryCustomertransferById(Integer uId,Integer num, int curpage, int pagesize) throws ParseException {
        return TWCustomerService.queryCustomerTransferById(uId,num,curpage,pagesize);
    }

    /**
     * 查询所有客户转移日志
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_all_customertransfer")
    public Pager<Customertransfer> queryAllCustomertransfer(int curpage, int pagesize) throws ParseException {
        return TWCustomerService.queryAllCustomerTransfer(curpage,pagesize);
    }

    /**
     * 添加客户转移日志
     * @param customertransfer
     * @return
     */
    @PostMapping("/add_customertransfer") //restful风格
    @ResponseBody
    public Result addCustomerTransfer(@RequestBody Customertransfer customertransfer){
        TWCustomerService.saveCustomerTransfer(customertransfer);
        return Result.SUCCESS;
    }

    /**
     * 分页查询所有客户
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_all_customer")
    public Pager<Customer> queryAllCustomer(int curpage, int pagesize){
        return TWCustomerService.queryAllCustomers(curpage,pagesize);
    }

    /**
     * 查询所有客户
     * @return
     */
    @ResponseBody
    @GetMapping("/query_all_customer2")
    public List<Customer> queryAllCustomer2(){
        return TWCustomerService.queryAllCustomers2();
    }

    /**
     * 查看是否重名客户
     * @param cusName
     * @return
     */
    @ResponseBody
    @GetMapping("/count_customer_name")
    public boolean countCustomerName(String cusName){
        return TWCustomerService.countCustomerName(cusName);
    }

    /**
     * 排序（正序）
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_all_customer_sort")
    public Pager<Customer> queryAllCustomerByIdASC(String prop,String order,int curpage, int pagesize){
        return TWCustomerService.queryAllCustomerByIdASC(prop,order,curpage,pagesize);
    }

    /**
     * 根据id查询客户
     * @param id
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_customer_by_id")
    public Pager<Customer> queryCustomerById(Integer id,Integer curpage, Integer pagesize){
        return TWCustomerService.queryCustomerById(id,curpage,pagesize);
    }

    /**
     * 高级查询客户
     * @param advancedQueryCustomerData
     * @return
     */
    @ResponseBody
    @RequestMapping("/query_customer_senior")
    public Pager<Customer> queryCustomerSenior(@RequestBody AdvancedQueryCustomerData advancedQueryCustomerData){
        return TWCustomerService.queryCustomerSenior(advancedQueryCustomerData);
    }

    /**
     * 统计饼图数据
     * @param num
     * @return
     */
    @ResponseBody
    @RequestMapping("/count_pie")
    public List<CountPie> countPie(Integer num){
        return TWCustomerService.countPie(num);
    }

    /**
     * 统计柱状图数据
     * @param num
     * @return
     */
    @ResponseBody
    @RequestMapping("/count_bar")
    public CountBar countBar(Integer num){
        return TWCustomerService.countBar(num);
    }

    /**
     * 加载客户详情（全）
     * @param cusId
     * @return
     */
    @GetMapping("/find_customer_by_id")
    @ResponseBody
    public Customer findCustomerById(Integer cusId){
        return TWCustomerService.findCustomerDetailsById(cusId);
    }


    /**
     * 加载客户（左）
     * @param cusId
     * @return
     */
    @GetMapping("/find_customer")
    @ResponseBody
    public Customer findCustomer(Integer cusId){
        return TWCustomerService.findCustomer(cusId);
    }

    /**
     * 根据id查询客户详情
     * @param cusId
     * @return
     */
    @GetMapping("/find_customer_details")
    @ResponseBody
    public Customer queryCustomerDetailsById(Integer cusId){
        return TWCustomerService.queryCustomerDetailsById(cusId);
    }

    /**
     * 根据名称加载客户
     * @param cusName
     * @return
     */
    @GetMapping("/find_customer_by_name")
    @ResponseBody
    public Customer findCustomerByName(String cusName){
        return TWCustomerService.findCustomerByName(cusName);
    }

    /**
     * 根据名称模糊查询客户
     * @param name
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_customer_by_name")
    public Pager<Customer> queryCustomerByName(String name,Integer curpage, Integer pagesize){
        return TWCustomerService.queryCustomerByName(name,curpage,pagesize);
    }

    /**
     * 根据数据查询客户
     * @param value
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_customer_by_shuju")
    public Pager<Customer> queryCustomerByShuJu(String value,Integer curpage, Integer pagesize){
        return TWCustomerService.queryCustomerByShuJu(value,curpage,pagesize);
    }

    /**
     * Excel导入客户
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("/imp_customer")
    public String[] impCustomer(MultipartFile file){
        List<Customer> list= ExcelUtils.importData(file,1,Customer.class);
        String[] strings=new String[list.size()];

        if (list!=null){
            boolean num=true;
            strings=TWCustomerService.CustomerExcle(list);
           for (int i=0;i<strings.length;i++){
               if (strings[i]!=null){
                   num=false;
               }
           }
           if (num){
               TWCustomerService.InsertAllCustomer(list);
           }

        }
        return strings;
    }

    /**
     * Excel导出客户
     * @param response
     * @return
     */
    @ResponseBody
    @GetMapping("/exp_customer")
    public Result expUser(HttpServletResponse response){
        List<Customer> list = TWCustomerService.queryAllCustomers2();
        if(list != null && list.size() > 0){
            ExcelUtils.exportExcel(list, null, "客户数据", Customer.class, "客户数据.xlsx", response);
            return Result.SUCCESS;
        }else {
            return Result.FAILURE;
        }
    }

    /**
     * 添加或修改客户信息
     * @param customer
     * @return
     */
    @PostMapping("/add_and_update_customer") //restful风格
    @ResponseBody
    public Result addAndUpdateCustomer(@RequestBody  Customer customer){
        TWCustomerService.saveCustomer(customer);
        return Result.SUCCESS;
    }

    /**
     * 删除客户
     * @param cusid
     * @return
     */
    @DeleteMapping("/delete_customer")
    @ResponseBody
    public Result deleteCustomer(Integer cusid){
        TWCustomerService.deleteCustomer(cusid);
        return Result.SUCCESS;
    }

    /**
     * 删除客户连带客户转移日志
     * @param cusid
     * @return
     */
    @DeleteMapping("/delete_customer2")
    @ResponseBody
    public Result deleteCustomer2(Integer cusid){
        TWCustomerService.deleteCustomer2(cusid);
        return Result.SUCCESS;
    }
}
