package com.zktr.crmproject.controller;

import com.zktr.crmproject.pojos.Orderdetail;
import com.zktr.crmproject.pojos.Product;
import com.zktr.crmproject.pojos.Productclassification;
import com.zktr.crmproject.service.PLproductService;
import com.zktr.crmproject.utils.ExcelUtils;
import com.zktr.crmproject.utils.QiniuUtils;
import com.zktr.crmproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class PLproductController {
    @Autowired
    private PLproductService pservice;

    @Autowired
    private QiniuUtils qiniuUtils;

    @Value("${uploadFile.resourceHandler}")
    private String resourceHandler;//请求 url 中的资源映射，不推荐写死在代码中，最好提供可配置，如 /uploadImgFiles/**

    @Value("${uploadFile.location}")
    private String uploadFileLocation;//上传文件保存的本地目录，使用@Value获取全局配置文件中配置的属性值，如 E:/PL/uploadImgFiles/

    @GetMapping("/query_all_product")
    public Pager<Product> queryAllProduct(int curpage, int sizepage){
        return pservice.queryByPageProduct(curpage,sizepage);
    }

    @RequestMapping("/queryall")
    public Pager<Product> queryall(int curpage,int sizepage){
        return pservice.queryByPageProduct(curpage,sizepage);
    }

    @PostMapping("/add_update_product")
    public Result addUpdateProduct(@RequestBody Product product){
        System.out.println(product.getProId());
        pservice.addAndUpdateProduct(product);
        return Result.SUCCESS;
    }

    @DeleteMapping("/delete_product")
    public Result deleteProduct(Integer proid){
        pservice.deleteProudct(proid);
        return Result.SUCCESS;
    }

    @PostMapping("/delete_products")
    public Result deleteProducts(@RequestBody Integer[] proids){
        pservice.deleteProducts(proids);
        return Result.SUCCESS;
    }

    /**
     * 生成唯一的文件名，扩展名不变 ab.c.jpg
     * @param fileName
     * @return
     */
    private String uniqueFileName(String fileName){
        int doPos=fileName.lastIndexOf('.');//点的位置
        String ext=fileName.substring(doPos); //获取扩展名.jpg
        String uuid= UUID.randomUUID().toString().toUpperCase();//唯一的字符串
        return uuid+ext;
    }
    //此方法作废
    @PostMapping("/uploadImg") //file:///E:/PL/uploadImgFiles/)OES9BODI1M6MJ1VP(%5BB@MF.png
    public String uploadImgs(@RequestBody MultipartFile file, HttpServletRequest request) throws IOException {
        if(file==null || file.isEmpty()){
            return "上传图片为空";
        }
        //basePath拼接完成后，形如：http://192.168.1.20:8022/yf1804
        String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        String fileName = this.uniqueFileName(file.getOriginalFilename());
        String fileServerPath = basepath+resourceHandler.substring(0,resourceHandler.lastIndexOf("/")+1)+fileName;
        System.out.println("图片访问路径:"+fileServerPath);

        File savefile=new File(uploadFileLocation,fileName);
        //如果不存在就创建目录
        if(!savefile.exists()){
            savefile.mkdirs();
        }
        file.transferTo(savefile); //文件保存

        System.out.println("图片保存路径："+savefile.getPath());
        return fileServerPath;
    }

    @GetMapping("/findByProid")
    public Product findByProid(Integer proid){
        return pservice.findByid(proid);
    }

    @GetMapping("/query_By_Select_page")
    public Pager<Product> queryBySelectPage(String value,String input,int curpage,int sizepage){
        return pservice.queryByselect(value,input,curpage,sizepage);
    }

    @PostMapping("Product_AdvancedSearch")
    public Pager<Product> ProductAdvancedSearch(@RequestBody ProductAdvancedSearch productAdvancedSearch){
        System.out.println(productAdvancedSearch.toString());
        return pservice.ProductAdvancedSearch(productAdvancedSearch);
    }

    @GetMapping("statistics_By_Money")
    public List<Map> statisticsByMoney(){
        return pservice.statisticsByMoney();
    }

    @PostMapping("import_product")
    public String  importProduct(MultipartFile multipartFile){
        List<Product> products= ExcelUtils.importData(multipartFile,1,Product.class);
        if(products!=null){
            pservice.insertAllProduct(products);
        }else {
            return "false";
        }
        return "success";
    }

    @GetMapping("/find_all_by_print")
    public List<Product> findAllByPrint(){
        return pservice.findAll();
    }

    @GetMapping("/findAllProduct")
    public List<Product> findAllproduct(){
        return pservice.findAll();
    }
    @GetMapping("/likeByInput")
    public List<Product> likeByInput(String input){
        return pservice.likeByInput(input);
    }
    @GetMapping("/selectByValue")
    public List<Product> selectByValue(String value){
        return pservice.selectByValue(value);
    }

    @GetMapping("/findAllBySpe")
    public List<Product> findAllBySpe(){
        return pservice.findAllBySepcification();
    }
    @GetMapping("/findAllByClaStock")
    public List<Productclassification> findAllByClaStock(){
        return pservice.findAllByClaStock();
    }
    @GetMapping("/findAllCla")
    public List<Productclassification> findAllCla(){
        return pservice.findAllCla();
    }
    @GetMapping("/findBySpeid")
    public Product findBySpeid(Integer speid){
        return pservice.findBySpeid(speid);
    }
    //HT
    @GetMapping("/queryAllProductInstock")
    public List<Product> queryAllProductInstock(){
        return pservice.queryAllProductInstock();
    }

    @GetMapping("/findBySpeidInstock")
    public Product findBySpeidInstock(Integer speid){
        return pservice.findBySpeidInstock(speid);
    }

    @GetMapping("/PLQueryByStock")
    public List<PLCountPie> PLQueryByStock(){
        return pservice.PLQueryByStock();
    }

    @RequestMapping("/uploadUserImg")
    public String uploadUserImg(@RequestParam MultipartFile file) throws IllegalStateException, IOException {
        if (!file.isEmpty()) {
            FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
            //默认不指定key的情况下，以文件内容的hash值作为文件名
            String fileKey = UUID.randomUUID()+ ".png";
            return qiniuUtils.upload(fileInputStream,fileKey);
        }
        return "上传失败";
    }
}
