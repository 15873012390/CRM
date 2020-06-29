package com.zktr.crmproject.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Time;
import java.sql.Date;

public class OutBackLogTaskVo {
    //行动描述
    @Excel(name = "主题")
    private String bltDescription;
    //客户(cusId)
    @Excel(name = "客户")
    private String cusName;
    //联系人
    @Excel(name = "联系人")
    private String conName;
    //完成期限
    @Excel(name = "完成日期")
    @JSONField(format = "yy-MM-dd")
    private Date finishDate;
    //优先级
    @Excel(name = "优先级")
    private String precedence;
    //执行人（userList)
    @Excel(name = "执行人")
    private String userList;
    //状态
    @Excel(name = "状态")
    private String status;

    @Excel(name = "创建人")
    private String createUser;

    public String getBltDescription() {
        return bltDescription;
    }

    public void setBltDescription(String bltDescription) {
        this.bltDescription = bltDescription;
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

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }


    public String getPrecedence() {
        return precedence;
    }

    public void setPrecedence(String precedence) {
        this.precedence = precedence;
    }

    public String getUserList() {
        return userList;
    }

    public void setUserList(String userList) {
        this.userList = userList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public OutBackLogTaskVo(String bltDescription, String cusName, String conName, Date finishDate, String precedence, String userList, String status, String createUser) {
        this.bltDescription = bltDescription;
        this.cusName = cusName;
        this.conName = conName;
        this.finishDate = finishDate;
        this.precedence = precedence;
        this.userList = userList;
        this.status = status;
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "OutBackLogTaskVo{" +
                "bltDescription='" + bltDescription + '\'' +
                ", cusName='" + cusName + '\'' +
                ", conName='" + conName + '\'' +
                ", finishDate=" + finishDate +
                ", precedence='" + precedence + '\'' +
                ", userList='" + userList + '\'' +
                ", status='" + status + '\'' +
                ", createUser='" + createUser + '\'' +
                '}';
    }

    public OutBackLogTaskVo() {
    }
}
