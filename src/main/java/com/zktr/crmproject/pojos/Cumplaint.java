package com.zktr.crmproject.pojos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Cumplaint {
    private int comId;
    private Integer cusId;
    private String title;
    private String receptionPerson;
    private String classify;
    private String describe;
    private Timestamp comDate;
    private String complainant;
    private String emergencyLevel;
    private String treatmentProcess;
    private String dealResult;
    private String spentTime;
    private String cusFeedback;
    private String returnConfirmation;
    private String remarks;

    @Id
    @Column(name = "com_id")
    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    @Basic
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "reception_person")
    public String getReceptionPerson() {
        return receptionPerson;
    }

    public void setReceptionPerson(String receptionPerson) {
        this.receptionPerson = receptionPerson;
    }

    @Basic
    @Column(name = "classify")
    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    @Basic
    @Column(name = "describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Basic
    @Column(name = "com_date")
    public Timestamp getComDate() {
        return comDate;
    }

    public void setComDate(Timestamp comDate) {
        this.comDate = comDate;
    }

    @Basic
    @Column(name = "complainant")
    public String getComplainant() {
        return complainant;
    }

    public void setComplainant(String complainant) {
        this.complainant = complainant;
    }

    @Basic
    @Column(name = "emergency_level")
    public String getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(String emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    @Basic
    @Column(name = "treatment_process")
    public String getTreatmentProcess() {
        return treatmentProcess;
    }

    public void setTreatmentProcess(String treatmentProcess) {
        this.treatmentProcess = treatmentProcess;
    }

    @Basic
    @Column(name = "deal_result")
    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    @Basic
    @Column(name = "spent_time")
    public String getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(String spentTime) {
        this.spentTime = spentTime;
    }

    @Basic
    @Column(name = "cus_feedback")
    public String getCusFeedback() {
        return cusFeedback;
    }

    public void setCusFeedback(String cusFeedback) {
        this.cusFeedback = cusFeedback;
    }

    @Basic
    @Column(name = "return_confirmation")
    public String getReturnConfirmation() {
        return returnConfirmation;
    }

    public void setReturnConfirmation(String returnConfirmation) {
        this.returnConfirmation = returnConfirmation;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cumplaint cumplaint = (Cumplaint) o;
        return comId == cumplaint.comId &&
                Objects.equals(cusId, cumplaint.cusId) &&
                Objects.equals(title, cumplaint.title) &&
                Objects.equals(receptionPerson, cumplaint.receptionPerson) &&
                Objects.equals(classify, cumplaint.classify) &&
                Objects.equals(describe, cumplaint.describe) &&
                Objects.equals(comDate, cumplaint.comDate) &&
                Objects.equals(complainant, cumplaint.complainant) &&
                Objects.equals(emergencyLevel, cumplaint.emergencyLevel) &&
                Objects.equals(treatmentProcess, cumplaint.treatmentProcess) &&
                Objects.equals(dealResult, cumplaint.dealResult) &&
                Objects.equals(spentTime, cumplaint.spentTime) &&
                Objects.equals(cusFeedback, cumplaint.cusFeedback) &&
                Objects.equals(returnConfirmation, cumplaint.returnConfirmation) &&
                Objects.equals(remarks, cumplaint.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comId, cusId, title, receptionPerson, classify, describe, comDate, complainant, emergencyLevel, treatmentProcess, dealResult, spentTime, cusFeedback, returnConfirmation, remarks);
    }
}
