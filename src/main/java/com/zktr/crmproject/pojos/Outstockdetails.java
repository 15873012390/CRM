package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Outstockdetails {
    private int osdId;
    private Integer proId;
    private Integer osdNumber;
    private String status;
    private Integer outId;
    private String remarks;
    private Product product;
    private Outstock outstock;

    @Id
    @Column(name = "osd_id")
    public int getOsdId() {
        return osdId;
    }

    public void setOsdId(int osdId) {
        this.osdId = osdId;
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
    @Column(name = "osd_number")
    public Integer getOsdNumber() {
        return osdNumber;
    }

    public void setOsdNumber(Integer osdNumber) {
        this.osdNumber = osdNumber;
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
    @Column(name = "out_id")
    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
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
        Outstockdetails that = (Outstockdetails) o;
        return osdId == that.osdId &&
                Objects.equals(proId, that.proId) &&
                Objects.equals(osdNumber, that.osdNumber) &&
                Objects.equals(status, that.status) &&
                Objects.equals(outId, that.outId) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(osdId, proId, osdNumber, status, outId, remarks);
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
    @JoinColumn(referencedColumnName = "out_id")
    public Outstock getOutstock() {
        return outstock;
    }

    public void setOutstock(Outstock outstock) {
        this.outstock = outstock;
    }
}
