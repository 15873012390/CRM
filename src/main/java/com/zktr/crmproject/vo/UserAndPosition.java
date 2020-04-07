package com.zktr.crmproject.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.pojos.Position;
import com.zktr.crmproject.pojos.User;

import java.sql.Timestamp;
import java.util.List;

public class UserAndPosition {
    @Excel(name = "用户ID")
    private Integer uId;
    @Excel(name = "姓名")
    private String uName;
    @Excel(name = "密码")
    private String uPass;
    @Excel(name = "性别")
    private String uSex;
    @Excel(name = "生日日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp uBirth;
    @Excel(name = "注册时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp uJoindate;
    @Excel(name = "头像")
    private String uImg;
    @Excel(name = "状态")
    private Integer uStatus;
    @Excel(name = "部门ID")
    private Integer dId;
    @Excel(name = "部门")
    private String dName;
    @Excel(name = "职位ID")
    private String postId;
//    @Excel(name = "职位")
    private String postName;
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Timestamp getuJoindate() {
        return uJoindate;
    }

    public void setuJoindate(Timestamp uJoindate) {
        this.uJoindate = uJoindate;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "UserAndPosition{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPass='" + uPass + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uBirth=" + uBirth +
                ", uJoindate=" + uJoindate +
                ", uImg='" + uImg + '\'' +
                ", uStatus=" + uStatus +
                ", dId=" + dId +
                ", dName='" + dName + '\'' +
                ", postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }
}
