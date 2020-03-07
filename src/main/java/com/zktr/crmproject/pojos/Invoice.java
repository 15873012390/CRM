package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Invoice {
    private int invId;
    private String invContent;
    private BigDecimal invMoney;
    private String invType;
    private Timestamp invDate;
    private String invRm;
    private String invPlan;
    @JsonIgnoreProperties("invoice")
    private String invRemark;
    @JsonIgnoreProperties("invoice")
    private Customer customer;
    @JsonIgnoreProperties("invoice")
    private Orders orders;
    @JsonIgnoreProperties("invoice")
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
