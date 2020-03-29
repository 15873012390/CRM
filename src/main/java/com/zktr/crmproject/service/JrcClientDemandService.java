package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.JrcClientDemandJDao;
import com.zktr.crmproject.dao.mybatis.JrcClientdemandMDao;
import com.zktr.crmproject.pojos.Backlogtask;
import com.zktr.crmproject.pojos.Clientdemand;
import com.zktr.crmproject.vo.JrcClientDemandAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class JrcClientDemandService {

    @Autowired
    private JrcClientdemandMDao clientdemandMDao;
    @Autowired
    private JrcClientDemandJDao clientDemandJDao;

    /**
     * 分页查找全部数据
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager queryAllClientDemand(int curpage, int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Clientdemand> list=clientdemandMDao.queryAllClientDemand();
        PageInfo<Clientdemand> pager=new PageInfo<>(list);
        return new Pager<Clientdemand>(pager.getTotal(),pager.getList());
    }

    /**
     * 分页模糊搜索
     * @param curpage
     * @param pagesize
     * @param value
     * @param input
     * @return
     */
    public Pager queryClientDemandByLike(int curpage,int pagesize,String value,String input){
        PageHelper.startPage(curpage,pagesize);
        String inputs=input.trim()==""?"":"%"+input.trim()+"%";
        List<Clientdemand> list=clientdemandMDao.queryClientDemandByLike(value,inputs);
        PageInfo<Clientdemand> pageInfo=new PageInfo<>(list);
        return new Pager(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 高级搜索
     * @param clientDemandAdvancedSearch
     * @return
     */
    public Pager queryClientDemandAdvenced(JrcClientDemandAdvancedSearch clientDemandAdvancedSearch){
        PageHelper.startPage(clientDemandAdvancedSearch.getCurpage(),clientDemandAdvancedSearch.getPagesize());
        String de=clientDemandAdvancedSearch.getDemand().trim()==""?"":"%"+clientDemandAdvancedSearch.getDemand().trim()+"%";
        clientDemandAdvancedSearch.setDemand(de);
        String dd=clientDemandAdvancedSearch.getThem().trim()==""?"":"%"+clientDemandAdvancedSearch.getThem().trim()+"%";
        clientDemandAdvancedSearch.setThem(dd);
        List<Clientdemand> list=clientdemandMDao.queryClientDemandAdvenced(clientDemandAdvancedSearch);
        PageInfo<Clientdemand> pageInfo=new PageInfo<>(list);
        return new Pager(pageInfo.getTotal(),pageInfo.getList());
    }
    /**
     * 添加客户需求记录
     * @param clientdemand
     * @return
     */
    public Result addClientDemand(Clientdemand clientdemand){
        clientDemandJDao.save(clientdemand);
        return Result.SUCCESS;
    }

    /**
     * 通过id查看详情
     * @param cdId
     * @return
     */
    public Clientdemand queryClientDemandByCdId(Integer cdId){
        return clientdemandMDao.queryClientDemandByCdId(cdId);
    }

    /**
     * 根据id删除
     * @param cdId
     * @return
     */
    public Result delClientDemandByCdId(Integer cdId){
        clientDemandJDao.deleteById(cdId);
        return Result.SUCCESS;
    }

    /**
     * 批量删除
     * @param cdIds
     * @return
     */
    public Result delClientDemandByCdIdAll(Integer[] cdIds){
        for (Integer cdid:cdIds){
            clientDemandJDao.deleteById(cdid);
        }
        return Result.SUCCESS;
    }


}
