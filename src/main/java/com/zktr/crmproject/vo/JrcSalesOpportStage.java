package com.zktr.crmproject.vo;

public class JrcSalesOpportStage {

    private String stage;
    private Long counts;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Long getCounts() {
        return counts;
    }

    public void setCounts(Long counts) {
        this.counts = counts;
    }

    public JrcSalesOpportStage() {
    }

    public JrcSalesOpportStage(String stage, Long counts) {
        this.stage = stage;
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "JrcSalesOpportStage{" +
                "stage='" + stage + '\'' +
                ", counts=" + counts +
                '}';
    }
}
