package com.zktr.crmproject.vo;

import java.util.Date;
import java.util.List;

public class PLRmpAdvancedSearch {
    private int curpage;
    private int pagesize;
    private Date signingTimeStart; //开始日期
    private Date signingTimeEnd;//结束日期
    private Double rmpMoney; //金额
    private String rmpMoneySelect;//金额(大于小于等于)
    private String uname; //负责人
    private String unameSelect; //员工名(包含、不包含)
    private Integer cusId; //客户
    private List<String> rmpRmp; //是否回款
    private List<Integer> rmpIssue; //期次
    private String rmpRemark; //备注
    private String rmpRemarkSelect;//备注(包含不包含)

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

    public List<Integer> getRmpIssue() {
        return rmpIssue;
    }

    public void setRmpIssue(List<Integer> rmpIssue) {
        this.rmpIssue = rmpIssue;
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

    public Double getRmpMoney() {
        return rmpMoney;
    }

    public void setRmpMoney(Double rmpMoney) {
        this.rmpMoney = rmpMoney;
    }

    public String getRmpMoneySelect() {
        return rmpMoneySelect;
    }

    public void setRmpMoneySelect(String rmpMoneySelect) {
        this.rmpMoneySelect = rmpMoneySelect;
    }



    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public List<String> getRmpRmp() {
        return rmpRmp;
    }

    public void setRmpRmp(List<String> rmpRmp) {
        this.rmpRmp = rmpRmp;
    }

    public String getRmpRemark() {
        return rmpRemark;
    }

    public void setRmpRemark(String rmpRemark) {
        this.rmpRemark = rmpRemark;
    }

    public String getRmpRemarkSelect() {
        return rmpRemarkSelect;
    }

    public void setRmpRemarkSelect(String rmpRemarkSelect) {
        this.rmpRemarkSelect = rmpRemarkSelect;
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

    @Override
    public String toString() {
        return "PLRmpAdvancedSearch{" +
                "curpage=" + curpage +
                ", pagesize=" + pagesize +
                ", signingTimeStart=" + signingTimeStart +
                ", signingTimeEnd=" + signingTimeEnd +
                ", rmpMoney=" + rmpMoney +
                ", rmpMoneySelect='" + rmpMoneySelect + '\'' +
                ", uname='" + uname + '\'' +
                ", unameSelect='" + unameSelect + '\'' +
                ", cusId=" + cusId +
                ", rmpRmp=" + rmpRmp +
                ", rmpIssue=" + rmpIssue +
                ", rmpRemark='" + rmpRemark + '\'' +
                ", rmpRemarkSelect='" + rmpRemarkSelect + '\'' +
                '}';
    }
}
