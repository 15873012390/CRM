package com.zktr.crmproject.vo;

import java.util.List;

public class Pager<E> {
    private long total;//总的记录条数
    private List<E> list;//当前页数据

    public Pager() {
    }

    public Pager(long total, List<E> list) {
        this.total = total;
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
