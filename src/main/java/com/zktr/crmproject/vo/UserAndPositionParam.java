package com.zktr.crmproject.vo;

public class UserAndPositionParam {
    private Integer uId;//用户id，和部门id
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

}
