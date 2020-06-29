package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Contract;
import com.zktr.crmproject.vo.PLContractAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PLContractMDao {
    //查询全部
    public List<Contract> queryAllContract();
    //根据合同id查询
    public Contract queryByCtrId(Integer ctrId);
    //查找最大id 自动编号调用
    public Integer findMaxByCtrId();
    //表格下方统计金额
    public List<Map> statisticsByMoney();
    //新增
    public void insertContract(Contract contract);
    //修改
    public void updateContract(Contract contract);
    //删除
    public void delByCtrId(@Param("ctrId") Integer ctrId);
    //批量删除
    public void BatchCtrIds(@Param("ctrids") Integer[] ctrids);
    //模糊条件查询
    public List<Contract> queryByLikeQuery(@Param("select") String select, @Param("input1") String input1, @Param("value") String value);
    //高级查询
    public List<Contract> ContractAdvancedSearch(PLContractAdvancedSearch contractAdvancedSearch);
    //回款和计划回款 当o.rm_or_rmp为空时 表示并未被计划回款和回款记录
    public List<Contract> CqueryAllOrdersByRM();
    //如果是计划回款 则表示被计划回款已记录 选择合同时不显示 根据合同id修改状态
    public void updateRmOrRmp1(Integer ctrId);
    //如果是回款 则表示被款已记录 选择合同时不显示 根据合同id修改状态
    public void updateRmOrRmp2(Integer ctrId);
    //首页 本月签订合同
    public List<Map> statisticsHomePageCon(Integer uId);
    //首页 本月签订合同数量 前20
    public Map statisticsHomePageConNum(Integer uId);



}
