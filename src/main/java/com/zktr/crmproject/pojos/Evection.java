package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

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
    private int uId;
    private Integer approver;
    private Integer borrowMoney;
    private Integer status;
    private Integer audId;
    private Integer cosId;
    private Integer auditStatus;
    private String remarks;
    private int delStatus;
    private User user;
    private Audit audit;
    private Cost cost;
    private List<Evectiondetails> eventiondetails;
    private List<Evectionlog> evectionlog;
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
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
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
    public Integer getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(Integer borrowMoney) {
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
    @Column(name = "aud_id")
    public Integer getAudId() {
        return audId;
    }

    public void setAudId(Integer audId) {
        this.audId = audId;
    }

    @Basic
    @Column(name = "cos_id")
    public Integer getCosId() {
        return cosId;
    }

    public void setCosId(Integer cosId) {
        this.cosId = cosId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evection evection = (Evection) o;
        return eveId == evection.eveId &&
                uId == evection.uId &&
                delStatus == evection.delStatus &&
                Objects.equals(eveTheme, evection.eveTheme) &&
                Objects.equals(startTime, evection.startTime) &&
                Objects.equals(endTime, evection.endTime) &&
                Objects.equals(placeOfDeparture, evection.placeOfDeparture) &&
                Objects.equals(destination, evection.destination) &&
                Objects.equals(field, evection.field) &&
                Objects.equals(vehicle, evection.vehicle) &&
                Objects.equals(approver, evection.approver) &&
                Objects.equals(borrowMoney, evection.borrowMoney) &&
                Objects.equals(status, evection.status) &&
                Objects.equals(audId, evection.audId) &&
                Objects.equals(cosId, evection.cosId) &&
                Objects.equals(auditStatus, evection.auditStatus) &&
                Objects.equals(remarks, evection.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eveId, eveTheme, startTime, endTime, placeOfDeparture, destination, field, vehicle, uId, approver, borrowMoney, status, audId, cosId, auditStatus, remarks, delStatus);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "aud_id")
    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cos_id")
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
