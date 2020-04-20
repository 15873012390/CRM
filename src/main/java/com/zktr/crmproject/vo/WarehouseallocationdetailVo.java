package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.Warehouseallocationdetail;

import java.util.List;

public class WarehouseallocationdetailVo {
    private List<Warehouseallocationdetail> list;
    private String uName;
    private List<Integer> delList;

    public List<Warehouseallocationdetail> getList() {
        return list;
    }

    public void setList(List<Warehouseallocationdetail> list) {
        this.list = list;
    }

    public List<Integer> getDelList() {
        return delList;
    }

    public void setDelList(List<Integer> delList) {
        this.delList = delList;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
