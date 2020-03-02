package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Evectionlog {
    private int elId;
    private int eveId;
    private Timestamp recordTime;
    private String elContent;
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
    @Column(name = "eve_id")
    public int getEveId() {
        return eveId;
    }

    public void setEveId(int eveId) {
        this.eveId = eveId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evectionlog that = (Evectionlog) o;
        return elId == that.elId &&
                eveId == that.eveId &&
                Objects.equals(recordTime, that.recordTime) &&
                Objects.equals(elContent, that.elContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elId, eveId, recordTime, elContent);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "eve_id", nullable = false)
    public Evection getEvection() {
        return evection;
    }

    public void setEvection(Evection evection) {
        this.evection = evection;
    }
}
