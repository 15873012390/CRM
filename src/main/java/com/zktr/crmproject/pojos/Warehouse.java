package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Warehouse {
    private int warehouseId;
    private String warehouseName;
    private String stockType;
    private Integer stockValue;
    private String remarks;
    @JsonIgnoreProperties("warehouse")
    private List<Purchaseplan> purchaseplan;
    @JsonIgnoreProperties("warehouse")
    private List<Outstock> outstock;
    @JsonIgnoreProperties("warehouse")
    private List<Stock> stock;
    @JsonIgnoreProperties("warehouse")
    private List<Instock> instock;
    @JsonIgnoreProperties("warehouse")
    private List<Returnedgoods> returnedgoods;
    @JsonIgnoreProperties("warehouse")
    private List<Product> product;

    @Id
    @Column(name = "warehouse_id")
    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Basic
    @Column(name = "warehouse_name")
    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Basic
    @Column(name = "stock_type")
    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    @Basic
    @Column(name = "stock_value")
    public Integer getStockValue() {
        return stockValue;
    }

    public void setStockValue(Integer stockValue) {
        this.stockValue = stockValue;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return warehouseId == warehouse.warehouseId &&
                Objects.equals(warehouseName, warehouse.warehouseName) &&
                Objects.equals(stockType, warehouse.stockType) &&
                Objects.equals(stockValue, warehouse.stockValue) &&
                Objects.equals(remarks, warehouse.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId, warehouseName, stockType, stockValue, remarks);
    }

    @OneToMany(mappedBy = "warehouse")
    public List<Purchaseplan> getPurchaseplan() {
        return purchaseplan;
    }

    public void setPurchaseplan(List<Purchaseplan> purchaseplan) {
        this.purchaseplan = purchaseplan;
    }

    @OneToMany(mappedBy = "warehouse")
    public List<Outstock> getOutstock() {
        return outstock;
    }

    public void setOutstock(List<Outstock> outstock) {
        this.outstock = outstock;
    }

    @OneToMany(mappedBy = "warehouse")
    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    @OneToMany(mappedBy = "warehouse")
    public List<Instock> getInstock() {
        return instock;
    }

    public void setInstock(List<Instock> instock) {
        this.instock = instock;
    }

    @OneToMany(mappedBy = "warehouse")
    public List<Returnedgoods> getReturnedgoods() {
        return returnedgoods;
    }

    public void setReturnedgoods(List<Returnedgoods> returnedgoods) {
        this.returnedgoods = returnedgoods;
    }

    @OneToMany(mappedBy = "warehouse")
    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
