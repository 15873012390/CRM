package com.zktr.crmproject.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PLOrdersDetailInVo {
    private int detId;
    private Integer detNumber;
    private Timestamp detTime;
    private String detRequire;
    private String detCondition;
    private String detRemark;
    private BigDecimal detMoney;
    private Integer cusId;
    private Integer ordId;
    private Integer speId;
    private Integer uId;

    public PLOrdersDetailInVo() {

    }

    public int getDetId() {
        return detId;
    }

    public void setDetId(int detId) {
        this.detId = detId;
    }

    public Integer getDetNumber() {
        return detNumber;
    }

    public void setDetNumber(Integer detNumber) {
        this.detNumber = detNumber;
    }

    public Timestamp getDetTime() {
        return detTime;
    }

    public void setDetTime(Timestamp detTime) {
        this.detTime = detTime;
    }

    public String getDetRequire() {
        return detRequire;
    }

    public void setDetRequire(String detRequire) {
        this.detRequire = detRequire;
    }

    public String getDetCondition() {
        return detCondition;
    }

    public void setDetCondition(String detCondition) {
        this.detCondition = detCondition;
    }

    public String getDetRemark() {
        return detRemark;
    }

    public void setDetRemark(String detRemark) {
        this.detRemark = detRemark;
    }



    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public Integer getSpeId() {
        return speId;
    }

    public void setSpeId(Integer speId) {
        this.speId = speId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public BigDecimal getDetMoney() {
        return detMoney;
    }

    public void setDetMoney(BigDecimal detMoney) {
        this.detMoney = detMoney;
    }

    public PLOrdersDetailInVo(int detId, Integer detNumber, Timestamp detTime, String detRequire, String detCondition, String detRemark, BigDecimal detMoney, Integer cusId, Integer ordId, Integer speId, Integer uId) {
        this.detId = detId;
        this.detNumber = detNumber;
        this.detTime = detTime;
        this.detRequire = detRequire;
        this.detCondition = detCondition;
        this.detRemark = detRemark;
        this.detMoney = detMoney;
        this.cusId = cusId;
        this.ordId = ordId;
        this.speId = speId;
        this.uId = uId;
    }
}
