package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Actionhistory {
    private int ahId;
    private String actDescribe;
    private int cusId;
    private String conName;
    private String conPhone;
    private Integer maiId;
    private Integer uId;
    private String action;
    private Timestamp actDate;
    private Integer delStatus;
    private Customer customer;
    private Repair repair;
    private User user;
    private List<Actionhistorydetails> actionhistorydetails;

    @Id
    @Column(name = "ah_id")
    public int getAhId() {
        return ahId;
    }

    public void setAhId(int ahId) {
        this.ahId = ahId;
    }

    @Basic
    @Column(name = "act_describe")
    public String getActDescribe() {
        return actDescribe;
    }

    public void setActDescribe(String actDescribe) {
        this.actDescribe = actDescribe;
    }

    @Basic
    @Column(name = "cus_id")
    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
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
    @Column(name = "mai_id")
    public Integer getMaiId() {
        return maiId;
    }

    public void setMaiId(Integer maiId) {
        this.maiId = maiId;
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
    @Column(name = "action")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "act_date")
    public Timestamp getActDate() {
        return actDate;
    }

    public void setActDate(Timestamp actDate) {
        this.actDate = actDate;
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
        Actionhistory that = (Actionhistory) o;
        return ahId == that.ahId &&
                cusId == that.cusId &&
                Objects.equals(actDescribe, that.actDescribe) &&
                Objects.equals(conName, that.conName) &&
                Objects.equals(conPhone, that.conPhone) &&
                Objects.equals(maiId, that.maiId) &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(action, that.action) &&
                Objects.equals(actDate, that.actDate) &&
                Objects.equals(delStatus, that.delStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ahId, actDescribe, cusId, conName, conPhone, maiId, uId, action, actDate, delStatus);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "repair_id")
    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "actionhistory")
    public List<Actionhistorydetails> getActionhistorydetails() {
        return actionhistorydetails;
    }

    public void setActionhistorydetails(List<Actionhistorydetails> actionhistorydetails) {
        this.actionhistorydetails = actionhistorydetails;
    }
}
