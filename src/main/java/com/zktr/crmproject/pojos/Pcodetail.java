package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pcodetail {
    private int pcodId;
    private Integer pcoId;
    private Integer proId;
    private Integer quantity;
    private Integer uintPrice;
    private String remarks;
    private Purchaseorder purchaseorder;
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
    @Column(name = "pco_id")
    public Integer getPcoId() {
        return pcoId;
    }

    public void setPcoId(Integer pcoId) {
        this.pcoId = pcoId;
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
        Pcodetail pcodetail = (Pcodetail) o;
        return pcodId == pcodetail.pcodId &&
                Objects.equals(pcoId, pcodetail.pcoId) &&
                Objects.equals(proId, pcodetail.proId) &&
                Objects.equals(quantity, pcodetail.quantity) &&
                Objects.equals(uintPrice, pcodetail.uintPrice) &&
                Objects.equals(remarks, pcodetail.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcodId, pcoId, proId, quantity, uintPrice, remarks);
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
    @JoinColumn(name = "pco_id", referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
