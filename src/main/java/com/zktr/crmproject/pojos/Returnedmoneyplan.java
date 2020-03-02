package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Returnedmoneyplan {
    private int rmpId;
    private Integer cusId;
    private Integer ordId;
    private Integer uId;
    private BigDecimal rmpMoney;
    private String rmpRmp;
    private String rmpBilling;
    private Integer rmpIssue;
    private Timestamp rmpDate;
    private String rmpRemark;
    private Customer customer;
    private Orders orders;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Returnedmoneyplan that = (Returnedmoneyplan) o;
        return rmpId == that.rmpId &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(ordId, that.ordId) &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(rmpMoney, that.rmpMoney) &&
                Objects.equals(rmpRmp, that.rmpRmp) &&
                Objects.equals(rmpBilling, that.rmpBilling) &&
                Objects.equals(rmpIssue, that.rmpIssue) &&
                Objects.equals(rmpDate, that.rmpDate) &&
                Objects.equals(rmpRemark, that.rmpRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rmpId, cusId, ordId, uId, rmpMoney, rmpRmp, rmpBilling, rmpIssue, rmpDate, rmpRemark);
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
