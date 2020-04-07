package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Customercare {
    private int ccId;
    private String contacts;
    private String title;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp ccDate;
    private String executor;
    private String type;
    private String ccContent;
    private String cusFeedback;
    private String remarks;
    @JsonIgnoreProperties("customercare")
    private Customer customer;

    @Id
    @Column(name = "cc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCcId() {
        return ccId;
    }

    public void setCcId(int ccId) {
        this.ccId = ccId;
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

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
