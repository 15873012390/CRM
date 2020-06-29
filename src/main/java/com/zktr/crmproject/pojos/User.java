package com.zktr.crmproject.pojos;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Excel(name="用户ID",needMerge = true)
    private int uId;
    @Excel(name = "姓名")
    private String uName;
    private String uPass;
    private Integer uStatus;
    @Excel(name = "性别")
    private String uSex;
    //    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp uBirth;
    //    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @Excel(name = "加入日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp uJoindate;
    private String uImg;
    private String ucolor;
    private List<Customer> customer;
    @JsonIgnoreProperties("user3")
    private List<Customertransfer> customertransfer3;
    @JsonIgnoreProperties("user2")
    private List<Customertransfer> customertransfer2;
    @JsonIgnoreProperties("user1")
    private List<Customertransfer> customertransfer1;
    @JsonIgnoreProperties("user")
    private List<Customerupdatelog> customerupdatelog;
    @JsonIgnoreProperties("user")
    private List<Salesopport> salesopport;
    @JsonIgnoreProperties("user")
    private List<Backlogtask> backlogtask;
    @JsonIgnoreProperties("user")
    private List<Backlogtaskdetails> backlogtaskdetails;
    @JsonIgnoreProperties("user")
    private List<Actionhistory> actionhistory;
    @JsonIgnoreProperties("user")
    private List<Actionhistorydetails> actionhistorydetails;
    @JsonIgnoreProperties("user")
    private List<Evection> evection;
    @JsonIgnoreProperties("user")
    private List<Evectionsummarize> eventionsummarize;
    @JsonIgnoreProperties("user")
    private List<Quote> quote;
    /*   @JsonIgnoreProperties("user")*/
    private List<Audit> audit;
    @JsonIgnoreProperties("user")
    private List<Auditdetails> auditdetails;
    @JsonIgnoreProperties("user")
    private List<Costaudit> costaudit;
    private List<Costauditdetails> coatauditdetails;
    private List<Position> position;
    private Department department;
    private List<Leaved> leaved;
    private List<Orders> orders;
    private List<Orderdetail> orderdetail;
    private List<Contract> contract;
    private List<Returnedgoods> returnedgoods;
    private List<Returnedmoney> returnedmoney;
    private List<Returnedmoneyplan> returnedmoneyplan;
    private List<Invoice> invoice;
    private List<Warehouseallocation> inConfirms;
    private List<Warehouseallocation> outConfirms;

    @Id
    @Column(name = "u_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_name")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "u_pass")
    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Timestamp getuBirth() {
        return uBirth;
    }

    public void setuBirth(Timestamp uBirth) {
        this.uBirth = uBirth;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Timestamp getuJoindate() {
        return uJoindate;
    }

    public void setuJoindate(Timestamp uJoindate) {
        this.uJoindate = uJoindate;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }

    @Basic
    @Column(name = "u_status")
    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public String getUcolor() {
        return ucolor;
    }

    public void setUcolor(String ucolor) {
        this.ucolor = ucolor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uId == user.uId &&
                Objects.equals(uName, user.uName) &&
                Objects.equals(uPass, user.uPass) &&
                Objects.equals(uStatus, user.uStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uName, uPass, uStatus);
    }

    @OneToMany(mappedBy = "user")
    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    @OneToMany(mappedBy = "user3")
    public List<Customertransfer> getCustomertransfer3() {
        return customertransfer3;
    }

    public void setCustomertransfer3(List<Customertransfer> customertransfer3) {
        this.customertransfer3 = customertransfer3;
    }

    @OneToMany(mappedBy = "user2")
    public List<Customertransfer> getCustomertransfer2() {
        return customertransfer2;
    }

    public void setCustomertransfer2(List<Customertransfer> customertransfer2) {
        this.customertransfer2 = customertransfer2;
    }

    @OneToMany(mappedBy = "user1")
    public List<Customertransfer> getCustomertransfer1() {
        return customertransfer1;
    }

    public void setCustomertransfer1(List<Customertransfer> customertransfer1) {
        this.customertransfer1 = customertransfer1;
    }

    @OneToMany(mappedBy = "user")
    public List<Customerupdatelog> getCustomerupdatelog() {
        return customerupdatelog;
    }

    public void setCustomerupdatelog(List<Customerupdatelog> customerupdatelog) {
        this.customerupdatelog = customerupdatelog;
    }

    @OneToMany(mappedBy = "user")
    public List<Salesopport> getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(List<Salesopport> salesopport) {
        this.salesopport = salesopport;
    }

    @OneToMany(mappedBy = "user")
    public List<Backlogtask> getBacklogtask() {
        return backlogtask;
    }

    public void setBacklogtask(List<Backlogtask> backlogtask) {
        this.backlogtask = backlogtask;
    }

    @OneToMany(mappedBy = "user")
    public List<Backlogtaskdetails> getBacklogtaskdetails() {
        return backlogtaskdetails;
    }

    public void setBacklogtaskdetails(List<Backlogtaskdetails> backlogtaskdetails) {
        this.backlogtaskdetails = backlogtaskdetails;
    }

    @OneToMany(mappedBy = "user")
    public List<Actionhistory> getActionhistory() {
        return actionhistory;
    }

    public void setActionhistory(List<Actionhistory> actionhistory) {
        this.actionhistory = actionhistory;
    }

    @OneToMany(mappedBy = "user")
    public List<Actionhistorydetails> getActionhistorydetails() {
        return actionhistorydetails;
    }

    public void setActionhistorydetails(List<Actionhistorydetails> actionhistorydetails) {
        this.actionhistorydetails = actionhistorydetails;
    }

    @OneToMany(mappedBy = "user")
    public List<Evection> getEvection() {
        return evection;
    }

    public void setEvection(List<Evection> evection) {
        this.evection = evection;
    }

    @OneToMany(mappedBy = "user")
    public List<Evectionsummarize> getEventionsummarize() {
        return eventionsummarize;
    }

    public void setEventionsummarize(List<Evectionsummarize> eventionsummarize) {
        this.eventionsummarize = eventionsummarize;
    }

    @OneToMany(mappedBy = "user")
    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }

    @OneToMany(mappedBy = "user")
    public List<Audit> getAudit() {
        return audit;
    }

    public void setAudit(List<Audit> audit) {
        this.audit = audit;
    }

    @OneToMany(mappedBy = "user")
    public List<Auditdetails> getAuditdetails() {
        return auditdetails;
    }

    public void setAuditdetails(List<Auditdetails> auditdetails) {
        this.auditdetails = auditdetails;
    }

    @OneToMany(mappedBy = "user")
    public List<Costaudit> getCostaudit() {
        return costaudit;
    }

    public void setCostaudit(List<Costaudit> costaudit) {
        this.costaudit = costaudit;
    }

    @OneToMany(mappedBy = "user")
    public List<Costauditdetails> getCoatauditdetails() {
        return coatauditdetails;
    }

    public void setCoatauditdetails(List<Costauditdetails> coatauditdetails) {
        this.coatauditdetails = coatauditdetails;
    }

    @ManyToMany(mappedBy = "user")
    public List<Position> getPosition() {
        return position;
    }

    public void setPosition(List<Position> position) {
        this.position = position;
    }

    @ManyToOne
    @JoinColumn(name = "d_id", referencedColumnName = "d_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "user")
    public List<Leaved> getLeaved() {
        return leaved;
    }

    public void setLeaved(List<Leaved> leaved) {
        this.leaved = leaved;
    }

    @OneToMany(mappedBy = "user")
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @OneToMany(mappedBy = "user")
    public List<Orderdetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(List<Orderdetail> orderdetail) {
        this.orderdetail = orderdetail;
    }

    @OneToMany(mappedBy = "user")
    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }

    @OneToMany(mappedBy = "user")
    public List<Returnedgoods> getReturnedgoods() {
        return returnedgoods;
    }

    public void setReturnedgoods(List<Returnedgoods> returnedgoods) {
        this.returnedgoods = returnedgoods;
    }

    @OneToMany(mappedBy = "user")
    public List<Returnedmoney> getReturnedmoney() {
        return returnedmoney;
    }

    public void setReturnedmoney(List<Returnedmoney> returnedmoney) {
        this.returnedmoney = returnedmoney;
    }

    @OneToMany(mappedBy = "user")
    public List<Returnedmoneyplan> getReturnedmoneyplan() {
        return returnedmoneyplan;
    }

    public void setReturnedmoneyplan(List<Returnedmoneyplan> returnedmoneyplan) {
        this.returnedmoneyplan = returnedmoneyplan;
    }

    @OneToMany(mappedBy = "user")
    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPass='" + uPass + '\'' +
                ", uStatus=" + uStatus +
                ", uSex='" + uSex + '\'' +
                ", uBirth=" + uBirth +
                ", uJoindate=" + uJoindate +
                ", uImg='" + uImg + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "inUser")
    public List<Warehouseallocation> getInConfirms() {
        return inConfirms;
    }

    public void setInConfirms(List<Warehouseallocation> inConfirms) {
        this.inConfirms = inConfirms;
    }

    @OneToMany(mappedBy = "outUser")
    public List<Warehouseallocation> getOutConfirms() {
        return outConfirms;
    }

    public void setOutConfirms(List<Warehouseallocation> outConfirms) {
        this.outConfirms = outConfirms;
    }


}
