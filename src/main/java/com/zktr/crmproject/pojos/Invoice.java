package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Invoice {
    private int invId;
    private Integer cusId;
    private Integer ordId;
    private String invContent;
    private BigDecimal invMoney;
    private String invType;
    private Timestamp invDate;
    private Integer uId;
    private String invRm;
    private String invPlan;
    private String invRemark;
    private Customer customer;
    private Orders orders;
    private User user;

    @Id
    @Column(name = "inv_id")
    public int getInvId() {
        return invId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
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
    @Column(name = "inv_content")
    public String getInvContent() {
        return invContent;
    }

    public void setInvContent(String invContent) {
        this.invContent = invContent;
    }

    @Basic
    @Column(name = "inv_money")
    public BigDecimal getInvMoney() {
        return invMoney;
    }

    public void setInvMoney(BigDecimal invMoney) {
        this.invMoney = invMoney;
    }

    @Basic
    @Column(name = "inv_type")
    public String getInvType() {
        return invType;
    }

    public void setInvType(String invType) {
        this.invType = invType;
    }

    @Basic
    @Column(name = "inv_date")
    public Timestamp getInvDate() {
        return invDate;
    }

    public void setInvDate(Timestamp invDate) {
        this.invDate = invDate;
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
    @Column(name = "inv_rm")
    public String getInvRm() {
        return invRm;
    }

    public void setInvRm(String invRm) {
        this.invRm = invRm;
    }

    @Basic
    @Column(name = "inv_plan")
    public String getInvPlan() {
        return invPlan;
    }

    public void setInvPlan(String invPlan) {
        this.invPlan = invPlan;
    }

    @Basic
    @Column(name = "inv_remark")
    public String getInvRemark() {
        return invRemark;
    }

    public void setInvRemark(String invRemark) {
        this.invRemark = invRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invId == invoice.invId &&
                Objects.equals(cusId, invoice.cusId) &&
                Objects.equals(ordId, invoice.ordId) &&
                Objects.equals(invContent, invoice.invContent) &&
                Objects.equals(invMoney, invoice.invMoney) &&
                Objects.equals(invType, invoice.invType) &&
                Objects.equals(invDate, invoice.invDate) &&
                Objects.equals(uId, invoice.uId) &&
                Objects.equals(invRm, invoice.invRm) &&
                Objects.equals(invPlan, invoice.invPlan) &&
                Objects.equals(invRemark, invoice.invRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invId, cusId, ordId, invContent, invMoney, invType, invDate, uId, invRm, invPlan, invRemark);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "ord_id")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
