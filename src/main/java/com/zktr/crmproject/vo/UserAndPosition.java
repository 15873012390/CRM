package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.Department;
import com.zktr.crmproject.pojos.Position;
import com.zktr.crmproject.pojos.User;

public class UserAndPosition {
    private Integer uId;
    private Integer postId;
    private User user;
    private Position position;
    private Department department;
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
