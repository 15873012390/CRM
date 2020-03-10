package com.zktr.crmproject.vo;

import java.sql.Timestamp;

public class CustomerCareAdvancedSearch {
    private int ccId;
    private String title;
    private Timestamp ccDate[];
    private String executor;
    private String type;
    private Integer cusId;
    private Integer cusName;
    private Timestamp s1;
    private Timestamp s2;
    private Integer curPage;
    private Integer pageSize;

    public int getCcId() {
        return ccId;
    }

    public void setCcId(int ccId) {
        this.ccId = ccId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp[] getCcDate() {
        return ccDate;
    }

    public void setCcDate(Timestamp[] ccDate) {
        this.ccDate = ccDate;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getCusName() {
        return cusName;
    }

    public void setCusName(Integer cusName) {
        this.cusName = cusName;
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
}
