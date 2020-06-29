package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.User;

import java.util.List;

public class JrcSalesFunnelUO {
    private List<User> users;
    private Integer op;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return "JrcSalesFunnelUO{" +
                "users=" + users +
                ", op=" + op +
                '}';
    }

    public JrcSalesFunnelUO(List<User> users, Integer op) {
        this.users = users;
        this.op = op;
    }
}
