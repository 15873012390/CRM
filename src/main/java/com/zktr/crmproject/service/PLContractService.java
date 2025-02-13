package com.zktr.crmproject.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zktr.crmproject.dao.jpa.PLContractJDao;
import com.zktr.crmproject.dao.mybatis.*;
import com.zktr.crmproject.pojos.*;
import com.zktr.crmproject.utils.UUIDUtils;
import com.zktr.crmproject.vo.PLContractAdvancedSearch;
import com.zktr.crmproject.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackOn = Exception.class)
public class PLContractService {
    @Autowired
    private PLContractMDao contractMDao;
    @Autowired
    private PLContractJDao contractJDao;
    @Autowired
    private PLproductMDao productMDao;
    @Autowired
    private PLProductSpecificationMDao specificationMDao;
    @Autowired
    private JrcQuoteDetailsMDao quoteDetailsMDao;
    @Autowired
    private JrcQuoteMDao quoteMDao;

    /**
     * 分页查询全部合同
     * @param curpage
     * @param pagesize
     * @return
     */
    public Pager<Contract> queryAllContracrByPage(int curpage,int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Contract> list=contractMDao.queryAllContract();
        PageInfo<Contract> page=new PageInfo<>(list);
        return new Pager<>(page.getTotal(),page.getList());
    }

    /**
     * 自动生成编号
     * @return
     */
    public String getId(){
        String id=String.valueOf(contractMDao.findMaxByCtrId());
        try {
            //String s=id.substring(id.length()-4);//截取最大id的后4位
            String equipmentNo= UUIDUtils.getNewNo("CON",id);
            System.out.println(equipmentNo);
            return equipmentNo;
        }catch (Exception e){
            return "CON00001"; //若没有id则返回这个
        }
    }
    /**
     * jpa 新增
     * @param contract
     */
    public void saveContract(Contract contract){
        Contract c=new Contract();
        c.setConNumber(this.getId());
        c.setConClassify(contract.getConClassify());
        c.setConDelState(1);
        c.setConEndTime(contract.getConEndTime());
        c.setConStartTime(contract.getConStartTime());
        c.setConMoneyWay(contract.getConMoneyWay());
        c.setConSendOutMoney(contract.getConSendOutMoney());
        c.setConSigningDate(contract.getConSigningDate());
        c.setConPayment(contract.getConPayment());
        c.setConTheme(contract.getConTheme());
        c.setOrdPurchaseWay(contract.getOrdPurchaseWay());
        c.setOrdExecutingState(contract.getOrdExecutingState());
        c.setCustomer(contract.getCustomer());
        c.setUser(contract.getUser());
        c.setProductspecification(contract.getProductspecification());
        c.setQuote(contract.getQuote());
        contractJDao.save(c);
        //报价状态为转订单 修改为3
        quoteMDao.PLupdateByQutId(c.getQuote().getQuoId());
    }

    /**
     * mybatis 新增/修改
     * @param contract
     */
    public void insertContract(Contract contract){
        if(contract.getCtrId()==0){
            Contract c=new Contract();
            c.setConNumber(this.getId());
            c.setConClassify(contract.getConClassify());
            c.setConDelState(1);
            c.setConEndTime(contract.getConEndTime());
            c.setConStartTime(contract.getConStartTime());
            c.setConMoneyWay(contract.getConMoneyWay());
            c.setConSendOutMoney(contract.getConSendOutMoney());
            c.setConSigningDate(contract.getConSigningDate());
            c.setConPayment(contract.getConPayment());
            c.setConTheme(contract.getConTheme());
            c.setOrdPurchaseWay(contract.getOrdPurchaseWay());
            c.setOrdExecutingState(contract.getOrdExecutingState());
            c.setCustomer(contract.getCustomer());
            c.setUser(contract.getUser());
            c.setProductspecification(contract.getProductspecification());
            c.setQuote(contract.getQuote());
            c.setConQdid(contract.getConQdid());
            contractMDao.insertContract(c);
            System.out.println("ccc"+c.getConSigningDate());

        }else {
           contractMDao.updateContract(contract);
        }
    }

    /**
     * 删除 修改状态
     * @param ctrid
     */
    public void delByCtrId(Integer ctrid){
        contractMDao.delByCtrId(ctrid);
    }

    /**
     * 批量删除 修改状态
     * @param ctrids
     */
    public void batchCtrIds(Integer [] ctrids){
        if(ctrids.length!=0){
            contractMDao.BatchCtrIds(ctrids);
        }else {
            System.out.println("删除数组为空");
        }
    }

    /**
     * 分页模糊条件查询
     * @param curpage
     * @param pagesize
     * @param select
     * @param input1
     * @param value
     * @return
     */
    public Pager<Contract> queryByLikeQuery(int curpage, int pagesize,String select,String input1,String value){
        PageHelper.startPage(curpage,pagesize);
        String input="%"+input1.trim()+"%";
        List<Contract> list=contractMDao.queryByLikeQuery(select,input,value);
        PageInfo<Contract> page=new PageInfo<>(list);
        return new Pager<>(page.getTotal(),page.getList());
    }

    /**
     * 高级查询
     * @param contractAdvancedSearch
     * @return
     */
    public Pager<Contract> ContractAdvancedSearch(PLContractAdvancedSearch contractAdvancedSearch){
        String conTheme="%"+contractAdvancedSearch.getConTheme().trim()+"%";
        String conNumber="%"+contractAdvancedSearch.getConNumber().trim()+"%";
        String uId="%"+contractAdvancedSearch.getuId().trim()+"%";
        contractAdvancedSearch.setConTheme(conTheme);
        contractAdvancedSearch.setConNumber(conNumber);
        contractAdvancedSearch.setuId(uId);
        //System.out.println("aaaa"+contractAdvancedSearch.getConThemeSelect());
        PageHelper.startPage(contractAdvancedSearch.getCurpage(),contractAdvancedSearch.getPagesize());
        List<Contract> list=contractMDao.ContractAdvancedSearch(contractAdvancedSearch);
        PageInfo<Contract> page=new PageInfo<>(list);
        return new Pager<Contract>(page.getTotal(),page.getList());
    }
    /**
     * 根据合同id查询
     * @param ctrId
     * @return
     */
    public Contract queryByCtrId(Integer ctrId){
        return contractMDao.queryByCtrId(ctrId);
    }

    /**
     * 查询 服务类的产品
     * @return
     */
    public List<Productspecification> queryByClaState(){
        return specificationMDao.queryByClaState();
    }
    /**
     * //合同页面 根据规格id查找产品销售金额 赋值给合同金额
     * @param speId
     * @return
     */
    public Productspecification findBySpeIdPrice(Integer speId){
        return specificationMDao.findBySpeIdPrice(speId);
    }
    /**
     * 查询 报价详情服务类产品
     * @return
     */
    public List<Quotedetails> findAllByClaIdId(){
        return quoteDetailsMDao.findAllByClaIdId();
    }

    /**
     * 查询 报价详情对象
     * @param qdid
     * @return
     */
    public Quotedetails findByQuoteClaIdId(Integer qdid){
        return quoteDetailsMDao.findByQuoteClaIdId(qdid);
    }
    /**
     * 统计总金额
     * @return
     */
    public List<Map> statisticsByMoney(){
        return contractMDao.statisticsByMoney();
    }
}
