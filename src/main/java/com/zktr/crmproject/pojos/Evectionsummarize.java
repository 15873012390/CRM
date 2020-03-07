package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Evectionsummarize {
    private int esId;
    private Timestamp esRecordTime;
    private String esContent;
    @JsonIgnoreProperties("evectionsummarize")
    private Evection evection;
    @JsonIgnoreProperties("evectionsummarize")
    private User user;

    @Id
    @Column(name = "es_id")
    public int getEsId() {
        return esId;
    }

    public void setEsId(int esId) {
        this.esId = esId;
    }

    @Basic
    @Column(name = "es_record_time")
    public Timestamp getEsRecordTime() {
        return esRecordTime;
    }

    public void setEsRecordTime(Timestamp esRecordTime) {
        this.esRecordTime = esRecordTime;
    }

    @Basic
    @Column(name = "es_content")
    public String getEsContent() {
        return esContent;
    }

    public void setEsContent(String esContent) {
        this.esContent = esContent;
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
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
