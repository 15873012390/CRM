package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {
    private int cusId;
    private String cusName;
    private Integer uId;
    private String cusLevel;
    private String cusAddr;
    private String cusTel;
    private String cusSource;
    private Timestamp cusCreationTime;
    private Timestamp cusUpdateTime;
    private String cusCredit;
    private String cusZip;
    private String cusFax;
    private String cusLifeCycle;
    private String cusCountry;
    private String cusProvince;
    private String cusCity;
    private String cusDistrict;
    private String cusState;
    private String cusGrading;
    private String cusRemarks;
    private List<Duepay> duepay;
    private List<Paid> paid;
    private List<Outstock> outstock;
    private List<Repair> repair;
    private List<Customercare> customercare;
    private User user;
    private List<Customertransfer> customertransfer;
    private List<Customerupdatelog> customerupdatelog;
    private List<Contacts> contacts;
    private List<Customerchurnwarning> customerchurnwarning;
    private List<Salesopport> salesopport;
    private List<Clientdemand> clientdemand;
    private List<Solution> solution;
    private List<Competitor> competitor;
    private List<Backlogtask> backlogtask;
    private List<Actionhistory> actionhistory;
    private List<Evectiondetails> evectiondetails;
    private List<Quote> quote;
    private List<Orders> orders;
    private List<Orderdetail> orderdetail;
    private List<Contract> contract;
    private List<Sendout> sendout;
    private List<Address> address;
    private List<Returnedgoods> returnedgoods;
    private List<Returnedmoney> returnedmoney;
    private List<Returnedmoneyplan> returnedmoneyplan;
    private List<Invoice> invoice;

    @Id
    @Column(name = "cus_id")
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
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return cusId == customer.cusId &&
                Objects.equals(cusName, customer.cusName) &&
                Objects.equals(uId, customer.uId) &&
                Objects.equals(cusLevel, customer.cusLevel) &&
                Objects.equals(cusAddr, customer.cusAddr) &&
                Objects.equals(cusTel, customer.cusTel) &&
                Objects.equals(cusSource, customer.cusSource) &&
                Objects.equals(cusCreationTime, customer.cusCreationTime) &&
                Objects.equals(cusUpdateTime, customer.cusUpdateTime) &&
                Objects.equals(cusCredit, customer.cusCredit) &&
                Objects.equals(cusZip, customer.cusZip) &&
                Objects.equals(cusFax, customer.cusFax) &&
                Objects.equals(cusLifeCycle, customer.cusLifeCycle) &&
                Objects.equals(cusCountry, customer.cusCountry) &&
                Objects.equals(cusProvince, customer.cusProvince) &&
                Objects.equals(cusCity, customer.cusCity) &&
                Objects.equals(cusDistrict, customer.cusDistrict) &&
                Objects.equals(cusState, customer.cusState) &&
                Objects.equals(cusGrading, customer.cusGrading) &&
                Objects.equals(cusRemarks, customer.cusRemarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusId, cusName, uId, cusLevel, cusAddr, cusTel, cusSource, cusCreationTime, cusUpdateTime, cusCredit, cusZip, cusFax, cusLifeCycle, cusCountry, cusProvince, cusCity, cusDistrict, cusState, cusGrading, cusRemarks);
    }

    @OneToMany(mappedBy = "customer")
    public List<Duepay> getDuepay() {
        return duepay;
    }

    public void setDuepay(List<Duepay> duepay) {
        this.duepay = duepay;
    }

    @OneToMany(mappedBy = "customer")
    public List<Paid> getPaid() {
        return paid;
    }

    public void setPaid(List<Paid> paid) {
        this.paid = paid;
    }

    @OneToMany(mappedBy = "customer")
    public List<Outstock> getOutstock() {
        return outstock;
    }

    public void setOutstock(List<Outstock> outstock) {
        this.outstock = outstock;
    }

    @OneToMany(mappedBy = "customer")
    public List<Repair> getRepair() {
        return repair;
    }

    public void setRepair(List<Repair> repair) {
        this.repair = repair;
    }

    @OneToMany(mappedBy = "customer")
    public List<Customercare> getCustomercare() {
        return customercare;
    }

    public void setCustomercare(List<Customercare> customercare) {
        this.customercare = customercare;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
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
    public List<Customerupdatelog> getCustomerupdatelog() {
        return customerupdatelog;
    }

    public void setCustomerupdatelog(List<Customerupdatelog> customerupdatelog) {
        this.customerupdatelog = customerupdatelog;
    }

    @OneToMany(mappedBy = "customer")
    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    @OneToMany(mappedBy = "customer")
    public List<Customerchurnwarning> getCustomerchurnwarning() {
        return customerchurnwarning;
    }

    public void setCustomerchurnwarning(List<Customerchurnwarning> customerchurnwarning) {
        this.customerchurnwarning = customerchurnwarning;
    }

    @OneToMany(mappedBy = "customer")
    public List<Salesopport> getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(List<Salesopport> salesopport) {
        this.salesopport = salesopport;
    }

    @OneToMany(mappedBy = "customer")
    public List<Clientdemand> getClientdemand() {
        return clientdemand;
    }

    public void setClientdemand(List<Clientdemand> clientdemand) {
        this.clientdemand = clientdemand;
    }

    @OneToMany(mappedBy = "customer")
    public List<Solution> getSolution() {
        return solution;
    }

    public void setSolution(List<Solution> solution) {
        this.solution = solution;
    }

    @OneToMany(mappedBy = "customer")
    public List<Competitor> getCompetitor() {
        return competitor;
    }

    public void setCompetitor(List<Competitor> competitor) {
        this.competitor = competitor;
    }

    @OneToMany(mappedBy = "customer")
    public List<Backlogtask> getBacklogtask() {
        return backlogtask;
    }

    public void setBacklogtask(List<Backlogtask> backlogtask) {
        this.backlogtask = backlogtask;
    }

    @OneToMany(mappedBy = "customer")
    public List<Actionhistory> getActionhistory() {
        return actionhistory;
    }

    public void setActionhistory(List<Actionhistory> actionhistory) {
        this.actionhistory = actionhistory;
    }

    @OneToMany(mappedBy = "customer")
    public List<Evectiondetails> getEvectiondetails() {
        return evectiondetails;
    }

    public void setEvectiondetails(List<Evectiondetails> evectiondetails) {
        this.evectiondetails = evectiondetails;
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
    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
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
    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }
}
