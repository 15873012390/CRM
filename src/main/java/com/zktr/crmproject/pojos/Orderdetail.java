package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Orderdetail {
    private int detId;
    private Integer detNumber;
    private Timestamp detTime;
    private String detRequire;
    private String detCondition;
    private String detRemark;
    @JsonIgnoreProperties("orderdetail")
    private Orders orders;
    @JsonIgnoreProperties("orderdetail")
    private Product product;
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
    @JoinColumn(name="pro_id",referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
