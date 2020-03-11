package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
public class Complaint {
    private int comId;
    private String title;
    private String receptionPerson;
    private String classify;
    private String describes;
    private Timestamp comDate;
    private String complainant;
    private String emergencyLevel;
    private String treatmentProcess;
    private String dealResult;
    private String spentTime;
    private String cusFeedback;
    private String returnConfirmation;
    private String remarks;
    private Customer customer;

    @Id
    @Column(name = "com_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
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
    @Column(name = "describes")
    public String getDescribe() {
        return describes;
    }

    public void setDescribe(String describe) {
        this.describes = describe;
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

    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
