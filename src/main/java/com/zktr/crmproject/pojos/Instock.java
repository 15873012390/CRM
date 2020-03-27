package com.zktr.crmproject.pojos;

import cn.afterturn.easypoi.excel.annotation.Excel;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Instock {
    private int insId;
    private String title;
    private Timestamp fillTime;
    private String status;
    private String filler;
    private Integer keeper;
    private Timestamp executionTime;
    private String remarks;
    private Warehouse warehouse;
    @NotFound(action=NotFoundAction.IGNORE)
    private Purchaseorder purchaseorder;
    @NotFound(action=NotFoundAction.IGNORE)
    private Returnedgoods returnedgoods;
    @NotFound(action=NotFoundAction.IGNORE)
    private Supplier supplier;
    @NotFound(action=NotFoundAction.IGNORE)
    private List<Instockdetail> instockdetail;
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

    @OneToMany(mappedBy = "instock",cascade = CascadeType.ALL)
    public List<Instockdetail> getInstockdetail() {
        return instockdetail;
    }

    public void setInstockdetail(List<Instockdetail> instockdetail) {
        this.instockdetail = instockdetail;
    }
}
