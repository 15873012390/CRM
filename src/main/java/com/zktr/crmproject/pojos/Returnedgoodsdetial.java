package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Returnedgoodsdetial {
    private int rgdId;
    private Integer regId;
    private Integer proId;
    private String rgdCause;
    private Integer rgdAmount;
    private BigDecimal rgdMoney;
    private String rgdRemark;
    private Returnedgoods returnedgoods;
    private Product product;

    @Id
    @Column(name = "rgd_id")
    public int getRgdId() {
        return rgdId;
    }

    public void setRgdId(int rgdId) {
        this.rgdId = rgdId;
    }

    @Basic
    @Column(name = "reg_id")
    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Returnedgoodsdetial that = (Returnedgoodsdetial) o;
        return rgdId == that.rgdId &&
                Objects.equals(regId, that.regId) &&
                Objects.equals(proId, that.proId) &&
                Objects.equals(rgdCause, that.rgdCause) &&
                Objects.equals(rgdAmount, that.rgdAmount) &&
                Objects.equals(rgdMoney, that.rgdMoney) &&
                Objects.equals(rgdRemark, that.rgdRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rgdId, regId, proId, rgdCause, rgdAmount, rgdMoney, rgdRemark);
    }

    @ManyToOne
    @JoinColumn(name = "reg_id", referencedColumnName = "reg_id")
    public Returnedgoods getReturnedgoods() {
        return returnedgoods;
    }

    public void setReturnedgoods(Returnedgoods returnedgoods) {
        this.returnedgoods = returnedgoods;
    }

    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
