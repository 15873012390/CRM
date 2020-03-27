package com.zktr.crmproject.vo;


public class WareHouseAdvancedSearch {
    private int warehouseId;
    private String warehouseName;
    private String stockType[];
    private Integer curPage;
    private Integer pageSize;

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String[] getStockType() {
        return stockType;
    }

    public void setStockType(String[] stockType) {
        this.stockType = stockType;
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
