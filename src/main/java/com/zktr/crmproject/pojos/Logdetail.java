package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Logdetail {
    private int logdId;
    private Integer logId;
    private String play;
    private Integer uId;
    private Log log;

    @Id
    @Column(name = "logd_id")
    public int getLogdId() {
        return logdId;
    }

    public void setLogdId(int logdId) {
        this.logdId = logdId;
    }

    @Basic
    @Column(name = "log_id")
    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "play")
    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    @Basic
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logdetail logdetail = (Logdetail) o;
        return logdId == logdetail.logdId &&
                Objects.equals(logId, logdetail.logId) &&
                Objects.equals(play, logdetail.play) &&
                Objects.equals(uId, logdetail.uId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logdId, logId, play, uId);
    }

    @ManyToOne
    @JoinColumn(name = "log_id", referencedColumnName = "log_id")
    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }
}
