package com.zktr.crmproject.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class ProductAdvancedSearch {
    private int curpage; //当前页
    private int sizepage; //页大小
    private String advancedstatevalue; //下拉数据
    private Integer proBarcode; //条形码
    private String proBarcodeSelect; //条形码(包含、不包含)
    private String proName; //产品名
    private String pronameSelect; //产品名(包含、不包含)
    private String proState; //上架下架
    private String proMode; //产品型号
    private String proModeSelect; // 型号(包含、不包含)
    private Double proPrice; //价格
    private String proPriceSelect; //价格(大于、小于、等于、不等于)
    private Double proCostprice; //成本价格
    private String proCostpriceSelect; //成本价格(大于、小于、等于、不等于)
    @JSONField(name = "signingTimeStart",format = "yyyy-MM-dd")
    private Date signingTimeStart; //产品建立时间
    @JSONField(name = "signingTimeEnd",format = "yyyy-MM-dd")
    private Date signingTimeEnd; //产品时间
    private List<String> proGroup; //产品权限分组(原料、半成品、成品)

    public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    public int getSizepage() {
        return sizepage;
    }

    public void setSizepage(int sizepage) {
        this.sizepage = sizepage;
    }

    public String getAdvancedstatevalue() {
        return advancedstatevalue;
    }

    public void setAdvancedstatevalue(String advancedstatevalue) {
        this.advancedstatevalue = advancedstatevalue;
    }

    public Integer getProBarcode() {
        return proBarcode;
    }

    public void setProBarcode(Integer proBarcode) {
        this.proBarcode = proBarcode;
    }

    public String getProBarcodeSelect() {
        return proBarcodeSelect;
    }

    public void setProBarcodeSelect(String proBarcodeSelect) {
        this.proBarcodeSelect = proBarcodeSelect;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getPronameSelect() {
        return pronameSelect;
    }

    public void setPronameSelect(String pronameSelect) {
        this.pronameSelect = pronameSelect;
    }

    public String getProState() {
        return proState;
    }

    public void setProState(String proState) {
        this.proState = proState;
    }

    public String getProMode() {
        return proMode;
    }

    public void setProMode(String proMode) {
        this.proMode = proMode;
    }

    public String getProModeSelect() {
        return proModeSelect;
    }

    public void setProModeSelect(String proModeSelect) {
        this.proModeSelect = proModeSelect;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public String getProPriceSelect() {
        return proPriceSelect;
    }

    public void setProPriceSelect(String proPriceSelect) {
        this.proPriceSelect = proPriceSelect;
    }

    public Double getProCostprice() {
        return proCostprice;
    }

    public void setProCostprice(Double proCostprice) {
        this.proCostprice = proCostprice;
    }

    public String getProCostpriceSelect() {
        return proCostpriceSelect;
    }

    public void setProCostpriceSelect(String proCostpriceSelect) {
        this.proCostpriceSelect = proCostpriceSelect;
    }

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

    public List<String> getProGroup() {
        return proGroup;
    }

    public void setProGroup(List<String> proGroup) {
        this.proGroup = proGroup;
    }

    public ProductAdvancedSearch() {
    }

    public ProductAdvancedSearch(int curpage, int sizepage, String advancedstatevalue, int proBarcode, String proBarcodeSelect, String proName, String pronameSelect, String proState, String proMode, String proModeSelect, Double proPrice, String proPriceSelect, Double proCostprice, String proCostpriceSelect, Date signingTimeStart, Date signingTimeEnd, List<String> proGroup) {
        this.curpage = curpage;
        this.sizepage = sizepage;
        this.advancedstatevalue = advancedstatevalue;
        this.proBarcode = proBarcode;
        this.proBarcodeSelect = proBarcodeSelect;
        this.proName = proName;
        this.pronameSelect = pronameSelect;
        this.proState = proState;
        this.proMode = proMode;
        this.proModeSelect = proModeSelect;
        this.proPrice = proPrice;
        this.proPriceSelect = proPriceSelect;
        this.proCostprice = proCostprice;
        this.proCostpriceSelect = proCostpriceSelect;
        this.signingTimeStart = signingTimeStart;
        this.signingTimeEnd = signingTimeEnd;
        this.proGroup = proGroup;
    }
}
