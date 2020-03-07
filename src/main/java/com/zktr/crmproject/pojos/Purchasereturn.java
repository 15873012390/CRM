package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Purchasereturn {
    private int preturnId;
    private String preturnNumber;
    private Timestamp preturnTime;
    private String shipper;
    private String operator;
    private Timestamp enterTime;
    private String alterPerson;
    private Integer audId;
    private String remarks;
    @JsonIgnoreProperties("purchasereturn")
    private Supplier supplier;
    @JsonIgnoreProperties("purchasereturn")
    private List<Pcrdetail> pcrdetail;
    @JsonIgnoreProperties("purchasereturn")
    private List<Paid> paid;
    @JsonIgnoreProperties("purchasereturn")
    private List<Outstock> outstock;

    @Id
    @Column(name = "preturn_id")
    public int getPreturnId() {
        return preturnId;
    }

    public void setPreturnId(int preturnId) {
        this.preturnId = preturnId;
    }

    @Basic
    @Column(name = "preturn_number")
    public String getPreturnNumber() {
        return preturnNumber;
    }

    public void setPreturnNumber(String preturnNumber) {
        this.preturnNumber = preturnNumber;
    }

    @Basic
    @Column(name = "preturn_time")
    public Timestamp getPreturnTime() {
        return preturnTime;
    }

    public void setPreturnTime(Timestamp preturnTime) {
        this.preturnTime = preturnTime;
    }

    @Basic
    @Column(name = "shipper")
    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "enter_time")
    public Timestamp getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
    }

    @Basic
    @Column(name = "alter_person")
    public String getAlterPerson() {
        return alterPerson;
    }

    public void setAlterPerson(String alterPerson) {
        this.alterPerson = alterPerson;
    }

    @Basic
    @Column(name = "aud_id")
    public Integer getAudId() {
        return audId;
    }

    public void setAudId(Integer audId) {
        this.audId = audId;
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
    @JoinColumn(name="supplier_id",referencedColumnName = "supplier_id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @OneToMany(mappedBy = "purchasereturn")
    public List<Pcrdetail> getPcrdetail() {
        return pcrdetail;
    }

    public void setPcrdetail(List<Pcrdetail> pcrdetail) {
        this.pcrdetail = pcrdetail;
    }

    @OneToMany(mappedBy = "purchasereturn")
    public List<Paid> getPaid() {
        return paid;
    }

    public void setPaid(List<Paid> paid) {
        this.paid = paid;
    }

    @OneToMany(mappedBy = "purchasereturn")
    public List<Outstock> getOutstock() {
        return outstock;
    }

    public void setOutstock(List<Outstock> outstock) {
        this.outstock = outstock;
    }
}
