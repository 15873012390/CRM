package com.zktr.crmproject.vo;

import com.zktr.crmproject.pojos.Returnedgoods;

public class PLReturnedGoodsVo {
    //退货对象
    private Returnedgoods returnedgoods;
    //发货id
   private Integer senId;

    public Returnedgoods getReturnedgoods() {
        return returnedgoods;
    }

    public void setReturnedgoods(Returnedgoods returnedgoods) {
        this.returnedgoods = returnedgoods;
    }

    public Integer getSenId() {
        return senId;
    }

    public void setSenId(Integer senId) {
        this.senId = senId;
    }

   @Override
    public String toString() {
        return "PLReturnedGoodsVo{" +
                "returnedgoods=" + returnedgoods +
                ", senId=" + senId +
                '}';
    }
}
