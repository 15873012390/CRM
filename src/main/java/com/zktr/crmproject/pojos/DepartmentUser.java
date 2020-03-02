package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department_user", schema = "crm", catalog = "")
public class DepartmentUser {
    private int duId;
    private Integer uId;
    private Integer dId;

    @Id
    @Column(name = "du_id")
    public int getDuId() {
        return duId;
    }

    public void setDuId(int duId) {
        this.duId = duId;
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
    @Column(name = "d_id")
    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentUser that = (DepartmentUser) o;
        return duId == that.duId &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(dId, that.dId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duId, uId, dId);
    }
}
