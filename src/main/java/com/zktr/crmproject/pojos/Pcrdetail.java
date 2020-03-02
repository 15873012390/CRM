package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pcrdetail {
    private int pcrdId;
    private Integer preturnId;
    private Integer proId;
    private Integer quantity;
    private Integer uintPrice;
    private String remarks;
    private Purchasereturn purchasereturn;
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
    @Column(name = "preturn_id")
    public Integer getPreturnId() {
        return preturnId;
    }

    public void setPreturnId(Integer preturnId) {
        this.preturnId = preturnId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pcrdetail pcrdetail = (Pcrdetail) o;
        return pcrdId == pcrdetail.pcrdId &&
                Objects.equals(preturnId, pcrdetail.preturnId) &&
                Objects.equals(proId, pcrdetail.proId) &&
                Objects.equals(quantity, pcrdetail.quantity) &&
                Objects.equals(uintPrice, pcrdetail.uintPrice) &&
                Objects.equals(remarks, pcrdetail.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcrdId, preturnId, proId, quantity, uintPrice, remarks);
    }

    @ManyToOne
    @JoinColumn(name = "preturn_id", referencedColumnName = "preturn_id")
    public Purchasereturn getPurchasereturn() {
        return purchasereturn;
    }

    public void setPurchasereturn(Purchasereturn purchasereturn) {
        this.purchasereturn = purchasereturn;
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
