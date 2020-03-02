package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Productclassification {
    private int claId;
    private String claName;
    private Integer claIdId;
    private String claState;
    private Timestamp claDatetime;
    private List<Product> product;

    @Id
    @Column(name = "cla_id")
    public int getClaId() {
        return claId;
    }

    public void setClaId(int claId) {
        this.claId = claId;
    }

    @Basic
    @Column(name = "cla_name")
    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }

    @Basic
    @Column(name = "cla_id_id")
    public Integer getClaIdId() {
        return claIdId;
    }

    public void setClaIdId(Integer claIdId) {
        this.claIdId = claIdId;
    }

    @Basic
    @Column(name = "cla_state")
    public String getClaState() {
        return claState;
    }

    public void setClaState(String claState) {
        this.claState = claState;
    }

    @Basic
    @Column(name = "cla_datetime")
    public Timestamp getClaDatetime() {
        return claDatetime;
    }

    public void setClaDatetime(Timestamp claDatetime) {
        this.claDatetime = claDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productclassification that = (Productclassification) o;
        return claId == that.claId &&
                Objects.equals(claName, that.claName) &&
                Objects.equals(claIdId, that.claIdId) &&
                Objects.equals(claState, that.claState) &&
                Objects.equals(claDatetime, that.claDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claId, claName, claIdId, claState, claDatetime);
    }

    @OneToMany(mappedBy = "productclassification")
    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
