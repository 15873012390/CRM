package com.zktr.crmproject.vo;

import java.util.List;

public class PLInvoiceAdvancedSearch {
    private int curpage;//当前页
    private int pagesize;//页大小
    private String invContent;//开票内容
    private String invContentSelect;//开票内容(包含、不包含)
    private List<String> invType;//票据类型
    private Double invMoney;//金额
    private String invMoneySelect;//票据金额(大于、小于、等于)
    private String signingTimeStart;//开始日期
    private String signingTimeEnd;//结束日期
    private String uname;//负责人
    private String unameSelect;//负责人(包含、不包含)
    private List<String> invRm;//是否回款
    private String invRemark;//备注
    private String invRemarkSelect;//备注(包含、不包含)
    private Integer cusId;//客户id

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
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

    public String getInvContent() {
        return invContent;
    }

    public void setInvContent(String invContent) {
        this.invContent = invContent;
    }

    public String getInvContentSelect() {
        return invContentSelect;
    }

    public void setInvContentSelect(String invContentSelect) {
        this.invContentSelect = invContentSelect;
    }

    public List<String> getInvType() {
        return invType;
    }

    public void setInvType(List<String> invType) {
        this.invType = invType;
    }

    public Double getInvMoney() {
        return invMoney;
    }

    public void setInvMoney(Double invMoney) {
        this.invMoney = invMoney;
    }

    public String getInvMoneySelect() {
        return invMoneySelect;
    }

    public void setInvMoneySelect(String invMoneySelect) {
        this.invMoneySelect = invMoneySelect;
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

    public List<String> getInvRm() {
        return invRm;
    }

    public void setInvRm(List<String> invRm) {
        this.invRm = invRm;
    }

    public String getInvRemark() {
        return invRemark;
    }

    public void setInvRemark(String invRemark) {
        this.invRemark = invRemark;
    }

    public String getInvRemarkSelect() {
        return invRemarkSelect;
    }

    public void setInvRemarkSelect(String invRemarkSelect) {
        this.invRemarkSelect = invRemarkSelect;
    }
}
