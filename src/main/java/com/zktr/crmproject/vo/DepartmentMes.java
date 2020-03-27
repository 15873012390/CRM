package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.pojos.User;

public class DepartmentMes {
    private int dId;
    private String dName;
    private String dFunction;
    private Integer dBoss;
    private Integer parentId;
    private User user;
    private String dName2;

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdFunction() {
        return dFunction;
    }

    public void setdFunction(String dFunction) {
        this.dFunction = dFunction;
    }

    public Integer getdBoss() {
        return dBoss;
    }

    public void setdBoss(Integer dBoss) {
        this.dBoss = dBoss;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getdName2() {
        return dName2;
    }

    public void setdName2(String dName2) {
        this.dName2 = dName2;
    }

    @Override
    public String toString() {
        return "DepartmentMes{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dFunction='" + dFunction + '\'' +
                ", dBoss=" + dBoss +
                ", parentId=" + parentId +
                ", user=" + user +
                '}';
    }
}
