package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Purchaseplan {
    private int purId;
    private String purNumber;
    private String purTitle;
    private Integer deptId;
    private Integer warehouseId;
    private Timestamp planTime;
    private String planner;
    private String handler;
    private Timestamp inTime;
    private Integer audId;
    private Integer deal;
    private String remarks;
    private Department department;
    private Warehouse warehouse;
    private Audit audit;
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
    @Column(name = "dept_id")
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "warehouse_id")
    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
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
    @Column(name = "aud_id")
    public Integer getAudId() {
        return audId;
    }

    public void setAudId(Integer audId) {
        this.audId = audId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchaseplan that = (Purchaseplan) o;
        return purId == that.purId &&
                Objects.equals(purNumber, that.purNumber) &&
                Objects.equals(purTitle, that.purTitle) &&
                Objects.equals(deptId, that.deptId) &&
                Objects.equals(warehouseId, that.warehouseId) &&
                Objects.equals(planTime, that.planTime) &&
                Objects.equals(planner, that.planner) &&
                Objects.equals(handler, that.handler) &&
                Objects.equals(inTime, that.inTime) &&
                Objects.equals(audId, that.audId) &&
                Objects.equals(deal, that.deal) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purId, purNumber, purTitle, deptId, warehouseId, planTime, planner, handler, inTime, audId, deal, remarks);
    }

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "d_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(name = "aud_id", referencedColumnName = "aud_id")
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
