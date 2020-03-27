package com.zktr.crmproject.vo;

//饼图数据
public class CountPie {
    private String name;
    private int value;

    public CountPie(String name, int value) {
        this.name = name;
        this.value = value;
    }

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

    @Override
    public String toString() {
        return "CountPie{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
