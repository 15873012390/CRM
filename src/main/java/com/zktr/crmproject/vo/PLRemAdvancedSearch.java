package com.zktr.crmproject.vo;

import java.util.List;

public class PLRemAdvancedSearch {
    private int curpage;
    private int pagesize;
    private String signingTimeStart;//开始日期
    private String signingTimeEnd;//结束日期
    private Double remMoney;//金额
    private String remMoneySelect;//金额(大于小于等于)
    private String uname;//负责人
    private String unameSelect;//员工名(包含、不包含)
    private Integer cusId; //客户
    private List<String> remClassify;//分类
    private List<String> remRem;//是否回款
    private String remRemark;//备注
    private String remRemarkSelect;//备注(包含不包含)

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

    public Double getRemMoney() {
        return remMoney;
    }

    public void setRemMoney(Double remMoney) {
        this.remMoney = remMoney;
    }

    public String getRemMoneySelect() {
        return remMoneySelect;
    }

    public void setRemMoneySelect(String remMoneySelect) {
        this.remMoneySelect = remMoneySelect;
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

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public List<String> getRemClassify() {
        return remClassify;
    }

    public void setRemClassify(List<String> remClassify) {
        this.remClassify = remClassify;
    }

    public List<String> getRemRem() {
        return remRem;
    }

    public void setRemRem(List<String> remRem) {
        this.remRem = remRem;
    }

    public String getRemRemark() {
        return remRemark;
    }

    public void setRemRemark(String remRemark) {
        this.remRemark = remRemark;
    }

    public String getRemRemarkSelect() {
        return remRemarkSelect;
    }

    public void setRemRemarkSelect(String remRemarkSelect) {
        this.remRemarkSelect = remRemarkSelect;
    }
}
