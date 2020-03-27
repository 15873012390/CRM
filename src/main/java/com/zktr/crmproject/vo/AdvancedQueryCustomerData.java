package com.zktr.crmproject.vo;

import java.util.Date;

public class AdvancedQueryCustomerData {
    Integer cusId;
    String cusName;
    Integer uId;
    String uName;
    String[] cusLevel;
    String cusAddr;
    String cusTel;
    String[] cusSource;
    Date cusCreationTimeStart;
    Date cusCreationTimeEnd;
    Date cusUpdateTimeStart;
    Date cusUpdateTimeEnd;
    String[] cusCredit;
    String cusZip;
    String cusFax;
    String[] cusLifeCycle;
    String cusCountry;
    String cusProvince;
    String cusCity;
    String cusDistrict;
    String[] cusState;
    String[] cusGrading;
    String cusRemarks;
    Integer curpage;
    Integer pagesize;

    public AdvancedQueryCustomerData(Integer cusId, String cusName, Integer uId, String uName, String[] cusLevel, String cusAddr, String cusTel, String[] cusSource, Date cusCreationTimeStart, Date cusCreationTimeEnd, Date cusUpdateTimeStart, Date cusUpdateTimeEnd, String[] cusCredit, String cusZip, String cusFax, String[] cusLifeCycle, String cusCountry, String cusProvince, String cusCity, String cusDistrict, String[] cusState, String[] cusGrading, String cusRemarks, Integer curpage, Integer pagesize) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.uId = uId;
        this.uName = uName;
        this.cusLevel = cusLevel;
        this.cusAddr = cusAddr;
        this.cusTel = cusTel;
        this.cusSource = cusSource;
        this.cusCreationTimeStart = cusCreationTimeStart;
        this.cusCreationTimeEnd = cusCreationTimeEnd;
        this.cusUpdateTimeStart = cusUpdateTimeStart;
        this.cusUpdateTimeEnd = cusUpdateTimeEnd;
        this.cusCredit = cusCredit;
        this.cusZip = cusZip;
        this.cusFax = cusFax;
        this.cusLifeCycle = cusLifeCycle;
        this.cusCountry = cusCountry;
        this.cusProvince = cusProvince;
        this.cusCity = cusCity;
        this.cusDistrict = cusDistrict;
        this.cusState = cusState;
        this.cusGrading = cusGrading;
        this.cusRemarks = cusRemarks;
        this.curpage = curpage;
        this.pagesize = pagesize;
    }

    public Integer getCurpage() {
        return curpage;
    }

    public void setCurpage(Integer curpage) {
        this.curpage = curpage;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }


    public AdvancedQueryCustomerData() {
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

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

    public String[] getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(String[] cusLevel) {
        this.cusLevel = cusLevel;
    }

    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(String cusTel) {
        this.cusTel = cusTel;
    }

    public String[] getCusSource() {
        return cusSource;
    }

    public void setCusSource(String[] cusSource) {
        this.cusSource = cusSource;
    }

    public Date getCusCreationTimeStart() {
        return cusCreationTimeStart;
    }

    public void setCusCreationTimeStart(Date cusCreationTimeStart) {
        this.cusCreationTimeStart = cusCreationTimeStart;
    }

    public Date getCusCreationTimeEnd() {
        return cusCreationTimeEnd;
    }

    public void setCusCreationTimeEnd(Date cusCreationTimeEnd) {
        this.cusCreationTimeEnd = cusCreationTimeEnd;
    }

    public Date getCusUpdateTimeStart() {
        return cusUpdateTimeStart;
    }

    public void setCusUpdateTimeStart(Date cusUpdateTimeStart) {
        this.cusUpdateTimeStart = cusUpdateTimeStart;
    }

    public Date getCusUpdateTimeEnd() {
        return cusUpdateTimeEnd;
    }

    public void setCusUpdateTimeEnd(Date cusUpdateTimeEnd) {
        this.cusUpdateTimeEnd = cusUpdateTimeEnd;
    }

    public String[] getCusCredit() {
        return cusCredit;
    }

    public void setCusCredit(String[] cusCredit) {
        this.cusCredit = cusCredit;
    }

    public String getCusZip() {
        return cusZip;
    }

    public void setCusZip(String cusZip) {
        this.cusZip = cusZip;
    }

    public String getCusFax() {
        return cusFax;
    }

    public void setCusFax(String cusFax) {
        this.cusFax = cusFax;
    }

    public String[] getCusLifeCycle() {
        return cusLifeCycle;
    }

    public void setCusLifeCycle(String[] cusLifeCycle) {
        this.cusLifeCycle = cusLifeCycle;
    }

    public String getCusCountry() {
        return cusCountry;
    }

    public void setCusCountry(String cusCountry) {
        this.cusCountry = cusCountry;
    }

    public String getCusProvince() {
        return cusProvince;
    }

    public void setCusProvince(String cusProvince) {
        this.cusProvince = cusProvince;
    }

    public String getCusCity() {
        return cusCity;
    }

    public void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

    public String getCusDistrict() {
        return cusDistrict;
    }

    public void setCusDistrict(String cusDistrict) {
        this.cusDistrict = cusDistrict;
    }

    public String[] getCusState() {
        return cusState;
    }

    public void setCusState(String[] cusState) {
        this.cusState = cusState;
    }

    public String[] getCusGrading() {
        return cusGrading;
    }

    public void setCusGrading(String[] cusGrading) {
        this.cusGrading = cusGrading;
    }

    public String getCusRemarks() {
        return cusRemarks;
    }

    public void setCusRemarks(String cusRemarks) {
        this.cusRemarks = cusRemarks;
    }
}
