package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Customercare {
    private int ccId;
    private Integer cusId;
    private String contacts;
    private Timestamp ccDate;
    private String executor;
    private String type;
    private String ccContent;
    private String cusFeedback;
    private String remarks;
    private Customer customer;

    @Id
    @Column(name = "cc_id")
    public int getCcId() {
        return ccId;
    }

    public void setCcId(int ccId) {
        this.ccId = ccId;
    }

    @Basic
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "contacts")
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Basic
    @Column(name = "cc_date")
    public Timestamp getCcDate() {
        return ccDate;
    }

    public void setCcDate(Timestamp ccDate) {
        this.ccDate = ccDate;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "cc_content")
    public String getCcContent() {
        return ccContent;
    }

    public void setCcContent(String ccContent) {
        this.ccContent = ccContent;
    }

    @Basic
    @Column(name = "cus_feedback")
    public String getCusFeedback() {
        return cusFeedback;
    }

    public void setCusFeedback(String cusFeedback) {
        this.cusFeedback = cusFeedback;
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
        Customercare that = (Customercare) o;
        return ccId == that.ccId &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(contacts, that.contacts) &&
                Objects.equals(ccDate, that.ccDate) &&
                Objects.equals(executor, that.executor) &&
                Objects.equals(type, that.type) &&
                Objects.equals(ccContent, that.ccContent) &&
                Objects.equals(cusFeedback, that.cusFeedback) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccId, cusId, contacts, ccDate, executor, type, ccContent, cusFeedback, remarks);
    }

    @ManyToOne
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
