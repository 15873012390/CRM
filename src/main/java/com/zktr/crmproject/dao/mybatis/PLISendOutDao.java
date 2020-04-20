package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Sendout;
import com.zktr.crmproject.pojos.Sendoutdetial;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PLISendOutDao {

    public void insertSendOut(Sendout sendout);

    public void insertSendOutDetail(Sendoutdetial sendoutdetial);
    //根据ordid查找
    public Sendout findSendOutByOrdid(Integer ordid);
    //修改时间备注
    public void updateSendOut(Sendout sendout);
    //根据发货单id查询发货详情
    public List<Sendoutdetial> findAllBySendOutDetailBySenId(Integer senId);
    //发货修改
    public void updateBySendOutBySenId(Sendout sendout);
    //修改发货状态
    public void updateSendOutState(Integer senId);
    //如被退货 则修改退货状态为已被退货
    public void updateIfReturnedgoods(Integer senId);
    //根据发货单Id查找发货对象
    public Sendout findBySenId(Integer senId);
    //统计发货单金额
    public Map statisticsMoney(Integer senId);


}
