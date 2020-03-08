package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Duepay {
    private int duePayId;
    private Timestamp planpayTime;
    private String period;
    private BigDecimal money;
    private String dueMoney;
    private String charity;
    private String status;
    private Integer buyORreturn;
    private String remarks;
    @JsonIgnoreProperties("duepay")
    private Customer customer;

    @Id
    @Column(name = "duepay_id")
    public int getDuePayId() {
        return duePayId;
    }

    public void setDuePayId(int duePayId) {
        this.duePayId = duePayId;
    }

    @Basic
    @Column(name = "planpay_time")
    public Timestamp getPlanpayTime() {
        return planpayTime;
    }

    public void setPlanpayTime(Timestamp planpayTime) {
        this.planpayTime = planpayTime;
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
    @Column(name = "money")
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Basic
    @Column(name = "due_money")
    public String getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(String dueMoney) {
        this.dueMoney = dueMoney;
    }

    @Basic
    @Column(name = "charity")
    public String getCharity() {
        return charity;
    }

    public void setCharity(String charity) {
        this.charity = charity;
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
    @Column(name = "buyORreturn")
    public Integer getBuyORreturn() {
        return buyORreturn;
    }

    public void setBuyORreturn(Integer buyORreturn) {
        this.buyORreturn = buyORreturn;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
