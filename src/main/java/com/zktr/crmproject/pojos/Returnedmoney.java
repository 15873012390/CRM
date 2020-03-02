package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Returnedmoney {
    private int remId;
    private Integer cusId;
    private Integer ordId;
    private Integer uId;
    private BigDecimal remMoney;
    private String remRem;
    private String remBilling;
    private String remClassify;
    private Timestamp remDate;
    private String remRemark;
    private Customer customer;
    private Orders orders;
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
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "ord_id")
    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    @Basic
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Returnedmoney that = (Returnedmoney) o;
        return remId == that.remId &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(ordId, that.ordId) &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(remMoney, that.remMoney) &&
                Objects.equals(remRem, that.remRem) &&
                Objects.equals(remBilling, that.remBilling) &&
                Objects.equals(remClassify, that.remClassify) &&
                Objects.equals(remDate, that.remDate) &&
                Objects.equals(remRemark, that.remRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remId, cusId, ordId, uId, remMoney, remRem, remBilling, remClassify, remDate, remRemark);
    }

    @ManyToOne
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "ord_id", referencedColumnName = "ord_id")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
