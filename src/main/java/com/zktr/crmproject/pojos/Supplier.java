package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Supplier {
    private int supplierId;
    private String supplierName;
    private String sex;
    private String phone;
    private String job;
    private String email;
    private String qq;
    private String weixin;
    private Integer useStatus;
    @JsonIgnoreProperties("supplier")
    private List<Purchaseorder> purchaseorder;
    @JsonIgnoreProperties("supplier")
    private List<Purchasereturn> purchasereturn;
    @JsonIgnoreProperties("supplier")
    private List<Instock> instock;

    @Id
    @Column(name = "supplier_id")
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "supplier_name")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "job")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "weixin")
    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    @Basic
    @Column(name = "use_status")
    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return supplierId == supplier.supplierId &&
                Objects.equals(supplierName, supplier.supplierName) &&
                Objects.equals(sex, supplier.sex) &&
                Objects.equals(phone, supplier.phone) &&
                Objects.equals(job, supplier.job) &&
                Objects.equals(email, supplier.email) &&
                Objects.equals(qq, supplier.qq) &&
                Objects.equals(weixin, supplier.weixin) &&
                Objects.equals(useStatus, supplier.useStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, supplierName, sex, phone, job, email, qq, weixin, useStatus);
    }

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    public List<Purchaseorder> getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(List<Purchaseorder> purchaseorder) {
        this.purchaseorder = purchaseorder;
    }

    @OneToMany(mappedBy = "supplier")
    public List<Purchasereturn> getPurchasereturn() {
        return purchasereturn;
    }

    public void setPurchasereturn(List<Purchasereturn> purchasereturn) {
        this.purchasereturn = purchasereturn;
    }

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    public List<Instock> getInstock() {
        return instock;
    }

    public void setInstock(List<Instock> instock) {
        this.instock = instock;
    }
}
