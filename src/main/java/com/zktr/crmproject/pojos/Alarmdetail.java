package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Alarmdetail {
    private int adId;
    private Integer check;
    private Productspecification productspecification;
    @JsonIgnoreProperties("alarmdetail")
    private Stock stock;
    @JsonIgnoreProperties("alarmdetail")
    private Alarm alarm;

    @Id
    @Column(name = "ad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name="spe_id",referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
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
