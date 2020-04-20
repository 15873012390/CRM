package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.jpa.HTStockDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PLSendOutService {
    @Autowired
    private PLISendOutDao sendOutDao;
    @Autowired
    private PLAddressMDao addressMDao;
    @Autowired
    private HTIOutstockDao iOutstockDao;
    @Autowired
    private HTIStockDao istockDao;
    @Autowired
    private HTStockDao stockDao;
    @Autowired
    private PLIOrdersDao ordersDao;

    /**
     * 根据订单id查找发货单
     * @param ordid
     * @return
     */
    public Sendout findSendOutByOrdid(Integer ordid){

        return sendOutDao.findSendOutByOrdid(ordid);
    }

    /**
     * 查找地址
     * @param addid
     * @return
     */
    public Address findByAddidByOrders(Integer addid){
        return addressMDao.findByAddidByOrders(addid);
    }

    /**
     * 修改订单时间、备注、收货人
     * @param sendout
     */
    public void updateSendOut(Sendout sendout){
        sendOutDao.updateSendOut(sendout);
    }

    /**
     * 根据发货单id查询订单明细
     * @param senid
     * @return
     */
    public List<Sendoutdetial> findAllBySendOutDetailBySenId(Integer senid){
        return sendOutDao.findAllBySendOutDetailBySenId(senid);
    }

    /**
     * 修改发货单(全部)
     * @param sendout
     */
    public void updateBySendOutBySenId(Sendout sendout){
        sendout.setSenState("已发货");
        //修改订单的发货状态和发货金额 把发货单的发货状态和运费赋值
        ordersDao.updateSendOut(sendout.getOrders().getOrdId(),sendout.getSenFreight(),sendout.getSenState());
        sendOutDao.updateBySendOutBySenId(sendout);

    }

    /**
     * 撤销
     * @param senid
     * @param outid
     */
    public void updateStockAndSendOut(Integer senid,Integer outid){
        if (senid!=0){
            sendOutDao.updateSendOutState(senid);
        }
        //查找出库id
        Outstock outstock = iOutstockDao.queryOutstockByOutId(outid);
        //更新成未出库
        outstock.setStatus("未出库");
        iOutstockDao.updateOutStock(outstock);
        //查找出库详情
        List<Outstockdetails> outstockdetailsList = iOutstockDao.queryAllOutdetailById(outid);
        for (Outstockdetails o : outstockdetailsList) {
            o.setStatus("未出库");
            //更新出库详情
            iOutstockDao.updateOutDeatails(o);
            //根据规格id查询库存
            Stock stock = istockDao.queryQuantityBySpeId(o.getProductspecification().getSpeId());
            //库存为空则增加,否则修改
            if (stock != null) {
                Integer num = istockDao.queryQuantityBySpeId(o.getProductspecification().getSpeId()).getStockQuantity();
                istockDao.updatestockQuantity((num + o.getOsdNumber()), o.getProductspecification().getSpeId(),o.getOutstock().getWarehouse().getWarehouseId());
            } else {
                Stock stock1 = new Stock();
                stock1.setProductspecification(o.getProductspecification());
                stock1.setWarehouse(outstock.getWarehouse());
                stock1.setStockQuantity(o.getOsdNumber());
                stockDao.save(stock);
            }
        }
    }
}
