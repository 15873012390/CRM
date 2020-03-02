package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Customerupdatelog {
    private int culId;
    private Integer cusId;
    private Integer operationUid;
    private String operationField;
    private Timestamp culTime;
    private String culContents;
    private User user;
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
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "operation_uid")
    public Integer getOperationUid() {
        return operationUid;
    }

    public void setOperationUid(Integer operationUid) {
        this.operationUid = operationUid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customerupdatelog that = (Customerupdatelog) o;
        return culId == that.culId &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(operationUid, that.operationUid) &&
                Objects.equals(operationField, that.operationField) &&
                Objects.equals(culTime, that.culTime) &&
                Objects.equals(culContents, that.culContents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(culId, cusId, operationUid, operationField, culTime, culContents);
    }

    @ManyToOne
    @JoinColumn(name = "operation_uid", referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
