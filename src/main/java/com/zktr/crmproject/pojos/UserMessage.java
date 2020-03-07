package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_message", schema = "crm", catalog = "")
public class UserMessage {
    private int umId;
    private String uName;
    private String umSex;
    private Timestamp umBrith;
    private Timestamp umJoindate;
    private String umImg;
    @JsonIgnoreProperties("userMessage")
    private User user;

    @Id
    @Column(name = "um_id")
    public int getUmId() {
        return umId;
    }

    public void setUmId(int umId) {
        this.umId = umId;
    }

    @Basic
    @Column(name = "u_name")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "um_sex")
    public String getUmSex() {
        return umSex;
    }

    public void setUmSex(String umSex) {
        this.umSex = umSex;
    }

    @Basic
    @Column(name = "um_brith")
    public Timestamp getUmBrith() {
        return umBrith;
    }

    public void setUmBrith(Timestamp umBrith) {
        this.umBrith = umBrith;
    }

    @Basic
    @Column(name = "um_joindate")
    public Timestamp getUmJoindate() {
        return umJoindate;
    }

    public void setUmJoindate(Timestamp umJoindate) {
        this.umJoindate = umJoindate;
    }

    @Basic
    @Column(name = "um_img")
    public String getUmImg() {
        return umImg;
    }

    public void setUmImg(String umImg) {
        this.umImg = umImg;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
