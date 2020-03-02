package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Fitcustom {
    private int customizeId;
    private String customizeName;
    private Integer contentId;
    private Integer contentStatus;
    private List<Fitdetail> fitdetail;

    @Id
    @Column(name = "customize_id")
    public int getCustomizeId() {
        return customizeId;
    }

    public void setCustomizeId(int customizeId) {
        this.customizeId = customizeId;
    }

    @Basic
    @Column(name = "customize_name")
    public String getCustomizeName() {
        return customizeName;
    }

    public void setCustomizeName(String customizeName) {
        this.customizeName = customizeName;
    }

    @Basic
    @Column(name = "content_id")
    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @Basic
    @Column(name = "content_status")
    public Integer getContentStatus() {
        return contentStatus;
    }

    public void setContentStatus(Integer contentStatus) {
        this.contentStatus = contentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fitcustom fitcustom = (Fitcustom) o;
        return customizeId == fitcustom.customizeId &&
                Objects.equals(customizeName, fitcustom.customizeName) &&
                Objects.equals(contentId, fitcustom.contentId) &&
                Objects.equals(contentStatus, fitcustom.contentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customizeId, customizeName, contentId, contentStatus);
    }

    @OneToMany(mappedBy = "fitcustom")
    public List<Fitdetail> getFitdetail() {
        return fitdetail;
    }

    public void setFitdetail(List<Fitdetail> fitdetail) {
        this.fitdetail = fitdetail;
    }
}
