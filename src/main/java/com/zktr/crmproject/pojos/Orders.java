package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Orders {
    private int ordId;
    private String ordNumber;
    private String ordTheme;
    private String ordClassify;
    private String ordPayment;
    private BigDecimal ordTotalAmount;
    private BigDecimal ordSendOutMoney;
    private BigDecimal ordMargin;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp ordTime;
    private String ordExecutingState;
    private String ordPurchaseWay;
    private String ordHabit;
    private String ordSendOutState;
    private String outStatus;
    private String ordRemark;
    private Integer ordDelState;
    @JsonIgnoreProperties("orders")
    private List<Outstock> outstock;
    @JsonIgnoreProperties("orders")
    private Customer customer;
    @JsonIgnoreProperties("orders")
    private User user;
    @JsonIgnoreProperties("orders")
    private Quote quote;
    @JsonIgnoreProperties("orders")
    private List<Orderdetail> orderdetail;
    @JsonIgnoreProperties("orders")
    private List<Sendout> sendout;
    @JsonIgnoreProperties("orders")
    private List<Returnedgoods> returnedgoods;
    @JsonIgnoreProperties("orders")
    private List<Returnedmoney> returnedmoney;
    @JsonIgnoreProperties("orders")
    private List<Returnedmoneyplan> returnedmoneyplan;
    @JsonIgnoreProperties("orders")
    private List<Invoice> invoice;
    @JsonIgnoreProperties("orders")
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return ordId == orders.ordId &&
                Objects.equals(ordNumber, orders.ordNumber) &&
                Objects.equals(ordTheme, orders.ordTheme) &&
                Objects.equals(ordClassify, orders.ordClassify) &&
                Objects.equals(ordPayment, orders.ordPayment) &&
                Objects.equals(ordTotalAmount, orders.ordTotalAmount) &&
                Objects.equals(ordSendOutMoney, orders.ordSendOutMoney) &&
                Objects.equals(ordMargin, orders.ordMargin) &&
                Objects.equals(ordTime, orders.ordTime) &&
                Objects.equals(ordExecutingState, orders.ordExecutingState) &&
                Objects.equals(ordPurchaseWay, orders.ordPurchaseWay) &&
                Objects.equals(ordHabit, orders.ordHabit) &&
                Objects.equals(ordSendOutState, orders.ordSendOutState) &&
                Objects.equals(outStatus, orders.outStatus) &&
                Objects.equals(ordRemark, orders.ordRemark) &&
                Objects.equals(ordDelState, orders.ordDelState) &&
                Objects.equals(outstock, orders.outstock) &&
                Objects.equals(customer, orders.customer) &&
                Objects.equals(user, orders.user) &&
                Objects.equals(quote, orders.quote) &&
                Objects.equals(orderdetail, orders.orderdetail) &&
                Objects.equals(sendout, orders.sendout) &&
                Objects.equals(returnedgoods, orders.returnedgoods) &&
                Objects.equals(returnedmoney, orders.returnedmoney) &&
                Objects.equals(returnedmoneyplan, orders.returnedmoneyplan) &&
                Objects.equals(invoice, orders.invoice) &&
                Objects.equals(address, orders.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordId, ordNumber, ordTheme, ordClassify, ordPayment, ordTotalAmount, ordSendOutMoney, ordMargin, ordTime, ordExecutingState, ordPurchaseWay, ordHabit, ordSendOutState, outStatus, ordRemark, ordDelState, outstock, customer, user, quote, orderdetail, sendout, returnedgoods, returnedmoney, returnedmoneyplan, invoice, address);
    }

    @ManyToOne
    @JoinColumn(name="add_id",referencedColumnName = "add_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Id
    @Column(name = "ord_id")
    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    @Basic
    @Column(name = "ord_number")
    public String getOrdNumber() {
        return ordNumber;
    }

    public void setOrdNumber(String ordNumber) {
        this.ordNumber = ordNumber;
    }


    @Basic
    @Column(name = "ord_theme")
    public String getOrdTheme() {
        return ordTheme;
    }

    public void setOrdTheme(String ordTheme) {
        this.ordTheme = ordTheme;
    }

    @Basic
    @Column(name = "ord_classify")
    public String getOrdClassify() {
        return ordClassify;
    }

    public void setOrdClassify(String ordClassify) {
        this.ordClassify = ordClassify;
    }

    @Basic
    @Column(name = "ord_payment")
    public String getOrdPayment() {
        return ordPayment;
    }

    public void setOrdPayment(String ordPayment) {
        this.ordPayment = ordPayment;
    }

    @Basic
    @Column(name = "ord_total_amount")
    public BigDecimal getOrdTotalAmount() {
        return ordTotalAmount;
    }

    public void setOrdTotalAmount(BigDecimal ordTotalAmount) {
        this.ordTotalAmount = ordTotalAmount;
    }

    @Basic
    @Column(name = "ord_send_out_money")
    public BigDecimal getOrdSendOutMoney() {
        return ordSendOutMoney;
    }

    public void setOrdSendOutMoney(BigDecimal ordSendOutMoney) {
        this.ordSendOutMoney = ordSendOutMoney;
    }

    @Basic
    @Column(name = "ord_margin")
    public BigDecimal getOrdMargin() {
        return ordMargin;
    }

    public void setOrdMargin(BigDecimal ordMargin) {
        this.ordMargin = ordMargin;
    }

    @Basic
    @Column(name = "ord_time")
    public Timestamp getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(Timestamp ordTime) {
        this.ordTime = ordTime;
    }

    @Basic
    @Column(name = "ord_executing_state")
    public String getOrdExecutingState() {
        return ordExecutingState;
    }

    public void setOrdExecutingState(String ordExecutingState) {
        this.ordExecutingState = ordExecutingState;
    }

    @Basic
    @Column(name = "ord_purchase_way")
    public String getOrdPurchaseWay() {
        return ordPurchaseWay;
    }

    public void setOrdPurchaseWay(String ordPurchaseWay) {
        this.ordPurchaseWay = ordPurchaseWay;
    }

    @Basic
    @Column(name = "ord_habit")
    public String getOrdHabit() {
        return ordHabit;
    }

    public void setOrdHabit(String ordHabit) {
        this.ordHabit = ordHabit;
    }

    @Basic
    @Column(name = "ord_send_out_state")
    public String getOrdSendOutState() {
        return ordSendOutState;
    }

    public void setOrdSendOutState(String ordSendOutState) {
        this.ordSendOutState = ordSendOutState;
    }

    @Basic
    @Column(name = "out_status")
    public String getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(String outStatus) {
        this.outStatus = outStatus;
    }

    @Basic
    @Column(name = "ord_remark")
    public String getOrdRemark() {
        return ordRemark;
    }

    public void setOrdRemark(String ordRemark) {
        this.ordRemark = ordRemark;
    }

    @Basic
    @Column(name = "ord_del_state")
    public Integer getOrdDelState() {
        return ordDelState;
    }

    public void setOrdDelState(Integer ordDelState) {
        this.ordDelState = ordDelState;
    }


    @OneToMany(mappedBy = "orders")
    public List<Outstock> getOutstock() {
        return outstock;
    }

    public void setOutstock(List<Outstock> outstock) {
        this.outstock = outstock;
    }

    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name="quo_id",referencedColumnName = "quo_id")
    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    @OneToMany(mappedBy = "orders")
    public List<Orderdetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(List<Orderdetail> orderdetail) {
        this.orderdetail = orderdetail;
    }

    @OneToMany(mappedBy = "orders")
    public List<Sendout> getSendout() {
        return sendout;
    }

    public void setSendout(List<Sendout> sendout) {
        this.sendout = sendout;
    }

    @OneToMany(mappedBy = "orders")
    public List<Returnedgoods> getReturnedgoods() {
        return returnedgoods;
    }

    public void setReturnedgoods(List<Returnedgoods> returnedgoods) {
        this.returnedgoods = returnedgoods;
    }

    @OneToMany(mappedBy = "orders")
    public List<Returnedmoney> getReturnedmoney() {
        return returnedmoney;
    }

    public void setReturnedmoney(List<Returnedmoney> returnedmoney) {
        this.returnedmoney = returnedmoney;
    }

    @OneToMany(mappedBy = "orders")
    public List<Returnedmoneyplan> getReturnedmoneyplan() {
        return returnedmoneyplan;
    }

    public void setReturnedmoneyplan(List<Returnedmoneyplan> returnedmoneyplan) {
        this.returnedmoneyplan = returnedmoneyplan;
    }

    @OneToMany(mappedBy = "orders")
    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ordId=" + ordId +
                ", ordNumber='" + ordNumber + '\'' +
                ", ordTheme='" + ordTheme + '\'' +
                ", ordClassify='" + ordClassify + '\'' +
                ", ordPayment='" + ordPayment + '\'' +
                ", ordTotalAmount=" + ordTotalAmount +
                ", ordSendOutMoney=" + ordSendOutMoney +
                ", ordMargin=" + ordMargin +
                ", ordTime=" + ordTime +
                ", ordExecutingState='" + ordExecutingState + '\'' +
                ", ordPurchaseWay='" + ordPurchaseWay + '\'' +
                ", ordHabit='" + ordHabit + '\'' +
                ", ordSendOutState='" + ordSendOutState + '\'' +
                ", outStatus='" + outStatus + '\'' +
                ", ordRemark='" + ordRemark + '\'' +
                ", ordDelState=" + ordDelState +
                ", outstock=" + outstock +
                ", customer=" + customer +
                ", user=" + user +
                ", quote=" + quote +
                ", orderdetail=" + orderdetail +
                ", sendout=" + sendout +
                ", returnedgoods=" + returnedgoods +
                ", returnedmoney=" + returnedmoney +
                ", returnedmoneyplan=" + returnedmoneyplan +
                ", invoice=" + invoice +
                ", address=" + address +
                '}';
    }
}
