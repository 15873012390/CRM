package com.zktr.crmproject.pojos;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Position {
    private int postId;
    private String postName;
    private Integer postLv;
    private List<Power> power;
    private List<User> user;

    @Id
    @Column(name = "post_id")
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
    @Column(name = "post_lv")
    public Integer getPostLv() {
        return postLv;
    }

    public void setPostLv(Integer postLv) {
        this.postLv = postLv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return postId == position.postId &&
                Objects.equals(postName, position.postName) &&
                Objects.equals(postLv, position.postLv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postName, postLv);
    }

    @ManyToMany
    @JoinTable(catalog = "", schema = "crm", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "post_id"), inverseJoinColumns = @JoinColumn(name = "power_id", referencedColumnName = "power_id"))
    public List<Power> getPower() {
        return power;
    }

    public void setPower(List<Power> power) {
        this.power = power;
    }

    @ManyToMany
    @JoinTable(catalog = "", schema = "crm", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "post_id"), inverseJoinColumns = @JoinColumn(name = "u_id", referencedColumnName = "u_id"))
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
