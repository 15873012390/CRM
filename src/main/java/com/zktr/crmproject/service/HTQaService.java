package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTQaDao;
import com.zktr.crmproject.dao.mybatis.HTIQaDao;
import com.zktr.crmproject.pojos.Complaint;
import com.zktr.crmproject.pojos.Qa;
import com.zktr.crmproject.vo.ComplaintAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import com.zktr.crmproject.vo.QaAdvancedSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class HTQaService {
    @Autowired
    private HTQaDao qaDao;
    @Autowired
    private HTIQaDao iQaDao;

    /**
     * 分页查询所有的问答
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Qa> queryAllQaByPage(Integer curpage, Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Qa> list = iQaDao.queryAllByPage();
        PageInfo<Qa> pager = new PageInfo<>(list);
        return new Pager<Qa>(pager.getTotal(),pager.getList());
    }

   /* *
     * 分页高级查询
     * @param cas
     * @return
     */
    public Pager<Qa> queryQaByAdvancedSearch(QaAdvancedSearch qas){
        PageHelper.startPage(qas.getCurPage(),qas.getPageSize());
        if(qas.getCreatonTime()!=null && qas.getCreatonTime().length>1){
            qas.setS1(qas.getCreatonTime()[0]);
            qas.setS2(qas.getCreatonTime()[1]);
        }
        List<Qa> list = iQaDao.queryConditionByPage(qas);
        PageInfo<Qa> pager = new PageInfo<>(list);
        return new Pager<Qa>(pager.getTotal(),pager.getList());
    }

    /**
     * 分页显示QA
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Qa> queryLikeQa(String value, String input, String select, Integer curpage, Integer pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Qa> clist = iQaDao.queryLikeQa(value,"%"+input.trim()+"%",select);
        PageInfo<Qa> pager = new PageInfo<>(clist);
        return new Pager<Qa>(pager.getTotal(),pager.getList());
    }

    /**
     * 增加/编辑所有Qa
     * @param qa
     */
    public void addAndEditQa(Qa qa){
        qaDao.save(qa);
    }

    /**
     * 通过QaID删除
     * @param qaId
     */
    public void deleteByqaId(Integer qaId){
        qaDao.deleteById(qaId);
    }

    /**
     * 批量删除
     * @param qaIds
     */
    public void deleteByqaIds(Integer[] qaIds){
        for(Integer c : qaIds){
            qaDao.deleteById(c);
        }
    }

    /**
     * 通过QAID查询QA
     * @param qaId
     * @return
     */
    public Qa queryQatByQaId(Integer qaId){
        return iQaDao.queryById(qaId);
    }

    /**
     * 通过问题和回答来查找所有的问题
     * @param value
     * @return
     */
    public List<Qa> queryByQusetionAndAnswer(String value){
        return iQaDao.queryByLike("%"+value+"%");
    }
}
