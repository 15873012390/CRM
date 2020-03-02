package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Orderdetail {
    private int detId;
    private Integer ordId;
    private Integer proId;
    private Integer uId;
    private Integer cusId;
    private Integer detNumber;
    private Timestamp detTime;
    private String detRequire;
    private String detCondition;
    private String detRemark;
    private Orders orders;
    private Product product;
    private User user;
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
    @Column(name = "ord_id")
    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderdetail that = (Orderdetail) o;
        return detId == that.detId &&
                Objects.equals(ordId, that.ordId) &&
                Objects.equals(proId, that.proId) &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(detNumber, that.detNumber) &&
                Objects.equals(detTime, that.detTime) &&
                Objects.equals(detRequire, that.detRequire) &&
                Objects.equals(detCondition, that.detCondition) &&
                Objects.equals(detRemark, that.detRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detId, ordId, proId, uId, cusId, detNumber, detTime, detRequire, detCondition, detRemark);
    }

    @ManyToOne
    @JoinColumn(name = "ord_id", referencedColumnName = "ord_id")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
