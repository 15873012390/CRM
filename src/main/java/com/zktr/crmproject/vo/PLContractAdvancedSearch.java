package com.zktr.crmproject.vo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class PLContractAdvancedSearch {
    private int curpage;//当前页
    private int pagesize; //页大小
    private Integer cusId;//客户
    private String conNumber;//合同号
    private String conNumberSelect;//合同号(包含、不包含)
    private String conTheme;//主题
    private String conThemeSelect;//主题(包含、不包含)
    private Double conSendOutMoney;//总金额
    private String conSendOutMoneySelect;//总金额(大于、小于、等于)
    private String uId;//员工
    private String uIdSelect;//员工(包含、不包含)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date signingTimeStart;//签约时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date signingTimeEnd;//
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date StartsigningTimeStart;//开始时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date StartsigningTimeEnd;//
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date EndsigningTimeStart;//结束时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date EndsigningTimeEnd;//

    private List<String> ordExecutingState; //执行状态
    private List<String> ordPurchaseWay; //购买习惯
    private List<String> conMoneyWay;//结款方式
    private List<String> conPayment;//支付方式

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

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getConNumber() {
        return conNumber;
    }

    public void setConNumber(String conNumber) {
        this.conNumber = conNumber;
    }

    public String getConNumberSelect() {
        return conNumberSelect;
    }

    public void setConNumberSelect(String conNumberSelect) {
        this.conNumberSelect = conNumberSelect;
    }

    public String getConTheme() {
        return conTheme;
    }

    public void setConTheme(String conTheme) {
        this.conTheme = conTheme;
    }

    public String getConThemeSelect() {
        return conThemeSelect;
    }

    public void setConThemeSelect(String conThemeSelect) {
        this.conThemeSelect = conThemeSelect;
    }

    public Double getConSendOutMoney() {
        return conSendOutMoney;
    }

    public void setConSendOutMoney(Double conSendOutMoney) {
        this.conSendOutMoney = conSendOutMoney;
    }

    public String getConSendOutMoneySelect() {
        return conSendOutMoneySelect;
    }

    public void setConSendOutMoneySelect(String conSendOutMoneySelect) {
        this.conSendOutMoneySelect = conSendOutMoneySelect;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuIdSelect() {
        return uIdSelect;
    }

    public void setuIdSelect(String uIdSelect) {
        this.uIdSelect = uIdSelect;
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

    public Date getStartsigningTimeStart() {
        return StartsigningTimeStart;
    }

    public void setStartsigningTimeStart(Date startsigningTimeStart) {
        StartsigningTimeStart = startsigningTimeStart;
    }

    public Date getStartsigningTimeEnd() {
        return StartsigningTimeEnd;
    }

    public void setStartsigningTimeEnd(Date startsigningTimeEnd) {
        StartsigningTimeEnd = startsigningTimeEnd;
    }

    public Date getEndsigningTimeStart() {
        return EndsigningTimeStart;
    }

    public void setEndsigningTimeStart(Date endsigningTimeStart) {
        EndsigningTimeStart = endsigningTimeStart;
    }

    public Date getEndsigningTimeEnd() {
        return EndsigningTimeEnd;
    }

    public void setEndsigningTimeEnd(Date endsigningTimeEnd) {
        EndsigningTimeEnd = endsigningTimeEnd;
    }

    public List<String> getOrdExecutingState() {
        return ordExecutingState;
    }

    public void setOrdExecutingState(List<String> ordExecutingState) {
        this.ordExecutingState = ordExecutingState;
    }

    public List<String> getOrdPurchaseWay() {
        return ordPurchaseWay;
    }

    public void setOrdPurchaseWay(List<String> ordPurchaseWay) {
        this.ordPurchaseWay = ordPurchaseWay;
    }

    public List<String> getConMoneyWay() {
        return conMoneyWay;
    }

    public void setConMoneyWay(List<String> conMoneyWay) {
        this.conMoneyWay = conMoneyWay;
    }

    public List<String> getConPayment() {
        return conPayment;
    }

    public void setConPayment(List<String> conPayment) {
        this.conPayment = conPayment;
    }
}
