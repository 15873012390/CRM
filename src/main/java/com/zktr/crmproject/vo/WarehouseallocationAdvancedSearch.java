package com.zktr.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Arrays;

public class WarehouseallocationAdvancedSearch {
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp waDate[];
    private String waStatus[];
    private Integer inwarhouseId[];
    private Integer outwarehouseId[];
    private Integer inUserId;
    private Integer outUserId;
    private Timestamp s1;
    private Timestamp s2;
    private Integer curPage;
    private Integer pageSize;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp[] getWaDate() {
        return waDate;
    }

    public void setWaDate(Timestamp[] waDate) {
        this.waDate = waDate;
    }

    public String[] getWaStatus() {
        return waStatus;
    }

    public void setWaStatus(String[] waStatus) {
        this.waStatus = waStatus;
    }

    public Integer[] getInwarhouseId() {
        return inwarhouseId;
    }

    public void setInwarhouseId(Integer[] inwarhouseId) {
        this.inwarhouseId = inwarhouseId;
    }

    public Integer[] getOutwarehouseId() {
        return outwarehouseId;
    }

    public void setOutwarehouseId(Integer[] outwarehouseId) {
        this.outwarehouseId = outwarehouseId;
    }

    public Integer getInUserId() {
        return inUserId;
    }

    public void setInUserId(Integer inUserId) {
        this.inUserId = inUserId;
    }

    public Integer getOutUserId() {
        return outUserId;
    }

    public void setOutUserId(Integer outUserId) {
        this.outUserId = outUserId;
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

    @Override
    public String toString() {
        return "WarehouseallocationAdvancedSearch{" +
                "title='" + title + '\'' +
                ", waDate=" + Arrays.toString(waDate) +
                ", waStatus=" + Arrays.toString(waStatus) +
                ", inwarhouseId=" + Arrays.toString(inwarhouseId) +
                ", outwarehouseId=" + Arrays.toString(outwarehouseId) +
                ", inUserId=" + inUserId +
                ", outUserId=" + outUserId +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", curPage=" + curPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
