package com.zktr.crmproject.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcSolutionJDao;
import com.zktr.crmproject.dao.mybatis.JrcSolutionMDao;
import com.zktr.crmproject.pojos.Solution;
import com.zktr.crmproject.vo.JrcSolutionAdvenceSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class JrcSolutionService {

    @Autowired
    private JrcSolutionMDao solutionMDao;
    @Autowired
    private JrcSolutionJDao solutionJDao;

    /**
     * 分页查找全部的方法
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager querySolutionAllByPage(int curpage,int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Solution> list=solutionMDao.querySolutionAllByPage();
        PageInfo<Solution> pageInfo=new PageInfo<>(list);
        return new Pager<Solution>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据方案主题模糊搜索
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager querySolutionByLike(int curpage,int pagesize,String input){
        PageHelper.startPage(curpage,pagesize);
        String inputs=input.trim()==""?"":"%"+input.trim()+"%";
        List<Solution> list=solutionMDao.querySolutionByLike(inputs);
        PageInfo<Solution> pageInfo=new PageInfo<>(list);
        return new Pager<Solution>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 高级搜索
     * @param solutionAdvenceSearch
     * @return
     */
    public Pager querySolutionByAdvenSearch(JrcSolutionAdvenceSearch solutionAdvenceSearch){
        PageHelper.startPage(solutionAdvenceSearch.getCurpage(),solutionAdvenceSearch.getPagesize());
        String thems=solutionAdvenceSearch.getThem().trim()==""?"":"%"+solutionAdvenceSearch.getThem().trim()+"%";
        solutionAdvenceSearch.setThem(thems);
        List<Solution> list=solutionMDao.querySolutionAdvenceSearch(solutionAdvenceSearch);
        PageInfo<Solution> pageInfo=new PageInfo<>(list);
        return new Pager<Solution>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据id找详情记录
     * @param solId
     * @return
     */
    public Solution querySolutionById(Integer solId){
        return solutionMDao.querySolutionById(solId);
    }
    /**
     * 添加记录
     * @param solution
     * @return
     */
    public Result addSolution(Solution solution){
        solutionJDao.save(solution);
        return Result.SUCCESS;
    }

    /**
     * 单个删除
     * @param solId
     * @return
     */
    public Result delSolutionById(Integer solId){
        solutionJDao.deleteById(solId);
        return Result.SUCCESS;
    }

    /**
     * 批量删除
     * @param solIds
     * @return
     */
    public Result delSolutionAll(Integer[] solIds){
        for(Integer i:solIds){
            solutionJDao.deleteById(i);
        }
        return Result.SUCCESS;
    }

}
