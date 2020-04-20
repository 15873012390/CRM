package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.jpa.HTInstockDetailDao;
import com.zktr.crmproject.dao.jpa.HTStockDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.vo.PLReturnedGoodsVo;
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
    /*public void dealService(PLReturnedGoodsVo returnedGoodsVo){
        //查找发货单id
        Sendout sendout=sendOutDao.findBySenId(returnedGoodsVo.getSenId());
        if(sendout!=null){
            //设置状态为已被退货
            sendOutDao.updateIfReturnedgoods(sendout.getSenId());
            //保存退货单
            returnedGoodsMDao.insertRG(returnedGoodsVo.getReturnedgoods());
            //根据发货单id查找发货单详情
            List<Sendoutdetial> sendoutdetialList=sendOutDao.findAllBySendOutDetailBySenId(returnedGoodsVo.getSenId());
            //退货详情
            Returnedgoodsdetial returnedgoodsdetial=new Returnedgoodsdetial();
            for(Sendoutdetial sendoutdetial:sendoutdetialList){
               returnedgoodsdetial.setReturnedgoods(returnedGoodsVo.getReturnedgoods()); //退货单id
               returnedgoodsdetial.setProductspecification(sendoutdetial.getProductspecification());//规格id
               returnedgoodsdetial.setRgdAmount(sendoutdetial.getSodNumber());//数量
               returnedgoodsdetial.setRgdMoney(sendoutdetial.getSodMoney());//金额
               returnedgoodsdetial.setRgdCause("退货不想要");
               returnedgoodsdetial.setRgdRemark("退货");
               //保存
               returnedGoodsMDao.insertRGD(returnedgoodsdetial);
            }
            //把退货的产品入库 新建入库记录和入库详情
            Instock instock=new Instock();
            instock.setTitle("退货入库");
            instock.setWarehouse(returnedGoodsVo.getReturnedgoods().getWarehouse());//退货单选择的入库仓库
            instock.setStatus("已入库");
            instock.setFiller(returnedGoodsVo.getReturnedgoods().getUser().getuName());//退货单的员工
            instock.setKeeper(returnedGoodsVo.getReturnedgoods().getUser().getuName());
            instock.setExecutionTime(new Timestamp(System.currentTimeMillis())); //设置当前时间
            instock.setFillTime(new Timestamp(System.currentTimeMillis()));
            instock.setReturnedgoods(returnedGoodsVo.getReturnedgoods()); //设置退货id
            instock.setRemarks("退货入库");
            //保存入库
            iIstockDao.insertInstock(instock);
            //根据退货单id查询退货单详情
            List<Returnedgoodsdetial> returnedgoodsdetialList=returnedGoodsMDao.findAllByRGDRegId(returnedGoodsVo.getReturnedgoods().getRegId());
            //新增入库详情记录
            Instockdetail instockdetail=new Instockdetail();
            for(Returnedgoodsdetial r : returnedgoodsdetialList){
                instockdetail.setProductspecification(r.getProductspecification());//规格id
                instockdetail.setInstock(instock); //出库id
                instockdetail.setStatus("已入库");
                instockdetail.setInsdQuantity(r.getRgdAmount());//入库数量
                instockdetail.setRemarks("订单退货");
                //保存出库单详情
                iIstockDao.insertInstockDetail(instockdetail);
            }
            //把入库的数量放入库存
            List<Instockdetail> instockdetails = iIstockDao.queryInstockDetailByInsId(instock.getInsId());
            for(Instockdetail ins : instockdetails){
                Stock s1 = istockDao.queryQuantityBySpeId(ins.getProductspecification().getSpeId());
                if(s1!=null){
                    Integer num = istockDao.queryQuantityBySpeId(ins.getProductspecification().getSpeId()).getStockQuantity();
                    istockDao.updatestockQuantity((num + ins.getInsdQuantity()), ins.getProductspecification().getSpeId());
                }else{
                    Stock stock = new Stock();
                    stock.setProductspecification(ins.getProductspecification());
                    stock.setWarehouse(instock.getWarehouse());
                    stock.setStockQuantity(ins.getInsdQuantity());
                    stockDao.save(stock);
                }
            }

        }else {
            System.out.println("没有此发货单！");
        }
    }*/
    public void dealService(PLReturnedGoodsVo returnedGoodsVo){
        //查找发货单id
        Sendout sendout=sendOutDao.findBySenId(returnedGoodsVo.getSenId());
        if(sendout!=null) {
            //设置状态为已被退货
            sendOutDao.updateIfReturnedgoods(sendout.getSenId());
            //保存退货单
            System.out.println("ddd"+returnedGoodsVo.getReturnedgoods().getRegId());
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
                //根据规格id查询库存
                Stock stock = istockDao.queryQuantityBySpeId(r.getProductspecification().getSpeId());
                //库存为空则增加,否则修改
                if (stock != null) {
                    Integer num = istockDao.queryQuantityBySpeId(r.getProductspecification().getSpeId()).getStockQuantity();
                    istockDao.updatestockQuantity((num + r.getRgdAmount()),r.getProductspecification().getSpeId(),r.getReturnedgoods().getWarehouse().getWarehouseId());
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
}
