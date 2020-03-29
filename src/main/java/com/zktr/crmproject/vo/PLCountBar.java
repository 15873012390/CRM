package com.zktr.crmproject.vo;

public class PLCountBar {
    String name[];
    int value[];

    public PLCountBar() {
    }

    public PLCountBar(String[] name, int[] value) {
        this.name = name;
        this.value = value;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }
}
