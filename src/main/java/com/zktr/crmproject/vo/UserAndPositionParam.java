package com.zktr.crmproject.vo;

import java.util.Arrays;

public class UserAndPositionParam {
    private Integer uId;//用户id，和部门id,职位id
    private Integer[] postId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer[] getPostId() {
        return postId;
    }

    public void setPostId(Integer[] postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "UserAndPositionParam{" +
                "uId=" + uId +
                ", postId=" + Arrays.toString(postId) +
                '}';
    }
}
