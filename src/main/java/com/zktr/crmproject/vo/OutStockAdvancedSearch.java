package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.Customer;
import com.zktr.crmproject.pojos.Orders;
import com.zktr.crmproject.pojos.Purchasereturn;
import com.zktr.crmproject.pojos.Warehouse;

import java.sql.Timestamp;

public class OutStockAdvancedSearch {
    private int outId;
    private String outNumber;
    private String ordNumber;
    private String title;
    private String status[];
    private Timestamp fillTime[];
    private String passPerson;
    private Timestamp passTime[];
    private Integer cusId;
    private Integer warehouseId[];
    private String preturnId;
    private Integer proId;
    private Integer ordId;
    private Integer curPage;
    private Integer pageSize;
    private Timestamp s1;
    private Timestamp s2;
    private Timestamp s3;
    private Timestamp s4;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public int getOutId() {
        return outId;
    }

    public void setOutId(int outId) {
        this.outId = outId;
    }

    public String getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(String outNumber) {
        this.outNumber = outNumber;
    }

    public String getOrdNumber() {
        return ordNumber;
    }

    public void setOrdNumber(String ordNumber) {
        this.ordNumber = ordNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public Timestamp[] getFillTime() {
        return fillTime;
    }

    public void setFillTime(Timestamp[] fillTime) {
        this.fillTime = fillTime;
    }

    public String getPassPerson() {
        return passPerson;
    }

    public void setPassPerson(String passPerson) {
        this.passPerson = passPerson;
    }

    public Timestamp[] getPassTime() {
        return passTime;
    }

    public void setPassTime(Timestamp[] passTime) {
        this.passTime = passTime;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getPreturnId() {
        return preturnId;
    }

    public void setPreturnId(String preturnId) {
        this.preturnId = preturnId;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public Integer[] getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer[] warehouseId) {
        this.warehouseId = warehouseId;
    }



    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Timestamp getS1() {
        return s1;
    }

    public void setS1(Timestamp s1) {
        this.s1 = s1;
    }

    public Timestamp getS2() {
        return s2;
    }

    public void setS2(Timestamp s2) {
        this.s2 = s2;
    }

    public Timestamp getS3() {
        return s3;
    }

    public void setS3(Timestamp s3) {
        this.s3 = s3;
    }

    public Timestamp getS4() {
        return s4;
    }

    public void setS4(Timestamp s4) {
        this.s4 = s4;
    }
}
