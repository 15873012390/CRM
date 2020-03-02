package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Power {
    private int powerId;
    private String powerName;
    private String powerMessage;
    private List<Position> position;

    @Id
    @Column(name = "power_id")
    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    @Basic
    @Column(name = "power_name")
    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    @Basic
    @Column(name = "power_message")
    public String getPowerMessage() {
        return powerMessage;
    }

    public void setPowerMessage(String powerMessage) {
        this.powerMessage = powerMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power = (Power) o;
        return powerId == power.powerId &&
                Objects.equals(powerName, power.powerName) &&
                Objects.equals(powerMessage, power.powerMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerId, powerName, powerMessage);
    }

    @ManyToMany(mappedBy = "power")
    public List<Position> getPosition() {
        return position;
    }

    public void setPosition(List<Position> position) {
        this.position = position;
    }
}
