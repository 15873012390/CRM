package com.zktr.crmproject.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.zktr.crmproject.pojos.Repair;
import com.zktr.crmproject.pojos.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public class JrcActionHistoryVo {
    private Integer ahId;//行动历史记录id
    private String actDescribe;//行动历史行为描述
    private Integer cusId;//客户id
    private String conName;//联系人
    private String action;//类型
    @JSONField(format = "yy-MM-dd")
    private Date actDate;//日期
    private Repair repair;//维修工单
    private List<User> userList;//执行人

    public Integer getAhId() {
        return ahId;
    }

    public void setAhId(Integer ahId) {
        this.ahId = ahId;
    }

    public String getActDescribe() {
        return actDescribe;
    }

    public void setActDescribe(String actDescribe) {
        this.actDescribe = actDescribe;
    }

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public JrcActionHistoryVo() {
    }

    public JrcActionHistoryVo(Integer ahId, String actDescribe, Integer cusId, String conName, String action, Date actDate, Repair repair, List<User> userList) {
        this.ahId = ahId;
        this.actDescribe = actDescribe;
        this.cusId = cusId;
        this.conName = conName;
        this.action = action;
        this.actDate = actDate;
        this.repair = repair;
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "JrcActionHistoryVo{" +
                "ahId=" + ahId +
                ", actDescribe='" + actDescribe + '\'' +
                ", cusId=" + cusId +
                ", conName='" + conName + '\'' +
                ", action='" + action + '\'' +
                ", actDate=" + actDate +
                ", repair=" + repair +
                ", userList=" + userList +
                '}';
    }
}
