package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Backlogtaskdetails {
    private int btdId;
    private Timestamp finishTime;
    private int status;
    @JsonIgnoreProperties("backlogtaskdetails")
    private Backlogtask backlogtask;
    @JsonIgnoreProperties("backlogtaskdetails")
    private User user;

    @Id
    @Column(name = "btd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBtdId() {
        return btdId;
    }

    public void setBtdId(int btdId) {
        this.btdId = btdId;
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

    @ManyToOne
    @JoinColumn(name="blt_id",referencedColumnName = "blt_id", nullable = false)
    public Backlogtask getBacklogtask() {
        return backlogtask;
    }

    public void setBacklogtask(Backlogtask backlogtask) {
        this.backlogtask = backlogtask;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
