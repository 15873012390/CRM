package com.zktr.crmproject.vo;

import java.util.Arrays;

public class CountBar {
    private String[] name;
    private int[] value;

    public CountBar(String[] name, int[] value) {
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

    @Override
    public String toString() {
        return "CountBar{" +
                "name=" + Arrays.toString(name) +
                ", value=" + Arrays.toString(value) +
                '}';
    }

    public CountBar() {
    }
}
