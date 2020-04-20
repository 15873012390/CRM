package com.zktr.crmproject.pojos;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Audit {
    private int audId;
    private String audTheme;
    private Integer audType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp audTime;
    private int audStatus;
    private int delStatus;
    private User user;
    @JsonIgnoreProperties("audit")
    private List<Purchaseplan> purchaseplan;
    @JsonIgnoreProperties("audit")
    private List<Purchaseorder> purchaseorder;
    @JsonIgnoreProperties("audit")
    private List<Purchaseenter> purchaseenter;
    @JsonIgnoreProperties("audit")
    private List<Evection> evection;
    @JsonIgnoreProperties("audit")
    private List<Quote> quote;
    @JsonIgnoreProperties("audit")
    private List<Auditdetails> auditdetails;

    @Id
    @Column(name = "aud_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAudId() {
        return audId;
    }

    public void setAudId(int audId) {
        this.audId = audId;
    }

    @Basic
    @Column(name = "aud_theme")
    public String getAudTheme() {
        return audTheme;
    }

    public void setAudTheme(String audTheme) {
        this.audTheme = audTheme;
    }

    @Basic
    @Column(name = "aud_type")
    public Integer getAudType() {
        return audType;
    }

    public void setAudType(Integer audType) {
        this.audType = audType;
    }

    @Basic
    @Column(name = "aud_time")
    public Timestamp getAudTime() {
        return audTime;
    }

    public void setAudTime(Timestamp audTime) {
        this.audTime = audTime;
    }

    @Basic
    @Column(name = "aud_status")
    public int getAudStatus() {
        return audStatus;
    }

    public void setAudStatus(int audStatus) {
        this.audStatus = audStatus;
    }

    @Basic
    @Column(name = "del_status")
    public int getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(int delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audit audit = (Audit) o;
        return audId == audit.audId &&
                audStatus == audit.audStatus &&
                delStatus == audit.delStatus &&
                Objects.equals(audTheme, audit.audTheme) &&
                Objects.equals(audType, audit.audType) &&
                Objects.equals(audTime, audit.audTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(audId, audTheme, audType, audTime, audStatus, delStatus);
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "audit")
    public List<Purchaseplan> getPurchaseplan() {
        return purchaseplan;
    }

    public void setPurchaseplan(List<Purchaseplan> purchaseplan) {
        this.purchaseplan = purchaseplan;
    }

    @OneToMany(mappedBy = "audit" )
    public List<Purchaseorder> getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(List<Purchaseorder> purchaseorder) {
        this.purchaseorder = purchaseorder;
    }

    @OneToMany(mappedBy = "audit")
    public List<Purchaseenter> getPurchaseenter() {
        return purchaseenter;
    }

    public void setPurchaseenter(List<Purchaseenter> purchaseenter) {
        this.purchaseenter = purchaseenter;
    }

    @OneToMany(mappedBy = "audit")
    public List<Evection> getEvection() {
        return evection;
    }

    public void setEvection(List<Evection> evection) {
        this.evection = evection;
    }

    @OneToMany(mappedBy = "audit")
    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }

    @OneToMany(mappedBy = "audit")
    public List<Auditdetails> getAuditdetails() {
        return auditdetails;
    }

    public void setAuditdetails(List<Auditdetails> auditdetails) {
        this.auditdetails = auditdetails;
    }

    public Audit() {
    }


}
