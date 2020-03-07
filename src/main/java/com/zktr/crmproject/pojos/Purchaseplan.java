package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Purchaseplan {
    private int purId;
    private String purNumber;
    private String purTitle;
    private Timestamp planTime;
    private String planner;
    private String handler;
    private Timestamp inTime;
    private Integer deal;
    private String remarks;
    @JsonIgnoreProperties("purchaseplan")
    private Department department;
    @JsonIgnoreProperties("purchaseplan")
    private Warehouse warehouse;
    @JsonIgnoreProperties("purchaseplan")
    private Audit audit;
    @JsonIgnoreProperties("purchaseplan")
    private List<Plandetail> plandetail;

    @Id
    @Column(name = "pur_id")
    public int getPurId() {
        return purId;
    }

    public void setPurId(int purId) {
        this.purId = purId;
    }

    @Basic
    @Column(name = "pur_number")
    public String getPurNumber() {
        return purNumber;
    }

    public void setPurNumber(String purNumber) {
        this.purNumber = purNumber;
    }

    @Basic
    @Column(name = "pur_title")
    public String getPurTitle() {
        return purTitle;
    }

    public void setPurTitle(String purTitle) {
        this.purTitle = purTitle;
    }


    @Basic
    @Column(name = "plan_time")
    public Timestamp getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Timestamp planTime) {
        this.planTime = planTime;
    }

    @Basic
    @Column(name = "planner")
    public String getPlanner() {
        return planner;
    }

    public void setPlanner(String planner) {
        this.planner = planner;
    }

    @Basic
    @Column(name = "handler")
    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Basic
    @Column(name = "in_time")
    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    @Basic
    @Column(name = "deal")
    public Integer getDeal() {
        return deal;
    }

    public void setDeal(Integer deal) {
        this.deal = deal;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @ManyToOne
    @JoinColumn(name="d_id",referencedColumnName = "d_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name="warehouse_id",referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(name="aud_id",referencedColumnName = "aud_id")
    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @OneToMany(mappedBy = "purchaseplan")
    public List<Plandetail> getPlandetail() {
        return plandetail;
    }

    public void setPlandetail(List<Plandetail> plandetail) {
        this.plandetail = plandetail;
    }
}
