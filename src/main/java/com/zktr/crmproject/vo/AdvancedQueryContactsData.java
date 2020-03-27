package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.Customer;

import java.util.Date;

public class AdvancedQueryContactsData {
    private Integer conId;
    private String conName;
    private String conTel;
    private String conMobile;
    private Date conTimeStart;
    private Date conTimeEnd;
    private String[] conSex;
    private String conPosition;
    private String conRemarks;
    private Integer curpage;
    private Integer pagesize;
    private Customer customer;

    public AdvancedQueryContactsData(Integer conId, String conName, String conTel, String conMobile, Date conTimeStart, Date conTimeEnd, String[] conSex, String conPosition, String conRemarks, Integer curpage, Integer pagesize, Customer customer) {
        this.conId = conId;
        this.conName = conName;
        this.conTel = conTel;
        this.conMobile = conMobile;
        this.conTimeStart = conTimeStart;
        this.conTimeEnd = conTimeEnd;
        this.conSex = conSex;
        this.conPosition = conPosition;
        this.conRemarks = conRemarks;
        this.curpage = curpage;
        this.pagesize = pagesize;
        this.customer = customer;
    }

    public AdvancedQueryContactsData() {
    }

    public Date getConTimeEnd() {
        return conTimeEnd;
    }

    public void setConTimeEnd(Date conTimeEnd) {
        this.conTimeEnd = conTimeEnd;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel;
    }

    public String getConMobile() {
        return conMobile;
    }

    public void setConMobile(String conMobile) {
        this.conMobile = conMobile;
    }

    public Date getConTimeStart() {
        return conTimeStart;
    }

    public void setConTimeStart(Date conTimeStart) {
        this.conTimeStart = conTimeStart;
    }

    public String[] getConSex() {
        return conSex;
    }

    public void setConSex(String[] conSex) {
        this.conSex = conSex;
    }

    public String getConPosition() {
        return conPosition;
    }

    public void setConPosition(String conPosition) {
        this.conPosition = conPosition;
    }

    public String getConRemarks() {
        return conRemarks;
    }

    public void setConRemarks(String conRemarks) {
        this.conRemarks = conRemarks;
    }

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
}
