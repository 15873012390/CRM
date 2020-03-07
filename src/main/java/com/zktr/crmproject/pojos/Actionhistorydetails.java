package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Actionhistorydetails {
    private int ahdId;
    @JsonIgnoreProperties("actionhistorydetails")
    private Actionhistory actionhistory;
    @JsonIgnoreProperties("actionhistorydetails")
    private User user;

    @Id
    @Column(name = "ahd_id")
    public int getAhdId() {
        return ahdId;
    }

    public void setAhdId(int ahdId) {
        this.ahdId = ahdId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actionhistorydetails that = (Actionhistorydetails) o;
        return ahdId == that.ahdId ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(ahdId);
    }

    @ManyToOne
    @JoinColumn(name="ah_id",referencedColumnName = "ah_id", nullable = false)
    public Actionhistory getActionhistory() {
        return actionhistory;
    }

    public void setActionhistory(Actionhistory actionhistory) {
        this.actionhistory = actionhistory;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
