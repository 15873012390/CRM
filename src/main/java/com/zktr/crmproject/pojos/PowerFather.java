package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class PowerFather {
    private int powerFid;
    private String powerFname;
    private String powerFmessage;
    @JsonIgnoreProperties("powerfather")
    private PowerManage powermanage;
    @JsonIgnoreProperties("powerfather")
    private List<Power> power;
    @Id
    @Column(name = "power_fid")
    public int getPowerFid() {
        return powerFid;
    }

    public void setPowerFid(int powerFid) {
        this.powerFid = powerFid;
    }
    @Basic
    @Column(name = "power_fname")
    public String getPowerFname() {
        return powerFname;
    }

    public void setPowerFname(String powerFname) {
        this.powerFname = powerFname;
    }
    @Basic
    @Column(name = "power_fmessage")
    public String getPowerFmessage() {
        return powerFmessage;
    }

    public void setPowerFmessage(String powerFmessage) {
        this.powerFmessage = powerFmessage;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerFather powerfather=(PowerFather)o;
        return powerFid == powerfather.powerFid &&
                Objects.equals(powerFname, powerfather.powerFname) &&
                Objects.equals(powerFmessage, powerfather.powerFmessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerFid, powerFname, powerFmessage);
    }
    @ManyToOne
    @JoinColumn(name = "pm_id", referencedColumnName = "pm_id")
    public PowerManage getPowermanage() {
        return powermanage;
    }

    public void setPowermanage(PowerManage powermanage) {
        this.powermanage = powermanage;
    }
    @OneToMany(mappedBy = "powerfather")
    public List<Power> getPower() {
        return power;
    }

    public void setPower(List<Power> power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Powerfather{" +
                "powerFid=" + powerFid +
                ", powerFname='" + powerFname + '\'' +
                ", powerFmessage='" + powerFmessage + '\'' +
                ", power=" + power +
                '}';
    }
}
