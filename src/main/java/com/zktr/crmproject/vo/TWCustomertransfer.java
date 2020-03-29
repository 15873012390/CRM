package com.zktr.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zktr.crmproject.pojos.Customer;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class TWCustomertransfer {
    private int ctId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp ctTime;
    private Customer customer;
    private int original_u_id,now_u_id,operation_u_id;

    @Id
    @Column(name = "ct_id")
    public int getCtId() {
        return ctId;
    }

    public void setCtId(int ctId) {
        this.ctId = ctId;
    }
    @Basic
    @Column(name = "ct_time")
    public Timestamp getCtTime() {
        return ctTime;
    }

    public void setCtTime(Timestamp ctTime) {
        this.ctTime = ctTime;
    }
    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Basic
    @Column(name = "original_u_id")
    public int getOriginal_u_id() {
        return original_u_id;
    }

    public void setOriginal_u_id(int original_u_id) {
        this.original_u_id = original_u_id;
    }
    @Basic
    @Column(name = "now_u_id")
    public int getNow_u_id() {
        return now_u_id;
    }

    public void setNow_u_id(int now_u_id) {
        this.now_u_id = now_u_id;
    }
    @Basic
    @Column(name = "operation_u_id")
    public int getOperation_u_id() {
        return operation_u_id;
    }

    public void setOperation_u_id(int operation_u_id) {
        this.operation_u_id = operation_u_id;
    }
}
