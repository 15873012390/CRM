package com.zktr.crmproject.dao.mybatis;

import com.zktr.crmproject.pojos.Clientdemand;
import com.zktr.crmproject.pojos.Solution;
import com.zktr.crmproject.vo.JrcSolutionAdvenceSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Mapper
public interface JrcSolutionMDao {

    public List<Solution> querySolutionAllByPage();

    public List<Solution> querySolutionByLike(@Param("inputs") String inputs);

    public List<Solution> querySolutionAdvenceSearch(JrcSolutionAdvenceSearch solutionAdvenceSearch);

    public Solution querySolutionById(@Param("solId") Integer solId);

    public List<Solution> querySolutionBySoid(@Param("soId") Integer soId);

}
