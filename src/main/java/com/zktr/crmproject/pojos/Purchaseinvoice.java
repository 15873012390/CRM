package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Purchaseinvoice {
    private int piId;
    private String piNumber;
    private String abstrat;
    private String billType;
    private BigDecimal money;
    private Timestamp ticketDate;
    private String passPerson;
    private String period;
    private Integer cusId;
    private Integer toPay;
    private Integer createPayPlan;
    private String remarks;
    @JsonIgnoreProperties("purchaseinvoice")
    private List<Purchaseenter> purchaseenter;
    @JsonIgnoreProperties("purchaseinvoice")
    private Purchaseorder purchaseorder;

    @Id
    @Column(name = "pi_id")
    public int getPiId() {
        return piId;
    }

    public void setPiId(int piId) {
        this.piId = piId;
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
    @Column(name = "abstrat")
    public String getAbstrat() {
        return abstrat;
    }

    public void setAbstrat(String abstrat) {
        this.abstrat = abstrat;
    }

    @Basic
    @Column(name = "bill_type")
    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    @Basic
    @Column(name = "money")
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Basic
    @Column(name = "ticket_date")
    public Timestamp getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Timestamp ticketDate) {
        this.ticketDate = ticketDate;
    }

    @Basic
    @Column(name = "pass_person")
    public String getPassPerson() {
        return passPerson;
    }

    public void setPassPerson(String passPerson) {
        this.passPerson = passPerson;
    }

    @Basic
    @Column(name = "period")
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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
    @Column(name = "to_pay")
    public Integer getToPay() {
        return toPay;
    }

    public void setToPay(Integer toPay) {
        this.toPay = toPay;
    }

    @Basic
    @Column(name = "create_payPlan")
    public Integer getCreatePayPlan() {
        return createPayPlan;
    }

    public void setCreatePayPlan(Integer createPayPlan) {
        this.createPayPlan = createPayPlan;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @OneToMany(mappedBy = "purchaseInvoice",cascade = CascadeType.ALL)
    public List<Purchaseenter> getPurchaseenter() {
        return purchaseenter;
    }

    public void setPurchaseenter(List<Purchaseenter> purchaseenter) {
        this.purchaseenter = purchaseenter;
    }

    @ManyToOne
    @JoinColumn(name="pco_id",referencedColumnName = "pco_id")
    public Purchaseorder getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(Purchaseorder purchaseorder) {
        this.purchaseorder = purchaseorder;
    }
}
