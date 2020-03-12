package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stock {
    private Integer stockId;
    private Integer stockQuantity;
    private List<Productspecification> ProductSpecification;
    @JsonIgnoreProperties("stock")
    private Warehouse warehouse;
    @JsonIgnoreProperties("stock")
    private List<Alarmdetail> alarmdetail;
    @Id
    @Basic
    @Column(name = "stock_id")
    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }


    @Basic
    @Column(name = "stock_quantity")
    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @OneToMany(mappedBy = "stocks")
    public List<Productspecification> getProductSpecification() {
        return ProductSpecification;
    }

    public void setProductSpecification(List<Productspecification> productSpecification) {
        ProductSpecification = productSpecification;
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @OneToMany(mappedBy = "stock")
    public List<Alarmdetail> getAlarmdetail() {
        return alarmdetail;
    }

    public void setAlarmdetail(List<Alarmdetail> alarmdetail) {
        this.alarmdetail = alarmdetail;
    }
}
