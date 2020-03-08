package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Pcodetail {
    private int pcodId;
    private Integer quantity;
    private BigDecimal uintPrice;
    private String remarks;
    @JsonIgnoreProperties("pcodetail")
    private Purchaseorder purchaseorder;
    @JsonIgnoreProperties("pcodetail")
    private Product product;

    @Id
    @Column(name = "pcod_id")
    public int getPcodId() {
        return pcodId;
    }

    public void setPcodId(int pcodId) {
        this.pcodId = pcodId;
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
    @JoinColumn(name = "pco_id", referencedColumnName = "pco_id")
    public Purchaseorder getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(Purchaseorder purchaseorder) {
        this.purchaseorder = purchaseorder;
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
