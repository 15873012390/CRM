package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Stock {
    private Integer stockId;
    private Integer proId;
    private Integer warehouseId;
    private Integer stockQuantity;
    private Product product;
    private Warehouse warehouse;
    private List<Alarmdetail> alarmdetail;

    @Basic
    @Column(name = "stock_id")
    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
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
    @Column(name = "warehouse_id")
    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Basic
    @Column(name = "stock_quantity")
    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(stockId, stock.stockId) &&
                Objects.equals(proId, stock.proId) &&
                Objects.equals(warehouseId, stock.warehouseId) &&
                Objects.equals(stockQuantity, stock.stockQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, proId, warehouseId, stockQuantity);
    }

    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
