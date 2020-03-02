package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Leaved {
    private int leaveId;
    private Integer uId;
    private Integer leaveStatus;
    private User user;

    @Id
    @Column(name = "leave_id")
    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
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
    @Column(name = "leave_status")
    public Integer getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(Integer leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaved leaved = (Leaved) o;
        return leaveId == leaved.leaveId &&
                Objects.equals(uId, leaved.uId) &&
                Objects.equals(leaveStatus, leaved.leaveStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaveId, uId, leaveStatus);
    }

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
