package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Purchasereturn {
    private int preturnId;
    private String preturnNumber;
    private Integer supplierId;
    private Timestamp preturnTime;
    private String shipper;
    private String operator;
    private Timestamp enterTime;
    private String alterPerson;
    private Integer audId;
    private String remarks;
    private Supplier supplier;
    private List<Pcrdetail> pcrdetail;
    private List<Paid> paid;
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
    @Column(name = "supplier_id")
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchasereturn that = (Purchasereturn) o;
        return preturnId == that.preturnId &&
                Objects.equals(preturnNumber, that.preturnNumber) &&
                Objects.equals(supplierId, that.supplierId) &&
                Objects.equals(preturnTime, that.preturnTime) &&
                Objects.equals(shipper, that.shipper) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(enterTime, that.enterTime) &&
                Objects.equals(alterPerson, that.alterPerson) &&
                Objects.equals(audId, that.audId) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preturnId, preturnNumber, supplierId, preturnTime, shipper, operator, enterTime, alterPerson, audId, remarks);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "supplier_id")
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
