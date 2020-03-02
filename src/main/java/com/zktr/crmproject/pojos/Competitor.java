package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Competitor {
    private int comId;
    private String comName;
    private Integer cusId;
    private Integer soId;
    private Integer price;
    private Integer comCapacity;
    private Integer winOut;
    private String comScheme;
    private String advantage;
    private String disadvantaged;
    private String copingStrategy;
    private String note;
    private Integer delStatus;
    private Customer customer;
    private Salesopport salesopport;

    @Id
    @Column(name = "com_id")
    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    @Basic
    @Column(name = "com_name")
    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    @Basic
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "so_id")
    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "com_capacity")
    public Integer getComCapacity() {
        return comCapacity;
    }

    public void setComCapacity(Integer comCapacity) {
        this.comCapacity = comCapacity;
    }

    @Basic
    @Column(name = "win_out")
    public Integer getWinOut() {
        return winOut;
    }

    public void setWinOut(Integer winOut) {
        this.winOut = winOut;
    }

    @Basic
    @Column(name = "com_scheme")
    public String getComScheme() {
        return comScheme;
    }

    public void setComScheme(String comScheme) {
        this.comScheme = comScheme;
    }

    @Basic
    @Column(name = "advantage")
    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    @Basic
    @Column(name = "disadvantaged")
    public String getDisadvantaged() {
        return disadvantaged;
    }

    public void setDisadvantaged(String disadvantaged) {
        this.disadvantaged = disadvantaged;
    }

    @Basic
    @Column(name = "coping_strategy")
    public String getCopingStrategy() {
        return copingStrategy;
    }

    public void setCopingStrategy(String copingStrategy) {
        this.copingStrategy = copingStrategy;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "del_status")
    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competitor that = (Competitor) o;
        return comId == that.comId &&
                Objects.equals(comName, that.comName) &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(soId, that.soId) &&
                Objects.equals(price, that.price) &&
                Objects.equals(comCapacity, that.comCapacity) &&
                Objects.equals(winOut, that.winOut) &&
                Objects.equals(comScheme, that.comScheme) &&
                Objects.equals(advantage, that.advantage) &&
                Objects.equals(disadvantaged, that.disadvantaged) &&
                Objects.equals(copingStrategy, that.copingStrategy) &&
                Objects.equals(note, that.note) &&
                Objects.equals(delStatus, that.delStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comId, comName, cusId, soId, price, comCapacity, winOut, comScheme, advantage, disadvantaged, copingStrategy, note, delStatus);
    }

    @ManyToOne
    @JoinColumn(name = "cus_id", referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "so_id", referencedColumnName = "so_id")
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }
}
