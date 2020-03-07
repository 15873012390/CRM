package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Pcrdetail {
    private int pcrdId;
    private Integer quantity;
    private Integer uintPrice;
    private String remarks;
    @JsonIgnoreProperties("pcrdetail")
    private Purchasereturn purchasereturn;
    @JsonIgnoreProperties("pcrdetail")
    private Product product;

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
    public Integer getUintPrice() {
        return uintPrice;
    }

    public void setUintPrice(Integer uintPrice) {
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
    @JoinColumn(name="pro_id",referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
