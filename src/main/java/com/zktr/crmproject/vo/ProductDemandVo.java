package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.Productspecification;
import com.zktr.crmproject.pojos.Warehouse;

public class ProductDemandVo {
    private Productspecification speId;//规格ID
    private Integer number;//需求数量
    private Warehouse outwarehouseId;//可出库仓库
    private Warehouse inwarehouseId;//需求仓库ID
    private String uName;//登记人

    public Productspecification getSpeId() {
        return speId;
    }

    public void setSpeId(Productspecification speId) {
        this.speId = speId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Warehouse getOutwarehouseId() {
        return outwarehouseId;
    }

    public void setOutwarehouseId(Warehouse outwarehouseId) {
        this.outwarehouseId = outwarehouseId;
    }

    public Warehouse getInwarehouseId() {
        return inwarehouseId;
    }

    public void setInwarehouseId(Warehouse inwarehouseId) {
        this.inwarehouseId = inwarehouseId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Override
    public String toString() {
        return "ProductDemandVo{" +
                "speId=" + speId +
                ", number=" + number +
                ", outwarehouseId=" + outwarehouseId +
                ", inwarehouseId=" + inwarehouseId +
                ", uName='" + uName + '\'' +
                '}';
    }
}
