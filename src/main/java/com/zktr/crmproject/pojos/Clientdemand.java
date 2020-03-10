package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Clientdemand {
    private int cdId;
    private String cdTheme;
    private String cdPeople;
    private Timestamp recordTime;
    private Integer importance;
    private String cdContent;
    @JsonIgnoreProperties("clientdemand")
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

    @ManyToOne
    @JoinColumn(name="so_id",referencedColumnName = "so_id")
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }
}
