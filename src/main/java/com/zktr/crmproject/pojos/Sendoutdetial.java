package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Sendoutdetial {
    private int sodId;
    private Integer sodNumber;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp sodDate;
    private BigDecimal sodMoney;
    private String sodRemark;

    private Sendout sendout;
    private Productspecification productspecification;

    @Id
    @Column(name = "sod_id")
    public int getSodId() {
        return sodId;
    }

    public void setSodId(int sodId) {
        this.sodId = sodId;
    }


    @Basic
    @Column(name = "sod_number")
    public Integer getSodNumber() {
        return sodNumber;
    }

    public void setSodNumber(Integer sodNumber) {
        this.sodNumber = sodNumber;
    }

    @Basic
    @Column(name = "sod_date")
    public Timestamp getSodDate() {
        return sodDate;
    }

    public void setSodDate(Timestamp sodDate) {
        this.sodDate = sodDate;
    }

    @Basic
    @Column(name = "sod_money")
    public BigDecimal getSodMoney() {
        return sodMoney;
    }

    public void setSodMoney(BigDecimal sodMoney) {
        this.sodMoney = sodMoney;
    }

    @Basic
    @Column(name = "sod_remark")
    public String getSodRemark() {
        return sodRemark;
    }

    public void setSodRemark(String sodRemark) {
        this.sodRemark = sodRemark;
    }

    @ManyToOne
    @JoinColumn(name="sen_id",referencedColumnName = "sen_id")
    public Sendout getSendout() {
        return sendout;
    }

    public void setSendout(Sendout sendout) {
        this.sendout = sendout;
    }

    @ManyToOne
    @JoinColumn(name="spe_id",referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
    }
}
