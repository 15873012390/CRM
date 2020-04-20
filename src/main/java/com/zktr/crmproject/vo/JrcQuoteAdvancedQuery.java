package com.zktr.crmproject.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class JrcQuoteAdvancedQuery {
    private Integer curPage;
    private Integer pageSize;
    private List<User> userList;
    private Customer customer;
    private String quotationNoSelect;
    private String quotationNo;
    private String totalMoneySelect;
    private BigDecimal totalMoney;
    private String grossProfitSelect;
    private BigDecimal grossProfit;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date quoDateStars;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date quoDateEnd;
    private List<Integer> toOrders;
    private String quoThemeSelect;
    private String quoTheme;
    private List<Integer> quoPersons;

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getQuotationNoSelect() {
        return quotationNoSelect;
    }

    public void setQuotationNoSelect(String quotationNoSelect) {
        this.quotationNoSelect = quotationNoSelect;
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public String getTotalMoneySelect() {
        return totalMoneySelect;
    }

    public void setTotalMoneySelect(String totalMoneySelect) {
        this.totalMoneySelect = totalMoneySelect;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getGrossProfitSelect() {
        return grossProfitSelect;
    }

    public void setGrossProfitSelect(String grossProfitSelect) {
        this.grossProfitSelect = grossProfitSelect;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public Date getQuoDateStars() {
        return quoDateStars;
    }

    public void setQuoDateStars(Date quoDateStars) {
        this.quoDateStars = quoDateStars;
    }

    public Date getQuoDateEnd() {
        return quoDateEnd;
    }

    public void setQuoDateEnd(Date quoDateEnd) {
        this.quoDateEnd = quoDateEnd;
    }

    public List<Integer> getToOrders() {
        return toOrders;
    }

    public void setToOrders(List<Integer> toOrders) {
        this.toOrders = toOrders;
    }

    public String getQuoThemeSelect() {
        return quoThemeSelect;
    }

    public void setQuoThemeSelect(String quoThemeSelect) {
        this.quoThemeSelect = quoThemeSelect;
    }

    public String getQuoTheme() {
        return quoTheme;
    }

    public void setQuoTheme(String quoTheme) {
        this.quoTheme = quoTheme;
    }

    public List<Integer> getQuoPersons() {
        return quoPersons;
    }

    public void setQuoPersons(List<Integer> quoPersons) {
        this.quoPersons = quoPersons;
    }

    public JrcQuoteAdvancedQuery(Integer curPage, Integer pageSize, List<User> userList, Customer customer, String quotationNoSelect, String quotationNo, String totalMoneySelect, BigDecimal totalMoney, String grossProfitSelect, BigDecimal grossProfit, Date quoDateStars, Date quoDateEnd, List<Integer> toOrders, String quoThemeSelect, String quoTheme, List<Integer> quoPersons) {
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.userList = userList;
        this.customer = customer;
        this.quotationNoSelect = quotationNoSelect;
        this.quotationNo = quotationNo;
        this.totalMoneySelect = totalMoneySelect;
        this.totalMoney = totalMoney;
        this.grossProfitSelect = grossProfitSelect;
        this.grossProfit = grossProfit;
        this.quoDateStars = quoDateStars;
        this.quoDateEnd = quoDateEnd;
        this.toOrders = toOrders;
        this.quoThemeSelect = quoThemeSelect;
        this.quoTheme = quoTheme;
        this.quoPersons = quoPersons;
    }

    public JrcQuoteAdvancedQuery() {
    }
}
