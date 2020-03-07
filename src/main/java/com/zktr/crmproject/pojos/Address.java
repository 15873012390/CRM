package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Address {
    private int addId;
    private String addName;
    private String addPhone;
    private String addAddress;
    private String addType;
    private Integer addPostcode;
    @JsonIgnoreProperties("address")
    private List<Sendout> sendout;
    @JsonIgnoreProperties("address")
    private Customer customer;

    @Id
    @Column(name = "add_id")
    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }


    @Basic
    @Column(name = "add_name")
    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    @Basic
    @Column(name = "add_phone")
    public String getAddPhone() {
        return addPhone;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone;
    }

    @Basic
    @Column(name = "add_address")
    public String getAddAddress() {
        return addAddress;
    }

    public void setAddAddress(String addAddress) {
        this.addAddress = addAddress;
    }

    @Basic
    @Column(name = "add_type")
    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType;
    }

    @Basic
    @Column(name = "add_postcode")
    public Integer getAddPostcode() {
        return addPostcode;
    }

    public void setAddPostcode(Integer addPostcode) {
        this.addPostcode = addPostcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addId == address.addId &&
                Objects.equals(addName, address.addName) &&
                Objects.equals(addPhone, address.addPhone) &&
                Objects.equals(addAddress, address.addAddress) &&
                Objects.equals(addType, address.addType) &&
                Objects.equals(addPostcode, address.addPostcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addId,addName, addPhone, addAddress, addType, addPostcode);
    }

    @OneToMany(mappedBy = "address")
    public List<Sendout> getSendout() {
        return sendout;
    }

    public void setSendout(List<Sendout> sendout) {
        this.sendout = sendout;
    }

    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
