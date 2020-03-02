package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Fitdetail {
    private int fdId;
    private Integer proId;
    private Integer warrantyStatus;
    private String faultDescription;
    private Integer customizeId;
    private String customizeName;
    private String fcdArrayId;
    private String fcdArrayValue;
    private Integer aprtId;
    private String fdProgress;
    private Integer price;
    private Integer alreadyFee;
    private String status;
    private Timestamp deliverTime;
    private Integer grossProfit;
    private String remarks;
    private List<Repair> repair;
    private Product product;
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
    @Column(name = "pro_id")
    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
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
    @Column(name = "customize_id")
    public Integer getCustomizeId() {
        return customizeId;
    }

    public void setCustomizeId(Integer customizeId) {
        this.customizeId = customizeId;
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
    @Column(name = "fcdArray_id")
    public String getFcdArrayId() {
        return fcdArrayId;
    }

    public void setFcdArrayId(String fcdArrayId) {
        this.fcdArrayId = fcdArrayId;
    }

    @Basic
    @Column(name = "fcdArray_value")
    public String getFcdArrayValue() {
        return fcdArrayValue;
    }

    public void setFcdArrayValue(String fcdArrayValue) {
        this.fcdArrayValue = fcdArrayValue;
    }

    @Basic
    @Column(name = "aprt_id")
    public Integer getAprtId() {
        return aprtId;
    }

    public void setAprtId(Integer aprtId) {
        this.aprtId = aprtId;
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
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "already_fee")
    public Integer getAlreadyFee() {
        return alreadyFee;
    }

    public void setAlreadyFee(Integer alreadyFee) {
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
    public Integer getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(Integer grossProfit) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fitdetail fitdetail = (Fitdetail) o;
        return fdId == fitdetail.fdId &&
                Objects.equals(proId, fitdetail.proId) &&
                Objects.equals(warrantyStatus, fitdetail.warrantyStatus) &&
                Objects.equals(faultDescription, fitdetail.faultDescription) &&
                Objects.equals(customizeId, fitdetail.customizeId) &&
                Objects.equals(customizeName, fitdetail.customizeName) &&
                Objects.equals(fcdArrayId, fitdetail.fcdArrayId) &&
                Objects.equals(fcdArrayValue, fitdetail.fcdArrayValue) &&
                Objects.equals(aprtId, fitdetail.aprtId) &&
                Objects.equals(fdProgress, fitdetail.fdProgress) &&
                Objects.equals(price, fitdetail.price) &&
                Objects.equals(alreadyFee, fitdetail.alreadyFee) &&
                Objects.equals(status, fitdetail.status) &&
                Objects.equals(deliverTime, fitdetail.deliverTime) &&
                Objects.equals(grossProfit, fitdetail.grossProfit) &&
                Objects.equals(remarks, fitdetail.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fdId, proId, warrantyStatus, faultDescription, customizeId, customizeName, fcdArrayId, fcdArrayValue, aprtId, fdProgress, price, alreadyFee, status, deliverTime, grossProfit, remarks);
    }

    @OneToMany(mappedBy = "fitdetail")
    public List<Repair> getRepair() {
        return repair;
    }

    public void setRepair(List<Repair> repair) {
        this.repair = repair;
    }

    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "customize_id", referencedColumnName = "customize_id")
    public Fitcustom getFitcustom() {
        return fitcustom;
    }

    public void setFitcustom(Fitcustom fitcustom) {
        this.fitcustom = fitcustom;
    }

    @ManyToOne
    @JoinColumn(name = "aprt_id", referencedColumnName = "d_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
