package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Pcrdetail {
    private int pcrdId;
    private Integer quantity;
    private BigDecimal uintPrice;
    private String remarks;
    @JsonIgnoreProperties("pcrdetail")
    private Purchasereturn purchasereturn;
    private Productspecification productspecification;
    @Id
    @Column(name = "pcrd_id")
    public int getPcrdId() {
        return pcrdId;
    }

    public void setPcrdId(int pcrdId) {
        this.pcrdId = pcrdId;
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
    @JoinColumn(name="preturn_id",referencedColumnName = "preturn_id")
    public Purchasereturn getPurchasereturn() {
        return purchasereturn;
    }

    public void setPurchasereturn(Purchasereturn purchasereturn) {
        this.purchasereturn = purchasereturn;
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
