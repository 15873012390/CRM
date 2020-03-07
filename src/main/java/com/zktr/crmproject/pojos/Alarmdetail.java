package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Alarmdetail {
    private int adId;
    private Integer check;
    @JsonIgnoreProperties("alarmdetail")
    private Product product;
    @JsonIgnoreProperties("alarmdetail")
    private Stock stock;
    @JsonIgnoreProperties("alarmdetail")
    private Alarm alarm;

    @Id
    @Column(name = "ad_id")
    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }


    @Basic
    @Column(name = "check")
    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }


    @ManyToOne
    @JoinColumn(name="pro_id",referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name="stock_id",referencedColumnName = "stock_id")
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @ManyToOne
    @JoinColumn(name="alarm_id",referencedColumnName = "alarm_id")
    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }
}
