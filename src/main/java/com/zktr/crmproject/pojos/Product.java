package com.zktr.crmproject.pojos;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Product {
    private int proId;
    private String proName;
    private String proImage;
    private String proMode;
    private String proState;
    private BigDecimal proPrice;
    private BigDecimal proCostprice;
    private String proUnit;
    private Integer proBarcode;
    private String proWeight;
    private String proGroup;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp proDate;
    private String durableYears;
    private String proRemark;
    private Integer proDelState;
    private String proExplain;
    private String proDetailedProfile;
    @JsonIgnoreProperties("product")
    private Productclassification productclassification;
    @JsonIgnoreProperties("product")
    private List<Productspecification> productspecification;

    @Id
    @Column(name = "pro_id")
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    @Basic
    @Column(name = "pro_explain")
    public String getProExplain() {
        return proExplain;
    }

    public void setProExplain(String proExplain) {
        this.proExplain = proExplain;
    }
    @Basic
    @Column(name = "pro_detailed_profile")
    public String getProDetailedProfile() {
        return proDetailedProfile;
    }

    public void setProDetailedProfile(String proDetailedProfile) {
        this.proDetailedProfile = proDetailedProfile;
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
    @Column(name = "pro_image")
    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    @Basic
    @Column(name = "pro_mode")
    public String getProMode() {
        return proMode;
    }

    public void setProMode(String proMode) {
        this.proMode = proMode;
    }

    @Basic
    @Column(name = "pro_state")
    public String getProState() {
        return proState;
    }

    public void setProState(String proState) {
        this.proState = proState;
    }

    @Basic
    @Column(name = "pro_price")
    public BigDecimal getProPrice() {
        return proPrice;
    }

    public void setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
    }

    @Basic
    @Column(name = "pro_costprice")
    public BigDecimal getProCostprice() {
        return proCostprice;
    }

    public void setProCostprice(BigDecimal proCostprice) {
        this.proCostprice = proCostprice;
    }

    @Basic
    @Column(name = "pro_unit")
    public String getProUnit() {
        return proUnit;
    }

    public void setProUnit(String proUnit) {
        this.proUnit = proUnit;
    }

    @Basic
    @Column(name = "pro_barcode")
    public Integer getProBarcode() {
        return proBarcode;
    }

    public void setProBarcode(Integer proBarcode) {
        this.proBarcode = proBarcode;
    }

    @Basic
    @Column(name = "pro_weight")
    public String getProWeight() {
        return proWeight;
    }

    public void setProWeight(String proWeight) {
        this.proWeight = proWeight;
    }

    @Basic
    @Column(name = "pro_group")
    public String getProGroup() {
        return proGroup;
    }

    public void setProGroup(String proGroup) {
        this.proGroup = proGroup;
    }

    @Basic
    @Column(name = "pro_date")
    public Timestamp getProDate() {
        return proDate;
    }

    public void setProDate(Timestamp proDate) {
        this.proDate = proDate;
    }

    @Basic
    @Column(name = "durable_years")
    public String getDurableYears() {
        return durableYears;
    }

    public void setDurableYears(String durableYears) {
        this.durableYears = durableYears;
    }

    @Basic
    @Column(name = "pro_remark")
    public String getProRemark() {
        return proRemark;
    }

    public void setProRemark(String proRemark) {
        this.proRemark = proRemark;
    }

    @Basic
    @Column(name = "pro_del_state")
    public Integer getProDelState() {
        return proDelState;
    }

    public void setProDelState(Integer proDelState) {
        this.proDelState = proDelState;
    }

    @ManyToOne
    @JoinColumn(name="cla_id",referencedColumnName = "cla_id")
    public Productclassification getProductclassification() {
        return productclassification;
    }

    public void setProductclassification(Productclassification productclassification) {
        this.productclassification = productclassification;
    }

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    public List<Productspecification> getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(List<Productspecification> productspecification) {
        this.productspecification = productspecification;
    }
}
