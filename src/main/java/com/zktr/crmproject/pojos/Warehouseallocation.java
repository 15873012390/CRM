package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Warehouseallocation {
    private int waId;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp waDate;
    private String waStatus;
    private String remarks;
    private List<Warehouseallocationdetail> warehouseallocationdetails;
    private Warehouse inwarehouse;
    private Warehouse outwarehouse;
    private User inUser;
    private User outUser;
    private Instock instock;
    private Outstock outstock;

    @Id
    @Column(name = "wa_id")
    public int getWaId() {
        return waId;
    }

    public void setWaId(int waId) {
        this.waId = waId;
    }

    @Basic
    @Column(name = "wa_date")
    public Timestamp getWaDate() {
        return waDate;
    }

    public void setWaDate(Timestamp waDate) {
        this.waDate = waDate;
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
    @Column(name = "wa_status")
    public String getWaStatus() {
        return waStatus;
    }

    public void setWaStatus(String waStatus) {
        this.waStatus = waStatus;
    }


    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @OneToMany(mappedBy = "warehouseallocation")
    public List<Warehouseallocationdetail> getWarehouseallocationdetails() {
        return warehouseallocationdetails;
    }

    public void setWarehouseallocationdetails(List<Warehouseallocationdetail> warehouseallocationdetails) {
        this.warehouseallocationdetails = warehouseallocationdetails;
    }

    @ManyToOne
    @JoinColumn(name = "in_wid", referencedColumnName = "warehouse_id")
    public Warehouse getInwarehouse() {
        return inwarehouse;
    }

    public void setInwarehouse(Warehouse inwarehouse) {
        this.inwarehouse = inwarehouse;
    }

    @ManyToOne
    @JoinColumn(name = "out_wid", referencedColumnName = "warehouse_id")
    public Warehouse getOutwarehouse() {
        return outwarehouse;
    }

    public void setOutwarehouse(Warehouse outwarehouse) {
        this.outwarehouse = outwarehouse;
    }

    @ManyToOne
    @JoinColumn(name = "in_confirm", referencedColumnName = "u_id")
    public User getInUser() {
        return inUser;
    }

    public void setInUser(User inUser) {
        this.inUser = inUser;
    }

    @ManyToOne
    @JoinColumn(name = "out_confirm", referencedColumnName = "u_id")
    public User getOutUser() {
        return outUser;
    }

    public void setOutUser(User outUser) {
        this.outUser = outUser;
    }

    @ManyToOne
    @JoinColumn(name = "ins_id", referencedColumnName = "ins_id")
    public Instock getInstock() {
        return instock;
    }

    public void setInstock(Instock instock) {
        this.instock = instock;
    }

    @ManyToOne
    @JoinColumn(name = "out_id", referencedColumnName = "out_id")
    public Outstock getOutstock() {
        return outstock;
    }

    public void setOutstock(Outstock outstock) {
        this.outstock = outstock;
    }

    @Override
    public String toString() {
        return "Warehouseallocation{" +
                "waId=" + waId +
                ", title='" + title + '\'' +
                ", waDate=" + waDate +
                ", waStatus='" + waStatus + '\'' +
                ", remarks='" + remarks + '\'' +
                ", warehouseallocationdetails=" + warehouseallocationdetails +
                ", inwarehouse=" + inwarehouse +
                ", outwarehouse=" + outwarehouse +
                ", inUser=" + inUser +
                ", outUser=" + outUser +
                ", instock=" + instock +
                ", outstock=" + outstock +
                '}';
    }
}
