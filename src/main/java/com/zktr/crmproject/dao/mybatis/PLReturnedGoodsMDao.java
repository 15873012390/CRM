package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Returnedgoods;
import com.zktr.crmproject.pojos.Returnedgoodsdetial;
import com.zktr.crmproject.pojos.Returnedmoney;
import com.zktr.crmproject.service.PLReturnedGoodsService;
import com.zktr.crmproject.vo.PLReturnedgoodsAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PLReturnedGoodsMDao {
    //新增退货
    public void insertRG(Returnedgoods returnedgoods);
    //新增退货详情
    public void insertRGD(Returnedgoodsdetial returnedgoodsdetial);
    //查询全部退货
    public List<Returnedgoods> findAllRG();
    //根据退货id查询退货详情
    public List<Returnedgoodsdetial> findAllByRGDRegId(Integer regId);
    //模糊条件查询
    public List<Returnedgoods> queryByLikeQuery(@Param("statevalue") String statevalue, @Param("input") String input);
    //高级查询
    public List<Returnedgoods> RGAdvancedSearch(PLReturnedgoodsAdvancedSearch returnedgoodsAdvancedSearch);
    //统计退还金额
    public List<Map> statisticsByMoney();
    //批量删除
    public void batchByregId(@Param("regId") Integer[] regId);
    //本周未处理的退货单
    public List<Map> statisticsHomePageRGWeek(Integer uId);
    //本周未处理的退货单的数量
    public Map statisticsHomePageRGWeekNum(Integer uId);


}
