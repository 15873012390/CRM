package com.zktr.crmproject.vo;


import com.zktr.crmproject.pojos.User;

public class UserAndDeptParm {
    private User user;
    private Integer dId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
