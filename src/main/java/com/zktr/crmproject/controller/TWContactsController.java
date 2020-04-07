package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Contacts;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.service.TWContactsService;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TWContactsController {
    @Autowired
    private TWContactsService twContactsService;

    /**
     * 排序
     * @param prop
     * @param order
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_all_contacts_sort")
    public Pager<Contacts> queryAllContactsByIdASC(String prop,String order,int curpage, int pagesize){
        return twContactsService.queryAllContactsByIdASC(prop,order,curpage,pagesize);
    }

    /**
     * 根据数据查询联系人
     * @param shuJu
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_contacts_by_shuju")
    public Pager<Contacts> queryContactsByName(Integer shuJu,Integer curpage, Integer pagesize){
        return twContactsService.queryContactsByShuJu(shuJu,curpage,pagesize);
    }

    /**
     * 高级查询联系人
     * @param advancedQueryContactsData
     * @return
     */

    @ResponseBody
    @RequestMapping("/query_contacts_senior")
    public Pager<Contacts> queryCustomerSenior(@RequestBody AdvancedQueryContactsData advancedQueryContactsData){
        return twContactsService.queryContactsSenior(advancedQueryContactsData);
    }

    /**
     * 加载客户
     * @param conId
     * @return
     */
    @GetMapping("/find_contacts")
    @ResponseBody
    public Contacts findContacts(Integer conId){
        return twContactsService.findContacts(conId);
    }

    /**
     * 根据名称模糊查询联系人
     * @param name
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_contacts_by_name")
    public Pager<Contacts> queryContactsByName(String name,Integer curpage, Integer pagesize){
        return twContactsService.queryContactsByName(name,curpage,pagesize);
    }

    /**
     * 根据id查询联系人
     * @param id
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_contacts_by_id")
    public Pager<Contacts> queryContactsById(Integer id,Integer curpage, Integer pagesize){
        return twContactsService.queryContactsById(id,curpage,pagesize);
    }

    /**
     * 查询所有联系人
     * @param curpage
     * @param pagesize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_all_contacts")
    public Pager<Contacts> queryAllContacts(int curpage, int pagesize){
        return twContactsService.queryAllContacts(curpage,pagesize);
    }

    /**
     * 添加/修改联系人
     * @param contacts
     * @return
     */
//    @MyLog(value = "添加/修改联系人")
    @PostMapping("/add_and_update_contacts") //restful风格
    @ResponseBody
    public Result addAndUpdateCustomer(@RequestBody Contacts contacts){
        twContactsService.saveContacts(contacts);
        return Result.SUCCESS;
    }

    /**
     * 删除联系人
     * @param conid
     * @return
     */
    @DeleteMapping("/delete_contacts")
    @ResponseBody
    public Result deleteContacts(Integer conid){
        twContactsService.deleteContacts(conid);
        return Result.SUCCESS;
    }

    /**
     * 批量删除联系人
     * @param conIds
     * @return
     */
    @DeleteMapping("/delete_contacts_byids")
    @ResponseBody
    public Result deleteContactsByIds(Integer[] conIds){
        twContactsService.deleteContactsByIds(conIds);
        return Result.SUCCESS;
    }
}
