package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Purchaseenter {
    private int peId;
    private String peNumber;
    private String supplierName;
    private String piNumber;
    private Timestamp buyTime;
    private String buyer;
    private Integer pcoId;
    private String operator;
    private Timestamp enterTime;
    private Integer audId;
    private String remarks;
    private Purchaseinvoice purchaseInvoice;
    private Purchaseorder purchaseorder;
    private Audit audit;
    private List<Pedetail> pedetail;

    @Id
    @Column(name = "pe_id")
    public int getPeId() {
        return peId;
    }

    public void setPeId(int peId) {
        this.peId = peId;
    }

    @Basic
    @Column(name = "pe_number")
    public String getPeNumber() {
        return peNumber;
    }

    public void setPeNumber(String peNumber) {
        this.peNumber = peNumber;
    }

    @Basic
    @Column(name = "supplier_name")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "pi_number")
    public String getPiNumber() {
        return piNumber;
    }

    public void setPiNumber(String piNumber) {
        this.piNumber = piNumber;
    }

    @Basic
    @Column(name = "buy_time")
    public Timestamp getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
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
    @Column(name = "pco_id")
    public Integer getPcoId() {
        return pcoId;
    }

    public void setPcoId(Integer pcoId) {
        this.pcoId = pcoId;
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
    @Column(name = "enter_time")
    public Timestamp getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
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
        Purchaseenter that = (Purchaseenter) o;
        return peId == that.peId &&
                Objects.equals(peNumber, that.peNumber) &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(piNumber, that.piNumber) &&
                Objects.equals(buyTime, that.buyTime) &&
                Objects.equals(buyer, that.buyer) &&
                Objects.equals(pcoId, that.pcoId) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(enterTime, that.enterTime) &&
                Objects.equals(audId, that.audId) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peId, peNumber, supplierName, piNumber, buyTime, buyer, pcoId, operator, enterTime, audId, remarks);
    }

    @ManyToOne
    @JoinColumn(name = "pi_number", referencedColumnName = "pi_number")
    public Purchaseinvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public void setPurchaseInvoice(Purchaseinvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
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
    @JoinColumn(name = "aud_id", referencedColumnName = "aud_id")
    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @OneToMany(mappedBy = "purchaseenter")
    public List<Pedetail> getPedetail() {
        return pedetail;
    }

    public void setPedetail(List<Pedetail> pedetail) {
        this.pedetail = pedetail;
    }
}
