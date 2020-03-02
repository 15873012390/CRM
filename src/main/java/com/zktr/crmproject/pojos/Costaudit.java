package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Costaudit {
    private int costAudit;
    private Integer cdId;
    private Integer uId;
    private String caContent;
    private Timestamp caTime;
    private Integer approvalStatus;
    private Integer delStatus;
    private Costdetails costdetails;
    private User user;
    private List<Costauditdetails> costauditdetails;

    @Id
    @Column(name = "costAudit")
    public int getCostAudit() {
        return costAudit;
    }

    public void setCostAudit(int costAudit) {
        this.costAudit = costAudit;
    }

    @Basic
    @Column(name = "cd_id")
    public Integer getCdId() {
        return cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
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
    @Column(name = "ca_content")
    public String getCaContent() {
        return caContent;
    }

    public void setCaContent(String caContent) {
        this.caContent = caContent;
    }

    @Basic
    @Column(name = "ca_time")
    public Timestamp getCaTime() {
        return caTime;
    }

    public void setCaTime(Timestamp caTime) {
        this.caTime = caTime;
    }

    @Basic
    @Column(name = "approval_status")
    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Basic
    @Column(name = "del_status")
    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costaudit costaudit = (Costaudit) o;
        return costAudit == costaudit.costAudit &&
                Objects.equals(cdId, costaudit.cdId) &&
                Objects.equals(uId, costaudit.uId) &&
                Objects.equals(caContent, costaudit.caContent) &&
                Objects.equals(caTime, costaudit.caTime) &&
                Objects.equals(approvalStatus, costaudit.approvalStatus) &&
                Objects.equals(delStatus, costaudit.delStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costAudit, cdId, uId, caContent, caTime, approvalStatus, delStatus);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cd_id")
    public Costdetails getCostdetails() {
        return costdetails;
    }

    public void setCostdetails(Costdetails costdetails) {
        this.costdetails = costdetails;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "costaudit")
    public List<Costauditdetails> getCostauditdetails() {
        return costauditdetails;
    }

    public void setCostauditdetails(List<Costauditdetails> costauditdetails) {
        this.costauditdetails = costauditdetails;
    }
}
