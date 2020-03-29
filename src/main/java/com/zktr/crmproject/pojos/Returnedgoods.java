package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Returnedgoods {
    private int regId;
    private Timestamp regDate;
    private BigDecimal refundableMoney;
    private BigDecimal retiredMoney;
    private String regState;
    private Integer regDelState;
    private List<Instock> instock;
    private Orders orders;
    private Warehouse warehouse;
    private Customer customer;
    private User user;
    private List<Returnedgoodsdetial> returnedgoodsdetial;

    @Id
    @Column(name = "reg_id")
    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }


    @Basic
    @Column(name = "reg_date")
    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Basic
    @Column(name = "refundable_money")
    public BigDecimal getRefundableMoney() {
        return refundableMoney;
    }

    public void setRefundableMoney(BigDecimal refundableMoney) {
        this.refundableMoney = refundableMoney;
    }

    @Basic
    @Column(name = "retired_money")
    public BigDecimal getRetiredMoney() {
        return retiredMoney;
    }

    public void setRetiredMoney(BigDecimal retiredMoney) {
        this.retiredMoney = retiredMoney;
    }

    @Basic
    @Column(name = "reg_state")
    public String getRegState() {
        return regState;
    }

    public void setRegState(String regState) {
        this.regState = regState;
    }

    @Basic
    @Column(name = "reg_del_state")
    public Integer getRegDelState() {
        return regDelState;
    }

    public void setRegDelState(Integer regDelState) {
        this.regDelState = regDelState;
    }


    @OneToMany(mappedBy = "returnedgoods",cascade = CascadeType.ALL)
    public List<Instock> getInstock() {
        return instock;
    }

    public void setInstock(List<Instock> instock) {
        this.instock = instock;
    }

    @ManyToOne
    @JoinColumn(name="ord_id",referencedColumnName = "ord_id")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JoinColumn(name="warehouse_id",referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
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

    @OneToMany(mappedBy = "returnedgoods",cascade = CascadeType.ALL)
    public List<Returnedgoodsdetial> getReturnedgoodsdetial() {
        return returnedgoodsdetial;
    }

    public void setReturnedgoodsdetial(List<Returnedgoodsdetial> returnedgoodsdetial) {
        this.returnedgoodsdetial = returnedgoodsdetial;
    }
}
