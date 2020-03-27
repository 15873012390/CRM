package com.zktr.crmproject.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;
import java.util.List;

//父级属性和子级集合对象
public class PLClassificationParent {
    //Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
    private static final long serialVersionUID = 1L;
    //分类主键
    private int claId;
    //分类方式名称
    private String claName;
    //分类父级id
    private Integer claIdId;
    //状态
    private String claState;
    //时间
    private Timestamp claDatetime;

    //分类子级的集合
    List<PLClassificationChild> childList;

    public PLClassificationParent() {
    }

    public PLClassificationParent(int claId, String claName, Integer claIdId, String claState, Timestamp claDatetime, List<PLClassificationChild> childList) {
        this.claId = claId;
        this.claName = claName;
        this.claIdId = claIdId;
        this.claState = claState;
        this.claDatetime = claDatetime;
        this.childList = childList;
    }

    public int getClaId() {
        return claId;
    }

    public void setClaId(int claId) {
        this.claId = claId;
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }

    public Integer getClaIdId() {
        return claIdId;
    }

    public void setClaIdId(Integer claIdId) {
        this.claIdId = claIdId;
    }

    public String getClaState() {
        return claState;
    }

    public void setClaState(String claState) {
        this.claState = claState;
    }

    public Timestamp getClaDatetime() {
        return claDatetime;
    }

    public void setClaDatetime(Timestamp claDatetime) {
        this.claDatetime = claDatetime;
    }

    public List<PLClassificationChild> getChildList() {
        return childList;
    }

    public void setChildList(List<PLClassificationChild> childList) {
        this.childList = childList;
    }
}
