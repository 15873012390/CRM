package com.zktr.crmproject.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Position {
    private int postId;
    private String postName;
    private String postMes;
    private String creater;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp createTime;
    @JsonIgnoreProperties("position")
    private List<Power> power;
    @JsonIgnoreProperties("position")
    private List<User> user;

    @Id
    @Column(name = "post_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "post_name")
    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Basic
    @Column(name = "post_mes")
    public String getPostMes() {
        return postMes;
    }

    public void setPostMes(String postMes) {
        this.postMes = postMes;
    }

    @Basic
    @Column(name = "creater")
    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    @Basic
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return postId == position.postId &&
                Objects.equals(postName, position.postName) &&
                Objects.equals(postMes, position.postMes) &&
                Objects.equals(creater, position.creater) &&
                Objects.equals(createTime, position.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postName, postMes);
    }

    @ManyToMany(mappedBy = "position")
    public List<Power> getPower() {
        return power;
    }

    public void setPower(List<Power> power) {
        this.power = power;
    }

    @ManyToMany
    @JoinTable(name = "user_position", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "post_id"), inverseJoinColumns = @JoinColumn(name = "u_id", referencedColumnName = "u_id"))
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Position{" +
                "postId=" + postId +
                ", postName='" + postName + '\'' +
                ", postMes='" + postMes + '\'' +
                ", creater=" + creater +
                ", createTime=" + createTime +
                '}';
    }
}
