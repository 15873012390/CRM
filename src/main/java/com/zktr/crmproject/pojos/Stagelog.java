package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Stagelog {
    private int slId;
    private String slNote;
    private Timestamp recordTime;
    private String stageName;
    @JsonIgnoreProperties("stagelog")
    private User user;
    @JsonIgnoreProperties("stagelog")
    private Salesopport salesopport;

    @Id
    @Column(name = "sl_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSlId() {
        return slId;
    }

    public void setSlId(int slId) {
        this.slId = slId;
    }

    @Basic
    @Column(name = "sl_note")
    public String getSlNote() {
        return slNote;
    }

    public void setSlNote(String slNote) {
        this.slNote = slNote;
    }

    @Basic
    @Column(name = "record_time")
    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "stage_name")
    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = {CascadeType.MERGE})//Cascade设置级联
    @JoinColumn(name="so_id",referencedColumnName = "so_id")
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }

    public Stagelog() {
    }

    @Override
    public String toString() {
        return "Stagelog{" +
                "slId=" + slId +
                ", slNote='" + slNote + '\'' +
                ", recordTime=" + recordTime +
                ", stageName='" + stageName + '\'' +
                ", user=" + user +
                ", salesopport=" + salesopport +
                '}';
    }
}
