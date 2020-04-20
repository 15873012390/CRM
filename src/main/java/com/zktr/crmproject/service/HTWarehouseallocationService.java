package com.zktr.crmproject.service;

import com.zktr.crmproject.dao.jpa.HTStockDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.utils.UUIDUtils;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class HTWarehouseallocationService {
    @Autowired
    private HTIWarehouseAllocationDao iwarehouseAllocationDao;
    @Autowired
    private HTIInstockDao instockDao;
    @Autowired
    private HTIOutstockDao outstockDao;
    @Autowired
    private lliUserDao userDao;
    @Autowired
    private HTIStockDao istockDao;
    @Autowired
    private HTStockDao stockDao;


    /**
     * 分页查询仓库调拨
     *
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Warehouseallocation> selectWaByPage(Integer curpage, Integer pagesize) {
        List<Warehouseallocation> list1 = iwarehouseAllocationDao.selectWaByPage();
        List list2 = new ArrayList();
        for (int i = 0; i < pagesize; i++) {
            int index = (curpage - 1) * pagesize + i;
            if (index < list1.size()) {
                if (list1.get(index) != null) {
                    list2.add(list1.get(index));
                }
            }
        }
        return new Pager<Warehouseallocation>(list1.size(), list2);
    }

    /**
     * 编辑和增加仓库调拨
     *
     * @param warehouseallocation
     */
    public void addAndEditWahouseallocation(Warehouseallocation warehouseallocation) {
        if (warehouseallocation.getWaId() == 0) {
            warehouseallocation.setWaStatus("未执行");
            iwarehouseAllocationDao.insertWa(warehouseallocation);
        } else {
            //修改调拨表时，如果有入库和出库记录的仓库也要一起改
            iwarehouseAllocationDao.updateWa(warehouseallocation);
            if (warehouseallocation.getInstock() != null) {
                Instock instock = instockDao.queryByInsId(warehouseallocation.getInstock().getInsId());
                instock.setWarehouse(warehouseallocation.getInwarehouse());
                instockDao.updateInstock(instock);
            }
            if (warehouseallocation.getOutstock() != null) {
                Outstock outstock = outstockDao.queryOutstockByOutId(warehouseallocation.getOutstock().getOutId());
                outstock.setWarehouse(warehouseallocation.getOutwarehouse());
                outstockDao.updateOutStock(outstock);
            }
        }
    }

    /**
     * 根据仓库调拨ID查询仓库调拨单
     *
     * @param waId
     * @return
     */
    public Warehouseallocation queryWaByWaId(Integer waId) {
        Warehouseallocation wa = iwarehouseAllocationDao.queryWaByWaId(waId);
        if (wa != null) {
            if (wa.getInUser() == null) {
                wa.setInUser(new User());
            }
            if (wa.getOutUser() == null) {
                wa.setOutUser(new User());
            }
            if (wa.getInstock() == null) {
                wa.setInstock(new Instock());
            }
            if (wa.getOutstock() == null) {
                wa.setOutstock(new Outstock());
            }
            if (wa.getInwarehouse() == null) {
                wa.setInwarehouse(new Warehouse());
            }
            if (wa.getOutwarehouse() == null) {
                wa.setOutwarehouse(new Warehouse());
            }

            if (wa.getWarehouseallocationdetails() != null && wa.getWarehouseallocationdetails().get(0).getWadId() != 0) {
                System.out.println(92);
                for (Warehouseallocationdetail wad : wa.getWarehouseallocationdetails()) {
                    if (wad.getWarehouseallocation().getInUser() == null) {
                        wad.getWarehouseallocation().setInUser(new User());
                    }
                    if (wad.getWarehouseallocation().getOutUser() == null) {
                        wad.getWarehouseallocation().setOutUser(new User());
                    }
                    if (wad.getWarehouseallocation().getInstock() == null) {
                        wad.getWarehouseallocation().setInstock(new Instock());
                    }
                    if (wad.getWarehouseallocation().getOutstock() == null) {
                        wad.getWarehouseallocation().setOutstock(new Outstock());
                    }
                    if (wad.getWarehouseallocation().getInwarehouse() == null) {
                        wad.getWarehouseallocation().setInwarehouse(new Warehouse());
                    }
                    if (wad.getWarehouseallocation().getOutwarehouse() == null) {
                        wad.getWarehouseallocation().setOutwarehouse(new Warehouse());
                    }
                    if (wad.getProductspecification() == null) {
                        wad.setProductspecification(new Productspecification());
                    }
                }
            } else {
                System.out.println(117);
                wa.setWarehouseallocationdetails(null);
            }
        }

        return wa;
    }

    /**
     * 根据下拉框和模糊查询出来的分页查询
     *
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Warehouseallocation> queryBySelectAndInput(String value, String input, String select, Integer curpage, Integer pagesize) {
        List<Warehouseallocation> clist = iwarehouseAllocationDao.queryBySelectAndInput(value, "%" + input.trim() + "%", select);
        List list2 = new ArrayList();
        for (int i = 0; i < pagesize; i++) {
            int index = (curpage - 1) * pagesize + i;
            if (index < clist.size()) {
                if (clist.get(index) != null) {
                    list2.add(clist.get(index));
                }
            }
        }
        return new Pager<Warehouseallocation>(clist.size(), list2);
    }

    /**
     * 高级查询
     *
     * @param waas
     * @return
     */
    public Pager<Warehouseallocation> queryConditionByPage(WarehouseallocationAdvancedSearch waas) {
        if (waas.getWaDate() != null && waas.getWaDate().length != 0) {
            waas.setS1(waas.getWaDate()[0]);
            waas.setS2(waas.getWaDate()[1]);
        }
        List<Warehouseallocation> list = iwarehouseAllocationDao.queryByAdvanced(waas);
        List list2 = new ArrayList();
        for (int i = 0; i < waas.getPageSize(); i++) {
            int index = (waas.getCurPage() - 1) * waas.getPageSize() + i;
            if (index < list.size()) {
                if (list.get(index) != null) {
                    list2.add(list.get(index));
                }
            }
        }
        return new Pager<Warehouseallocation>(list.size(), list2);

    }

    /**
     * 根据仓库调拨ID来删除
     *
     * @param waId
     */
    public void deleteWaByWaId(Integer waId) {
        Warehouseallocation wa = iwarehouseAllocationDao.queryWaByWaId(waId);
        iwarehouseAllocationDao.deleteWaByWaId(waId);
        if(wa.getInstock()!=null){
            instockDao.deleteInstockById(wa.getInstock().getInsId());
            instockDao.deleteInstockDetailById(wa.getInstock().getInsId());
        }
        if(wa.getOutstock()!=null) {
            outstockDao.deleteOutstockByOutId(wa.getOutstock().getOutId());
            outstockDao.deleteOutstockDetailByOutId(wa.getOutstock().getOutId());
        }
    }

    /**
     * 根据 需求增加调拨单
     *
     * @param productDemandVos
     */
    public void addWaDemand(List<ProductDemandVo> productDemandVos) {
        Warehouseallocation wa = new Warehouseallocation();
        Instock instock = new Instock();
        Outstock outstock = new Outstock();
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        wa.setTitle(createdate + "订单需求调拨");
        wa.setWaDate(new Timestamp(System.currentTimeMillis()));
        wa.setInwarehouse(productDemandVos.get(0).getInwarehouseId());
        wa.setOutwarehouse(productDemandVos.get(0).getOutwarehouseId());
        wa.setWaStatus("未执行");
        wa.setRemarks(createdate + "订单需求调拨");
        iwarehouseAllocationDao.insertWa(wa);
        //添加入库调拨单
        Warehouseallocationdetail wad = new Warehouseallocationdetail();
        instock.setTitle(createdate + "调拨入库单");
        instock.setFiller(productDemandVos.get(0).getuName());
        instock.setFillTime(new Timestamp(System.currentTimeMillis()));
        instock.setStatus("未入库");
        instock.setWarehouse(productDemandVos.get(0).getInwarehouseId());
        instock.setWarehouseallocation(wa);
        instockDao.insertInstock(instock);
        wa.setInstock(instock);
        iwarehouseAllocationDao.updateWa(wa);
        //添加出库调拨单
        outstock.setTitle(createdate + "调拨出库单");
        outstock.setOutNumber(UUIDUtils.getId());
        outstock.setFillTime(new Timestamp(System.currentTimeMillis()));
        outstock.setStatus("未出库");
        outstock.setWarehouse(productDemandVos.get(0).getOutwarehouseId());
        outstock.setWarehouseallocation(wa);
        outstockDao.insertOutstock(outstock);
        wa.setOutstock(outstock);
        iwarehouseAllocationDao.updateWa(wa);
        for (ProductDemandVo p : productDemandVos) {
            wad.setProductspecification(p.getSpeId());
            wad.setWadQuantity(p.getNumber());
            wad.setWarehouseallocation(wa);
            iwarehouseAllocationDao.insertWad(wad);
            //添加入库详情单
            Instockdetail instockdetail = new Instockdetail();
            instockdetail.setInstock(instock);
            instockdetail.setStatus("未入库");
            instockdetail.setInsdQuantity(p.getNumber());
            instockdetail.setProductspecification(p.getSpeId());
            instockDao.insertInstockDetail(instockdetail);
            //添加出库详情单
            Outstockdetails outstockdetails = new Outstockdetails();
            outstockdetails.setOutstock(outstock);
            outstockdetails.setStatus("未出库");
            outstockdetails.setOsdNumber(p.getNumber());
            outstockdetails.setProductspecification(p.getSpeId());
            outstockDao.insertOutStockDetails(outstockdetails);
        }
    }

    /**
     * 仓库调拨单增加产品详情
     *
     * @param warehouseallocationdetailVo
     */
    public void addAndEditWad(WarehouseallocationdetailVo warehouseallocationdetailVo) {
        boolean flag = true;
        boolean flag2 = true;
        Warehouseallocation wa = null;
        Instock instock1 = null;
        Outstock outstock1 = null;
        Instock instock = new Instock();
        Outstock outstock = new Outstock();
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        for (Warehouseallocationdetail wad : warehouseallocationdetailVo.getList()) {
            Warehouseallocationdetail wads = new Warehouseallocationdetail();
            //添加调拨详情单
            wa = iwarehouseAllocationDao.queryWaByWaId(wad.getWarehouseallocation().getWaId());
            if (wa != null) {
                wads.setProductspecification(wad.getProductspecification());
                wads.setWadQuantity(wad.getWadQuantity());
                wads.setWarehouseallocation(wa);
                if (wad.getWadId() == 0) {
                    iwarehouseAllocationDao.insertWad(wads);
                } else {
                    iwarehouseAllocationDao.updateWad(wads);
                }
                //如果入库单没有数据就添加入库单
                if (wa.getInstock() == null) {
                    if (flag) {
                        instock.setTitle(createdate + "调拨入库单");
                        instock.setFiller(warehouseallocationdetailVo.getuName());
                        instock.setFillTime(new Timestamp(System.currentTimeMillis()));
                        instock.setStatus("未入库");
                        instock.setWarehouse(wads.getWarehouseallocation().getInwarehouse());
                        instock.setWarehouseallocation(wa);
                        instockDao.insertInstock(instock);
                        wa.setInstock(instock);
                        iwarehouseAllocationDao.updateWa(wa);
                        flag = false;
                    }
                    Instockdetail instockdetail = new Instockdetail();
                    instockdetail.setInstock(instock);
                    instockdetail.setStatus("未入库");
                    instockdetail.setInsdQuantity(wad.getWadQuantity());
                    instockdetail.setProductspecification(wad.getProductspecification());
                    instockDao.insertInstockDetail(instockdetail);
                } else {
                    //否则在原有的基础上添加详情
                    instock1 = instockDao.queryByInsId(wa.getInstock().getInsId());
                    Instockdetail instockdetail = new Instockdetail();
                    instockdetail.setInstock(instock1);
                    instockdetail.setStatus("未入库");
                    instockdetail.setInsdQuantity(wad.getWadQuantity());
                    instockdetail.setProductspecification(wad.getProductspecification());
                    Instockdetail insd = instockDao.queryInsdByInsIdAndSpeId(instock1.getInsId(), wad.getProductspecification().getSpeId());
                    if (insd != null) {
                        instockDao.updateInstockDetail(instockdetail);
                    } else {
                        instockDao.insertInstockDetail(instockdetail);
                    }


                }
                //如果入库单没有数据就添加入库单
                if (wa.getOutstock() == null) {
                    if (flag2) {
                        outstock.setTitle(createdate + "调拨出库单");
                        outstock.setOutNumber(UUIDUtils.getId());
                        outstock.setFillTime(new Timestamp(System.currentTimeMillis()));
                        outstock.setStatus("未出库");
                        outstock.setWarehouse(wads.getWarehouseallocation().getInwarehouse());
                        outstock.setWarehouseallocation(wa);
                        outstockDao.insertOutstock(outstock);
                        wa.setOutstock(outstock);
                        iwarehouseAllocationDao.updateWa(wa);
                        flag2 = false;
                    }
                    Outstockdetails outstockdetails = new Outstockdetails();
                    outstockdetails.setOutstock(outstock);
                    outstockdetails.setStatus("未出库");
                    outstockdetails.setOsdNumber(wad.getWadQuantity());
                    outstockdetails.setProductspecification(wad.getProductspecification());
                    outstockDao.insertOutStockDetails(outstockdetails);
                } else {
                    //否则在原有的基础上添加详情
                    outstock1 = outstockDao.queryOutstockByOutId(wa.getOutstock().getOutId());
                    Outstockdetails outstockdetails = new Outstockdetails();
                    outstockdetails.setOutstock(outstock1);
                    outstockdetails.setStatus("未出库");
                    outstockdetails.setOsdNumber(wad.getWadQuantity());
                    outstockdetails.setProductspecification(wad.getProductspecification());
                    Outstockdetails osd = outstockDao.queryOsdByOutIdAndSpeId(outstock1.getOutId(), wad.getProductspecification().getSpeId());
                    if (osd != null) {
                        outstockDao.updateOutDeatails(outstockdetails);
                    } else {
                        outstockDao.insertOutStockDetails(outstockdetails);
                    }
                }
                for (Integer id : warehouseallocationdetailVo.getDelList()) {
                    if (instock1 != null) {
                        instockDao.deleteInstockDetailBySpeIdAndInsId(id, instock1.getInsId());
                    }
                    iwarehouseAllocationDao.deleteWaByWaIdAndSpeId(wa.getWaId(), id);
                    if (outstock1 != null) {
                        outstockDao.deleteOutstockDetailByOutIdAndSpeId(outstock1.getOutId(), id);
                    }

                }

            }

        }
    }

    /**
     * 去入库出库确认
     *
     * @param waId
     * @param type
     * @param uId
     */
    public void toConfirm(Integer waId, Integer type, Integer uId) {
        Warehouseallocation wa = iwarehouseAllocationDao.queryWaByWaId(waId);
        User user = userDao.findById(uId);
        if (type == 1) {
            wa.setInUser(user);
        }
        if (type == 2) {
            wa.setOutUser(user);
        }
        if (type == 3) {
            user.setuId(0);
            wa.setInUser(user);
        }
        if (type == 4) {
            user.setuId(0);
            wa.setOutUser(user);
        }
        iwarehouseAllocationDao.updateWa(wa);
    }

    /**
     * 执行调库操作
     *
     * @param waId
     * @param uName
     */
    public String toOutAndInStock(Integer waId, String uName) {
        Warehouseallocation wa = iwarehouseAllocationDao.queryWaByWaId(waId);
        if (wa != null) {
            //出库不为空则相应往仓库加数据
            if (wa.getOutstock() != null) {
                Outstock outstock = outstockDao.queryOutstockByOutId(wa.getOutstock().getOutId());
                boolean flag = false;
                StringBuffer sb = new StringBuffer();
                sb.append(wa.getOutwarehouse().getWarehouseName() + ":" + "<br/>" + "<br/>");
                //用于保存符合要求的产品
                List<Stock> stocks = new ArrayList<>();
                Stock stock = null;
                for (Outstockdetails outstockdetails : wa.getOutstock().getOutstockdetail()) {
                    //所在的仓库不为空则修改原有的数量，否则新增。
                    stock = istockDao.queryStockByWarehouseAndSpeId(outstockdetails.getProductspecification().getSpeId(), wa.getOutwarehouse().getWarehouseId());
                    System.out.println("429"+stock);
                    if (stock != null && stock.getStockId()!=0) {
                        if (stock.getStockQuantity() >= outstockdetails.getOsdNumber()) {
                            stock.setStockQuantity(stock.getStockQuantity() - outstockdetails.getOsdNumber());
                            stock.setProductspecification(outstockdetails.getProductspecification());
                            stock.setWarehouse(wa.getOutwarehouse());
                            stocks.add(stock);
                        } else {
                            flag = true;
                            sb.append(outstockdetails.getProductspecification().getProName() + "余量不足，无法进行调拨，请保证库存充足！" + "<br/>");
                        }
                    }else{
                        flag = true;
                        sb.append(outstockdetails.getProductspecification().getProName() + "余量不足，无法进行调拨，请保证库存充足！" + "<br/>");
                    }
                }
                if (flag) {
                    return sb.toString();
                } else {
                    outstock.setPassPerson(uName);
                    outstock.setPassTime(new Timestamp(System.currentTimeMillis()));
                    outstock.setStatus("已出库");
                    outstockDao.updateOutStock(outstock);
                    for (Stock s : stocks) {
                        istockDao.updatestockQuantity(s.getStockQuantity(), s.getProductspecification().getSpeId(), s.getWarehouse().getWarehouseId());
                    }
                    //入库不为空则相应往仓库加数据
                    if (wa.getInstock() != null) {
                        Instock instock = instockDao.queryByInsId(wa.getInstock().getInsId());
                        instock.setKeeper(uName);
                        instock.setExecutionTime(new Timestamp(System.currentTimeMillis()));
                        instock.setStatus("已入库");
                        instockDao.updateInstock(instock);
                        for (Instockdetail instockdetail : wa.getInstock().getInstockdetail()) {
                            Stock stock2 = istockDao.queryStockByWarehouseAndSpeId(instockdetail.getProductspecification().getSpeId(), wa.getInwarehouse().getWarehouseId());
                            if (stock2 != null && stock2.getStockId()!=0) {
                                stock2.setStockQuantity(stock2.getStockQuantity() + instockdetail.getInsdQuantity());
                                istockDao.updatestockQuantity(stock2.getStockQuantity(), instockdetail.getProductspecification().getSpeId(), wa.getInwarehouse().getWarehouseId());
                            } else {
                                Stock stock1 = new Stock();
                                stock1.setProductspecification(instockdetail.getProductspecification());
                                stock1.setWarehouse(instock.getWarehouse());
                                stock1.setStockQuantity(instockdetail.getInsdQuantity());
                                stockDao.save(stock1);
                            }
                        }
                    }
                    wa.setWaStatus("已执行");
                    iwarehouseAllocationDao.updateWa(wa);
                }
            }

        }

        return "1";
    }

    /**
     * 调拨辙销
     *
     * @param waId
     * @return
     */
    public String removeWaStatus(Integer waId) {
        Warehouseallocation wa = iwarehouseAllocationDao.queryWaByWaId(waId);
        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        sb.append(wa.getInwarehouse().getWarehouseName() + ":" + "<br/>" + "<br/>");
        List<Stock> stocks = new ArrayList<>();
        Stock stock = null;
        for (Instockdetail i : wa.getInstock().getInstockdetail()) {
            stock = istockDao.queryStockByWarehouseAndSpeId(i.getProductspecification().getSpeId(), wa.getInwarehouse().getWarehouseId());
            System.out.println("498"+stock);
            if (stock != null) {
                if (stock.getStockQuantity() >= i.getInsdQuantity()) {
                    stock.setStockQuantity(stock.getStockQuantity() - i.getInsdQuantity());
                    stock.setWarehouse(wa.getInwarehouse());
                    stock.setProductspecification(i.getProductspecification());
                    stocks.add(stock);
                } else {
                    flag = true;
                    sb.append(i.getProductspecification().getProName() + "余量不足，无法进行调拨，请保证库存充足！" + "<br/>");
                }
            }else{
                flag = true;
                sb.append(i.getProductspecification().getProName() + "余量不足，无法进行调拨，请保证库存充足！" + "<br/>");
            }
        }
        boolean flag3 = false;
        boolean flag4 = false;
        StringBuffer sb2 = new StringBuffer();
        if (flag) {
            return sb.toString();
        } else {
            User user = new User();
            user.setuId(0);
            wa.setWaStatus("未执行");
            wa.setInUser(user);
            wa.setOutUser(user);
            iwarehouseAllocationDao.updateWa(wa);
            Instock instock = instockDao.queryByInsId(wa.getInstock().getInsId());
            instock.setStatus("未入库");
            instock.setKeeper(null);
            instock.setExecutionTime(null);
            instockDao.updateInstock(instock);
            for (Stock s : stocks) {
                istockDao.updatestockQuantity(s.getStockQuantity(), s.getProductspecification().getSpeId(), s.getWarehouse().getWarehouseId());
            }
            Outstock outstock = outstockDao.queryOutstockByOutId(wa.getOutstock().getOutId());
            outstock.setPassPerson(null);
            outstock.setPassTime(null);
            outstock.setStatus("未出库");
            outstockDao.updateOutStock(outstock);
            for (Outstockdetails outstockdetails : wa.getOutstock().getOutstockdetail()) {
                Stock stock2 = istockDao.queryStockByWarehouseAndSpeId(outstockdetails.getProductspecification().getSpeId(), wa.getOutwarehouse().getWarehouseId());
                if (stock2 != null && stock2.getStockId()!=0) {
                    stock2.setStockQuantity(stock2.getStockQuantity() + outstockdetails.getOsdNumber());
                    istockDao.updatestockQuantity(stock2.getStockQuantity(), outstockdetails.getProductspecification().getSpeId(), wa.getOutwarehouse().getWarehouseId());
                } else {
                    Stock stock1 = new Stock();
                    stock1.setProductspecification(outstockdetails.getProductspecification());
                    stock1.setWarehouse(wa.getOutwarehouse());
                    stock1.setStockQuantity(outstockdetails.getOsdNumber());
                    stockDao.save(stock1);
                }
            }
            return "1";
        }

    }




}
