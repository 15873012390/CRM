package com.zktr.crmproject.vo;

public class StockAdvancedSearch {
    private Integer stockId;
    private Integer stockQuantity;
    private String proName;
    private String warehouseId[];
    private String stockNumSelect;
    private Integer curPage;
    private Integer pageSize;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String[] getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String[] warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStockNumSelect() {
        return stockNumSelect;
    }

    public void setStockNumSelect(String stockNumSelect) {
        this.stockNumSelect = stockNumSelect;
    }

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
}
