package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Backlogtaskdetails {
    private int btdId;
    private int bltId;
    private int uId;
    private Timestamp finishTime;
    private int status;
    private Backlogtask backlogtask;
    private User user;

    @Id
    @Column(name = "btd_id")
    public int getBtdId() {
        return btdId;
    }

    public void setBtdId(int btdId) {
        this.btdId = btdId;
    }

    @Basic
    @Column(name = "blt_id")
    public int getBltId() {
        return bltId;
    }

    public void setBltId(int bltId) {
        this.bltId = bltId;
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
    @Column(name = "finish_time")
    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backlogtaskdetails that = (Backlogtaskdetails) o;
        return btdId == that.btdId &&
                bltId == that.bltId &&
                uId == that.uId &&
                status == that.status &&
                Objects.equals(finishTime, that.finishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(btdId, bltId, uId, finishTime, status);
    }

    @ManyToOne
    @JoinColumn(name = "blt_id", referencedColumnName = "blt_id", nullable = false)
    public Backlogtask getBacklogtask() {
        return backlogtask;
    }

    public void setBacklogtask(Backlogtask backlogtask) {
        this.backlogtask = backlogtask;
    }

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
