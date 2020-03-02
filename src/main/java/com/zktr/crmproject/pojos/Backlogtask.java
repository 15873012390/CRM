package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Backlogtask {
    private int bltId;
    private String bltDescription;
    private Date finishDate;
    private Time finishTime;
    private Integer precedence;
    private Integer cusId;
    private String conName;
    private String conPhone;
    private Integer creator;
    private Integer status;
    private Timestamp creationTime;
    private Integer delStatus;
    private Customer customer;
    private User user;
    private List<Backlogtaskdetails> backlogtaskdetails;

    @Id
    @Column(name = "blt_id")
    public int getBltId() {
        return bltId;
    }

    public void setBltId(int bltId) {
        this.bltId = bltId;
    }

    @Basic
    @Column(name = "blt_description")
    public String getBltDescription() {
        return bltDescription;
    }

    public void setBltDescription(String bltDescription) {
        this.bltDescription = bltDescription;
    }

    @Basic
    @Column(name = "finish_date")
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Basic
    @Column(name = "finish_time")
    public Time getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Time finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "precedence")
    public Integer getPrecedence() {
        return precedence;
    }

    public void setPrecedence(Integer precedence) {
        this.precedence = precedence;
    }

    @Basic
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "con_name")
    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    @Basic
    @Column(name = "con_phone")
    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    @Basic
    @Column(name = "creator")
    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "creation_time")
    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
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
        Backlogtask that = (Backlogtask) o;
        return bltId == that.bltId &&
                Objects.equals(bltDescription, that.bltDescription) &&
                Objects.equals(finishDate, that.finishDate) &&
                Objects.equals(finishTime, that.finishTime) &&
                Objects.equals(precedence, that.precedence) &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(conName, that.conName) &&
                Objects.equals(conPhone, that.conPhone) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(status, that.status) &&
                Objects.equals(creationTime, that.creationTime) &&
                Objects.equals(delStatus, that.delStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bltId, bltDescription, finishDate, finishTime, precedence, cusId, conName, conPhone, creator, status, creationTime, delStatus);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "backlogtask")
    public List<Backlogtaskdetails> getBacklogtaskdetails() {
        return backlogtaskdetails;
    }

    public void setBacklogtaskdetails(List<Backlogtaskdetails> backlogtaskdetails) {
        this.backlogtaskdetails = backlogtaskdetails;
    }
}
