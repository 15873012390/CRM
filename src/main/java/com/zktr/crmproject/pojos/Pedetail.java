package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Pedetail {
    private int peDetailId;
    private Integer quantity;
    private BigDecimal uintPrice;
    private String remarks;
    private Purchaseenter purchaseenter;
    private Productspecification productspecification;

    @Id
    @Column(name = "peDetail_id")
    public int getPeDetailId() {
        return peDetailId;
    }

    public void setPeDetailId(int peDetailId) {
        this.peDetailId = peDetailId;
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
    @Column(name = "uint_price")
    public BigDecimal getUintPrice() {
        return uintPrice;
    }

    public void setUintPrice(BigDecimal uintPrice) {
        this.uintPrice = uintPrice;
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
    @JoinColumn(name="pe_id",referencedColumnName = "pe_id")
    public Purchaseenter getPurchaseenter() {
        return purchaseenter;
    }

    public void setPurchaseenter(Purchaseenter purchaseenter) {
        this.purchaseenter = purchaseenter;
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
