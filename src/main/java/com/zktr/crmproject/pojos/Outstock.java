package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Outstock {
    private int outId;
    private String outNumber;
    private String status;
    private Integer cusId;
    private String payWay;
    private Integer preturnId;
    private Integer consignorId;
    private String deliveryAddress;
    private String passPerson;
    private Timestamp passTime;
    private Integer orderId;
    private String remarks;
    private Customer customer;
    private Purchasereturn purchasereturn;
    private Warehouse warehouse;
    private Orders orders;
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
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
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
    @Column(name = "preturn_id")
    public Integer getPreturnId() {
        return preturnId;
    }

    public void setPreturnId(Integer preturnId) {
        this.preturnId = preturnId;
    }

    @Basic
    @Column(name = "consignor_id")
    public Integer getConsignorId() {
        return consignorId;
    }

    public void setConsignorId(Integer consignorId) {
        this.consignorId = consignorId;
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
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        Outstock outstock = (Outstock) o;
        return outId == outstock.outId &&
                Objects.equals(outNumber, outstock.outNumber) &&
                Objects.equals(status, outstock.status) &&
                Objects.equals(cusId, outstock.cusId) &&
                Objects.equals(payWay, outstock.payWay) &&
                Objects.equals(preturnId, outstock.preturnId) &&
                Objects.equals(consignorId, outstock.consignorId) &&
                Objects.equals(deliveryAddress, outstock.deliveryAddress) &&
                Objects.equals(passPerson, outstock.passPerson) &&
                Objects.equals(passTime, outstock.passTime) &&
                Objects.equals(orderId, outstock.orderId) &&
                Objects.equals(remarks, outstock.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outId, outNumber, status, cusId, payWay, preturnId, consignorId, deliveryAddress, passPerson, passTime, orderId, remarks);
    }

    @ManyToOne
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "preturn_id", referencedColumnName = "preturn_id")
    public Purchasereturn getPurchasereturn() {
        return purchasereturn;
    }

    public void setPurchasereturn(Purchasereturn purchasereturn) {
        this.purchasereturn = purchasereturn;
    }

    @ManyToOne
    @JoinColumn(name = "consignor_id", referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "ord_id")
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
