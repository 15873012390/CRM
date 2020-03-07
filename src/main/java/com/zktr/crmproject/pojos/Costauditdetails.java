package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Costauditdetails {
    private int cadId;
    private Timestamp cadTime;
    private int adOperation;
    @JsonIgnoreProperties("costauditdetails")
    private Costaudit costaudit;
    @JsonIgnoreProperties("costauditdetails")
    private User user;

    @Id
    @Column(name = "cad_id")
    public int getCadId() {
        return cadId;
    }

    public void setCadId(int cadId) {
        this.cadId = cadId;
    }


    @Basic
    @Column(name = "cad_time")
    public Timestamp getCadTime() {
        return cadTime;
    }

    public void setCadTime(Timestamp cadTime) {
        this.cadTime = cadTime;
    }

    @Basic
    @Column(name = "ad_operation")
    public int getAdOperation() {
        return adOperation;
    }

    public void setAdOperation(int adOperation) {
        this.adOperation = adOperation;
    }

    @ManyToOne
    @JoinColumn(name="ca_id",referencedColumnName = "ca_id", nullable = false)
    public Costaudit getCostaudit() {
        return costaudit;
    }

    public void setCostaudit(Costaudit costaudit) {
        this.costaudit = costaudit;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
