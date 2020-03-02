package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Plandetail {
    private int planDetailId;
    private Integer purId;
    private Integer proId;
    private Integer quantity;
    private String remarks;
    private Purchaseplan purchaseplan;
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
    @Column(name = "pur_id")
    public Integer getPurId() {
        return purId;
    }

    public void setPurId(Integer purId) {
        this.purId = purId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plandetail that = (Plandetail) o;
        return planDetailId == that.planDetailId &&
                Objects.equals(purId, that.purId) &&
                Objects.equals(proId, that.proId) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planDetailId, purId, proId, quantity, remarks);
    }

    @ManyToOne
    @JoinColumn(name = "pur_id", referencedColumnName = "pur_id")
    public Purchaseplan getPurchaseplan() {
        return purchaseplan;
    }

    public void setPurchaseplan(Purchaseplan purchaseplan) {
        this.purchaseplan = purchaseplan;
    }

    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
