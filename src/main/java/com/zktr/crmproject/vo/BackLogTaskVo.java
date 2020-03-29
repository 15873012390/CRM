package com.zktr.crmproject.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.User;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/*待办任务、待办任务详情添加的vo对象*/
public class BackLogTaskVo {
    //待办任务id
    private Integer bltId;
    //行动描述
    private String bltDescription;
    //完成期限
    @JSONField(format = "yy-MM-dd")
    private Date finishDate;
    //完成时间
    @JSONField(format = "HH:mm:ss")
    private Time finishTime;
    //优先级
    private Integer precedence;
    //客户(cusId)
    private Customer customer;
    //联系人
    private String conName;
    //状态
    private Integer status;
    //执行人（userList)
    private List<User> userList;

    public Integer getBltId() {
        return bltId;
    }

    public void setBltId(Integer bltId) {
        this.bltId = bltId;
    }

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

    public Integer getPrecedence() {
        return precedence;
    }

    public void setPrecedence(Integer precedence) {
        this.precedence = precedence;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public BackLogTaskVo() {
    }

    public BackLogTaskVo(Integer bltId, String bltDescription, Date finishDate, Time finishTime, Integer precedence, Customer customer, String conName, Integer status, List<User> userList) {
        this.bltId = bltId;
        this.bltDescription = bltDescription;
        this.finishDate = finishDate;
        this.finishTime = finishTime;
        this.precedence = precedence;
        this.customer = customer;
        this.conName = conName;
        this.status = status;
        this.userList = userList;
    }


}
