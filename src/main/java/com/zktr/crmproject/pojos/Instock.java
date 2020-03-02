package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Instock {
    private int insId;
    private String title;
    private Integer warehouseId;
    private Timestamp fillTime;
    private String status;
    private String filler;
    private Integer keeper;
    private Timestamp executionTime;
    private Integer peId;
    private Integer arId;
    private Integer supplierId;
    private String remarks;
    private Warehouse warehouse;
    private Purchaseorder purchaseorder;
    private Returnedgoods returnedgoods;
    private Supplier supplier;
    private List<Instockdetail> instockdetail;
    @Id
    @Basic
    @Column(name = "ins_id")
    public Integer getInsId() {
        return insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "fill_time")
    public Timestamp getFillTime() {
        return fillTime;
    }

    public void setFillTime(Timestamp fillTime) {
        this.fillTime = fillTime;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "filler")
    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    @Basic
    @Column(name = "keeper")
    public Integer getKeeper() {
        return keeper;
    }

    public void setKeeper(Integer keeper) {
        this.keeper = keeper;
    }

    @Basic
    @Column(name = "execution_time")
    public Timestamp getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Timestamp executionTime) {
        this.executionTime = executionTime;
    }

    @Basic
    @Column(name = "pe_id")
    public Integer getPeId() {
        return peId;
    }

    public void setPeId(Integer peId) {
        this.peId = peId;
    }

    @Basic
    @Column(name = "ar_id")
    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    @Basic
    @Column(name = "supplier_id")
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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
        Instock instock = (Instock) o;
        return Objects.equals(insId, instock.insId) &&
                Objects.equals(title, instock.title) &&
                Objects.equals(warehouseId, instock.warehouseId) &&
                Objects.equals(fillTime, instock.fillTime) &&
                Objects.equals(status, instock.status) &&
                Objects.equals(filler, instock.filler) &&
                Objects.equals(keeper, instock.keeper) &&
                Objects.equals(executionTime, instock.executionTime) &&
                Objects.equals(peId, instock.peId) &&
                Objects.equals(arId, instock.arId) &&
                Objects.equals(supplierId, instock.supplierId) &&
                Objects.equals(remarks, instock.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insId, title, warehouseId, fillTime, status, filler, keeper, executionTime, peId, arId, supplierId, remarks);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "pco_id")
    public Purchaseorder getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(Purchaseorder purchaseorder) {
        this.purchaseorder = purchaseorder;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "reg_id")
    public Returnedgoods getReturnedgoods() {
        return returnedgoods;
    }

    public void setReturnedgoods(Returnedgoods returnedgoods) {
        this.returnedgoods = returnedgoods;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "supplier_id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @OneToMany(mappedBy = "instock")
    public List<Instockdetail> getInstockdetail() {
        return instockdetail;
    }

    public void setInstockdetail(List<Instockdetail> instockdetail) {
        this.instockdetail = instockdetail;
    }
}
