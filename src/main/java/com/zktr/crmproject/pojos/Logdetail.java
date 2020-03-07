package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Logdetail {
    private int logdId;
    private String play;
    private Integer uId;
    @JsonIgnoreProperties("logdetail")
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


    @ManyToOne
    @JoinColumn(name="log_id",referencedColumnName = "log_id")
    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }
}
