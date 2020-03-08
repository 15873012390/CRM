package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Evection {
    private int eveId;
    private String eveTheme;
    private Timestamp startTime;
    private Timestamp endTime;
    private String placeOfDeparture;
    private String destination;
    private String field;
    private String vehicle;
    private Integer approver;
    private BigDecimal borrowMoney;
    private Integer status;
    private Integer auditStatus;
    private String remarks;
    private int delStatus;
    @JsonIgnoreProperties("evection")
    private User user;
    @JsonIgnoreProperties("evection")
    private Audit audit;
    @JsonIgnoreProperties("evection")
    private Cost cost;
    @JsonIgnoreProperties("evection")
    private List<Evectiondetails> eventiondetails;
    @JsonIgnoreProperties("evection")
    private List<Evectionlog> evectionlog;
    @JsonIgnoreProperties("evection")
    private List<Evectionsummarize> evectionsummarize;

    @Id
    @Column(name = "eve_id")
    public int getEveId() {
        return eveId;
    }

    public void setEveId(int eveId) {
        this.eveId = eveId;
    }

    @Basic
    @Column(name = "eve_theme")
    public String getEveTheme() {
        return eveTheme;
    }

    public void setEveTheme(String eveTheme) {
        this.eveTheme = eveTheme;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "place_of_departure")
    public String getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public void setPlaceOfDeparture(String placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    @Basic
    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "field")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Basic
    @Column(name = "vehicle")
    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }


    @Basic
    @Column(name = "approver")
    public Integer getApprover() {
        return approver;
    }

    public void setApprover(Integer approver) {
        this.approver = approver;
    }

    @Basic
    @Column(name = "borrow_money")
    public BigDecimal getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(BigDecimal borrowMoney) {
        this.borrowMoney = borrowMoney;
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
    @Column(name = "audit_status")
    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "del_status")
    public int getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(int delStatus) {
        this.delStatus = delStatus;
    }


    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name="aud_id",referencedColumnName = "aud_id")
    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @ManyToOne
    @JoinColumn(name="cos_id",referencedColumnName = "cos_id")
    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    @OneToMany(mappedBy = "evection")
    public List<Evectiondetails> getEventiondetails() {
        return eventiondetails;
    }

    public void setEventiondetails(List<Evectiondetails> eventiondetails) {
        this.eventiondetails = eventiondetails;
    }

    @OneToMany(mappedBy = "evection")
    public List<Evectionlog> getEvectionlog() {
        return evectionlog;
    }

    public void setEvectionlog(List<Evectionlog> evectionlog) {
        this.evectionlog = evectionlog;
    }

    @OneToMany(mappedBy = "evection")
    public List<Evectionsummarize> getEvectionsummarize() {
        return evectionsummarize;
    }

    public void setEvectionsummarize(List<Evectionsummarize> evectionsummarize) {
        this.evectionsummarize = evectionsummarize;
    }
}
