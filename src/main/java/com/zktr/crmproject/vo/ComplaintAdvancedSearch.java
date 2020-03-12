package com.zktr.crmproject.vo;

import java.sql.Timestamp;

public class ComplaintAdvancedSearch {
    private int comId;
    private String title;
    private String receptionPerson;
    private String classify[];
    private String describes;
    private Timestamp comDate[];
    private Timestamp s1;
    private Timestamp s2;
    private String complainant;
    private String emergencyLevel[];
    private String treatmentProcess;
    private String dealResult[];
    private String spentTime[];
    private String cusId;
    private String cusName;
    private Integer curPage;
    private Integer pageSize;

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReceptionPerson() {
        return receptionPerson;
    }

    public void setReceptionPerson(String receptionPerson) {
        this.receptionPerson = receptionPerson;
    }

    public String[] getClassify() {
        return classify;
    }

    public void setClassify(String[] classify) {
        this.classify = classify;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Timestamp[] getComDate() {
        return comDate;
    }

    public void setComDate(Timestamp[] comDate) {
        this.comDate = comDate;
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

    public String getComplainant() {
        return complainant;
    }

    public void setComplainant(String complainant) {
        this.complainant = complainant;
    }

    public String[] getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(String[] emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public String getTreatmentProcess() {
        return treatmentProcess;
    }

    public void setTreatmentProcess(String treatmentProcess) {
        this.treatmentProcess = treatmentProcess;
    }

    public String[] getDealResult() {
        return dealResult;
    }

    public void setDealResult(String[] dealResult) {
        this.dealResult = dealResult;
    }

    public String[] getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(String[] spentTime) {
        this.spentTime = spentTime;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
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
