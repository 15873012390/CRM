package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Contract {
    private int ctrId;
    private String conClassify;
    private String conPayment;
    private BigDecimal conSendOutMoney;
    private Timestamp conStartTime;
    private Timestamp conEndTime;
    private Timestamp conSigningDate;
    private String conMoneyWay;
    private Integer conDelState;
    @JsonIgnoreProperties("contract")
    private User user;
    @JsonIgnoreProperties("contract")
    private Customer customer;

    @Id
    @Column(name = "ctr_id")
    public int getCtrId() {
        return ctrId;
    }

    public void setCtrId(int ctrId) {
        this.ctrId = ctrId;
    }


    @Basic
    @Column(name = "con_classify")
    public String getConClassify() {
        return conClassify;
    }

    public void setConClassify(String conClassify) {
        this.conClassify = conClassify;
    }

    @Basic
    @Column(name = "con_payment")
    public String getConPayment() {
        return conPayment;
    }

    public void setConPayment(String conPayment) {
        this.conPayment = conPayment;
    }

    @Basic
    @Column(name = "con_send_out_money")
    public BigDecimal getConSendOutMoney() {
        return conSendOutMoney;
    }

    public void setConSendOutMoney(BigDecimal conSendOutMoney) {
        this.conSendOutMoney = conSendOutMoney;
    }

    @Basic
    @Column(name = "con_start_time")
    public Timestamp getConStartTime() {
        return conStartTime;
    }

    public void setConStartTime(Timestamp conStartTime) {
        this.conStartTime = conStartTime;
    }

    @Basic
    @Column(name = "con_end_time")
    public Timestamp getConEndTime() {
        return conEndTime;
    }

    public void setConEndTime(Timestamp conEndTime) {
        this.conEndTime = conEndTime;
    }

    @Basic
    @Column(name = "con_signing_date")
    public Timestamp getConSigningDate() {
        return conSigningDate;
    }

    public void setConSigningDate(Timestamp conSigningDate) {
        this.conSigningDate = conSigningDate;
    }

    @Basic
    @Column(name = "con_money_way")
    public String getConMoneyWay() {
        return conMoneyWay;
    }

    public void setConMoneyWay(String conMoneyWay) {
        this.conMoneyWay = conMoneyWay;
    }

    @Basic
    @Column(name = "con_del_state")
    public Integer getConDelState() {
        return conDelState;
    }

    public void setConDelState(Integer conDelState) {
        this.conDelState = conDelState;
    }


    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
