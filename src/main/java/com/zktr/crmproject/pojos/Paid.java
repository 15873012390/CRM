package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Paid {
    private Integer paidId;
    private String period;
    private Timestamp payTime;
    private Integer payMoney;
    private String foreignRemarks;
    private String paymentType;
    private Integer collectTickets;
    private Integer cusId;
    private Integer returnGoods;
    private String passPerson;
    private String classify;
    private String remarks;
    private Customer customer;
    private Purchasereturn purchasereturn;

    @Basic
    @Column(name = "paid_id")
    public Integer getPaidId() {
        return paidId;
    }

    public void setPaidId(Integer paidId) {
        this.paidId = paidId;
    }

    @Basic
    @Column(name = "period")
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Basic
    @Column(name = "pay_time")
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "pay_money")
    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    @Basic
    @Column(name = "foreign_remarks")
    public String getForeignRemarks() {
        return foreignRemarks;
    }

    public void setForeignRemarks(String foreignRemarks) {
        this.foreignRemarks = foreignRemarks;
    }

    @Basic
    @Column(name = "payment_type")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "collect_tickets")
    public Integer getCollectTickets() {
        return collectTickets;
    }

    public void setCollectTickets(Integer collectTickets) {
        this.collectTickets = collectTickets;
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
    @Column(name = "return_goods")
    public Integer getReturnGoods() {
        return returnGoods;
    }

    public void setReturnGoods(Integer returnGoods) {
        this.returnGoods = returnGoods;
    }

    @Basic
    @Column(name = "pass_person")
    public String getPassPerson() {
        return passPerson;
    }

    public void setPassPerson(String passPerson) {
        this.passPerson = passPerson;
    }

    @Basic
    @Column(name = "classify")
    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
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
        Paid paid = (Paid) o;
        return Objects.equals(paidId, paid.paidId) &&
                Objects.equals(period, paid.period) &&
                Objects.equals(payTime, paid.payTime) &&
                Objects.equals(payMoney, paid.payMoney) &&
                Objects.equals(foreignRemarks, paid.foreignRemarks) &&
                Objects.equals(paymentType, paid.paymentType) &&
                Objects.equals(collectTickets, paid.collectTickets) &&
                Objects.equals(cusId, paid.cusId) &&
                Objects.equals(returnGoods, paid.returnGoods) &&
                Objects.equals(passPerson, paid.passPerson) &&
                Objects.equals(classify, paid.classify) &&
                Objects.equals(remarks, paid.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paidId, period, payTime, payMoney, foreignRemarks, paymentType, collectTickets, cusId, returnGoods, passPerson, classify, remarks);
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
    @JoinColumn(name = "return_goods", referencedColumnName = "preturn_id")
    public Purchasereturn getPurchasereturn() {
        return purchasereturn;
    }

    public void setPurchasereturn(Purchasereturn purchasereturn) {
        this.purchasereturn = purchasereturn;
    }
}
