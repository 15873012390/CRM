package com.zktr.crmproject.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.zktr.crmproject.pojos.Customer;

import java.util.Date;
public class JrcSolutionAdvenceSearch {
    private Integer curpage;
    private Integer pagesize;
    private Customer customer;
    private String themSelect;
    private String them;
    @JSONField(format = "yyyy-MM-dd")
    private Date timeStart;
    @JSONField(format = "yyyy-MM-dd")
    private Date timeEnd;

    public Integer getCurpage() {
        return curpage;
    }

    public void setCurpage(Integer curpage) {
        this.curpage = curpage;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getThemSelect() {
        return themSelect;
    }

    public void setThemSelect(String themSelect) {
        this.themSelect = themSelect;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public JrcSolutionAdvenceSearch() {
    }

    public JrcSolutionAdvenceSearch(Integer curpage, Integer pagesize, Customer customer, String themSelect, String them, Date timeStart, Date timeEnd) {
        this.curpage = curpage;
        this.pagesize = pagesize;
        this.customer = customer;
        this.themSelect = themSelect;
        this.them = them;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
}
