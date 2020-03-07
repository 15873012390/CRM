package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Customerupdatelog {
    private int culId;
    private String operationField;
    private Timestamp culTime;
    private String culContents;
    @JsonIgnoreProperties("customerupdatelog")
    private User user;
    @JsonIgnoreProperties("customerupdatelog")
    private Customer customer;

    @Id
    @Column(name = "cul_id")
    public int getCulId() {
        return culId;
    }

    public void setCulId(int culId) {
        this.culId = culId;
    }

    @Basic
    @Column(name = "operation_field")
    public String getOperationField() {
        return operationField;
    }

    public void setOperationField(String operationField) {
        this.operationField = operationField;
    }

    @Basic
    @Column(name = "cul_time")
    public Timestamp getCulTime() {
        return culTime;
    }

    public void setCulTime(Timestamp culTime) {
        this.culTime = culTime;
    }

    @Basic
    @Column(name = "cul_contents")
    public String getCulContents() {
        return culContents;
    }

    public void setCulContents(String culContents) {
        this.culContents = culContents;
    }

    @ManyToOne
    @JoinColumn(name="operation_uid",referencedColumnName = "u_id")
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
