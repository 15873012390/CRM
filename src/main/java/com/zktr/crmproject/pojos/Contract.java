package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Contract {
    private int ctrId;
    private Integer uId;
    private Integer cusId;
    private String conClassify;
    private String conPayment;
    private BigDecimal conSendOutMoney;
    private Timestamp conStartTime;
    private Timestamp conEndTime;
    private Timestamp conSigningDate;
    private String conMoneyWay;
    private Integer conDelState;
    private User user;
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
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return ctrId == contract.ctrId &&
                Objects.equals(uId, contract.uId) &&
                Objects.equals(cusId, contract.cusId) &&
                Objects.equals(conClassify, contract.conClassify) &&
                Objects.equals(conPayment, contract.conPayment) &&
                Objects.equals(conSendOutMoney, contract.conSendOutMoney) &&
                Objects.equals(conStartTime, contract.conStartTime) &&
                Objects.equals(conEndTime, contract.conEndTime) &&
                Objects.equals(conSigningDate, contract.conSigningDate) &&
                Objects.equals(conMoneyWay, contract.conMoneyWay) &&
                Objects.equals(conDelState, contract.conDelState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ctrId, uId, cusId, conClassify, conPayment, conSendOutMoney, conStartTime, conEndTime, conSigningDate, conMoneyWay, conDelState);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
