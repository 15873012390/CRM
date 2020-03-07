package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Purchaseenter {
    private int peId;
    private String peNumber;
    private String supplierName;
    private Timestamp buyTime;
    private String buyer;
    private String operator;
    private Timestamp enterTime;
    private String remarks;
    @JsonIgnoreProperties("purchaseenter")
    private Purchaseinvoice purchaseInvoice;
    @JsonIgnoreProperties("purchaseenter")
    private Purchaseorder purchaseorder;
    @JsonIgnoreProperties("purchaseenter")
    private Audit audit;
    @JsonIgnoreProperties("purchaseenter")
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
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @ManyToOne
    @JoinColumn(name="pi_id",referencedColumnName = "pi_id")
    public Purchaseinvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public void setPurchaseInvoice(Purchaseinvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    @ManyToOne
    @JoinColumn(name="pco_id",referencedColumnName = "pco_id")
    public Purchaseorder getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(Purchaseorder purchaseorder) {
        this.purchaseorder = purchaseorder;
    }

    @ManyToOne
    @JoinColumn(name="aud_id",referencedColumnName = "aud_id")
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
