package com.zktr.crmproject.vo;


import com.zktr.crmproject.pojos.Outstockdetails;

import java.util.List;

public class OutstockDetailVo {
    private List<Outstockdetails> list;
    private List<Integer> delList;

    public List<Outstockdetails> getList() {
        return list;
    }

    public void setList(List<Outstockdetails> list) {
        this.list = list;
    }

    public List<Integer> getDelList() {
        return delList;
    }

    public void setDelList(List<Integer> delList) {
        this.delList = delList;
    }
}
