package com.zktr.crmproject.vo;

import java.sql.Timestamp;

public class InstockAdvancedSearch {
    private Integer insId;
    private String title;
    private Integer warehouseId[];
    private Timestamp fillTime[];
    private String  status[];
    private String filler;
    private String supplierId;
    private Timestamp executionTime[];
    private Integer pcoId;
    private Integer proId;
    private Integer curPage;
    private Integer pageSize;
    private Timestamp s1;
    private Timestamp s2;
    private Timestamp s3;
    private Timestamp s4;

    public Integer getInsId() {
        return insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer[] getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer[] warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Timestamp[] getFillTime() {
        return fillTime;
    }

    public void setFillTime(Timestamp[] fillTime) {
        this.fillTime = fillTime;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Timestamp[] getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Timestamp[] executionTime) {
        this.executionTime = executionTime;
    }

    public Integer getPcoId() {
        return pcoId;
    }

    public void setPcoId(Integer pcoId) {
        this.pcoId = pcoId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
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

    public Timestamp getS1() {
        return s1;
    }

    public void setS1(Timestamp s1) {
        this.s1 = s1;
    }

    public Timestamp getS2() {
        return s2;
    }

    public void setS2(Timestamp s2) {
        this.s2 = s2;
    }

    public Timestamp getS3() {
        return s3;
    }

    public void setS3(Timestamp s3) {
        this.s3 = s3;
    }

    public Timestamp getS4() {
        return s4;
    }

    public void setS4(Timestamp s4) {
        this.s4 = s4;
    }
}
