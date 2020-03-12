package com.zktr.crmproject.vo;

import java.sql.Timestamp;

public class QaAdvancedSearch {
    private int qaId;
    private String question;
    private String anthor;
    private Timestamp creatonTime[];
    private String classification[];
    private String status[];
    private Timestamp s1;
    private Timestamp s2;
    private Integer curPage;
    private Integer pageSize;

    public int getQaId() {
        return qaId;
    }

    public void setQaId(int qaId) {
        this.qaId = qaId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnthor() {
        return anthor;
    }

    public void setAnthor(String anthor) {
        this.anthor = anthor;
    }

    public Timestamp[] getCreatonTime() {
        return creatonTime;
    }

    public void setCreatonTime(Timestamp[] creatonTime) {
        this.creatonTime = creatonTime;
    }

    public String[] getClassification() {
        return classification;
    }

    public void setClassification(String[] classification) {
        this.classification = classification;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
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
