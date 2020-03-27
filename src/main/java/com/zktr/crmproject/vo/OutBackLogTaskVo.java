package com.zktr.crmproject.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.sql.Time;
import java.sql.Date;

public class OutBackLogTaskVo {
    //行动描述
    @Excel(name = "行动描述")
    private String bltDescription;
    //完成期限
    @Excel(name = "完成期限日期")
    private Date finishDate;
    //完成时间
    @Excel(name = "完成期限时间")
    private Time finishTime;
    //优先级
    @Excel(name = "优先级")
    private String precedence;
    //客户(cusId)
    @Excel(name = "客户姓名")
    private String cusName;
    //联系人
    @Excel(name = "联系人")
    private String conName;
    //状态
    @Excel(name = "状态")
    private String status;
    //执行人（userList)
    @Excel(name = "执行人")
    private String userList;

    public String getBltDescription() {
        return bltDescription;
    }

    public void setBltDescription(String bltDescription) {
        this.bltDescription = bltDescription;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Time getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Time finishTime) {
        this.finishTime = finishTime;
    }

    public String getPrecedence() {
        return precedence;
    }

    public void setPrecedence(String precedence) {
        this.precedence = precedence;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserList() {
        return userList;
    }

    public void setUserList(String userList) {
        this.userList = userList;
    }

    public OutBackLogTaskVo() {
    }

    public OutBackLogTaskVo(String bltDescription, Date finishDate, Time finishTime, String precedence, String cusName, String conName, String status, String userList) {
        this.bltDescription = bltDescription;
        this.finishDate = finishDate;
        this.finishTime = finishTime;
        this.precedence = precedence;
        this.cusName = cusName;
        this.conName = conName;
        this.status = status;
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "OutBackLogTaskVo{" +
                "bltDescription='" + bltDescription + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", precedence='" + precedence + '\'' +
                ", cusName='" + cusName + '\'' +
                ", conName='" + conName + '\'' +
                ", status='" + status + '\'' +
                ", userList='" + userList + '\'' +
                '}';
    }
}
