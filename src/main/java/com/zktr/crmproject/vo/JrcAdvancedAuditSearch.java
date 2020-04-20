package com.zktr.crmproject.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

public class JrcAdvancedAuditSearch {

    private Integer[] proposer;
    private Integer[] start;
    private Integer[] currentApprover;

    private Timestamp[] createDate;
    private Timestamp createStart;
    private Timestamp createEnd;
    private Integer curPage;
    private Integer pageSize;

    public Timestamp getCreateStart() {
        return createStart;
    }

    public void setCreateStart(Timestamp createStart) {
        this.createStart = createStart;
    }

    public Timestamp getCreateEnd() {
        return createEnd;
    }

    public void setCreateEnd(Timestamp createEnd) {
        this.createEnd = createEnd;
    }



    public Integer[] getProposer() {
        return proposer;
    }

    public void setProposer(Integer[] proposer) {
        this.proposer = proposer;
    }

    public Integer[] getStart() {
        return start;
    }

    public void setStart(Integer[] start) {
        this.start = start;
    }

    public Integer[] getCurrentApprover() {
        return currentApprover;
    }

    public void setCurrentApprover(Integer[] currentApprover) {
        this.currentApprover = currentApprover;
    }

    public Timestamp[] getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp[] createDate) {
        this.createDate = createDate;
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

    public JrcAdvancedAuditSearch() {
    }

    public JrcAdvancedAuditSearch(Integer[] proposer, Integer[] start, Integer[] currentApprover, Timestamp[] createDate, Timestamp createStart, Timestamp createEnd, Integer curPage, Integer pageSize) {
        this.proposer = proposer;
        this.start = start;
        this.currentApprover = currentApprover;
        this.createDate = createDate;
        this.createStart = createStart;
        this.createEnd = createEnd;
        this.curPage = curPage;
        this.pageSize = pageSize;
    }
}
