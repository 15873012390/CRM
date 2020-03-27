package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Plandetail {
    private int planDetailId;
    private Integer quantity;
    private String remarks;
    @JsonIgnoreProperties("plandetail")
    private Purchaseplan purchaseplan;
    @JsonIgnoreProperties("plandetail")
    private Productspecification productspecification;

    @Id
    @Column(name = "planDetail_id")
    public int getPlanDetailId() {
        return planDetailId;
    }

    public void setPlanDetailId(int planDetailId) {
        this.planDetailId = planDetailId;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
    @JoinColumn(name="pur_id",referencedColumnName = "pur_id")
    public Purchaseplan getPurchaseplan() {
        return purchaseplan;
    }

    public void setPurchaseplan(Purchaseplan purchaseplan) {
        this.purchaseplan = purchaseplan;
    }

    @ManyToOne
    @JoinColumn(name="spe_id",referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
    }
}
