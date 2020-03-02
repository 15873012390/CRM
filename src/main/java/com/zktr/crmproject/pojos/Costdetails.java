package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Costdetails {
    private int cdId;
    private int cosId;
    private int unitPrice;
    private int cdType;
    private String cdUse;
    private Timestamp cdTime;
    private int cdAudit;
    private int reimburse;
    private Cost cost;
    private List<Costaudit> costaudit;

    @Id
    @Column(name = "cd_id")
    public int getCdId() {
        return cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    @Basic
    @Column(name = "cos_id")
    public int getCosId() {
        return cosId;
    }

    public void setCosId(int cosId) {
        this.cosId = cosId;
    }

    @Basic
    @Column(name = "unit_price")
    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "cd_type")
    public int getCdType() {
        return cdType;
    }

    public void setCdType(int cdType) {
        this.cdType = cdType;
    }

    @Basic
    @Column(name = "cd_use")
    public String getCdUse() {
        return cdUse;
    }

    public void setCdUse(String cdUse) {
        this.cdUse = cdUse;
    }

    @Basic
    @Column(name = "cd_time")
    public Timestamp getCdTime() {
        return cdTime;
    }

    public void setCdTime(Timestamp cdTime) {
        this.cdTime = cdTime;
    }

    @Basic
    @Column(name = "cd_audit")
    public int getCdAudit() {
        return cdAudit;
    }

    public void setCdAudit(int cdAudit) {
        this.cdAudit = cdAudit;
    }

    @Basic
    @Column(name = "reimburse")
    public int getReimburse() {
        return reimburse;
    }

    public void setReimburse(int reimburse) {
        this.reimburse = reimburse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costdetails that = (Costdetails) o;
        return cdId == that.cdId &&
                cosId == that.cosId &&
                unitPrice == that.unitPrice &&
                cdType == that.cdType &&
                cdAudit == that.cdAudit &&
                reimburse == that.reimburse &&
                Objects.equals(cdUse, that.cdUse) &&
                Objects.equals(cdTime, that.cdTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdId, cosId, unitPrice, cdType, cdUse, cdTime, cdAudit, reimburse);
    }

    @ManyToOne
    @JoinColumn(name = "cos_id", referencedColumnName = "cos_id", nullable = false)
    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    @OneToMany(mappedBy = "costdetails")
    public List<Costaudit> getCostaudit() {
        return costaudit;
    }

    public void setCostaudit(List<Costaudit> costaudit) {
        this.costaudit = costaudit;
    }
}
