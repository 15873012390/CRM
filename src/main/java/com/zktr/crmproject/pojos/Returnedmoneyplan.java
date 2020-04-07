package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Returnedmoneyplan {
    private int rmpId;
    private BigDecimal rmpMoney;
    private String rmpRmp;
    private String rmpBilling;
    private Integer rmpIssue;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp rmpDate;
    private String rmpRemark;
    @JsonIgnoreProperties("returnedmoneyplan")
    private Customer customer;
    @JsonIgnoreProperties("returnedmoneyplan")
    private Orders orders;
    @JsonIgnoreProperties("returnedmoneyplan")
    private User user;

    @Id
    @Column(name = "rmp_id")
    public int getRmpId() {
        return rmpId;
    }

    public void setRmpId(int rmpId) {
        this.rmpId = rmpId;
    }


    @Basic
    @Column(name = "rmp_money")
    public BigDecimal getRmpMoney() {
        return rmpMoney;
    }

    public void setRmpMoney(BigDecimal rmpMoney) {
        this.rmpMoney = rmpMoney;
    }

    @Basic
    @Column(name = "rmp_rmp")
    public String getRmpRmp() {
        return rmpRmp;
    }

    public void setRmpRmp(String rmpRmp) {
        this.rmpRmp = rmpRmp;
    }

    @Basic
    @Column(name = "rmp_billing")
    public String getRmpBilling() {
        return rmpBilling;
    }

    public void setRmpBilling(String rmpBilling) {
        this.rmpBilling = rmpBilling;
    }

    @Basic
    @Column(name = "rmp_issue")
    public Integer getRmpIssue() {
        return rmpIssue;
    }

    public void setRmpIssue(Integer rmpIssue) {
        this.rmpIssue = rmpIssue;
    }

    @Basic
    @Column(name = "rmp_date")
    public Timestamp getRmpDate() {
        return rmpDate;
    }

    public void setRmpDate(Timestamp rmpDate) {
        this.rmpDate = rmpDate;
    }

    @Basic
    @Column(name = "rmp_remark")
    public String getRmpRemark() {
        return rmpRemark;
    }

    public void setRmpRemark(String rmpRemark) {
        this.rmpRemark = rmpRemark;
    }

    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="ord_id",referencedColumnName = "ord_id")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
