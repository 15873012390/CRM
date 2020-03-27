package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Fitdetail {
    private int fdId;
    private Integer warrantyStatus;
    private String faultDescription;
    private String customizeName;
    private String fcdArrayValue;
    private String fdProgress;
    private BigDecimal price;
    private BigDecimal alreadyFee;
    private String status;
    private Timestamp deliverTime;
    private BigDecimal grossProfit;
    private String remarks;
    private List<Repair> repair;
    private Productspecification productspecification;
    private Fitcustom fitcustom;
    private Department department;

    @Id
    @Column(name = "fd_id")
    public int getFdId() {
        return fdId;
    }

    public void setFdId(int fdId) {
        this.fdId = fdId;
    }


    @Basic
    @Column(name = "warranty_status")
    public Integer getWarrantyStatus() {
        return warrantyStatus;
    }

    public void setWarrantyStatus(Integer warrantyStatus) {
        this.warrantyStatus = warrantyStatus;
    }

    @Basic
    @Column(name = "fault_description")
    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }


    @Basic
    @Column(name = "customize_name")
    public String getCustomizeName() {
        return customizeName;
    }

    public void setCustomizeName(String customizeName) {
        this.customizeName = customizeName;
    }

    @Basic
    @Column(name = "fcd_array_value")
    public String getFcdArrayValue() {
        return fcdArrayValue;
    }

    public void setFcdArrayValue(String fcdArrayValue) {
        this.fcdArrayValue = fcdArrayValue;
    }

    @Basic
    @Column(name = "fd_progress")
    public String getFdProgress() {
        return fdProgress;
    }

    public void setFdProgress(String fdProgress) {
        this.fdProgress = fdProgress;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "already_fee")
    public BigDecimal getAlreadyFee() {
        return alreadyFee;
    }

    public void setAlreadyFee(BigDecimal alreadyFee) {
        this.alreadyFee = alreadyFee;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "deliver_time")
    public Timestamp getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Timestamp deliverTime) {
        this.deliverTime = deliverTime;
    }

    @Basic
    @Column(name = "gross_profit")
    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @OneToMany(mappedBy = "fitdetail")
    public List<Repair> getRepair() {
        return repair;
    }

    public void setRepair(List<Repair> repair) {
        this.repair = repair;
    }

    @ManyToOne
    @JoinColumn(name="spe_id",referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
    }

    @ManyToOne
    @JoinColumn(name="customize_id",referencedColumnName = "customize_id")
    public Fitcustom getFitcustom() {
        return fitcustom;
    }

    public void setFitcustom(Fitcustom fitcustom) {
        this.fitcustom = fitcustom;
    }

    @ManyToOne
    @JoinColumn(name="d_id",referencedColumnName = "d_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
