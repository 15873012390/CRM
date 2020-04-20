package com.zktr.crmproject.vo;

import java.math.BigDecimal;

public class JrcQuoteDetailsAdvance {
    private Integer curPage;
    private Integer pageSize;
    private Integer[] userIds;
    private Integer cusId;
    private Integer proId;
    private String  quantitySelect;
    private Integer  quantity;
    private String unitPriceSelect;
    private BigDecimal unitPrice;
    private String moneySelect;
    private BigDecimal money;

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer[] getUserIds() {
        return userIds;
    }

    public void setUserIds(Integer[] userIds) {
        this.userIds = userIds;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getQuantitySelect() {
        return quantitySelect;
    }

    public void setQuantitySelect(String quantitySelect) {
        this.quantitySelect = quantitySelect;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnitPriceSelect() {
        return unitPriceSelect;
    }

    public void setUnitPriceSelect(String unitPriceSelect) {
        this.unitPriceSelect = unitPriceSelect;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getMoneySelect() {
        return moneySelect;
    }

    public void setMoneySelect(String moneySelect) {
        this.moneySelect = moneySelect;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public JrcQuoteDetailsAdvance() {
    }

    public JrcQuoteDetailsAdvance(Integer curPage, Integer pageSize, Integer[] userIds, Integer cusId, Integer proId, String quantitySelect, Integer quantity, String unitPriceSelect, BigDecimal unitPrice, String moneySelect, BigDecimal money) {
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.userIds = userIds;
        this.cusId = cusId;
        this.proId = proId;
        this.quantitySelect = quantitySelect;
        this.quantity = quantity;
        this.unitPriceSelect = unitPriceSelect;
        this.unitPrice = unitPrice;
        this.moneySelect = moneySelect;
        this.money = money;
    }
}
