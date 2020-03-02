package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Evectionsummarize {
    private int esId;
    private int eveId;
    private Integer uId;
    private Timestamp esRecordTime;
    private String esContent;
    private Evection evection;
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
    @Column(name = "eve_id")
    public int getEveId() {
        return eveId;
    }

    public void setEveId(int eveId) {
        this.eveId = eveId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evectionsummarize that = (Evectionsummarize) o;
        return esId == that.esId &&
                eveId == that.eveId &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(esRecordTime, that.esRecordTime) &&
                Objects.equals(esContent, that.esContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(esId, eveId, uId, esRecordTime, esContent);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "eve_id", nullable = false)
    public Evection getEvection() {
        return evection;
    }

    public void setEvection(Evection evection) {
        this.evection = evection;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
