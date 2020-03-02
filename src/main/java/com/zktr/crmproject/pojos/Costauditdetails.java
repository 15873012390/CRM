package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Costauditdetails {
    private int cadId;
    private int caId;
    private int uId;
    private Timestamp cadTime;
    private int adOperation;
    private Costaudit costaudit;
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
    @Column(name = "ca_id")
    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    @Basic
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costauditdetails that = (Costauditdetails) o;
        return cadId == that.cadId &&
                caId == that.caId &&
                uId == that.uId &&
                adOperation == that.adOperation &&
                Objects.equals(cadTime, that.cadTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadId, caId, uId, cadTime, adOperation);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cd_id", nullable = false)
    public Costaudit getCostaudit() {
        return costaudit;
    }

    public void setCostaudit(Costaudit costaudit) {
        this.costaudit = costaudit;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
