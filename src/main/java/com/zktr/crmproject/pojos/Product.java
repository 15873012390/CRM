package com.zktr.crmproject.pojos;

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
    private Timestamp proDate;
    private String durableYears;
    private String proRemark;
    private Integer proDelState;
    @JsonIgnoreProperties("product")
    private List<Plandetail> plandetail;
    @JsonIgnoreProperties("product")
    private List<Pcodetail> pcodetail;
    @JsonIgnoreProperties("product")
    private List<Pcrdetail> pcrdetail;
    @JsonIgnoreProperties("product")
    private List<Pedetail> pedetail;
    @JsonIgnoreProperties("product")
    private List<Outstockdetails> outstockdetail;
    @JsonIgnoreProperties("product")
    private List<Stock> stock;
    @JsonIgnoreProperties("product")
    private List<Instockdetail> instockdetail;
    @JsonIgnoreProperties("product")
    private List<Alarmdetail> alarmdetail;
    @JsonIgnoreProperties("product")
    private List<Fitdetail> fitdetail;
    @JsonIgnoreProperties("product")
    private List<Quotedetails> quotedetails;
    @JsonIgnoreProperties("product")
    private List<Orderdetail> orderdetail;
    @JsonIgnoreProperties("product")
    private List<Sendoutdetial> sendoutdetial;
    @JsonIgnoreProperties("product")
    private List<Returnedgoodsdetial> returnedgoodsdetial;
    @JsonIgnoreProperties("product")
    private Productclassification productclassification;
    @JsonIgnoreProperties("product")
    private Warehouse warehouse;
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


    @OneToMany(mappedBy = "product")
    public List<Plandetail> getPlandetail() {
        return plandetail;
    }

    public void setPlandetail(List<Plandetail> plandetail) {
        this.plandetail = plandetail;
    }

    @OneToMany(mappedBy = "product")
    public List<Pcodetail> getPcodetail() {
        return pcodetail;
    }

    public void setPcodetail(List<Pcodetail> pcodetail) {
        this.pcodetail = pcodetail;
    }

    @OneToMany(mappedBy = "product")
    public List<Pcrdetail> getPcrdetail() {
        return pcrdetail;
    }

    public void setPcrdetail(List<Pcrdetail> pcrdetail) {
        this.pcrdetail = pcrdetail;
    }

    @OneToMany(mappedBy = "product")
    public List<Pedetail> getPedetail() {
        return pedetail;
    }

    public void setPedetail(List<Pedetail> pedetail) {
        this.pedetail = pedetail;
    }

    @OneToMany(mappedBy = "product")
    public List<Outstockdetails> getOutstockdetail() {
        return outstockdetail;
    }

    public void setOutstockdetail(List<Outstockdetails> outstockdetail) {
        this.outstockdetail = outstockdetail;
    }

    @OneToMany(mappedBy = "product")
    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    @OneToMany(mappedBy = "product")
    public List<Instockdetail> getInstockdetail() {
        return instockdetail;
    }

    public void setInstockdetail(List<Instockdetail> instockdetail) {
        this.instockdetail = instockdetail;
    }

    @OneToMany(mappedBy = "product")
    public List<Alarmdetail> getAlarmdetail() {
        return alarmdetail;
    }

    public void setAlarmdetail(List<Alarmdetail> alarmdetail) {
        this.alarmdetail = alarmdetail;
    }

    @OneToMany(mappedBy = "product")
    public List<Fitdetail> getFitdetail() {
        return fitdetail;
    }

    public void setFitdetail(List<Fitdetail> fitdetail) {
        this.fitdetail = fitdetail;
    }

    @OneToMany(mappedBy = "product")
    public List<Quotedetails> getQuotedetails() {
        return quotedetails;
    }

    public void setQuotedetails(List<Quotedetails> quotedetails) {
        this.quotedetails = quotedetails;
    }

    @OneToMany(mappedBy = "product")
    public List<Orderdetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(List<Orderdetail> orderdetail) {
        this.orderdetail = orderdetail;
    }

    @OneToMany(mappedBy = "product")
    public List<Sendoutdetial> getSendoutdetial() {
        return sendoutdetial;
    }

    public void setSendoutdetial(List<Sendoutdetial> sendoutdetial) {
        this.sendoutdetial = sendoutdetial;
    }

    @OneToMany(mappedBy = "product")
    public List<Returnedgoodsdetial> getReturnedgoodsdetial() {
        return returnedgoodsdetial;
    }

    public void setReturnedgoodsdetial(List<Returnedgoodsdetial> returnedgoodsdetial) {
        this.returnedgoodsdetial = returnedgoodsdetial;
    }

    @ManyToOne
    @JoinColumn(name="cla_id",referencedColumnName = "cla_id")
    public Productclassification getProductclassification() {
        return productclassification;
    }

    public void setProductclassification(Productclassification productclassification) {
        this.productclassification = productclassification;
    }

    @ManyToOne
    @JoinColumn(name="warehouse_id",referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @OneToMany(mappedBy = "product")
    public List<Productspecification> getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(List<Productspecification> productspecification) {
        this.productspecification = productspecification;
    }
}
