package com.zktr.crmproject.vo;



import java.sql.Timestamp;

public class CustomerServiceAdvancedSearch  extends  PageBeen{
    private int csId;
    private String title;
    private String serviceType;
    private String serviceWay;
    private Timestamp startTime;
    private Timestamp endTime;
    private String spendTime;
    private String executor;
    private String status;
    private Integer cusId;
    private Integer cusName;

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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceWay() {
        return serviceWay;
    }

    public void setServiceWay(String serviceWay) {
        this.serviceWay = serviceWay;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CustomerServiceAdvancedSearch{" +
                "csId=" + csId +
                ", title='" + title + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceWay='" + serviceWay + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", spendTime='" + spendTime + '\'' +
                ", executor='" + executor + '\'' +
                ", status='" + status + '\'' +
                ", cusId=" + cusId +
                ", cusName=" + cusName +
                '}';
    }
}
