package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Repair {
    private int repairId;
    private String title;
    private Integer cusId;
    private String accepter;
    private Timestamp receiptDate;
    private String classify;
    private Integer apdId;
    private Customer customer;
    private Fitdetail fitdetail;
    private List<Actionhistory> actionhistory;
    @Id
    @Basic
    @Column(name = "repair_id")
    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "accepter")
    public String getAccepter() {
        return accepter;
    }

    public void setAccepter(String accepter) {
        this.accepter = accepter;
    }

    @Basic
    @Column(name = "receipt_date")
    public Timestamp getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Timestamp receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Basic
    @Column(name = "classify")
    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    @Basic
    @Column(name = "apd_id")
    public Integer getApdId() {
        return apdId;
    }

    public void setApdId(Integer apdId) {
        this.apdId = apdId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repair repair = (Repair) o;
        return Objects.equals(repairId, repair.repairId) &&
                Objects.equals(title, repair.title) &&
                Objects.equals(cusId, repair.cusId) &&
                Objects.equals(accepter, repair.accepter) &&
                Objects.equals(receiptDate, repair.receiptDate) &&
                Objects.equals(classify, repair.classify) &&
                Objects.equals(apdId, repair.apdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repairId, title, cusId, accepter, receiptDate, classify, apdId);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "fd_id")
    public Fitdetail getFitdetail() {
        return fitdetail;
    }

    public void setFitdetail(Fitdetail fitdetail) {
        this.fitdetail = fitdetail;
    }

    @OneToMany(mappedBy = "repair")
    public List<Actionhistory> getActionhistory() {
        return actionhistory;
    }

    public void setActionhistory(List<Actionhistory> actionhistory) {
        this.actionhistory = actionhistory;
    }
}
