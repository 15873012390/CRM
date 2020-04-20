package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Contract {
    private int ctrId;
    private String conClassify;
    private String conPayment;
    private BigDecimal conSendOutMoney;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Timestamp conStartTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Timestamp conEndTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Timestamp conSigningDate;
    private String conMoneyWay;
    private Integer conDelState;
    private int rmOrRmp; //标识合同是计划回款还是回款
    private String conTheme;
    private User user;
    private Customer customer;
    private Quote quote;
    private Productspecification productspecification;
    private String conNumber; //合同编号
    private String ordPurchaseWay; //购买习惯
    private String ordExecutingState; //执行状态
    private Integer conQdid;//标识报价详情id
    @JsonIgnoreProperties("contract")
    private List<Returnedmoneyplan> returnedmoneyplan;
    @JsonIgnoreProperties("contract")
    private List<Returnedmoney> returnedmonie;
    @OneToMany(mappedBy = "contract")
    public List<Returnedmoney> getReturnedmonie() {
        return returnedmonie;
    }

    public void setReturnedmonie(List<Returnedmoney> returnedmonie) {
        this.returnedmonie = returnedmonie;
    }

    @OneToMany(mappedBy = "contract")
    public List<Returnedmoneyplan> getReturnedmoneyplan() {
        return returnedmoneyplan;
    }

    public void setReturnedmoneyplan(List<Returnedmoneyplan> returnedmoneyplan) {
        this.returnedmoneyplan = returnedmoneyplan;
    }

    @Basic
    @Column(name = "con_qdid")
    public Integer getConQdid() {
        return conQdid;
    }

    public void setConQdid(Integer conQdid) {
        this.conQdid = conQdid;
    }
    @Basic
    @Column(name = "rm_or_rmp")
    public int getRmOrRmp() {
        return rmOrRmp;
    }

    public void setRmOrRmp(int rmOrRmp) {
        this.rmOrRmp = rmOrRmp;
    }

    @Basic
    @Column(name = "con_number")
    public String getConNumber() {
        return conNumber;
    }

    public void setConNumber(String conNumber) {
        this.conNumber = conNumber;
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
    @Column(name = "ord_executing_state")
    public String getOrdExecutingState() {
        return ordExecutingState;
    }

    public void setOrdExecutingState(String ordExecutingState) {
        this.ordExecutingState = ordExecutingState;
    }

    @Id
    @Column(name = "ctr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCtrId() {
        return ctrId;
    }



    public void setCtrId(int ctrId) {
        this.ctrId = ctrId;
    }

    @Basic
    @Column(name = "con_classify")
    public String getConClassify() {
        return conClassify;
    }

    public void setConClassify(String conClassify) {
        this.conClassify = conClassify;
    }

    @Basic
    @Column(name = "con_payment")
    public String getConPayment() {
        return conPayment;
    }

    public void setConPayment(String conPayment) {
        this.conPayment = conPayment;
    }

    @Basic
    @Column(name = "con_send_out_money")
    public BigDecimal getConSendOutMoney() {
        return conSendOutMoney;
    }

    public void setConSendOutMoney(BigDecimal conSendOutMoney) {
        this.conSendOutMoney = conSendOutMoney;
    }

    @Basic
    @Column(name = "con_start_time")
    public Timestamp getConStartTime() {
        return conStartTime;
    }

    public void setConStartTime(Timestamp conStartTime) {
        this.conStartTime = conStartTime;
    }

    @Basic
    @Column(name = "con_end_time")
    public Timestamp getConEndTime() {
        return conEndTime;
    }

    public void setConEndTime(Timestamp conEndTime) {
        this.conEndTime = conEndTime;
    }

    @Basic
    @Column(name = "con_signing_date")
    public Timestamp getConSigningDate() {
        return conSigningDate;
    }

    public void setConSigningDate(Timestamp conSigningDate) {
        this.conSigningDate = conSigningDate;
    }

    @Basic
    @Column(name = "con_money_way")
    public String getConMoneyWay() {
        return conMoneyWay;
    }

    public void setConMoneyWay(String conMoneyWay) {
        this.conMoneyWay = conMoneyWay;
    }

    @Basic
    @Column(name = "con_del_state")
    public Integer getConDelState() {
        return conDelState;
    }

    public void setConDelState(Integer conDelState) {
        this.conDelState = conDelState;
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
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Basic
    @Column(name = "con_theme")
    public String getConTheme() {
        return conTheme;
    }

    public void setConTheme(String conTheme) {
        this.conTheme = conTheme;
    }

    @ManyToOne
    @JoinColumn(name = "quo_id", referencedColumnName = "quo_id")
    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    @ManyToOne
    @JoinColumn(name="spe_id",referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
    }
}
