package com.zktr.crmproject.vo;

import java.util.List;

public class PLClassificationResponse {
    //Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
    private static final long serialVersionUID = 1L;
    //分类父级的集合
    List<PLClassificationParent> parentList;

    public PLClassificationResponse() {
    }

    public PLClassificationResponse(List<PLClassificationParent> parentList) {
        this.parentList = parentList;
    }

    public List<PLClassificationParent> getParentList() {
        return parentList;
    }

    public void setParentList(List<PLClassificationParent> parentList) {
        this.parentList = parentList;
    }
}
