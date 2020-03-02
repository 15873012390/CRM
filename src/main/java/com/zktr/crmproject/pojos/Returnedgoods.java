package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Returnedgoods {
    private int regId;
    private Integer ordId;
    private Integer uId;
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
    @Column(name = "ord_id")
    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Returnedgoods that = (Returnedgoods) o;
        return regId == that.regId &&
                Objects.equals(ordId, that.ordId) &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(regDate, that.regDate) &&
                Objects.equals(refundableMoney, that.refundableMoney) &&
                Objects.equals(retiredMoney, that.retiredMoney) &&
                Objects.equals(regState, that.regState) &&
                Objects.equals(regDelState, that.regDelState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regId, ordId, uId, regDate, refundableMoney, retiredMoney, regState, regDelState);
    }

    @OneToMany(mappedBy = "returnedgoods")
    public List<Instock> getInstock() {
        return instock;
    }

    public void setInstock(List<Instock> instock) {
        this.instock = instock;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "ord_id")
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "returnedgoods")
    public List<Returnedgoodsdetial> getReturnedgoodsdetial() {
        return returnedgoodsdetial;
    }

    public void setReturnedgoodsdetial(List<Returnedgoodsdetial> returnedgoodsdetial) {
        this.returnedgoodsdetial = returnedgoodsdetial;
    }
}
