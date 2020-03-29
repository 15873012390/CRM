package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Outstock;
import com.zktr.crmproject.pojos.Outstockdetails;
import com.zktr.crmproject.vo.OutStockAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HTIOutstockDao {

    public Outstock queryOutstockByOutId(Integer outId);

    public List<Outstock> queryAllOutstock();

    public void insertOutstock(Outstock outstock);

    public void updateOutStock(Outstock outstock);

    public void insertOutStockDetails(Outstockdetails outstockdetails);

    public List<Outstockdetails> queryAllOutdetailById(Integer outId);

    public void deleteOutstockByOutId(Integer outId);

    public void deleteOutstockDetailByOutId(Integer outId);

    public void updateOutDeatails(Outstockdetails outstockdetails);

    public List<Outstock> queryOutStockSelectAndInputByPage(String value,String input,String select);

    public List<Outstock> queryoutStockByAdvancedSearch(OutStockAdvancedSearch oas);
}
