package com.zktr.crmproject.pojos;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Customer {
    private int cusId;
    @Excel(name="客户名称")
    private String cusName;
    @Excel(name="客户等级")
    private String cusLevel;
    @Excel(name="客户地址")
    private String cusAddr;
    @Excel(name="客户电话")
    private String cusTel;
    @Excel(name="客户来源")
    private String cusSource;
    @Excel(name = "创建时间", exportFormat = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp cusCreationTime;
    @Excel(name = "更新时间", exportFormat = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp cusUpdateTime;
    @Excel(name="信用等级")
    private String cusCredit;
    @Excel(name="邮编")
    private String cusZip;
    @Excel(name="传真")
    private String cusFax;
    @Excel(name="生命周期")
    private String cusLifeCycle;
    @Excel(name="国家或区域")
    private String cusCountry;
    @Excel(name="省份")
    private String cusProvince;
    @Excel(name="城市")
    private String cusCity;
    @Excel(name="区县")
    private String cusDistrict;
    @Excel(name="客户状态")
    private String cusState;
    @Excel(name="定级")
    private String cusGrading;
    @Excel(name="备注")
    private String cusRemarks;
    //出库单表
    private List<Outstock> outstock;
    //客户关怀表
    @JsonIgnoreProperties("customer")
    private List<Customercare> customercare;
    @ExcelEntity(id = "syz")
    private User user;
    //客户转移表
    private List<Customertransfer> customertransfer;
    //联系人表
    @JsonIgnoreProperties("customer")
    private List<Contacts> contacts;
//    @JsonIgnoreProperties("customer")
//    private List<Customerchurnwarning> customerchurnwarning;
    //销售机会表
    @JsonIgnoreProperties("customer")
    private List<Salesopport> salesopport;
    //待办任务表
    @JsonIgnoreProperties("customer")
    private List<Backlogtask> backlogtask;
    //报价表
    @JsonIgnoreProperties("customer")
    private List<Quote> quote;
    //订单表
    @JsonIgnoreProperties("customer")
    private List<Orders> orders;
    //订单明细表
    @JsonIgnoreProperties("customer")
    private List<Orderdetail> orderdetail;
    //合同表
    @JsonIgnoreProperties("customer")
    private List<Contract> contract;
    //发货表
    @JsonIgnoreProperties("customer")
    private List<Sendout> sendout;
    //退货表
    @JsonIgnoreProperties("customer")
    private List<Returnedgoods> returnedgoods;
    //回款表
    @JsonIgnoreProperties("customer")
    private List<Returnedmoney> returnedmoney;
    //计划回款表
    @JsonIgnoreProperties("customer")
    private List<Returnedmoneyplan> returnedmoneyplan;
    //开发票表
    @JsonIgnoreProperties("customer")
    private List<Invoice> invoice;
    //客户服务表
    @JsonIgnoreProperties("customer")
    private List<Customerservice> customerservice;
    //投诉管理表
    private List<Complaint> complaint;

    @Id
    @Column(name = "cus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "cus_name")
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }


    @Basic
    @Column(name = "cus_level")
    public String getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel;
    }

    @Basic
    @Column(name = "cus_addr")
    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    @Basic
    @Column(name = "cus_tel")
    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(String cusTel) {
        this.cusTel = cusTel;
    }

    @Basic
    @Column(name = "cus_source")
    public String getCusSource() {
        return cusSource;
    }

    public void setCusSource(String cusSource) {
        this.cusSource = cusSource;
    }

    @Basic
    @Column(name = "cus_creation_time")
    public Timestamp getCusCreationTime() {
        return cusCreationTime;
    }

    public void setCusCreationTime(Timestamp cusCreationTime) {
        this.cusCreationTime = cusCreationTime;
    }

    @Basic
    @Column(name = "cus_update_time")
    public Timestamp getCusUpdateTime() {
        return cusUpdateTime;
    }

    public void setCusUpdateTime(Timestamp cusUpdateTime) {
        this.cusUpdateTime = cusUpdateTime;
    }

    @Basic
    @Column(name = "cus_credit")
    public String getCusCredit() {
        return cusCredit;
    }

    public void setCusCredit(String cusCredit) {
        this.cusCredit = cusCredit;
    }

    @Basic
    @Column(name = "cus_zip")
    public String getCusZip() {
        return cusZip;
    }

    public void setCusZip(String cusZip) {
        this.cusZip = cusZip;
    }

    @Basic
    @Column(name = "cus_fax")
    public String getCusFax() {
        return cusFax;
    }

    public void setCusFax(String cusFax) {
        this.cusFax = cusFax;
    }

    @Basic
    @Column(name = "cus_life_cycle")
    public String getCusLifeCycle() {
        return cusLifeCycle;
    }

    public void setCusLifeCycle(String cusLifeCycle) {
        this.cusLifeCycle = cusLifeCycle;
    }

    @Basic
    @Column(name = "cus_country")
    public String getCusCountry() {
        return cusCountry;
    }

    public void setCusCountry(String cusCountry) {
        this.cusCountry = cusCountry;
    }

    @Basic
    @Column(name = "cus_province")
    public String getCusProvince() {
        return cusProvince;
    }

    public void setCusProvince(String cusProvince) {
        this.cusProvince = cusProvince;
    }

    @Basic
    @Column(name = "cus_city")
    public String getCusCity() {
        return cusCity;
    }

    public void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

    @Basic
    @Column(name = "cus_district")
    public String getCusDistrict() {
        return cusDistrict;
    }

    public void setCusDistrict(String cusDistrict) {
        this.cusDistrict = cusDistrict;
    }

    @Basic
    @Column(name = "cus_state")
    public String getCusState() {
        return cusState;
    }

    public void setCusState(String cusState) {
        this.cusState = cusState;
    }

    @Basic
    @Column(name = "cus_grading")
    public String getCusGrading() {
        return cusGrading;
    }

    public void setCusGrading(String cusGrading) {
        this.cusGrading = cusGrading;
    }

    @Basic
    @Column(name = "cus_remarks")
    public String getCusRemarks() {
        return cusRemarks;
    }

    public void setCusRemarks(String cusRemarks) {
        this.cusRemarks = cusRemarks;
    }


    @OneToMany(mappedBy = "customer")
    public List<Outstock> getOutstock() {
        return outstock;
    }

    public void setOutstock(List<Outstock> outstock) {
        this.outstock = outstock;
    }


    @OneToMany(mappedBy = "customer")
    public List<Customercare> getCustomercare() {
        return customercare;
    }

    public void setCustomercare(List<Customercare> customercare) {
        this.customercare = customercare;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "customer")
    public List<Customertransfer> getCustomertransfer() {
        return customertransfer;
    }

    public void setCustomertransfer(List<Customertransfer> customertransfer) {
        this.customertransfer = customertransfer;
    }

    @OneToMany(mappedBy = "customer")
    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

//    @OneToMany(mappedBy = "customer")
//    public List<Customerchurnwarning> getCustomerchurnwarning() {
//        return customerchurnwarning;
//    }
//
//    public void setCustomerchurnwarning(List<Customerchurnwarning> customerchurnwarning) {
//        this.customerchurnwarning = customerchurnwarning;
//    }

    @OneToMany(mappedBy = "customer")
    public List<Salesopport> getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(List<Salesopport> salesopport) {
        this.salesopport = salesopport;
    }

    @OneToMany(mappedBy = "customer")
    public List<Backlogtask> getBacklogtask() {
        return backlogtask;
    }

    public void setBacklogtask(List<Backlogtask> backlogtask) {
        this.backlogtask = backlogtask;
    }


    @OneToMany(mappedBy = "customer")
    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }

    @OneToMany(mappedBy = "customer")
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @OneToMany(mappedBy = "customer")
    public List<Orderdetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(List<Orderdetail> orderdetail) {
        this.orderdetail = orderdetail;
    }

    @OneToMany(mappedBy = "customer")
    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }

    @OneToMany(mappedBy = "customer")
    public List<Sendout> getSendout() {
        return sendout;
    }

    public void setSendout(List<Sendout> sendout) {
        this.sendout = sendout;
    }


    @OneToMany(mappedBy = "customer")
    public List<Returnedgoods> getReturnedgoods() {
        return returnedgoods;
    }

    public void setReturnedgoods(List<Returnedgoods> returnedgoods) {
        this.returnedgoods = returnedgoods;
    }

    @OneToMany(mappedBy = "customer")
    public List<Returnedmoney> getReturnedmoney() {
        return returnedmoney;
    }

    public void setReturnedmoney(List<Returnedmoney> returnedmoney) {
        this.returnedmoney = returnedmoney;
    }

    @OneToMany(mappedBy = "customer")
    public List<Returnedmoneyplan> getReturnedmoneyplan() {
        return returnedmoneyplan;
    }

    public void setReturnedmoneyplan(List<Returnedmoneyplan> returnedmoneyplan) {
        this.returnedmoneyplan = returnedmoneyplan;
    }

    @OneToMany(mappedBy = "customer")
    public List<Complaint> getComplaint() {
        return complaint;
    }

    public void setComplaint(List<Complaint> complaint) {
        this.complaint = complaint;
    }

    @OneToMany(mappedBy = "customer")
    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    @OneToMany(mappedBy = "customer")
    public List<Customerservice> getCustomerservice() {
        return customerservice;
    }

    public void setCustomerservice(List<Customerservice> customerservices) {
        this.customerservice = customerservices;
    }
}
