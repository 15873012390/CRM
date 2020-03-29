package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Customertransfer {
    private int ctId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp ctTime;
    private Customer customer;
    @JsonIgnoreProperties("customertransfer3")
    private User user3;
    @JsonIgnoreProperties("customertransfer2")
    private User user2;
    @JsonIgnoreProperties("customertransfer1")
    private User user1;

    public Customertransfer() {
    }

    public Customertransfer(int ctId, Timestamp ctTime, Customer customer, User user3, User user2, User user1) {
        this.ctId = ctId;
        this.ctTime = ctTime;
        this.customer = customer;
        this.user3 = user3;
        this.user2 = user2;
        this.user1 = user1;
    }

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

    @ManyToOne
    @JoinColumn(name="original_u_id",referencedColumnName = "u_id")
    public User getUser3() {
        return user3;
    }

    public void setUser3(User user3) {
        this.user3 = user3;
    }

    @ManyToOne
    @JoinColumn(name="now_u_id",referencedColumnName = "u_id")
    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    @ManyToOne
    @JoinColumn(name="operation_u_id",referencedColumnName = "u_id")
    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }
}
