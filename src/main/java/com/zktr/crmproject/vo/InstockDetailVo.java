package com.zktr.crmproject.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zktr.crmproject.pojos.Instock;
import com.zktr.crmproject.pojos.Instockdetail;
import com.zktr.crmproject.pojos.Productspecification;

import java.util.List;

public class InstockDetailVo {
    private List<Instockdetail> list;
    private List<Integer> delList;

    public List<Instockdetail> getList() {
        return list;
    }

    public void setList(List<Instockdetail> list) {
        this.list = list;
    }

    public List<Integer> getDelList() {
        return delList;
    }

    public void setDelList(List<Integer> delList) {
        this.delList = delList;
    }

    @Override
    public String toString() {
        return "InstockDetailVo{" +
                "list=" + list +
                ", delList=" + delList +
                '}';
    }
}
