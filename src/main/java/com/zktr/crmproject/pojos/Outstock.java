package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Outstock {
    private int outId;
    private String outNumber;
    private String status;
    private String payWay;
    private String deliveryAddress;
    private String passPerson;
    private Timestamp passTime;
    private String remarks;
    @JsonIgnoreProperties("outstock")
    private Customer customer;
    @JsonIgnoreProperties("outstock")
    private Purchasereturn purchasereturn;
    @JsonIgnoreProperties("outstock")
    private Warehouse warehouse;
    @JsonIgnoreProperties("outstock")
    private Orders orders;
    @JsonIgnoreProperties("outstock")
    private List<Outstockdetails> outstockdetail;

    @Id
    @Column(name = "out_id")
    public int getOutId() {
        return outId;
    }

    public void setOutId(int outId) {
        this.outId = outId;
    }

    @Basic
    @Column(name = "out_number")
    public String getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(String outNumber) {
        this.outNumber = outNumber;
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
    @Column(name = "pay_way")
    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    @Basic
    @Column(name = "delivery_address")
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Basic
    @Column(name = "pass_person")
    public String getPassPerson() {
        return passPerson;
    }

    public void setPassPerson(String passPerson) {
        this.passPerson = passPerson;
    }

    @Basic
    @Column(name = "pass_time")
    public Timestamp getPassTime() {
        return passTime;
    }

    public void setPassTime(Timestamp passTime) {
        this.passTime = passTime;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
    @JoinColumn(name="preturn_id",referencedColumnName = "preturn_id")
    public Purchasereturn getPurchasereturn() {
        return purchasereturn;
    }

    public void setPurchasereturn(Purchasereturn purchasereturn) {
        this.purchasereturn = purchasereturn;
    }

    @ManyToOne
    @JoinColumn(name="warehouse_id",referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(name="ord_id",referencedColumnName = "ord_id")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @OneToMany(mappedBy = "outstock")
    public List<Outstockdetails> getOutstockdetail() {
        return outstockdetail;
    }

    public void setOutstockdetail(List<Outstockdetails> outstockdetail) {
        this.outstockdetail = outstockdetail;
    }
}
