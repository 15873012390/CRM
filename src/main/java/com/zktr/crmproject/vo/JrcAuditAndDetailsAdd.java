package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.User;

public class JrcAuditAndDetailsAdd {
    private Integer quoId;
    private String audTheme;
    private Integer uId;
    private User user;

    public Integer getQuoId() {
        return quoId;
    }

    public void setQuoId(Integer quoId) {
        this.quoId = quoId;
    }

    public String getAudTheme() {
        return audTheme;
    }

    public void setAudTheme(String audTheme) {
        this.audTheme = audTheme;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JrcAuditAndDetailsAdd() {

    }

    public JrcAuditAndDetailsAdd(Integer quoId, String audTheme, Integer uId, User user) {
        this.quoId = quoId;
        this.audTheme = audTheme;
        this.uId = uId;
        this.user = user;
    }
}
