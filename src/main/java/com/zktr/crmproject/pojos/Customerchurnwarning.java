package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Customerchurnwarning {
    private int ccwId;
    private Timestamp churnTime;
    private Timestamp warningTel;
    private String ccwMeasures;
    private String ccwResult;
    private String ccwState;
    @JsonIgnoreProperties("customerchurnwarning")
    private Customer customer;

    @Id
    @Column(name = "ccw_id")
    public int getCcwId() {
        return ccwId;
    }

    public void setCcwId(int ccwId) {
        this.ccwId = ccwId;
    }


    @Basic
    @Column(name = "churn_time")
    public Timestamp getChurnTime() {
        return churnTime;
    }

    public void setChurnTime(Timestamp churnTime) {
        this.churnTime = churnTime;
    }

    @Basic
    @Column(name = "warning_tel")
    public Timestamp getWarningTel() {
        return warningTel;
    }

    public void setWarningTel(Timestamp warningTel) {
        this.warningTel = warningTel;
    }

    @Basic
    @Column(name = "ccw_measures")
    public String getCcwMeasures() {
        return ccwMeasures;
    }

    public void setCcwMeasures(String ccwMeasures) {
        this.ccwMeasures = ccwMeasures;
    }

    @Basic
    @Column(name = "ccw_result")
    public String getCcwResult() {
        return ccwResult;
    }

    public void setCcwResult(String ccwResult) {
        this.ccwResult = ccwResult;
    }

    @Basic
    @Column(name = "ccw_state")
    public String getCcwState() {
        return ccwState;
    }

    public void setCcwState(String ccwState) {
        this.ccwState = ccwState;
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
