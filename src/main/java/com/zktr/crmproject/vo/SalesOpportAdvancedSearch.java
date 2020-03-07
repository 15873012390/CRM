package com.zktr.crmproject.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class SalesOpportAdvancedSearch {
    //客户id
    private Integer cusId;
    //客户联系人姓名
    private String conName;
    //机会主题内容
    private String opportunitiesThem;
    //机会主题符号(包含、不包含)
    private String opportunitiesThemSelect;
    //预计签单开始日期
    @JSONField(name = "signingTimeStart",format = "yyyy-MM-dd")
    private Date signingTimeStart;
    //预计签单结束日期
    @JSONField(name = "signingTimeEnd",format = "yyyy-MM-dd")
    private Date signingTimeEnd;
    //预期金额
    private Double amount;
    //预期金额选择符
    private String amountSelect;
    //可能性
    private String possibility;
    //可能性选择符
    private String possibilitySelect;
    //更新日期开始事件
    @JSONField(name = "updateTimeStart",format = "yyyy-MM-dd")
    private Date updateTimeStart;
    //更新日期结束日期
    @JSONField(name = "updateTimeEnd",format = "yyyy-MM-dd")
    private Date updateTimeEnd;
    //客户来源数组
    private List<String> checkedCustomerSource;
    //阶段数组
    private List<String> checkedStage;
    //负责人
    private List<Integer> checkedUser;
    //状态
    private List<Integer> checkedStatus;
    //优先级
    private List<String> checkedPriority;
    //星标
    private List<String> checkedStarTarget;
    //类型
    private List<String> checkedType;
    //创建日期开始日期
    @JSONField(name = "createTimeStart",format = "yyyy-MM-dd")
    private Date createTimeStart;
    //创建日期结束日期
    @JSONField(name = "createTimeEnd",format = "yyyy-MM-dd")
    private Date createTimeEnd;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getOpportunitiesThem() {
        return opportunitiesThem;
    }

    public void setOpportunitiesThem(String opportunitiesThem) {
        this.opportunitiesThem = opportunitiesThem;
    }

    public String getOpportunitiesThemSelect() {
        return opportunitiesThemSelect;
    }

    public void setOpportunitiesThemSelect(String opportunitiesThemSelect) {
        this.opportunitiesThemSelect = opportunitiesThemSelect;
    }

    public Date getSigningTimeStart() {
        return signingTimeStart;
    }

    public void setSigningTimeStart(Date signingTimeStart) {
        this.signingTimeStart = signingTimeStart;
    }

    public Date getSigningTimeEnd() {
        return signingTimeEnd;
    }

    public void setSigningTimeEnd(Date signingTimeEnd) {
        this.signingTimeEnd = signingTimeEnd;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAmountSelect() {
        return amountSelect;
    }

    public void setAmountSelect(String amountSelect) {
        this.amountSelect = amountSelect;
    }

    public String getPossibility() {
        return possibility;
    }

    public void setPossibility(String possibility) {
        this.possibility = possibility;
    }

    public String getPossibilitySelect() {
        return possibilitySelect;
    }

    public void setPossibilitySelect(String possibilitySelect) {
        this.possibilitySelect = possibilitySelect;
    }

    public Date getUpdateTimeStart() {
        return updateTimeStart;
    }

    public void setUpdateTimeStart(Date updateTimeStart) {
        this.updateTimeStart = updateTimeStart;
    }

    public Date getUpdateTimeEnd() {
        return updateTimeEnd;
    }

    public void setUpdateTimeEnd(Date updateTimeEnd) {
        this.updateTimeEnd = updateTimeEnd;
    }

    public List<String> getCheckedCustomerSource() {
        return checkedCustomerSource;
    }

    public void setCheckedCustomerSource(List<String> checkedCustomerSource) {
        this.checkedCustomerSource = checkedCustomerSource;
    }

    public List<String> getCheckedStage() {
        return checkedStage;
    }

    public void setCheckedStage(List<String> checkedStage) {
        this.checkedStage = checkedStage;
    }

    public List<Integer> getCheckedUser() {
        return checkedUser;
    }

    public void setCheckedUser(List<Integer> checkedUser) {
        this.checkedUser = checkedUser;
    }

    public List<Integer> getCheckedStatus() {
        return checkedStatus;
    }

    public void setCheckedStatus(List<Integer> checkedStatus) {
        this.checkedStatus = checkedStatus;
    }

    public List<String> getCheckedPriority() {
        return checkedPriority;
    }

    public void setCheckedPriority(List<String> checkedPriority) {
        this.checkedPriority = checkedPriority;
    }

    public List<String> getCheckedStarTarget() {
        return checkedStarTarget;
    }

    public void setCheckedStarTarget(List<String> checkedStarTarget) {
        this.checkedStarTarget = checkedStarTarget;
    }

    public List<String> getCheckedType() {
        return checkedType;
    }

    public void setCheckedType(List<String> checkedType) {
        this.checkedType = checkedType;
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

    public SalesOpportAdvancedSearch() {
    }

    public SalesOpportAdvancedSearch(Integer cusId, String conName, String opportunitiesThem, String opportunitiesThemSelect, Date signingTimeStart, Date signingTimeEnd, Double amount, String amountSelect, String possibility, String possibilitySelect, Date updateTimeStart, Date updateTimeEnd, List<String> checkedCustomerSource, List<String> checkedStage, List<Integer> checkedUser, List<Integer> checkedStatus, List<String> checkedPriority, List<String> checkedStarTarget, List<String> checkedType, Date createTimeStart, Date createTimeEnd) {
        this.cusId = cusId;
        this.conName = conName;
        this.opportunitiesThem = opportunitiesThem;
        this.opportunitiesThemSelect = opportunitiesThemSelect;
        this.signingTimeStart = signingTimeStart;
        this.signingTimeEnd = signingTimeEnd;
        this.amount = amount;
        this.amountSelect = amountSelect;
        this.possibility = possibility;
        this.possibilitySelect = possibilitySelect;
        this.updateTimeStart = updateTimeStart;
        this.updateTimeEnd = updateTimeEnd;
        this.checkedCustomerSource = checkedCustomerSource;
        this.checkedStage = checkedStage;
        this.checkedUser = checkedUser;
        this.checkedStatus = checkedStatus;
        this.checkedPriority = checkedPriority;
        this.checkedStarTarget = checkedStarTarget;
        this.checkedType = checkedType;
        this.createTimeStart = createTimeStart;
        this.createTimeEnd = createTimeEnd;
    }

    @Override
    public String toString() {
        return "SalesOpportAdvancedSearch{" +
                "cusId=" + cusId +
                ", conName='" + conName + '\'' +
                ", opportunitiesThem='" + opportunitiesThem + '\'' +
                ", opportunitiesThemSelect='" + opportunitiesThemSelect + '\'' +
                ", signingTimeStart=" + signingTimeStart +
                ", signingTimeEnd=" + signingTimeEnd +
                ", amount=" + amount +
                ", amountSelect='" + amountSelect + '\'' +
                ", possibility='" + possibility + '\'' +
                ", possibilitySelect='" + possibilitySelect + '\'' +
                ", updateTimeStart=" + updateTimeStart +
                ", updateTimeEnd=" + updateTimeEnd +
                ", checkedCustomerSource=" + checkedCustomerSource +
                ", checkedStage=" + checkedStage +
                ", checkedUser=" + checkedUser +
                ", checkedStatus=" + checkedStatus +
                ", checkedPriority=" + checkedPriority +
                ", checkedStarTarget=" + checkedStarTarget +
                ", checkedType=" + checkedType +
                ", createTimeStart=" + createTimeStart +
                ", createTimeEnd=" + createTimeEnd +
                '}';
    }
}
