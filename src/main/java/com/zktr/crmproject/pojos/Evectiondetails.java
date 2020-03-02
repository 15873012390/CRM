package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Evectiondetails {
    private int edId;
    private int eveId;
    private Integer cusId;
    private Evection evection;
    private Customer customer;

    @Id
    @Column(name = "ed_id")
    public int getEdId() {
        return edId;
    }

    public void setEdId(int edId) {
        this.edId = edId;
    }

    @Basic
    @Column(name = "eve_id")
    public int getEveId() {
        return eveId;
    }

    public void setEveId(int eveId) {
        this.eveId = eveId;
    }

    @Basic
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evectiondetails that = (Evectiondetails) o;
        return edId == that.edId &&
                eveId == that.eveId &&
                Objects.equals(cusId, that.cusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edId, eveId, cusId);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "eve_id", nullable = false)
    public Evection getEvection() {
        return evection;
    }

    public void setEvection(Evection evection) {
        this.evection = evection;
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
