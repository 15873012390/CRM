package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Alarmdetail {
    private int adId;
    private Integer proId;
    private String stockId;
    private Integer check;
    private Integer alarmId;
    private Product product;
    private Stock stock;
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
    @Column(name = "pro_id")
    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    @Basic
    @Column(name = "stock_id")
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "check")
    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    @Basic
    @Column(name = "alarm_id")
    public Integer getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Integer alarmId) {
        this.alarmId = alarmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alarmdetail that = (Alarmdetail) o;
        return adId == that.adId &&
                Objects.equals(proId, that.proId) &&
                Objects.equals(stockId, that.stockId) &&
                Objects.equals(check, that.check) &&
                Objects.equals(alarmId, that.alarmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, proId, stockId, check, alarmId);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "stock_id")
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "alarm_id")
    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }
}
