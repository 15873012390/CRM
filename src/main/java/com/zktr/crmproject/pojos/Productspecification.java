package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Productspecification {
    private int speId;
    private String proName;
    private String speSpecification;
    private String speUnit;
    private Integer speUnitConversion;
    private Product product;
    private List<Stock> stocks;
    private List<Plandetail> plandetails;
    private List<Pcodetail> pcodetails;
    private List<Pcrdetail> pcrdetails;
    private List<Pedetail> pedetails;
    private List<Outstockdetails> outstockdetails;
    private List<Instockdetail> instockdetails;
    private List<Alarmdetail> alarmdetails;
    private List<Fitdetail> fitdetails;
    private List<Quotedetails> quotedetails;
    private List<Orderdetail> orderdetails;
    private List<Sendoutdetial> sendoutdetials;
    private List<Returnedgoodsdetial> returnedgoodsdetials;
    private List<Contract> contracts;

    @Id
    @Column(name = "spe_id")
    public int getSpeId() {
        return speId;
    }

    public void setSpeId(int speId) {
        this.speId = speId;
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

    @ManyToOne
    @JoinColumn(name="pro_id",referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

   @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Plandetail> getPlandetails() {
        return plandetails;
    }

    public void setPlandetails(List<Plandetail> plandetails) {
        this.plandetails = plandetails;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Pcodetail> getPcodetails() {
        return pcodetails;
    }

    public void setPcodetails(List<Pcodetail> pcodetails) {
        this.pcodetails = pcodetails;
    }
    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Pcrdetail> getPcrdetails() {
        return pcrdetails;
    }

    public void setPcrdetails(List<Pcrdetail> pcrdetails) {
        this.pcrdetails = pcrdetails;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Pedetail> getPedetails() {
        return pedetails;
    }

    public void setPedetails(List<Pedetail> pedetails) {
        this.pedetails = pedetails;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Outstockdetails> getOutstockdetails() {
        return outstockdetails;
    }

    public void setOutstockdetails(List<Outstockdetails> outstockdetails) {
        this.outstockdetails = outstockdetails;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Instockdetail> getInstockdetails() {
        return instockdetails;
    }

    public void setInstockdetails(List<Instockdetail> instockdetails) {
        this.instockdetails = instockdetails;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Alarmdetail> getAlarmdetails() {
        return alarmdetails;
    }

    public void setAlarmdetails(List<Alarmdetail> alarmdetails) {
        this.alarmdetails = alarmdetails;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Fitdetail> getFitdetails() {
        return fitdetails;
    }

    public void setFitdetails(List<Fitdetail> fitdetails) {
        this.fitdetails = fitdetails;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Quotedetails> getQuotedetails() {
        return quotedetails;
    }

    public void setQuotedetails(List<Quotedetails> quotedetails) {
        this.quotedetails = quotedetails;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Sendoutdetial> getSendoutdetials() {
        return sendoutdetials;
    }

    public void setSendoutdetials(List<Sendoutdetial> sendoutdetials) {
        this.sendoutdetials = sendoutdetials;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Returnedgoodsdetial> getReturnedgoodsdetials() {
        return returnedgoodsdetials;
    }

    public void setReturnedgoodsdetials(List<Returnedgoodsdetial> returnedgoodsdetials) {
        this.returnedgoodsdetials = returnedgoodsdetials;
    }

    @OneToMany(mappedBy = "productspecification",cascade = CascadeType.ALL)
    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "Productspecification{" +
                "speId=" + speId +
                ", proName='" + proName + '\'' +
                ", speSpecification='" + speSpecification + '\'' +
                ", speUnit='" + speUnit + '\'' +
                ", speUnitConversion=" + speUnitConversion +
                '}';
    }
}
