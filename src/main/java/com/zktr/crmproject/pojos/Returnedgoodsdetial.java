package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Returnedgoodsdetial {
    private int rgdId;
    private String rgdCause;
    private Integer rgdAmount;
    private BigDecimal rgdMoney;
    private String rgdRemark;
    @JsonIgnoreProperties("returnedgoodsdetial")
    private Returnedgoods returnedgoods;
    private Productspecification productspecification;

    @Id
    @Column(name = "rgd_id")
    public int getRgdId() {
        return rgdId;
    }

    public void setRgdId(int rgdId) {
        this.rgdId = rgdId;
    }

    @Basic
    @Column(name = "rgd_cause")
    public String getRgdCause() {
        return rgdCause;
    }

    public void setRgdCause(String rgdCause) {
        this.rgdCause = rgdCause;
    }

    @Basic
    @Column(name = "rgd_amount")
    public Integer getRgdAmount() {
        return rgdAmount;
    }

    public void setRgdAmount(Integer rgdAmount) {
        this.rgdAmount = rgdAmount;
    }

    @Basic
    @Column(name = "rgd_money")
    public BigDecimal getRgdMoney() {
        return rgdMoney;
    }

    public void setRgdMoney(BigDecimal rgdMoney) {
        this.rgdMoney = rgdMoney;
    }

    @Basic
    @Column(name = "rgd_remark")
    public String getRgdRemark() {
        return rgdRemark;
    }

    public void setRgdRemark(String rgdRemark) {
        this.rgdRemark = rgdRemark;
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
    @JoinColumn(name="spe_id",referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
    }
}
