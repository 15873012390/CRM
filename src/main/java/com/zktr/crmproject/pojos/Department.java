package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Department {
    private int dId;
    private String dName;
    private String dFunction;
    private Integer dBoss;
    private Integer lowerLevel;
    @JsonIgnoreProperties("department")
    private List<Purchaseplan> purchaseplan;
    @JsonIgnoreProperties("department")
    private List<Fitdetail> fitdetail;
    @JsonIgnoreProperties("department")
    private List<User> user;

    @Id
    @Column(name = "d_id")
    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    @Basic
    @Column(name = "d_name")
    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Basic
    @Column(name = "d_function")
    public String getdFunction() {
        return dFunction;
    }

    public void setdFunction(String dFunction) {
        this.dFunction = dFunction;
    }

    @Basic
    @Column(name = "d_boss")
    public Integer getdBoss() {
        return dBoss;
    }

    public void setdBoss(Integer dBoss) {
        this.dBoss = dBoss;
    }

    @Basic
    @Column(name = "lower_level")
    public Integer getLowerLevel() {
        return lowerLevel;
    }

    public void setLowerLevel(Integer lowerLevel) {
        this.lowerLevel = lowerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return dId == that.dId &&
                Objects.equals(dName, that.dName) &&
                Objects.equals(dFunction, that.dFunction) &&
                Objects.equals(dBoss, that.dBoss) &&
                Objects.equals(lowerLevel, that.lowerLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dId, dName, dFunction, dBoss, lowerLevel);
    }

    @OneToMany(mappedBy = "department")
    public List<Purchaseplan> getPurchaseplan() {
        return purchaseplan;
    }

    public void setPurchaseplan(List<Purchaseplan> purchaseplan) {
        this.purchaseplan = purchaseplan;
    }

    @OneToMany(mappedBy = "department")
    public List<Fitdetail> getFitdetail() {
        return fitdetail;
    }

    public void setFitdetail(List<Fitdetail> fitdetail) {
        this.fitdetail = fitdetail;
    }

    @OneToMany(mappedBy = "department")
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
