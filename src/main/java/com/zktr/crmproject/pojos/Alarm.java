package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Alarm {
    private int alarmId;
    private String passPerson;
    private Timestamp alarmTime;
    private String remarks;
    @JsonIgnoreProperties("alarm")
    private List<Alarmdetail> alarmdetail;

    @Id
    @Column(name = "alarm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    @Basic
    @Column(name = "pass_person")
    public String getPassPerson() {
        return passPerson;
    }

    public void setPassPerson(String passPerson) {
        this.passPerson = passPerson;
    }

    @Basic
    @Column(name = "alarm_time")
    public Timestamp getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Timestamp alarmTime) {
        this.alarmTime = alarmTime;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alarm alarm = (Alarm) o;
        return alarmId == alarm.alarmId &&
                Objects.equals(passPerson, alarm.passPerson) &&
                Objects.equals(alarmTime, alarm.alarmTime) &&
                Objects.equals(remarks, alarm.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alarmId, passPerson, alarmTime, remarks);
    }

    @OneToMany(mappedBy = "alarm")
    public List<Alarmdetail> getAlarmdetail() {
        return alarmdetail;
    }

    public void setAlarmdetail(List<Alarmdetail> alarmdetail) {
        this.alarmdetail = alarmdetail;
    }
}
