package com.zktr.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class UserMes {
    private int uId;
    private String uName;
    private String uSex;

    private Timestamp uBirth;
    private String uImg;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public Timestamp getuBirth() {
        return uBirth;
    }

    public void setuBirth(Timestamp uBirth) {
        this.uBirth = uBirth;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }
}
