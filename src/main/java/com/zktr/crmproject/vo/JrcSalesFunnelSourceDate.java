package com.zktr.crmproject.vo;

import java.math.BigDecimal;

public class JrcSalesFunnelSourceDate {
    private String stage;//阶段
    private Integer numbers;//数量
    private String numberConversion;//转化
    private String nmberHistoryConversion;//历史转化
    private String numberAvgen;//全局转化
    private BigDecimal money;//金额
    private String moneyConversion;//转化
    private String moneyHistoryConversion;//历史转化
    private String moneyAvgen;//全局平均

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

    public String getNumberConversion() {
        return numberConversion;
    }

    public void setNumberConversion(String numberConversion) {
        this.numberConversion = numberConversion;
    }

    public String getNmberHistoryConversion() {
        return nmberHistoryConversion;
    }

    public void setNmberHistoryConversion(String nmberHistoryConversion) {
        this.nmberHistoryConversion = nmberHistoryConversion;
    }

    public String getNumberAvgen() {
        return numberAvgen;
    }

    public void setNumberAvgen(String numberAvgen) {
        this.numberAvgen = numberAvgen;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getMoneyConversion() {
        return moneyConversion;
    }

    public void setMoneyConversion(String moneyConversion) {
        this.moneyConversion = moneyConversion;
    }

    public String getMoneyHistoryConversion() {
        return moneyHistoryConversion;
    }

    public void setMoneyHistoryConversion(String moneyHistoryConversion) {
        this.moneyHistoryConversion = moneyHistoryConversion;
    }

    public String getMoneyAvgen() {
        return moneyAvgen;
    }

    public void setMoneyAvgen(String moneyAvgen) {
        this.moneyAvgen = moneyAvgen;
    }

    public JrcSalesFunnelSourceDate(String stage, Integer numbers, String numberConversion, String nmberHistoryConversion, String numberAvgen, BigDecimal money, String moneyConversion, String moneyHistoryConversion, String moneyAvgen) {
        this.stage = stage;
        this.numbers = numbers;
        this.numberConversion = numberConversion;
        this.nmberHistoryConversion = nmberHistoryConversion;
        this.numberAvgen = numberAvgen;
        this.money = money;
        this.moneyConversion = moneyConversion;
        this.moneyHistoryConversion = moneyHistoryConversion;
        this.moneyAvgen = moneyAvgen;
    }

    public JrcSalesFunnelSourceDate() {
    }

    @Override
    public String toString() {
        return "JrcSalesFunnelSourceDate{" +
                "stage='" + stage + '\'' +
                ", numbers=" + numbers +
                ", numberConversion='" + numberConversion + '\'' +
                ", nmberHistoryConversion='" + nmberHistoryConversion + '\'' +
                ", numberAvgen='" + numberAvgen + '\'' +
                ", money=" + money +
                ", moneyConversion='" + moneyConversion + '\'' +
                ", moneyHistoryConversion='" + moneyHistoryConversion + '\'' +
                ", moneyAvgen='" + moneyAvgen + '\'' +
                '}';
    }
}
