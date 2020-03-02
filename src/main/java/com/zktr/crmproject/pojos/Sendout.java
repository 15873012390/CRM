package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Sendout {
    private int senId;
    private Integer cusId;
    private Integer addId;
    private Integer ordId;
    private String senReceiving;
    private Timestamp senDate;
    private Integer senFreight;
    private String senState;
    private String senWay;
    private String senRemark;
    private Integer senDelState;
    private Customer customer;
    private Address address;
    private Orders orders;
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
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "add_id")
    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sendout sendout = (Sendout) o;
        return senId == sendout.senId &&
                Objects.equals(cusId, sendout.cusId) &&
                Objects.equals(addId, sendout.addId) &&
                Objects.equals(ordId, sendout.ordId) &&
                Objects.equals(senReceiving, sendout.senReceiving) &&
                Objects.equals(senDate, sendout.senDate) &&
                Objects.equals(senFreight, sendout.senFreight) &&
                Objects.equals(senState, sendout.senState) &&
                Objects.equals(senWay, sendout.senWay) &&
                Objects.equals(senRemark, sendout.senRemark) &&
                Objects.equals(senDelState, sendout.senDelState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senId, cusId, addId, ordId, senReceiving, senDate, senFreight, senState, senWay, senRemark, senDelState);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "add_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "ord_id")
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
