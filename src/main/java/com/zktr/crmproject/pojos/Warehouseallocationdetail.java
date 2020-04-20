package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Warehouseallocationdetail {
    private int wadId;
    private Integer wadQuantity;
    private Productspecification productspecification;
    private Warehouseallocation warehouseallocation;

    @Id
    @Column(name = "wad_id")
    public int getWadId() {
        return wadId;
    }

    public void setWadId(int wadId) {
        this.wadId = wadId;
    }

    @Basic
    @Column(name = "wad_quantity")
    public Integer getWadQuantity() {
        return wadQuantity;
    }

    public void setWadQuantity(Integer wadQuantity) {
        this.wadQuantity = wadQuantity;
    }


    @ManyToOne
    @JoinColumn(name = "spe_id", referencedColumnName = "spe_id")
    public Productspecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(Productspecification productspecification) {
        this.productspecification = productspecification;
    }

    @ManyToOne
    @JoinColumn(name = "wa_id", referencedColumnName = "wa_id")
    public Warehouseallocation getWarehouseallocation() {
        return warehouseallocation;
    }

    public void setWarehouseallocation(Warehouseallocation warehouseallocation) {
        this.warehouseallocation = warehouseallocation;
    }
}
