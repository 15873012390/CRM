package com.zktr.crmproject.vo;

import java.util.Date;

public class CustomerServiceAdvancedSearch{
    private int csId;
    private String title;
    private String serviceType[];
    private String serviceWay[];
    private Date startTime[];
    private String spendTime;
    private String executor;
    private String status[];
    private Integer cusId;
    private Integer cusName;
    private Integer curPage;
    private Integer pageSize;
    private Date s1;
    private Date s2;

    public int getCsId() {
        return csId;
    }

    public void setCsId(int csId) {
        this.csId = csId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getServiceType() {
        return serviceType;
    }

    public void setServiceType(String[] serviceType) {
        this.serviceType = serviceType;
    }

    public String[] getServiceWay() {
        return serviceWay;
    }

    public void setServiceWay(String[] serviceWay) {
        this.serviceWay = serviceWay;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public Date[] getStartTime() {
        return startTime;
    }

    public void setStartTime(Date[] startTime) {
        this.startTime = startTime;
    }

    public String getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getCusName() {
        return cusName;
    }

    public void setCusName(Integer cusName) {
        this.cusName = cusName;
    }

    public Date getS1() {
        return s1;
    }

    public void setS1(Date s1) {
        this.s1 = s1;
    }

    public Date getS2() {
        return s2;
    }

    public void setS2(Date s2) {
        this.s2 = s2;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "CustomerServiceAdvancedSearch{" +
                "csId=" + csId +
                ", title='" + title + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceWay='" + serviceWay + '\'' +
                ", startTime=" + startTime +
                ", spendTime='" + spendTime + '\'' +
                ", executor='" + executor + '\'' +
                ", status='" + status + '\'' +
                ", cusId=" + cusId +
                ", cusName=" + cusName +
                '}';
    }
}
