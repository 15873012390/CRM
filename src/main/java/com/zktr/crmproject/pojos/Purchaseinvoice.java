package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Purchaseinvoice {
    private int piId;
    private String piNumber;
    private String abstrat;
    private String billType;
    private Integer money;
    private Timestamp ticketDate;
    private Integer pcoId;
    private String passPerson;
    private String period;
    private Integer cusId;
    private Integer toPay;
    private Integer createPayPlan;
    private String remarks;
    private List<Purchaseenter> purchaseenter;
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
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
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
    @Column(name = "pco_id")
    public Integer getPcoId() {
        return pcoId;
    }

    public void setPcoId(Integer pcoId) {
        this.pcoId = pcoId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchaseinvoice that = (Purchaseinvoice) o;
        return piId == that.piId &&
                Objects.equals(piNumber, that.piNumber) &&
                Objects.equals(abstrat, that.abstrat) &&
                Objects.equals(billType, that.billType) &&
                Objects.equals(money, that.money) &&
                Objects.equals(ticketDate, that.ticketDate) &&
                Objects.equals(pcoId, that.pcoId) &&
                Objects.equals(passPerson, that.passPerson) &&
                Objects.equals(period, that.period) &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(toPay, that.toPay) &&
                Objects.equals(createPayPlan, that.createPayPlan) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(piId, piNumber, abstrat, billType, money, ticketDate, pcoId, passPerson, period, cusId, toPay, createPayPlan, remarks);
    }

    @OneToMany(mappedBy = "purchaseInvoice")
    public List<Purchaseenter> getPurchaseenter() {
        return purchaseenter;
    }

    public void setPurchaseenter(List<Purchaseenter> purchaseenter) {
        this.purchaseenter = purchaseenter;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "pco_id")
    public Purchaseorder getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(Purchaseorder purchaseorder) {
        this.purchaseorder = purchaseorder;
    }
}
