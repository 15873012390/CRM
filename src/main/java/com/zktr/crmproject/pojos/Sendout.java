package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Sendout {
    private int senId;
    private String senReceiving;
    private Timestamp senDate;
    private Integer senFreight;
    private String senState;
    private String senWay;
    private String senRemark;
    private Integer senDelState;
    @JsonIgnoreProperties("sendout")
    private Customer customer;
    @JsonIgnoreProperties("sendout")
    private Orders orders;
    @JsonIgnoreProperties("sendout")
    private List<Sendoutdetial> sendoutdetial;

    @Id
    @Column(name = "sen_id")
    public int getSenId() {
        return senId;
    }

    public void setSenId(int senId) {
        this.senId = senId;
    }

    @Basic
    @Column(name = "sen_receiving")
    public String getSenReceiving() {
        return senReceiving;
    }

    public void setSenReceiving(String senReceiving) {
        this.senReceiving = senReceiving;
    }

    @Basic
    @Column(name = "sen_date")
    public Timestamp getSenDate() {
        return senDate;
    }

    public void setSenDate(Timestamp senDate) {
        this.senDate = senDate;
    }

    @Basic
    @Column(name = "sen_freight")
    public Integer getSenFreight() {
        return senFreight;
    }

    public void setSenFreight(Integer senFreight) {
        this.senFreight = senFreight;
    }

    @Basic
    @Column(name = "sen_state")
    public String getSenState() {
        return senState;
    }

    public void setSenState(String senState) {
        this.senState = senState;
    }

    @Basic
    @Column(name = "sen_way")
    public String getSenWay() {
        return senWay;
    }

    public void setSenWay(String senWay) {
        this.senWay = senWay;
    }

    @Basic
    @Column(name = "sen_remark")
    public String getSenRemark() {
        return senRemark;
    }

    public void setSenRemark(String senRemark) {
        this.senRemark = senRemark;
    }

    @Basic
    @Column(name = "sen_del_state")
    public Integer getSenDelState() {
        return senDelState;
    }

    public void setSenDelState(Integer senDelState) {
        this.senDelState = senDelState;
    }

    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="ord_id",referencedColumnName = "ord_id")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @OneToMany(mappedBy = "sendout")
    public List<Sendoutdetial> getSendoutdetial() {
        return sendoutdetial;
    }

    public void setSendoutdetial(List<Sendoutdetial> sendoutdetial) {
        this.sendoutdetial = sendoutdetial;
    }
}
