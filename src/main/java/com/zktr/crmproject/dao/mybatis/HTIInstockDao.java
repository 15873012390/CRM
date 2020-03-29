package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Instock;
import com.zktr.crmproject.pojos.Instockdetail;
import com.zktr.crmproject.vo.InstockAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HTIInstockDao {

    public List<Instock> queryByWhId(String warehouseId);

    public List<Instock> selectAllInstock();

    public void insertInstock(Instock instock);

    public Instock queryByInsId(Integer insId);

    public void updateInstock(Instock instock);

    public void deleteInstockById(Integer insId);

    public void deleteInstockDetailById(Integer insId);

    public List<Instock> querySelectAndInputByPage(String value, String input, String select);

    public List<Instock> queryInstockByAdvancedSearch(InstockAdvancedSearch iad);

    public List<Instockdetail> queryInstockDetailByInsId(Integer insId);

    public void insertInstockDetail(Instockdetail insd);

    public void updateInstockDetail(Instockdetail insd);
}
