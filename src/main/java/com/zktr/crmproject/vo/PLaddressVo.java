package com.zktr.crmproject.vo;

public class PLaddressVo {
    private int addId;
    private String addName;
    private String addPhone;
    private String addAddress;
    private String addType;
    private Integer addPostcode;
    private String addProvince;
    private String addCity;
    private String addDistrict;
    private Integer cusId;

    public PLaddressVo() {
    }

    public PLaddressVo(int addId, String addName, String addPhone, String addAddress, String addType, Integer addPostcode, String addProvince, String addCity, String addDistrict, Integer cusId) {
        this.addId = addId;
        this.addName = addName;
        this.addPhone = addPhone;
        this.addAddress = addAddress;
        this.addType = addType;
        this.addPostcode = addPostcode;
        this.addProvince = addProvince;
        this.addCity = addCity;
        this.addDistrict = addDistrict;
        this.cusId = cusId;
    }

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public String getAddPhone() {
        return addPhone;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone;
    }

    public String getAddAddress() {
        return addAddress;
    }

    public void setAddAddress(String addAddress) {
        this.addAddress = addAddress;
    }

    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType;
    }

    public Integer getAddPostcode() {
        return addPostcode;
    }

    public void setAddPostcode(Integer addPostcode) {
        this.addPostcode = addPostcode;
    }

    public String getAddProvince() {
        return addProvince;
    }

    public void setAddProvince(String addProvince) {
        this.addProvince = addProvince;
    }

    public String getAddCity() {
        return addCity;
    }

    public void setAddCity(String addCity) {
        this.addCity = addCity;
    }

    public String getAddDistrict() {
        return addDistrict;
    }

    public void setAddDistrict(String addDistrict) {
        this.addDistrict = addDistrict;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }


}
