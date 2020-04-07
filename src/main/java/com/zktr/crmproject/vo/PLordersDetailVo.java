package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.Orderdetail;

import java.sql.Timestamp;
import java.util.List;

public class PLordersDetailVo {
    private List<Orderdetail> list;
    private Integer[] del;

    public List<Orderdetail> getList() {
        return list;
    }

    public void setList(List<Orderdetail> list) {
        this.list = list;
    }

    public Integer[] getDel() {
        return del;
    }

    public void setDel(Integer[] del) {
        this.del = del;
    }
}
