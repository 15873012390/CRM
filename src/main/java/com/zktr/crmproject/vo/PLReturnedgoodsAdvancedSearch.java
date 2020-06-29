package com.zktr.crmproject.vo;

import java.util.List;

public class PLReturnedgoodsAdvancedSearch {
    private int curpage;
    private int pagesize;
    private Integer cusId;//客户
    private List<String> regState;//退货状态
    private List<String> warehouse;//退入仓库
    private String uname;//员工
    private String unameSelect;//员工(包含、不包含)
    private Double retiredMoney;//已退金额
    private String retiredMoneySelect;//已退金额(大于、小于、等于)
    private String signingTimeStart;//退货开始范围时间
    private String signingTimeEnd;//退货结束范围时间

    public PLReturnedgoodsAdvancedSearch(int curpage, int pagesize, Integer cusId, List<String> regState, List<String> warehouse, String uname, String unameSelect, Double retiredMoney, String retiredMoneySelect, String signingTimeStart, String signingTimeEnd) {
        this.curpage = curpage;
        this.pagesize = pagesize;
        this.cusId = cusId;
        this.regState = regState;
        this.warehouse = warehouse;
        this.uname = uname;
        this.unameSelect = unameSelect;
        this.retiredMoney = retiredMoney;
        this.retiredMoneySelect = retiredMoneySelect;
        this.signingTimeStart = signingTimeStart;
        this.signingTimeEnd = signingTimeEnd;
    }

    public PLReturnedgoodsAdvancedSearch() {
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

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public List<String> getRegState() {
        return regState;
    }

    public void setRegState(List<String> regState) {
        this.regState = regState;
    }

    public List<String> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<String> warehouse) {
        this.warehouse = warehouse;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUnameSelect() {
        return unameSelect;
    }

    public void setUnameSelect(String unameSelect) {
        this.unameSelect = unameSelect;
    }

    public Double getRetiredMoney() {
        return retiredMoney;
    }

    public void setRetiredMoney(Double retiredMoney) {
        this.retiredMoney = retiredMoney;
    }

    public String getRetiredMoneySelect() {
        return retiredMoneySelect;
    }

    public void setRetiredMoneySelect(String retiredMoneySelect) {
        this.retiredMoneySelect = retiredMoneySelect;
    }

    public String getSigningTimeStart() {
        return signingTimeStart;
    }

    public void setSigningTimeStart(String signingTimeStart) {
        this.signingTimeStart = signingTimeStart;
    }

    public String getSigningTimeEnd() {
        return signingTimeEnd;
    }

    public void setSigningTimeEnd(String signingTimeEnd) {
        this.signingTimeEnd = signingTimeEnd;
    }
}
