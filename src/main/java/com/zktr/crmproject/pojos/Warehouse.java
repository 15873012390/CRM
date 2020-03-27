package com.zktr.crmproject.pojos;

import cn.afterturn.easypoi.excel.annotation.Excel;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Warehouse {
    @Excel(name="仓库ID")
    private int warehouseId;
    @Excel(name="仓库名称")
    private String warehouseName;
    @Excel(name="仓库类型")
    private String stockType;
    @Excel(name="仓库价值")
    private BigDecimal stockValue;
    @Excel(name="备注")
    private String remarks;
    private List<Purchaseplan> purchaseplan;
    private List<Outstock> outstock;
    private List<Stock> stock;
    private List<Instock> instock;
    private List<Returnedgoods> returnedgoods;


    @Id
    @Column(name = "warehouse_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public BigDecimal getStockValue() {
        return stockValue;
    }

    public void setStockValue(BigDecimal stockValue) {
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

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL)
    public List<Purchaseplan> getPurchaseplan() {
        return purchaseplan;
    }

    public void setPurchaseplan(List<Purchaseplan> purchaseplan) {
        this.purchaseplan = purchaseplan;
    }

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL)
    public List<Outstock> getOutstock() {
        return outstock;
    }

    public void setOutstock(List<Outstock> outstock) {
        this.outstock = outstock;
    }

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL)
    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL)
    public List<Instock> getInstock() {
        return instock;
    }

    public void setInstock(List<Instock> instock) {
        this.instock = instock;
    }

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL)
    public List<Returnedgoods> getReturnedgoods() {
        return returnedgoods;
    }

    public void setReturnedgoods(List<Returnedgoods> returnedgoods) {
        this.returnedgoods = returnedgoods;
    }


    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", stockType='" + stockType + '\'' +
                ", stockValue=" + stockValue +
                ", remarks='" + remarks + '\'' +
                ", purchaseplan=" + purchaseplan +
                ", outstock=" + outstock +
                ", stock=" + stock +
                ", instock=" + instock +
                ", returnedgoods=" + returnedgoods +
                '}';
    }
}
