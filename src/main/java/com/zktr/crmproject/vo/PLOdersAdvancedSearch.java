package com.zktr.crmproject.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class PLOdersAdvancedSearch {
    private int curpage;//当前页
    private int pagesize; //页大小
    private String statevalue; //下拉数据
    private Integer cusId; //签约客户
    private String ordTheme;//主题
    private String ordThemeSelect;//主题(包含、不包含)
    private String ordNumber;//订单号
    private String ordNumberSelect;//订单号(包含、不包含)
    private Integer ordTotalAmount;//总金额
    private String ordTotalAmountSelect;//总金额(大于、小于、等于)
    private String uIdSingle;//我方签约人
    private String uIdSingleSelect;//我方签约人(包含、不包含)
    private List<String> ordPayment;//付款方式
    private List<String> ordSendOutState;//发货状态
    private List<String> ordExecutingState;//执行状态
    private List<String> purchaseWay;//购买途径
    private List<String> addProvince;//省份
    private String addCity; //城市
    private String addCitySelect;//城市(包含、不包含)
    @JSONField(name = "signingTimeStart",format = "yyyy-MM-dd")
    private Date signingTimeStart;//开始时间
    @JSONField(name = "signingTimeStart",format = "yyyy-MM-dd")
    private Date signingTimeEnd;//结束时间

    public Date getSigningTimeStart() {
        return signingTimeStart;
    }

    public void setSigningTimeStart(Date signingTimeStart) {
        this.signingTimeStart = signingTimeStart;
    }

    public Date getSigningTimeEnd() {
        return signingTimeEnd;
    }

    public void setSigningTimeEnd(Date signingTimeEnd) {
        this.signingTimeEnd = signingTimeEnd;
    }

    public PLOdersAdvancedSearch(int curpage, int pagesize, String statevalue, List<Integer> uId, Integer cusId, String ordTheme, String ordThemeSelect, String ordNumber, String ordNumberSelect, Integer ordTotalAmount, String ordTotalAmountSelect, String uIdSingle, String uIdSingleSelect, List<String> ordPayment, List<String> ordSendOutState, List<String> ordExecutingState, List<String> purchaseWay, List<String> addProvince, String addCity, String addCitySelect) {
        this.curpage = curpage;
        this.pagesize = pagesize;
        this.statevalue = statevalue;

        this.cusId = cusId;
        this.ordTheme = ordTheme;
        this.ordThemeSelect = ordThemeSelect;
        this.ordNumber = ordNumber;
        this.ordNumberSelect = ordNumberSelect;

        this.ordTotalAmount = ordTotalAmount;
        this.ordTotalAmountSelect = ordTotalAmountSelect;
        this.uIdSingle = uIdSingle;
        this.uIdSingleSelect = uIdSingleSelect;
        this.ordPayment = ordPayment;
        this.ordSendOutState = ordSendOutState;
        this.ordExecutingState = ordExecutingState;
        this.purchaseWay = purchaseWay;
        this.addProvince = addProvince;
        this.addCity = addCity;
        this.addCitySelect = addCitySelect;
    }



    public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getStatevalue() {
        return statevalue;
    }

    public void setStatevalue(String statevalue) {
        this.statevalue = statevalue;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getOrdTheme() {
        return ordTheme;
    }

    public void setOrdTheme(String ordTheme) {
        this.ordTheme = ordTheme;
    }

    public String getOrdThemeSelect() {
        return ordThemeSelect;
    }

    public void setOrdThemeSelect(String ordThemeSelect) {
        this.ordThemeSelect = ordThemeSelect;
    }

    public String getOrdNumber() {
        return ordNumber;
    }

    public void setOrdNumber(String ordNumber) {
        this.ordNumber = ordNumber;
    }

    public String getOrdNumberSelect() {
        return ordNumberSelect;
    }

    public void setOrdNumberSelect(String ordNumberSelect) {
        this.ordNumberSelect = ordNumberSelect;
    }



    public Integer getOrdTotalAmount() {
        return ordTotalAmount;
    }

    public void setOrdTotalAmount(Integer ordTotalAmount) {
        this.ordTotalAmount = ordTotalAmount;
    }

    public String getOrdTotalAmountSelect() {
        return ordTotalAmountSelect;
    }

    public void setOrdTotalAmountSelect(String ordTotalAmountSelect) {
        this.ordTotalAmountSelect = ordTotalAmountSelect;
    }

    public String getuIdSingle() {
        return uIdSingle;
    }

    public void setuIdSingle(String uIdSingle) {
        this.uIdSingle = uIdSingle;
    }

    public String getuIdSingleSelect() {
        return uIdSingleSelect;
    }

    public void setuIdSingleSelect(String uIdSingleSelect) {
        this.uIdSingleSelect = uIdSingleSelect;
    }

    public List<String> getOrdPayment() {
        return ordPayment;
    }

    public void setOrdPayment(List<String> ordPayment) {
        this.ordPayment = ordPayment;
    }

    public List<String> getOrdSendOutState() {
        return ordSendOutState;
    }

    public void setOrdSendOutState(List<String> ordSendOutState) {
        this.ordSendOutState = ordSendOutState;
    }

    public List<String> getOrdExecutingState() {
        return ordExecutingState;
    }

    public void setOrdExecutingState(List<String> ordExecutingState) {
        this.ordExecutingState = ordExecutingState;
    }

    public List<String> getPurchaseWay() {
        return purchaseWay;
    }

    public void setPurchaseWay(List<String> purchaseWay) {
        this.purchaseWay = purchaseWay;
    }

    public List<String> getAddProvince() {
        return addProvince;
    }

    public void setAddProvince(List<String> addProvince) {
        this.addProvince = addProvince;
    }

    public String getAddCity() {
        return addCity;
    }

    public void setAddCity(String addCity) {
        this.addCity = addCity;
    }

    public String getAddCitySelect() {
        return addCitySelect;
    }

    public void setAddCitySelect(String addCitySelect) {
        this.addCitySelect = addCitySelect;
    }
}
