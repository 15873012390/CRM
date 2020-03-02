package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Quote {
    private int quoId;
    private String quoTheme;
    private Integer toOrder;
    private int cusId;
    private int soId;
    private Integer uId;
    private String quoPhone;
    private Timestamp quoDate;
    private Integer totalMoney;
    private Integer grossProfit;
    private String instructions;
    private String remarks;
    private Integer approver;
    private Integer audId;
    private Integer auditStatus;
    private Integer delStatus;
    private Salesopport salesopport;
    private Customer customer;
    private User user;
    private Audit audit;
    private List<Quotedetails> quotedetails;
    private List<Orders> orders;

    @Id
    @Column(name = "quo_id")
    public int getQuoId() {
        return quoId;
    }

    public void setQuoId(int quoId) {
        this.quoId = quoId;
    }

    @Basic
    @Column(name = "quo_theme")
    public String getQuoTheme() {
        return quoTheme;
    }

    public void setQuoTheme(String quoTheme) {
        this.quoTheme = quoTheme;
    }

    @Basic
    @Column(name = "to_order")
    public Integer getToOrder() {
        return toOrder;
    }

    public void setToOrder(Integer toOrder) {
        this.toOrder = toOrder;
    }

    @Basic
    @Column(name = "cus_id")
    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "so_id")
    public int getSoId() {
        return soId;
    }

    public void setSoId(int soId) {
        this.soId = soId;
    }

    @Basic
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "quo_phone")
    public String getQuoPhone() {
        return quoPhone;
    }

    public void setQuoPhone(String quoPhone) {
        this.quoPhone = quoPhone;
    }

    @Basic
    @Column(name = "quo_date")
    public Timestamp getQuoDate() {
        return quoDate;
    }

    public void setQuoDate(Timestamp quoDate) {
        this.quoDate = quoDate;
    }

    @Basic
    @Column(name = "total_money")
    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Basic
    @Column(name = "gross_profit")
    public Integer getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(Integer grossProfit) {
        this.grossProfit = grossProfit;
    }

    @Basic
    @Column(name = "instructions")
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "approver")
    public Integer getApprover() {
        return approver;
    }

    public void setApprover(Integer approver) {
        this.approver = approver;
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
    @Column(name = "audit_status")
    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Basic
    @Column(name = "del_status")
    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return quoId == quote.quoId &&
                cusId == quote.cusId &&
                soId == quote.soId &&
                Objects.equals(quoTheme, quote.quoTheme) &&
                Objects.equals(toOrder, quote.toOrder) &&
                Objects.equals(uId, quote.uId) &&
                Objects.equals(quoPhone, quote.quoPhone) &&
                Objects.equals(quoDate, quote.quoDate) &&
                Objects.equals(totalMoney, quote.totalMoney) &&
                Objects.equals(grossProfit, quote.grossProfit) &&
                Objects.equals(instructions, quote.instructions) &&
                Objects.equals(remarks, quote.remarks) &&
                Objects.equals(approver, quote.approver) &&
                Objects.equals(audId, quote.audId) &&
                Objects.equals(auditStatus, quote.auditStatus) &&
                Objects.equals(delStatus, quote.delStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quoId, quoTheme, toOrder, cusId, soId, uId, quoPhone, quoDate, totalMoney, grossProfit, instructions, remarks, approver, audId, auditStatus, delStatus);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "so_id", nullable = false)
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "aud_id")
    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @OneToMany(mappedBy = "quote")
    public List<Quotedetails> getQuotedetails() {
        return quotedetails;
    }

    public void setQuotedetails(List<Quotedetails> quotedetails) {
        this.quotedetails = quotedetails;
    }

    @OneToMany(mappedBy = "quote")
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
