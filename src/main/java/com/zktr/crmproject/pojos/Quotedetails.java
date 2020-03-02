package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Quotedetails {
    private int qdId;
    private Integer proId;
    private int quoId;
    private String specification;
    private String unit;
    private Integer quantity;
    private Integer unitPrice;
    private Integer discount;
    private Integer money;
    private String remarks;
    private Product product;
    private Quote quote;

    @Id
    @Column(name = "qd_id")
    public int getQdId() {
        return qdId;
    }

    public void setQdId(int qdId) {
        this.qdId = qdId;
    }

    @Basic
    @Column(name = "pro_id")
    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    @Basic
    @Column(name = "quo_id")
    public int getQuoId() {
        return quoId;
    }

    public void setQuoId(int quoId) {
        this.quoId = quoId;
    }

    @Basic
    @Column(name = "specification")
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "unit_price")
    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "discount")
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "money")
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quotedetails that = (Quotedetails) o;
        return qdId == that.qdId &&
                quoId == that.quoId &&
                Objects.equals(proId, that.proId) &&
                Objects.equals(specification, that.specification) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(money, that.money) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qdId, proId, quoId, specification, unit, quantity, unitPrice, discount, money, remarks);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "pro_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "quo_id", nullable = false)
    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
