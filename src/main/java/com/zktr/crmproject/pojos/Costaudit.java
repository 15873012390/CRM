package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Costaudit {
    private int caId;
    private String caContent;
    private Timestamp caTime;
    private Integer approvalStatus;
    private Integer delStatus;
    @JsonIgnoreProperties("costaudit")
    private Costdetails costdetails;
    @JsonIgnoreProperties("costaudit")
    private User user;
    @JsonIgnoreProperties("costaudit")
    private List<Costauditdetails> costauditdetails;

    @Id
    @Column(name = "ca_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
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

    @ManyToOne
    @JoinColumn(name = "cd_id",referencedColumnName = "cd_id")
    public Costdetails getCostdetails() {
        return costdetails;
    }

    public void setCostdetails(Costdetails costdetails) {
        this.costdetails = costdetails;
    }

    @ManyToOne
    @JoinColumn(name = "u_id",referencedColumnName = "u_id")
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
