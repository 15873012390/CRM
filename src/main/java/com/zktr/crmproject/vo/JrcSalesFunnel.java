package com.zktr.crmproject.vo;

import java.math.BigDecimal;

public class JrcSalesFunnel {
    private String stage;
    private Integer numbers;//数量
    private Integer nmberHistoryConversion;//历史数量
    private Integer numberAvgen;//全局数量
    private BigDecimal money;//金额
    private BigDecimal moneyHistoryConversion;//历史转化
    private BigDecimal moneyAvgen;//全局平均

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public Integer getNmberHistoryConversion() {
        return nmberHistoryConversion;
    }

    public void setNmberHistoryConversion(Integer nmberHistoryConversion) {
        this.nmberHistoryConversion = nmberHistoryConversion;
    }

    public Integer getNumberAvgen() {
        return numberAvgen;
    }

    public void setNumberAvgen(Integer numberAvgen) {
        this.numberAvgen = numberAvgen;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoneyHistoryConversion() {
        return moneyHistoryConversion;
    }

    public void setMoneyHistoryConversion(BigDecimal moneyHistoryConversion) {
        this.moneyHistoryConversion = moneyHistoryConversion;
    }

    public BigDecimal getMoneyAvgen() {
        return moneyAvgen;
    }

    public void setMoneyAvgen(BigDecimal moneyAvgen) {
        this.moneyAvgen = moneyAvgen;
    }

    public JrcSalesFunnel(String stage, Integer numbers, Integer nmberHistoryConversion, Integer numberAvgen, BigDecimal money, BigDecimal moneyHistoryConversion, BigDecimal moneyAvgen) {
        this.stage = stage;
        this.numbers = numbers;
        this.nmberHistoryConversion = nmberHistoryConversion;
        this.numberAvgen = numberAvgen;
        this.money = money;
        this.moneyHistoryConversion = moneyHistoryConversion;
        this.moneyAvgen = moneyAvgen;
    }

    public JrcSalesFunnel() {
    }

    @Override
    public String toString() {
        return "JrcSalesFunnel{" +
                "stage='" + stage + '\'' +
                ", numbers=" + numbers +
                ", nmberHistoryConversion=" + nmberHistoryConversion +
                ", numberAvgen=" + numberAvgen +
                ", money=" + money +
                ", moneyHistoryConversion=" + moneyHistoryConversion +
                ", moneyAvgen=" + moneyAvgen +
                '}';
    }
}
