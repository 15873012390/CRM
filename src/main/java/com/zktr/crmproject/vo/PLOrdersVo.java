package com.zktr.crmproject.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PLOrdersVo {
    private int ordId;
    private String ordNumber;
    private String ordTheme;
    private String ordClassify;
    private String ordPayment;
    private BigDecimal ordTotalAmount;
    private BigDecimal ordSendOutMoney;
    private BigDecimal ordMargin;
    private Timestamp ordTime;
    private String ordExecutingState;
    private String ordPurchaseWay;
    private String ordHabit;
    private String ordSendOutState;
    private String outStatus;
    private String ordRemark;
    private Integer ordDelState;
    private Integer cusId;//客户id
    private Integer uId;//员工id
    private Integer quoId;//报价id
    private Integer addId;//地址id

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public String getOrdNumber() {
        return ordNumber;
    }

    public void setOrdNumber(String ordNumber) {
        this.ordNumber = ordNumber;
    }

    public String getOrdTheme() {
        return ordTheme;
    }

    public void setOrdTheme(String ordTheme) {
        this.ordTheme = ordTheme;
    }

    public String getOrdClassify() {
        return ordClassify;
    }

    public void setOrdClassify(String ordClassify) {
        this.ordClassify = ordClassify;
    }

    public String getOrdPayment() {
        return ordPayment;
    }

    public void setOrdPayment(String ordPayment) {
        this.ordPayment = ordPayment;
    }

    public BigDecimal getOrdTotalAmount() {
        return ordTotalAmount;
    }

    public void setOrdTotalAmount(BigDecimal ordTotalAmount) {
        this.ordTotalAmount = ordTotalAmount;
    }

    public BigDecimal getOrdSendOutMoney() {
        return ordSendOutMoney;
    }

    public void setOrdSendOutMoney(BigDecimal ordSendOutMoney) {
        this.ordSendOutMoney = ordSendOutMoney;
    }

    public BigDecimal getOrdMargin() {
        return ordMargin;
    }

    public void setOrdMargin(BigDecimal ordMargin) {
        this.ordMargin = ordMargin;
    }

    public Timestamp getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(Timestamp ordTime) {
        this.ordTime = ordTime;
    }

    public String getOrdExecutingState() {
        return ordExecutingState;
    }

    public void setOrdExecutingState(String ordExecutingState) {
        this.ordExecutingState = ordExecutingState;
    }

    public String getOrdPurchaseWay() {
        return ordPurchaseWay;
    }

    public void setOrdPurchaseWay(String ordPurchaseWay) {
        this.ordPurchaseWay = ordPurchaseWay;
    }

    public String getOrdHabit() {
        return ordHabit;
    }

    public void setOrdHabit(String ordHabit) {
        this.ordHabit = ordHabit;
    }

    public String getOrdSendOutState() {
        return ordSendOutState;
    }

    public void setOrdSendOutState(String ordSendOutState) {
        this.ordSendOutState = ordSendOutState;
    }

    public String getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(String outStatus) {
        this.outStatus = outStatus;
    }

    public String getOrdRemark() {
        return ordRemark;
    }

    public void setOrdRemark(String ordRemark) {
        this.ordRemark = ordRemark;
    }

    public Integer getOrdDelState() {
        return ordDelState;
    }

    public void setOrdDelState(Integer ordDelState) {
        this.ordDelState = ordDelState;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getQuoId() {
        return quoId;
    }

    public void setQuoId(Integer quoId) {
        this.quoId = quoId;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public PLOrdersVo() {
    }

    public PLOrdersVo(int ordId, String ordNumber, String ordTheme, String ordClassify, String ordPayment, BigDecimal ordTotalAmount, BigDecimal ordSendOutMoney, BigDecimal ordMargin, Timestamp ordTime, String ordExecutingState, String ordPurchaseWay, String ordHabit, String ordSendOutState, String outStatus, String ordRemark, Integer ordDelState, Integer cusId, Integer uId, Integer quoId, Integer addId) {
        this.ordId = ordId;
        this.ordNumber = ordNumber;
        this.ordTheme = ordTheme;
        this.ordClassify = ordClassify;
        this.ordPayment = ordPayment;
        this.ordTotalAmount = ordTotalAmount;
        this.ordSendOutMoney = ordSendOutMoney;
        this.ordMargin = ordMargin;
        this.ordTime = ordTime;
        this.ordExecutingState = ordExecutingState;
        this.ordPurchaseWay = ordPurchaseWay;
        this.ordHabit = ordHabit;
        this.ordSendOutState = ordSendOutState;
        this.outStatus = outStatus;
        this.ordRemark = ordRemark;
        this.ordDelState = ordDelState;
        this.cusId = cusId;
        this.uId = uId;
        this.quoId = quoId;
        this.addId = addId;
    }
}
