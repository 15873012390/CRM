package com.zktr.crmproject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.HTInstockDetailDao;
import com.zktr.crmproject.dao.jpa.HTStockDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.PLReturnedGoodsVo;
import com.zktr.crmproject.vo.PLReturnedgoodsAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class PLReturnedGoodsService {
    @Autowired
    private PLReturnedGoodsMDao returnedGoodsMDao;
    @Autowired
    private PLISendOutDao sendOutDao;
    @Autowired(required=false)
    private HTIInstockDao iIstockDao;
    @Autowired
    private HTIWarehouseDao warehouseDao;
    @Autowired
    private HTStockDao stockDao;
    @Autowired(required=false)
    private HTIStockDao istockDao;

    /**
     * 办理退货
     * @param returnedGoodsVo
     */
    public void dealService(PLReturnedGoodsVo returnedGoodsVo){
        //查找发货单id
        Sendout sendout=sendOutDao.findBySenId(returnedGoodsVo.getSenId());
        if(sendout!=null) {
            //设置状态为已被退货
            sendOutDao.updateIfReturnedgoods(sendout.getSenId());
            //保存退货单
            //System.out.println("ddd"+returnedGoodsVo.getReturnedgoods().getRegId());
            returnedGoodsMDao.insertRG(returnedGoodsVo.getReturnedgoods());
            //根据发货单id查找发货单详情
            List<Sendoutdetial> sendoutdetialList = sendOutDao.findAllBySendOutDetailBySenId(returnedGoodsVo.getSenId());
            //退货详情
            Returnedgoodsdetial returnedgoodsdetial = new Returnedgoodsdetial();
            for (Sendoutdetial sendoutdetial : sendoutdetialList) {
                returnedgoodsdetial.setReturnedgoods(returnedGoodsVo.getReturnedgoods()); //退货单id
                returnedgoodsdetial.setProductspecification(sendoutdetial.getProductspecification());//规格id
                returnedgoodsdetial.setRgdAmount(sendoutdetial.getSodNumber());//数量
                returnedgoodsdetial.setRgdMoney(sendoutdetial.getSodMoney());//金额
                returnedgoodsdetial.setRgdCause("退货不想要");
                returnedgoodsdetial.setRgdRemark("退货");
                //保存
                returnedGoodsMDao.insertRGD(returnedgoodsdetial);
            }
            System.out.println("aaa"+returnedGoodsVo.getReturnedgoods().toString());
            //根据查找退货单详情
            List<Returnedgoodsdetial> returnedgoodsdetialList=returnedGoodsMDao.findAllByRGDRegId(returnedGoodsVo.getReturnedgoods().getRegId());

            for(Returnedgoodsdetial r:returnedgoodsdetialList){
                System.out.println("ccc"+r.getProductspecification().getSpeId());
                //根据规格id查询库存
                Stock stock = istockDao.queryQuantityBySpeId(r.getProductspecification().getSpeId());
                //库存为空则增加,否则修改
                if (stock != null) {
                    Integer num = istockDao.queryQuantityBySpeId(r.getProductspecification().getSpeId()).getStockQuantity();
                    System.out.println("ccc"+num+"aaa"+r.getRgdAmount());
                    System.out.println(r.getProductspecification().getSpeId());
                    System.out.println(returnedGoodsVo.getReturnedgoods().getWarehouse().getWarehouseId());
                    istockDao.updatestockQuantity((num + r.getRgdAmount()),r.getProductspecification().getSpeId(),returnedGoodsVo.getReturnedgoods().getWarehouse().getWarehouseId());
                } else {
                    Stock stock1 = new Stock();
                    stock1.setProductspecification(r.getProductspecification());
                    stock1.setWarehouse(returnedGoodsVo.getReturnedgoods().getWarehouse());
                    stock1.setStockQuantity(r.getRgdAmount());
                    stockDao.save(stock);
                }

            }
        }
    }
    /**
     * 查询所有仓库
     * @return
     */
    public List<Warehouse> findAllWarehouse(){
        return warehouseDao.queryAllByPage();
    }


    /**
     * 根据发货id统计发货单的详情金额
     * @param senId
     * @return
     */
    public Map statisticsMoney(Integer senId){
        return sendOutDao.statisticsMoney(senId);
    }

    /**
     * 分页查询所有的退货单
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Returnedgoods> findAllRG(int curpage,int pagesize){
        PageHelper.startPage(curpage,pagesize);
       List<Returnedgoods> list=returnedGoodsMDao.findAllRG();
        PageInfo<Returnedgoods> page=new PageInfo<>(list);
        return new Pager<Returnedgoods>(page.getTotal(),page.getList());
    }

    /**
     * 模糊条件查询
     * @param curpage
     * @param pagesize
     * @param statevalue
     * @param input
     * @return
     */
    public Pager<Returnedgoods> queryByLikeQuery(int curpage,int pagesize,String statevalue,String input){
        PageHelper.startPage(curpage,pagesize);
        String tho="%"+input+"%";
        List<Returnedgoods> list=returnedGoodsMDao.queryByLikeQuery(statevalue,tho);
        PageInfo<Returnedgoods> page=new PageInfo<>(list);
        return new Pager<Returnedgoods>(page.getTotal(),page.getList());
    }

    /**
     * 高级查询
     * @param returnedgoodsAdvancedSearch
     * @return
     */
    public Pager<Returnedgoods> RGAdvancedSearch(PLReturnedgoodsAdvancedSearch returnedgoodsAdvancedSearch){
        PageHelper.startPage(returnedgoodsAdvancedSearch.getCurpage(),returnedgoodsAdvancedSearch.getPagesize());
        String uname="%"+returnedgoodsAdvancedSearch.getUname()+"%";
        returnedgoodsAdvancedSearch.setUname(uname);
        System.out.println("dddd"+returnedgoodsAdvancedSearch.getCusId());
        List<Returnedgoods> list=returnedGoodsMDao.RGAdvancedSearch(returnedgoodsAdvancedSearch);
        PageInfo<Returnedgoods> page=new PageInfo<>(list);
        return new Pager<Returnedgoods>(page.getTotal(),page.getList());
    }

    /**
     * 合计金额
     * @return
     */
    public List<Map> statisticsByMoney(){
        return returnedGoodsMDao.statisticsByMoney();
    }

    /**
     * 批量删除
     * @param regId
     */
    public void batchByregId(Integer[] regId){

        returnedGoodsMDao.batchByregId(regId);
    }
}
