package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class PowerManage {
    private int pmId;
    private String pmName;
    private String pmMessage;
    @JsonIgnoreProperties("powermanage")
    private List<PowerFather> powerfather;
    @Id
    @Column(name = "pm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPmId() {
        return pmId;
    }

    public void setPmId(int pmId) {
        this.pmId = pmId;
    }
    @Basic
    @Column(name = "pm_name")
    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }
    @Basic
    @Column(name = "pm_message")
    public String getPmMessage() {
        return pmMessage;
    }

    public void setPmMessage(String pmMessage) {
        this.pmMessage = pmMessage;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerManage powermanage=(PowerManage)o;
        return pmId == powermanage.pmId &&
                Objects.equals(pmName, powermanage.pmName) &&
                Objects.equals(pmMessage, powermanage.pmMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pmId, pmName, pmMessage);
    }
    @OneToMany(mappedBy = "powermanage")
    public List<PowerFather> getPowerfather() {
        return powerfather;
    }

    public void setPowerfather(List<PowerFather> powerfather) {
        this.powerfather = powerfather;
    }

    @Override
    public String toString() {
        return "PowerManage{" +
                "pmId=" + pmId +
                ", pmName='" + pmName + '\'' +
                ", pmMessage='" + pmMessage + '\'' +
                ", powerfather=" + powerfather +
                '}';
    }
}
