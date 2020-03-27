package com.zktr.crmproject.vo;

public class JrcSalesFunnel {
    private String stage;
    private Integer number;//数量
    private String numberConversion;//转化
    private String nmberHistoryConversion;//历史转化
    private String numberAvgen;//全局平均
    private String money;//预估金额
    private String moneyConversion;//转化
    private String moneyHistoryConversion;//历史转化
    private String moneyAvgen;//全局平均

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
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

    public JrcSalesFunnel() {
    }

    public JrcSalesFunnel(String stage, Integer number, String numberConversion, String nmberHistoryConversion, String numberAvgen, String money, String moneyConversion, String moneyHistoryConversion, String moneyAvgen) {
        this.stage = stage;
        this.number = number;
        this.numberConversion = numberConversion;
        this.nmberHistoryConversion = nmberHistoryConversion;
        this.numberAvgen = numberAvgen;
        this.money = money;
        this.moneyConversion = moneyConversion;
        this.moneyHistoryConversion = moneyHistoryConversion;
        this.moneyAvgen = moneyAvgen;
    }
}
