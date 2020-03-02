package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Sendoutdetial {
    private int sodId;
    private Integer senId;
    private Integer proId;
    private Integer sodNumber;
    private Timestamp sodDate;
    private BigDecimal sodMoney;
    private String sodRemark;
    private Sendout sendout;
    private Product product;

    @Id
    @Column(name = "sod_id")
    public int getSodId() {
        return sodId;
    }

    public void setSodId(int sodId) {
        this.sodId = sodId;
    }

    @Basic
    @Column(name = "sen_id")
    public Integer getSenId() {
        return senId;
    }

    public void setSenId(Integer senId) {
        this.senId = senId;
    }

    @Basic
    @Column(name = "pro_id")
    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sendoutdetial that = (Sendoutdetial) o;
        return sodId == that.sodId &&
                Objects.equals(senId, that.senId) &&
                Objects.equals(proId, that.proId) &&
                Objects.equals(sodNumber, that.sodNumber) &&
                Objects.equals(sodDate, that.sodDate) &&
                Objects.equals(sodMoney, that.sodMoney) &&
                Objects.equals(sodRemark, that.sodRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sodId, senId, proId, sodNumber, sodDate, sodMoney, sodRemark);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "sen_id")
    public Sendout getSendout() {
        return sendout;
    }

    public void setSendout(Sendout sendout) {
        this.sendout = sendout;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
