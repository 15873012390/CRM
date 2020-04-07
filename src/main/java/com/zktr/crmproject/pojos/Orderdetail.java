package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Orderdetail {
    private int detId;
    private Integer detNumber;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp detTime;
    private String detRequire;
    private String detCondition;
    private String detRemark;
    private BigDecimal detMoney;
    @JsonIgnoreProperties("orderdetail")
    private Orders orders;
    @JsonIgnoreProperties("orderdetail")
    private Productspecification productspecification;
    @JsonIgnoreProperties("orderdetail")
    private User user;
    @JsonIgnoreProperties("orderdetail")
    private Customer customer;

    @Id
    @Column(name = "det_id")
    public int getDetId() {
        return detId;
    }

    public void setDetId(int detId) {
        this.detId = detId;
    }
    @Basic
    @Column(name = "det_money")
    public BigDecimal getDetMoney() {
        return detMoney;
    }

    public void setDetMoney(BigDecimal detMoney) {
        this.detMoney = detMoney;
    }

    @Basic
    @Column(name = "det_number")
    public Integer getDetNumber() {
        return detNumber;
    }

    public void setDetNumber(Integer detNumber) {
        this.detNumber = detNumber;
    }

    @Basic
    @Column(name = "det_time")
    public Timestamp getDetTime() {
        return detTime;
    }

    public void setDetTime(Timestamp detTime) {
        this.detTime = detTime;
    }

    @Basic
    @Column(name = "det_require")
    public String getDetRequire() {
        return detRequire;
    }

    public void setDetRequire(String detRequire) {
        this.detRequire = detRequire;
    }

    @Basic
    @Column(name = "det_condition")
    public String getDetCondition() {
        return detCondition;
    }

    public void setDetCondition(String detCondition) {
        this.detCondition = detCondition;
    }

    @Basic
    @Column(name = "det_remark")
    public String getDetRemark() {
        return detRemark;
    }

    public void setDetRemark(String detRemark) {
        this.detRemark = detRemark;
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
    @JoinColumn(name="spe_id",referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
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

    @Override
    public String toString() {
        return "Orderdetail{" +
                "detId=" + detId +
                ", detNumber=" + detNumber +
                ", detTime=" + detTime +
                ", detRequire='" + detRequire + '\'' +
                ", detCondition='" + detCondition + '\'' +
                ", detRemark='" + detRemark + '\'' +
                ", orders=" + orders +
                ", productspecification=" + productspecification +
                ", user=" + user +
                ", customer=" + customer +
                '}';
    }
}
