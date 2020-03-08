package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Cost {
    private int cosId;
    private BigDecimal totaMoney;
    private int cosType;
    private int delStatus;
    @JsonIgnoreProperties("cost")
    private List<Evection> evection;
    @JsonIgnoreProperties("cost")
    private List<Costdetails> costdetails;

    @Id
    @Column(name = "cos_id")
    public int getCosId() {
        return cosId;
    }

    public void setCosId(int cosId) {
        this.cosId = cosId;
    }

    @Basic
    @Column(name = "tota_money")
    public BigDecimal getTotaMoney() {
        return totaMoney;
    }

    public void setTotaMoney(BigDecimal totaMoney) {
        this.totaMoney = totaMoney;
    }

    @Basic
    @Column(name = "cos_type")
    public int getCosType() {
        return cosType;
    }

    public void setCosType(int cosType) {
        this.cosType = cosType;
    }

    @Basic
    @Column(name = "del_status")
    public int getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(int delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost = (Cost) o;
        return cosId == cost.cosId &&
                totaMoney == cost.totaMoney &&
                cosType == cost.cosType &&
                delStatus == cost.delStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cosId, totaMoney, cosType, delStatus);
    }

    @OneToMany(mappedBy = "cost")
    public List<Evection> getEvection() {
        return evection;
    }

    public void setEvection(List<Evection> evection) {
        this.evection = evection;
    }

    @OneToMany(mappedBy = "cost")
    public List<Costdetails> getCostdetails() {
        return costdetails;
    }

    public void setCostdetails(List<Costdetails> costdetails) {
        this.costdetails = costdetails;
    }
}
