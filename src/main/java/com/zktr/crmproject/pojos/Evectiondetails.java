package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Evectiondetails {
    private int edId;
    @JsonIgnoreProperties("eventiondetails")
    private Evection evection;
    @JsonIgnoreProperties("eventiondetails")
    private Customer customer;

    @Id
    @Column(name = "ed_id")
    public int getEdId() {
        return edId;
    }

    public void setEdId(int edId) {
        this.edId = edId;
    }

    @ManyToOne
    @JoinColumn(name="eve_id",referencedColumnName = "eve_id", nullable = false)
    public Evection getEvection() {
        return evection;
    }

    public void setEvection(Evection evection) {
        this.evection = evection;
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
