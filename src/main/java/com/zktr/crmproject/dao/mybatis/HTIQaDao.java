package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Qa;
import com.zktr.crmproject.vo.QaAdvancedSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HTIQaDao {

    public List<Qa> queryAllByPage();

    public Qa queryById(Integer csId);

    public List<Qa> queryByLike(String value);

    public List<Qa> queryLikeQa(String value,String input,String select);

    public List<Qa> queryConditionByPage(QaAdvancedSearch qas);

}
