package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Returnedmoney {
    private int remId;
    private BigDecimal remMoney;
    private String remRem;
    private String remBilling;
    private String remClassify;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp remDate;
    private String remRemark;
    @JsonIgnoreProperties("returnedmoney")
    private Customer customer;
    @JsonIgnoreProperties("returnedmoney")
    private Orders orders;
    @JsonIgnoreProperties("returnedmoney")
    private User user;

    @Id
    @Column(name = "rem_id")
    public int getRemId() {
        return remId;
    }

    public void setRemId(int remId) {
        this.remId = remId;
    }


    @Basic
    @Column(name = "rem_money")
    public BigDecimal getRemMoney() {
        return remMoney;
    }

    public void setRemMoney(BigDecimal remMoney) {
        this.remMoney = remMoney;
    }

    @Basic
    @Column(name = "rem_rem")
    public String getRemRem() {
        return remRem;
    }

    public void setRemRem(String remRem) {
        this.remRem = remRem;
    }

    @Basic
    @Column(name = "rem_billing")
    public String getRemBilling() {
        return remBilling;
    }

    public void setRemBilling(String remBilling) {
        this.remBilling = remBilling;
    }

    @Basic
    @Column(name = "rem_classify")
    public String getRemClassify() {
        return remClassify;
    }

    public void setRemClassify(String remClassify) {
        this.remClassify = remClassify;
    }

    @Basic
    @Column(name = "rem_date")
    public Timestamp getRemDate() {
        return remDate;
    }

    public void setRemDate(Timestamp remDate) {
        this.remDate = remDate;
    }

    @Basic
    @Column(name = "rem_remark")
    public String getRemRemark() {
        return remRemark;
    }

    public void setRemRemark(String remRemark) {
        this.remRemark = remRemark;
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
