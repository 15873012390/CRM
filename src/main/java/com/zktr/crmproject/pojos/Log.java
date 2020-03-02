package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Log {
    private int logId;
    private Integer uId;
    private Timestamp loginTime;
    private Timestamp outTime;
    private User user;
    private List<Logdetail> logdetail;

    @Id
    @Column(name = "log_id")
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "login_time")
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "out_time")
    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return logId == log.logId &&
                Objects.equals(uId, log.uId) &&
                Objects.equals(loginTime, log.loginTime) &&
                Objects.equals(outTime, log.outTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, uId, loginTime, outTime);
    }

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "log")
    public List<Logdetail> getLogdetail() {
        return logdetail;
    }

    public void setLogdetail(List<Logdetail> logdetail) {
        this.logdetail = logdetail;
    }
}
