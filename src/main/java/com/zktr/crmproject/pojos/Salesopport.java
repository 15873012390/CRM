package com.zktr.crmproject.pojos;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Salesopport {
    private int soId;
    private String soTheme;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp updateDate;
    private Integer status;
    private String conName;
    private String conPhone;
    private String architecture;
    private String cusSource;
    private String priority;
    private String stage;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp disTime;
    private String provider;
    private String cusDemand;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp signingTime;
    private String possibility;
    private BigDecimal amount;
    private String starTarget;
    private Integer delStatus;
    private Customer customer;
    private User user;
    private List<Stagelog> stagelog;
    private List<Clientdemand> clientdemand;
    private List<Solution> solution;
    private List<Competitor> competitor;
    private List<Quote> quote;
    @Id
    @Basic
    @Column(name = "so_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    @Basic
    @Column(name = "so_theme")
    public String getSoTheme() {
        return soTheme;
    }

    public void setSoTheme(String soTheme) {
        this.soTheme = soTheme;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "con_name")
    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    @Basic
    @Column(name = "con_phone")
    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    @Basic
    @Column(name = "architecture")
    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    @Basic
    @Column(name = "cus_source")
    public String getCusSource() {
        return cusSource;
    }

    public void setCusSource(String cusSource) {
        this.cusSource = cusSource;
    }

    @Basic
    @Column(name = "priority")
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "stage")
    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Basic
    @Column(name = "dis_time")
    public Timestamp getDisTime() {
        return disTime;
    }

    public void setDisTime(Timestamp disTime) {
        this.disTime = disTime;
    }

    @Basic
    @Column(name = "provider")
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Basic
    @Column(name = "cus_demand")
    public String getCusDemand() {
        return cusDemand;
    }

    public void setCusDemand(String cusDemand) {
        this.cusDemand = cusDemand;
    }

    @Basic
    @Column(name = "signing_time")
    public Timestamp getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Timestamp signingTime) {
        this.signingTime = signingTime;
    }

    @Basic
    @Column(name = "possibility")
    public String getPossibility() {
        return possibility;
    }

    public void setPossibility(String possibility) {
        this.possibility = possibility;
    }

    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "star_target")
    public String getStarTarget() {
        return starTarget;
    }

    public void setStarTarget(String starTarget) {
        this.starTarget = starTarget;
    }

    @Basic
    @Column(name = "del_status")
    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }


    @ManyToOne
    @JoinColumn(name="cus_id",referencedColumnName = "cus_id")
    @NotFound(action = NotFoundAction.IGNORE)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="u_id",referencedColumnName = "u_id")
    @NotFound(action= NotFoundAction.IGNORE)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "salesopport")
    public List<Stagelog> getStagelog() {
        return stagelog;
    }

    public void setStagelog(List<Stagelog> stagelog) {
        this.stagelog = stagelog;
    }

    @OneToMany(mappedBy = "salesopport")
    public List<Clientdemand> getClientdemand() {
        return clientdemand;
    }

    public void setClientdemand(List<Clientdemand> clientdemand) {
        this.clientdemand = clientdemand;
    }

    @OneToMany(mappedBy = "salesopport")
    public List<Solution> getSolution() {
        return solution;
    }

    public void setSolution(List<Solution> solution) {
        this.solution = solution;
    }

    @OneToMany(mappedBy = "salesopport")
    public List<Competitor> getCompetitor() {
        return competitor;
    }

    public void setCompetitor(List<Competitor> competitor) {
        this.competitor = competitor;
    }

    @OneToMany(mappedBy = "salesopport")
    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }

    public Salesopport() {
    }
    
}
