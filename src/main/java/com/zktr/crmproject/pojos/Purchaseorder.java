package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Purchaseorder {
    private int pcoId;
    private Integer pcoNumber;
    private Integer supplierId;
    private Timestamp orderTime;
    private String buyer;
    private String pcoAddress;
    private String operator;
    private Integer audId;
    private Integer deal;
    private Supplier supplier;
    private Audit audit;
    private List<Pcodetail> pcodetail;
    private List<Purchaseenter> purchaseenter;
    private List<Purchaseinvoice> purchaseinvoice;
    private List<Instock> instock;

    @Id
    @Column(name = "pco_id")
    public int getPcoId() {
        return pcoId;
    }

    public void setPcoId(int pcoId) {
        this.pcoId = pcoId;
    }

    @Basic
    @Column(name = "pco_number")
    public Integer getPcoNumber() {
        return pcoNumber;
    }

    public void setPcoNumber(Integer pcoNumber) {
        this.pcoNumber = pcoNumber;
    }

    @Basic
    @Column(name = "supplier_id")
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "order_time")
    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "buyer")
    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @Basic
    @Column(name = "pco_address")
    public String getPcoAddress() {
        return pcoAddress;
    }

    public void setPcoAddress(String pcoAddress) {
        this.pcoAddress = pcoAddress;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "aud_id")
    public Integer getAudId() {
        return audId;
    }

    public void setAudId(Integer audId) {
        this.audId = audId;
    }

    @Basic
    @Column(name = "deal")
    public Integer getDeal() {
        return deal;
    }

    public void setDeal(Integer deal) {
        this.deal = deal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchaseorder that = (Purchaseorder) o;
        return pcoId == that.pcoId &&
                Objects.equals(pcoNumber, that.pcoNumber) &&
                Objects.equals(supplierId, that.supplierId) &&
                Objects.equals(orderTime, that.orderTime) &&
                Objects.equals(buyer, that.buyer) &&
                Objects.equals(pcoAddress, that.pcoAddress) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(audId, that.audId) &&
                Objects.equals(deal, that.deal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcoId, pcoNumber, supplierId, orderTime, buyer, pcoAddress, operator, audId, deal);
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToOne
    @JoinColumn(name = "aud_id", referencedColumnName = "aud_id")
    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @OneToMany(mappedBy = "purchaseorder")
    public List<Pcodetail> getPcodetail() {
        return pcodetail;
    }

    public void setPcodetail(List<Pcodetail> pcodetail) {
        this.pcodetail = pcodetail;
    }

    @OneToMany(mappedBy = "purchaseorder")
    public List<Purchaseenter> getPurchaseenter() {
        return purchaseenter;
    }

    public void setPurchaseenter(List<Purchaseenter> purchaseenter) {
        this.purchaseenter = purchaseenter;
    }

    @OneToMany(mappedBy = "purchaseorder")
    public List<Purchaseinvoice> getPurchaseinvoice() {
        return purchaseinvoice;
    }

    public void setPurchaseinvoice(List<Purchaseinvoice> purchaseinvoice) {
        this.purchaseinvoice = purchaseinvoice;
    }

    @OneToMany(mappedBy = "purchaseorder")
    public List<Instock> getInstock() {
        return instock;
    }

    public void setInstock(List<Instock> instock) {
        this.instock = instock;
    }
}
