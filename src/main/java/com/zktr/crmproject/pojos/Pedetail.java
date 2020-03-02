package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pedetail {
    private int peDetailId;
    private Integer peId;
    private Integer proId;
    private Integer quantity;
    private Integer uintPrice;
    private String remarks;
    private Purchaseenter purchaseenter;
    private Product product;

    @Id
    @Column(name = "peDetail_id")
    public int getPeDetailId() {
        return peDetailId;
    }

    public void setPeDetailId(int peDetailId) {
        this.peDetailId = peDetailId;
    }

    @Basic
    @Column(name = "pe_id")
    public Integer getPeId() {
        return peId;
    }

    public void setPeId(Integer peId) {
        this.peId = peId;
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
        Pedetail pedetail = (Pedetail) o;
        return peDetailId == pedetail.peDetailId &&
                Objects.equals(peId, pedetail.peId) &&
                Objects.equals(proId, pedetail.proId) &&
                Objects.equals(quantity, pedetail.quantity) &&
                Objects.equals(uintPrice, pedetail.uintPrice) &&
                Objects.equals(remarks, pedetail.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peDetailId, peId, proId, quantity, uintPrice, remarks);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "pe_id")
    public Purchaseenter getPurchaseenter() {
        return purchaseenter;
    }

    public void setPurchaseenter(Purchaseenter purchaseenter) {
        this.purchaseenter = purchaseenter;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
