package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Customertransfer {
    private int ctId;
    private Integer cusId;
    private Integer originalUId;
    private Integer nowUId;
    private Timestamp ctTime;
    private String ctRemarks;
    private Integer operationUId;
    private Customer customer;
    private User user3;
    private User user2;
    private User user1;

    @Id
    @Column(name = "ct_id")
    public int getCtId() {
        return ctId;
    }

    public void setCtId(int ctId) {
        this.ctId = ctId;
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
    @Column(name = "original_u_id")
    public Integer getOriginalUId() {
        return originalUId;
    }

    public void setOriginalUId(Integer originalUId) {
        this.originalUId = originalUId;
    }

    @Basic
    @Column(name = "now_u_id")
    public Integer getNowUId() {
        return nowUId;
    }

    public void setNowUId(Integer nowUId) {
        this.nowUId = nowUId;
    }

    @Basic
    @Column(name = "ct_time")
    public Timestamp getCtTime() {
        return ctTime;
    }

    public void setCtTime(Timestamp ctTime) {
        this.ctTime = ctTime;
    }

    @Basic
    @Column(name = "ct_remarks")
    public String getCtRemarks() {
        return ctRemarks;
    }

    public void setCtRemarks(String ctRemarks) {
        this.ctRemarks = ctRemarks;
    }

    @Basic
    @Column(name = "operation_u_id")
    public Integer getOperationUId() {
        return operationUId;
    }

    public void setOperationUId(Integer operationUId) {
        this.operationUId = operationUId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customertransfer that = (Customertransfer) o;
        return ctId == that.ctId &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(originalUId, that.originalUId) &&
                Objects.equals(nowUId, that.nowUId) &&
                Objects.equals(ctTime, that.ctTime) &&
                Objects.equals(ctRemarks, that.ctRemarks) &&
                Objects.equals(operationUId, that.operationUId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ctId, cusId, originalUId, nowUId, ctTime, ctRemarks, operationUId);
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
    @JoinColumn(name = "now_u_id", referencedColumnName = "u_id")
    public User getUser3() {
        return user3;
    }

    public void setUser3(User user3) {
        this.user3 = user3;
    }

    @ManyToOne
    @JoinColumn(name = "operation_u_id", referencedColumnName = "u_id")
    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    @ManyToOne
    @JoinColumn(name = "original_u_id", referencedColumnName = "u_id")
    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }
}
