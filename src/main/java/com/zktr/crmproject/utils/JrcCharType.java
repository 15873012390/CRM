package com.zktr.crmproject.utils;
public class JrcCharType {
    private Double value;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JrcCharType{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public JrcCharType() {
    }


}
