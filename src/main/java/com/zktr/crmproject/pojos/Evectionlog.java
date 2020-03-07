package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Evectionlog {
    private int elId;
    private Timestamp recordTime;
    private String elContent;
    @JsonIgnoreProperties("evectionlog")
    private Evection evection;

    @Id
    @Column(name = "el_id")
    public int getElId() {
        return elId;
    }

    public void setElId(int elId) {
        this.elId = elId;
    }

    @Basic
    @Column(name = "record_time")
    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "el_content")
    public String getElContent() {
        return elContent;
    }

    public void setElContent(String elContent) {
        this.elContent = elContent;
    }


    @ManyToOne
    @JoinColumn(name="eve_id",referencedColumnName = "eve_id", nullable = false)
    public Evection getEvection() {
        return evection;
    }

    public void setEvection(Evection evection) {
        this.evection = evection;
    }
}
