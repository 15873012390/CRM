package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Duepay {
    private int duePayId;
    private Timestamp planpayTime;
    private String period;
    private Integer money;
    private String dueMoney;
    private String charity;
    private String status;
    private Integer buyORreturn;
    private Integer cusId;
    private String remarks;
    private Customer customer;

    @Id
    @Column(name = "duePay_id")
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
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
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
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
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
        Duepay duepay = (Duepay) o;
        return duePayId == duepay.duePayId &&
                Objects.equals(planpayTime, duepay.planpayTime) &&
                Objects.equals(period, duepay.period) &&
                Objects.equals(money, duepay.money) &&
                Objects.equals(dueMoney, duepay.dueMoney) &&
                Objects.equals(charity, duepay.charity) &&
                Objects.equals(status, duepay.status) &&
                Objects.equals(buyORreturn, duepay.buyORreturn) &&
                Objects.equals(cusId, duepay.cusId) &&
                Objects.equals(remarks, duepay.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duePayId, planpayTime, period, money, dueMoney, charity, status, buyORreturn, cusId, remarks);
    }

    @ManyToOne
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
