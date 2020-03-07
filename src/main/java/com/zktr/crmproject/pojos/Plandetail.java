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
    private Product product;

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
    @JoinColumn(name="pro_id",referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
