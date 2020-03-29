package com.zktr.crmproject.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.User;

import java.util.Date;
import java.util.List;

public class JrcClientDemandAdvancedSearch {
    private Integer curpage;
    private Integer pagesize;
    private String themSelect;
    private String them;
    private Customer customer;
    @JSONField(format = "yyyy-MM-dd")
    private Date recordTimeStart;
    @JSONField(format = "yyyy-MM-dd")
    private Date recordTimeEnd;
    private List<String> importances;
    private String demandSelect;
    private String demand;

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

    public String getThemSelect() {
        return themSelect;
    }

    public void setThemSelect(String themSelect) {
        this.themSelect = themSelect;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getRecordTimeStart() {
        return recordTimeStart;
    }

    public void setRecordTimeStart(Date recordTimeStart) {
        this.recordTimeStart = recordTimeStart;
    }

    public Date getRecordTimeEnd() {
        return recordTimeEnd;
    }

    public void setRecordTimeEnd(Date recordTimeEnd) {
        this.recordTimeEnd = recordTimeEnd;
    }

    public List<String> getImportances() {
        return importances;
    }

    public void setImportances(List<String> importances) {
        this.importances = importances;
    }

    public String getDemandSelect() {
        return demandSelect;
    }

    public void setDemandSelect(String demandSelect) {
        this.demandSelect = demandSelect;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }


    public JrcClientDemandAdvancedSearch() {
    }

    public JrcClientDemandAdvancedSearch(Integer curpage, Integer pagesize, String themSelect, String them, Customer customer, Date recordTimeStart, Date recordTimeEnd, List<String> importances, String demandSelect, String demand) {
        this.curpage = curpage;
        this.pagesize = pagesize;
        this.themSelect = themSelect;
        this.them = them;
        this.customer = customer;
        this.recordTimeStart = recordTimeStart;
        this.recordTimeEnd = recordTimeEnd;
        this.importances = importances;
        this.demandSelect = demandSelect;
        this.demand = demand;
    }

    @Override
    public String toString() {
        return "JrcClientDemandAdvancedSearch{" +
                "curpage=" + curpage +
                ", pagesize=" + pagesize +
                ", themSelect='" + themSelect + '\'' +
                ", them='" + them + '\'' +
                ", customer=" + customer +
                ", recordTimeStart=" + recordTimeStart +
                ", recordTimeEnd=" + recordTimeEnd +
                ", importances=" + importances +
                ", demandSelect='" + demandSelect + '\'' +
                ", demand='" + demand + '\'' +
                '}';
    }
}
