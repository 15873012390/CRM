package com.zktr.crmproject.pojos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Fitcustomdetails {
    private int fcdId;
    private Integer customizeId;
    private String fieldName;
    private String type;
    private String parameter;
    private Integer ifFill;

    @Id
    @Column(name = "fcd_id")
    public int getFcdId() {
        return fcdId;
    }

    public void setFcdId(int fcdId) {
        this.fcdId = fcdId;
    }

    @Basic
    @Column(name = "customize_id")
    public Integer getCustomizeId() {
        return customizeId;
    }

    public void setCustomizeId(Integer customizeId) {
        this.customizeId = customizeId;
    }

    @Basic
    @Column(name = "field_name")
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "parameter")
    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Basic
    @Column(name = "ifFill")
    public Integer getIfFill() {
        return ifFill;
    }

    public void setIfFill(Integer ifFill) {
        this.ifFill = ifFill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fitcustomdetails that = (Fitcustomdetails) o;
        return fcdId == that.fcdId &&
                Objects.equals(customizeId, that.customizeId) &&
                Objects.equals(fieldName, that.fieldName) &&
                Objects.equals(type, that.type) &&
                Objects.equals(parameter, that.parameter) &&
                Objects.equals(ifFill, that.ifFill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fcdId, customizeId, fieldName, type, parameter, ifFill);
    }
}
