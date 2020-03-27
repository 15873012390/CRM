package com.zktr.crmproject.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class JrcBackLogTaskAdvancedSearch {
    private Integer curPage;
    private Integer pageSize;
    private String themSelect;
    private String them;
    private Integer cusId;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTimeStart;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTimeEnd;
    private List<Integer> precedenceList;
    private List<Integer> startList;
    private List<Integer> userList;

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

    public String getThemSelect() {
        return themSelect;
    }

    public void setThemSelect(String themSelect) {
        this.themSelect = themSelect;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public List<Integer> getPrecedenceList() {
        return precedenceList;
    }

    public void setPrecedenceList(List<Integer> precedenceList) {
        this.precedenceList = precedenceList;
    }

    public List<Integer> getStartList() {
        return startList;
    }

    public void setStartList(List<Integer> startList) {
        this.startList = startList;
    }

    public List<Integer> getUserList() {
        return userList;
    }

    public void setUserList(List<Integer> userList) {
        this.userList = userList;
    }

    public JrcBackLogTaskAdvancedSearch(Integer curPage, Integer pageSize, String themSelect, String them, Integer cusId, Date createTimeStart, Date createTimeEnd, List<Integer> precedenceList, List<Integer> startList, List<Integer> userList) {
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.themSelect = themSelect;
        this.them = them;
        this.cusId = cusId;
        this.createTimeStart = createTimeStart;
        this.createTimeEnd = createTimeEnd;
        this.precedenceList = precedenceList;
        this.startList = startList;
        this.userList = userList;
    }

    public JrcBackLogTaskAdvancedSearch() {
    }

    @Override
    public String toString() {
        return "JrcBackLogTaskAdvancedSearch{" +
                "curPage=" + curPage +
                ", pageSize=" + pageSize +
                ", themSelect='" + themSelect + '\'' +
                ", them='" + them + '\'' +
                ", cusId=" + cusId +
                ", createTimeStart=" + createTimeStart +
                ", createTimeEnd=" + createTimeEnd +
                ", precedenceList=" + precedenceList +
                ", startList=" + startList +
                ", userList=" + userList +
                '}';
    }
}
