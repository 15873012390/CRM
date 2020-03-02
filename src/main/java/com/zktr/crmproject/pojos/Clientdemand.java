package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Clientdemand {
    private int cdId;
    private String cdTheme;
    private String cdPeople;
    private Integer cusId;
    private Integer soId;
    private Timestamp recordTime;
    private Integer importance;
    private String cdContent;
    private Integer delStatus;
    private Customer customer;
    private Salesopport salesopport;

    @Id
    @Column(name = "cd_id")
    public int getCdId() {
        return cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    @Basic
    @Column(name = "cd_theme")
    public String getCdTheme() {
        return cdTheme;
    }

    public void setCdTheme(String cdTheme) {
        this.cdTheme = cdTheme;
    }

    @Basic
    @Column(name = "cd_people")
    public String getCdPeople() {
        return cdPeople;
    }

    public void setCdPeople(String cdPeople) {
        this.cdPeople = cdPeople;
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
    @Column(name = "record_time")
    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "importance")
    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    @Basic
    @Column(name = "cd_content")
    public String getCdContent() {
        return cdContent;
    }

    public void setCdContent(String cdContent) {
        this.cdContent = cdContent;
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
        Clientdemand that = (Clientdemand) o;
        return cdId == that.cdId &&
                Objects.equals(cdTheme, that.cdTheme) &&
                Objects.equals(cdPeople, that.cdPeople) &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(soId, that.soId) &&
                Objects.equals(recordTime, that.recordTime) &&
                Objects.equals(importance, that.importance) &&
                Objects.equals(cdContent, that.cdContent) &&
                Objects.equals(delStatus, that.delStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cdId, cdTheme, cdPeople, cusId, soId, recordTime, importance, cdContent, delStatus);
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
    @JoinColumn(referencedColumnName = "so_id")
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }
}
