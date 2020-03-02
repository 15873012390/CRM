package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Stagelog {
    private int slId;
    private String slNote;
    private Timestamp recordTime;
    private String stageName;
    private int uId;
    private int soId;
    private User user;
    private Salesopport salesopport;

    @Id
    @Column(name = "sl_id")
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

    @Basic
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "so_id")
    public int getSoId() {
        return soId;
    }

    public void setSoId(int soId) {
        this.soId = soId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stagelog stagelog = (Stagelog) o;
        return slId == stagelog.slId &&
                uId == stagelog.uId &&
                soId == stagelog.soId &&
                Objects.equals(slNote, stagelog.slNote) &&
                Objects.equals(recordTime, stagelog.recordTime) &&
                Objects.equals(stageName, stagelog.stageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slId, slNote, recordTime, stageName, uId, soId);
    }

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "so_id", referencedColumnName = "so_id", nullable = false)
    public Salesopport getSalesopport() {
        return salesopport;
    }

    public void setSalesopport(Salesopport salesopport) {
        this.salesopport = salesopport;
    }
}
