package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Repair {
    private int repairId;
    private String title;
    private String accepter;
    private Timestamp receiptDate;
    private String classify;
    @JsonIgnoreProperties("repair")
    private Customer customer;
    @JsonIgnoreProperties("repair")
    private Fitdetail fitdetail;
    @JsonIgnoreProperties("repair")
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

    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="fd_id",referencedColumnName = "fd_id")
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
