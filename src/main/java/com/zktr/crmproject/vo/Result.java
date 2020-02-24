package com.zktr.crmproject.vo;

/**
 * 封装返回结果
 */
public class Result {
    private boolean success;
    private String message; //操作失败的原因
    public static final Result SUCCESS = new Result();//操作成功
    public static final Result FAILURE = new Result("操作失败");//操作失败

    public Result() {
        this.success = true;
    }

    public Result(String message) {
        this.success = false;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
