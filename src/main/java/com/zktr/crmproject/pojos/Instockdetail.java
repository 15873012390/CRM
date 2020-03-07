package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Instockdetail {
    private int insdId;
    private Integer insdQuantity;
    private String status;
    private String remarks;
    @JsonIgnoreProperties("instockdetail")
    private Product product;
    @JsonIgnoreProperties("instockdetail")
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
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @ManyToOne
    @JoinColumn(name="pro_id",referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name="ins_id",referencedColumnName = "ins_id")
    public Instock getInstock() {
        return instock;
    }

    public void setInstock(Instock instock) {
        this.instock = instock;
    }
}
