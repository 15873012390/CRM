package com.zktr.crmproject.vo;



import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

public class PowerAndDept {
    private Integer uId;
    private String postName;
    private Integer[] power;
    private String deptName;
    private String uName;
    private String uSex;
    private Timestamp uBrith;
    private Timestamp uJoindate;
    private String uImg;

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

    public Timestamp getuBrith() {
        return uBrith;
    }

    public void setuBrith(Timestamp uBrith) {
        this.uBrith = uBrith;
    }

    public Timestamp getuJoindate() {
        return uJoindate;
    }

    public void setuJoindate(Timestamp uJoindate) {
        this.uJoindate = uJoindate;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public Integer[] getPower() {
        return power;
    }

    public void setPower(Integer[] power) {
        this.power = power;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "PowerAndDept{" +
                "uId=" + uId +
                ", postName='" + postName + '\'' +
                ", power=" + Arrays.toString(power) +
                ", deptName='" + deptName + '\'' +
                ", uName='" + uName + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uBrith=" + uBrith +
                ", uJoindate=" + uJoindate +
                ", uImg='" + uImg + '\'' +
                '}';
    }
}
