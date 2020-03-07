package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Quote {
    private int quoId;
    private String quoTheme;
    private Integer toOrder;
    private String quoPhone;
    private Timestamp quoDate;
    private Integer totalMoney;
    private Integer grossProfit;
    private String instructions;
    private String remarks;
    private Integer approver;
    private Integer auditStatus;
    private Integer delStatus;
    @JsonIgnoreProperties("quote")
    private Salesopport salesopport;
    @JsonIgnoreProperties("quote")
    private Customer customer;
    @JsonIgnoreProperties("quote")
    private User user;
    @JsonIgnoreProperties("quote")
    private Audit audit;
    @JsonIgnoreProperties("quote")
    private List<Quotedetails> quotedetails;
    @JsonIgnoreProperties("quote")
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

    @ManyToOne
    @JoinColumn(name="so_id",referencedColumnName = "so_id", nullable = false)
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }

    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name="aud_id",referencedColumnName = "aud_id")
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
