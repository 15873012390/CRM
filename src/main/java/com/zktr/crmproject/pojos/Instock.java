package com.zktr.crmproject.pojos;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Instock {
    private int insId;
    private String title;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp fillTime;
    private String status;
    private String filler;
    private String keeper;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp executionTime;
    private String remarks;
    private Warehouse warehouse;
    private Purchaseorder purchaseorder;
    private Returnedgoods returnedgoods;
    private Supplier supplier;
    private List<Instockdetail> instockdetail;
    private Warehouseallocation warehouseallocation;
    @Id
    @Basic
    @Column(name = "ins_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
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
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @ManyToOne
    @JoinColumn(name="warehouse_id",referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(name="pco_id",referencedColumnName = "pco_id")
    public Purchaseorder getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(Purchaseorder purchaseorder) {
        this.purchaseorder = purchaseorder;
    }

    @ManyToOne
    @JoinColumn(name="reg_id",referencedColumnName = "reg_id")
    public Returnedgoods getReturnedgoods() {
        return returnedgoods;
    }

    public void setReturnedgoods(Returnedgoods returnedgoods) {
        this.returnedgoods = returnedgoods;
    }

    @ManyToOne
    @JoinColumn(name="supplier_id",referencedColumnName = "supplier_id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToOne
    @JoinColumn(name="wa_id",referencedColumnName = "wa_id")
    public Warehouseallocation getWarehouseallocation() {
        return warehouseallocation;
    }

    public void setWarehouseallocation(Warehouseallocation warehouseallocation) {
        this.warehouseallocation = warehouseallocation;
    }

    @OneToMany(mappedBy = "instock",cascade = CascadeType.ALL)
    public List<Instockdetail> getInstockdetail() {
        return instockdetail;
    }

    public void setInstockdetail(List<Instockdetail> instockdetail) {
        this.instockdetail = instockdetail;
    }

    @Override
    public String toString() {
        return "Instock{" +
                "insId=" + insId +
                ", title='" + title + '\'' +
                ", fillTime=" + fillTime +
                ", status='" + status + '\'' +
                ", filler='" + filler + '\'' +
                ", keeper='" + keeper + '\'' +
                ", executionTime=" + executionTime +
                ", remarks='" + remarks + '\'' +
                ", warehouse=" + warehouse +
                ", purchaseorder=" + purchaseorder +
                ", returnedgoods=" + returnedgoods +
                ", supplier=" + supplier +
                ", instockdetail=" + instockdetail +
                '}';
    }
}
