package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Auditdetails {
    private int adId;
    private int audId;
    private int uId;
    private String adOpinion;
    private Timestamp adTime;
    private int adOperation;
    private Audit audit;
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
    @Column(name = "aud_id")
    public int getAudId() {
        return audId;
    }

    public void setAudId(int audId) {
        this.audId = audId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditdetails that = (Auditdetails) o;
        return adId == that.adId &&
                audId == that.audId &&
                uId == that.uId &&
                adOperation == that.adOperation &&
                Objects.equals(adOpinion, that.adOpinion) &&
                Objects.equals(adTime, that.adTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, audId, uId, adOpinion, adTime, adOperation);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "aud_id", nullable = false)
    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
