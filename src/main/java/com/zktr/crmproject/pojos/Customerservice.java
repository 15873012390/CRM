package com.zktr.crmproject.pojos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Customerservice {
    private int csId;
    private String title;
    private Integer customer;
    private String serviceType;
    private String serviceWay;
    private Timestamp startTime;
    private Timestamp spendTime;
    private String executor;
    private String status;
    private String serviceContent;
    private String customerFeedback;
    private String remarks;

    @Id
    @Column(name = "cs_id")
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
    @Column(name = "customer")
    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
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
    public Timestamp getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Timestamp spendTime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customerservice that = (Customerservice) o;
        return csId == that.csId &&
                Objects.equals(title, that.title) &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(serviceType, that.serviceType) &&
                Objects.equals(serviceWay, that.serviceWay) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(spendTime, that.spendTime) &&
                Objects.equals(executor, that.executor) &&
                Objects.equals(status, that.status) &&
                Objects.equals(serviceContent, that.serviceContent) &&
                Objects.equals(customerFeedback, that.customerFeedback) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(csId, title, customer, serviceType, serviceWay, startTime, spendTime, executor, status, serviceContent, customerFeedback, remarks);
    }
}
