package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Instockdetail {
    private int insdId;
    private Integer proId;
    private Integer insdQuantity;
    private String status;
    private Integer insId;
    private String remarks;
    private Product product;
    private Instock instock;

    @Id
    @Column(name = "insd_id")
    public int getInsdId() {
        return insdId;
    }

    public void setInsdId(int insdId) {
        this.insdId = insdId;
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
    @Column(name = "insd_quantity")
    public Integer getInsdQuantity() {
        return insdQuantity;
    }

    public void setInsdQuantity(Integer insdQuantity) {
        this.insdQuantity = insdQuantity;
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
    @Column(name = "ins_id")
    public Integer getInsId() {
        return insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
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
        Instockdetail that = (Instockdetail) o;
        return insdId == that.insdId &&
                Objects.equals(proId, that.proId) &&
                Objects.equals(insdQuantity, that.insdQuantity) &&
                Objects.equals(status, that.status) &&
                Objects.equals(insId, that.insId) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insdId, proId, insdQuantity, status, insId, remarks);
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
    @JoinColumn(referencedColumnName = "ins_id")
    public Instock getInstock() {
        return instock;
    }

    public void setInstock(Instock instock) {
        this.instock = instock;
    }
}
