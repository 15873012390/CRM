package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Contacts {
    private int conId;
    private Integer cusId;
    private String conName;
    private String conTel;
    private String conMobile;
    private Timestamp conTime;
    private String conSex;
    private String conPosition;
    private String conRemarks;
    private Customer customer;

    @Id
    @Column(name = "con_id")
    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
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
    @Column(name = "con_name")
    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    @Basic
    @Column(name = "con_tel")
    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel;
    }

    @Basic
    @Column(name = "con_mobile")
    public String getConMobile() {
        return conMobile;
    }

    public void setConMobile(String conMobile) {
        this.conMobile = conMobile;
    }

    @Basic
    @Column(name = "con_time")
    public Timestamp getConTime() {
        return conTime;
    }

    public void setConTime(Timestamp conTime) {
        this.conTime = conTime;
    }

    @Basic
    @Column(name = "con_sex")
    public String getConSex() {
        return conSex;
    }

    public void setConSex(String conSex) {
        this.conSex = conSex;
    }

    @Basic
    @Column(name = "con_position")
    public String getConPosition() {
        return conPosition;
    }

    public void setConPosition(String conPosition) {
        this.conPosition = conPosition;
    }

    @Basic
    @Column(name = "con_remarks")
    public String getConRemarks() {
        return conRemarks;
    }

    public void setConRemarks(String conRemarks) {
        this.conRemarks = conRemarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return conId == contacts.conId &&
                Objects.equals(cusId, contacts.cusId) &&
                Objects.equals(conName, contacts.conName) &&
                Objects.equals(conTel, contacts.conTel) &&
                Objects.equals(conMobile, contacts.conMobile) &&
                Objects.equals(conTime, contacts.conTime) &&
                Objects.equals(conSex, contacts.conSex) &&
                Objects.equals(conPosition, contacts.conPosition) &&
                Objects.equals(conRemarks, contacts.conRemarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conId, cusId, conName, conTel, conMobile, conTime, conSex, conPosition, conRemarks);
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
