package com.zktr.crmproject.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zktr.crmproject.pojos.*;

import java.sql.Timestamp;
import java.util.List;

public class InstockAndDeatilVo {
    @Excel(name="序号")
    private Integer index;
    @Excel(name = "主题")
    private String title;
    @Excel(name = "填单人")
    private String filler;
    @Excel(name = "仓库名称")
    private String warehouseName;
    @Excel(name = "入库数量")
    private Integer insdQuantity;
    @Excel(name = "备注")
    private String remarks;
    @Excel(name = "规格编号")
    private Integer speId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getInsdQuantity() {
        return insdQuantity;
    }

    public void setInsdQuantity(Integer insdQuantity) {
        this.insdQuantity = insdQuantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getSpeId() {
        return speId;
    }

    public void setSpeId(Integer speId) {
        this.speId = speId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "InstockAndDeatilVo{" +
                "title='" + title + '\'' +
                ", filler='" + filler + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", insdQuantity=" + insdQuantity +
                ", remarks='" + remarks + '\'' +
                ", speId=" + speId +
                '}';
    }
}
