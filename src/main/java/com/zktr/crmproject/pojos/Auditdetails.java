package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Auditdetails {
    private int adId;
    private String adOpinion;
    private Timestamp adTime;
    private int adOperation;
    @JsonIgnoreProperties("auditdetails")
    private Audit audit;
    @JsonIgnoreProperties("auditdetails")
    private User user;

    @Id
    @Column(name = "ad_id")
    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }


    @Basic
    @Column(name = "ad_opinion")
    public String getAdOpinion() {
        return adOpinion;
    }

    public void setAdOpinion(String adOpinion) {
        this.adOpinion = adOpinion;
    }

    @Basic
    @Column(name = "ad_time")
    public Timestamp getAdTime() {
        return adTime;
    }

    public void setAdTime(Timestamp adTime) {
        this.adTime = adTime;
    }

    @Basic
    @Column(name = "ad_operation")
    public int getAdOperation() {
        return adOperation;
    }

    public void setAdOperation(int adOperation) {
        this.adOperation = adOperation;
    }

    @ManyToOne
    @JoinColumn(name="aud_id",referencedColumnName = "aud_id", nullable = false)
    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
