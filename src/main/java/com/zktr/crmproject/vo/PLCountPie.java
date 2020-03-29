package com.zktr.crmproject.vo;

public class PLCountPie {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PLCountPie(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public PLCountPie() {
    }
}
