package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Actionhistorydetails {
    private int ahdId;
    private int ahId;
    private int uId;
    private Actionhistory actionhistory;
    private User user;

    @Id
    @Column(name = "ahd_id")
    public int getAhdId() {
        return ahdId;
    }

    public void setAhdId(int ahdId) {
        this.ahdId = ahdId;
    }

    @Basic
    @Column(name = "ah_id")
    public int getAhId() {
        return ahId;
    }

    public void setAhId(int ahId) {
        this.ahId = ahId;
    }

    @Basic
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actionhistorydetails that = (Actionhistorydetails) o;
        return ahdId == that.ahdId &&
                ahId == that.ahId &&
                uId == that.uId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ahdId, ahId, uId);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "ah_id", nullable = false)
    public Actionhistory getActionhistory() {
        return actionhistory;
    }

    public void setActionhistory(Actionhistory actionhistory) {
        this.actionhistory = actionhistory;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
