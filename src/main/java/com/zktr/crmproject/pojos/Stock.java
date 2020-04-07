package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stock {
    private Integer stockId;
    private Integer stockQuantity;
    private Integer stockStatus;
    private Productspecification productspecification;
    @JsonIgnoreProperties("stock")
    private Warehouse warehouse;
    @JsonIgnoreProperties("stock")
    private List<Alarmdetail> alarmdetail;
    @Id
    @Basic
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Basic
    @Column(name = "stock_status")
    public Integer getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    @ManyToOne
    @JoinColumn(name = "spe_id", referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
    }

    @OneToMany(mappedBy = "stock",cascade = CascadeType.ALL)
    public List<Alarmdetail> getAlarmdetail() {
        return alarmdetail;
    }

    public void setAlarmdetail(List<Alarmdetail> alarmdetail) {
        this.alarmdetail = alarmdetail;
    }
}
