package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Productspecification {
    private int speId;
    private Integer proId;
    private String proName;
    private String speSpecification;
    private String speUnit;
    private Integer speUnitConversion;
    private Product product;

    @Id
    @Column(name = "spe_id")
    public int getSpeId() {
        return speId;
    }

    public void setSpeId(int speId) {
        this.speId = speId;
    }

    @Basic
    @Column(name = "pro_id")
    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    @Basic
    @Column(name = "pro_name")
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Basic
    @Column(name = "spe_specification")
    public String getSpeSpecification() {
        return speSpecification;
    }

    public void setSpeSpecification(String speSpecification) {
        this.speSpecification = speSpecification;
    }

    @Basic
    @Column(name = "spe_unit")
    public String getSpeUnit() {
        return speUnit;
    }

    public void setSpeUnit(String speUnit) {
        this.speUnit = speUnit;
    }

    @Basic
    @Column(name = "spe_unit_conversion")
    public Integer getSpeUnitConversion() {
        return speUnitConversion;
    }

    public void setSpeUnitConversion(Integer speUnitConversion) {
        this.speUnitConversion = speUnitConversion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productspecification that = (Productspecification) o;
        return speId == that.speId &&
                Objects.equals(proId, that.proId) &&
                Objects.equals(proName, that.proName) &&
                Objects.equals(speSpecification, that.speSpecification) &&
                Objects.equals(speUnit, that.speUnit) &&
                Objects.equals(speUnitConversion, that.speUnitConversion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speId, proId, proName, speSpecification, speUnit, speUnitConversion);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
