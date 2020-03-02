package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Salesopport {
    private int soId;
    private String soTheme;
    private Timestamp updateDate;
    private Integer status;
    private String conName;
    private String conPhone;
    private Integer cusId;
    private Integer uId;
    private String architecture;
    private String cusSource;
    private String priority;
    private String stage;
    private Timestamp disTime;
    private String provider;
    private String cusDemand;
    private Timestamp signingTime;
    private String possibility;
    private Integer amount;
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
    @Column(name = "cus_id")
    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Basic
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesopport that = (Salesopport) o;
        return Objects.equals(soId, that.soId) &&
                Objects.equals(soTheme, that.soTheme) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(conName, that.conName) &&
                Objects.equals(conPhone, that.conPhone) &&
                Objects.equals(cusId, that.cusId) &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(architecture, that.architecture) &&
                Objects.equals(cusSource, that.cusSource) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(stage, that.stage) &&
                Objects.equals(disTime, that.disTime) &&
                Objects.equals(provider, that.provider) &&
                Objects.equals(cusDemand, that.cusDemand) &&
                Objects.equals(signingTime, that.signingTime) &&
                Objects.equals(possibility, that.possibility) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(starTarget, that.starTarget) &&
                Objects.equals(delStatus, that.delStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soId, soTheme, updateDate, status, conName, conPhone, cusId, uId, architecture, cusSource, priority, stage, disTime, provider, cusDemand, signingTime, possibility, amount, starTarget, delStatus);
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "cus_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "u_id")
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
}
