package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Solution {
    private int solId;
    private String solTheme;
    private Integer cusId;
    private Integer soId;
    private Timestamp submissionTime;
    private String solContent;
    private String feedback;
    private String delStatus;
    private Customer customer;
    private Salesopport salesopport;

    @Id
    @Column(name = "sol_id")
    public int getSolId() {
        return solId;
    }

    public void setSolId(int solId) {
        this.solId = solId;
    }

    @Basic
    @Column(name = "sol_theme")
    public String getSolTheme() {
        return solTheme;
    }

    public void setSolTheme(String solTheme) {
        this.solTheme = solTheme;
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
    @Column(name = "so_id")
    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    @Basic
    @Column(name = "submission_time")
    public Timestamp getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Timestamp submissionTime) {
        this.submissionTime = submissionTime;
    }

    @Basic
    @Column(name = "sol_content")
    public String getSolContent() {
        return solContent;
    }

    public void setSolContent(String solContent) {
        this.solContent = solContent;
    }

    @Basic
    @Column(name = "feedback")
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Basic
    @Column(name = "del_status")
    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return solId == solution.solId &&
                Objects.equals(solTheme, solution.solTheme) &&
                Objects.equals(cusId, solution.cusId) &&
                Objects.equals(soId, solution.soId) &&
                Objects.equals(submissionTime, solution.submissionTime) &&
                Objects.equals(solContent, solution.solContent) &&
                Objects.equals(feedback, solution.feedback) &&
                Objects.equals(delStatus, solution.delStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solId, solTheme, cusId, soId, submissionTime, solContent, feedback, delStatus);
    }

    @ManyToOne
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "so_id", referencedColumnName = "so_id")
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }
}
