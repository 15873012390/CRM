package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Customerchurnwarning {
    private int ccwId;
    private Integer cusId;
    private Timestamp churnTime;
    private Timestamp warningTel;
    private String ccwMeasures;
    private String ccwResult;
    private String ccwState;
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
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customerchurnwarning that = (Customerchurnwarning) o;
        return ccwId == that.ccwId &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(churnTime, that.churnTime) &&
                Objects.equals(warningTel, that.warningTel) &&
                Objects.equals(ccwMeasures, that.ccwMeasures) &&
                Objects.equals(ccwResult, that.ccwResult) &&
                Objects.equals(ccwState, that.ccwState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccwId, cusId, churnTime, warningTel, ccwMeasures, ccwResult, ccwState);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
