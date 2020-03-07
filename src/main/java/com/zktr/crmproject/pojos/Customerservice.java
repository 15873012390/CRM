package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Customerservice {
    private int csId;
    private String title;
    private String serviceType;
    private String serviceWay;
    private Timestamp startTime;
    private String spendTime;
    private String executor;
    private String status;
    private String serviceContent;
    private String customerFeedback;
    private String remarks;
    @JsonIgnoreProperties("customerservices")
    private Customer customer;

    @Id
    @Column(name = "cs_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCsId() {
        return csId;
    }

    public void setCsId(int csId) {
        this.csId = csId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Basic
    @Column(name = "service_type")
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Basic
    @Column(name = "service_way")
    public String getServiceWay() {
        return serviceWay;
    }

    public void setServiceWay(String serviceWay) {
        this.serviceWay = serviceWay;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "spend_time")
    public String getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
    }

    @Basic
    @Column(name = "executor")
    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "service_content")
    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    @Basic
    @Column(name = "customer_feedback")
    public String getCustomerFeedback() {
        return customerFeedback;
    }

    public void setCustomerFeedback(String customerFeedback) {
        this.customerFeedback = customerFeedback;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @ManyToOne
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Customerservice{" +
                "csId=" + csId +
                ", title='" + title + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceWay='" + serviceWay + '\'' +
                ", startTime=" + startTime +
                ", spendTime='" + spendTime + '\'' +
                ", executor='" + executor + '\'' +
                ", status='" + status + '\'' +
                ", serviceContent='" + serviceContent + '\'' +
                ", customerFeedback='" + customerFeedback + '\'' +
                ", remarks='" + remarks + '\'' +
                ", customer=" + customer +
                '}';
    }
}
