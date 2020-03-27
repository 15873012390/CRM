package com.zktr.crmproject.vo;

public class ProductSpecificationVo {
    private int speId;
    private String proName;
    private String speSpecification;
    private String speUnit;
    private Integer speUnitConversion;
    private int proId;

    public ProductSpecificationVo() {
    }

    public ProductSpecificationVo(int speId, String proName, String speSpecification, String speUnit, Integer speUnitConversion, int proId) {
        this.speId = speId;
        this.proName = proName;
        this.speSpecification = speSpecification;
        this.speUnit = speUnit;
        this.speUnitConversion = speUnitConversion;
        this.proId = proId;
    }

    public int getSpeId() {
        return speId;
    }

    public void setSpeId(int speId) {
        this.speId = speId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getSpeSpecification() {
        return speSpecification;
    }

    public void setSpeSpecification(String speSpecification) {
        this.speSpecification = speSpecification;
    }

    public String getSpeUnit() {
        return speUnit;
    }

    public void setSpeUnit(String speUnit) {
        this.speUnit = speUnit;
    }

    public Integer getSpeUnitConversion() {
        return speUnitConversion;
    }

    public void setSpeUnitConversion(Integer speUnitConversion) {
        this.speUnitConversion = speUnitConversion;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }
}
