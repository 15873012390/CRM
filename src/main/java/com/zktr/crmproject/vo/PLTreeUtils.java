package com.zktr.crmproject.vo;

import java.lang.reflect.Field;
import java.util.*;

// 抽取方法的时候要考虑一个问题，即，返回一个集合，集合中有父节点和字节点，父节点和字节点的类型一定要统一，
// 即这里返回的是一个装有TreeUtils类型的集合，那么集合里的父节点和子节点一定都得是TreeUtils类型的
public class PLTreeUtils<T> {
    private int claId; //分类id
    private String claName; //分类名称 返回给前台的是一个装有TreeUtils的集合的数据，所以在前台显示数据的时候，el-tree的lable的名字的和这个一样
    private Integer claIdId; //分类父id
    private String claState; //状态
    private List<PLTreeUtils> childList;// 父节点中存放子节点的集合
    private T data; // 节点数据


    public static List<PLTreeUtils> getTreeList(List<?> listData, String claId, String claIdId, String claName) throws Exception {
        List<PLTreeUtils> resultList = new ArrayList<PLTreeUtils>();  // 最终返回的结果
        Map<Integer,Object> map=new HashMap<Integer, Object>();

        for(int i=0;i<listData.size()&&!listData.isEmpty();i++){
            // 写一个与该方法差不多的方法，将得到TreeUtils的代码抽取出来
            // 也可以将listData集合整个转换成装有TreeUtils的集合x，然后再循环x
            PLTreeUtils plTreeUtils=new PLTreeUtils();
            // 返回值为Object无法直接转换成Integer,先toString，再转换成Integer。这里的返回值写成Object是因为多种类型字段的值都可以用该方法
            plTreeUtils.setClaId(Integer.parseInt(PLTreeUtils.getFileValue(listData.get(i),claId).toString())); // id
            plTreeUtils.setClaIdId(Integer.parseInt(PLTreeUtils.getFileValue(listData.get(i),claIdId).toString())); //父id
            plTreeUtils.setClaName(PLTreeUtils.getFileValue(listData.get(i),claName).toString());
            //System.out.println("节点名为+"+PLTreeUtils.getFileValue(listData.get(i),claName).toString());
            // data:原对象中的所有属性，无children
            plTreeUtils.setData(listData.get(i));
            // 通过反射得到每条数据的id将数据封装的map集合中，id为键，元素本身为值
            map.put(plTreeUtils.getClaId(),plTreeUtils);
            // 将所有顶层元素添加到resultList集合中
            //if( 0 == treeUtils.getParentId()){
            //   resultList.add(treeUtils);
            // }
        }
        // 得到所有的顶层节点，游离节点也算作顶层节点
        // 优点一，不用知道等级节点的id
        // 优点二，只查询了一次数据库
        for(int i =0;i<listData.size();i++){
            if(!map.containsKey(Integer.parseInt(PLTreeUtils.getFileValue(listData.get(i),claIdId).toString()))){
                resultList.add((PLTreeUtils) map.get(Integer.parseInt(PLTreeUtils.getFileValue(listData.get(i),claId).toString())));
            }
        }
        for(int i =0;i<listData.size() && !listData.isEmpty();i++){
            PLTreeUtils obj = (PLTreeUtils) map.get(Integer.parseInt(PLTreeUtils.getFileValue(listData.get(i), claIdId).toString()));
            if(obj != null){
                if(obj.getChildList() == null){
                    obj.setChildList(new ArrayList());
                }
                obj.getChildList().add(map.get(Integer.parseInt(PLTreeUtils.getFileValue(listData.get(i),claId).toString())));
            }
        }
        return resultList;
    }


    /**
     * 通过反射得到的数据类型的也是不一定的，所以这里我们返回值为Object
     * Object是无法直接转为Integer,现将Object转为String，然后再将String转为Integer
     * @param item
     * @param fileName
     * @return
     */
    public static Object  getFileValue(Object item,String fileName) throws Exception {
        Class<?> aClass = item.getClass();
        Field file = aClass.getDeclaredField(fileName); // 得到所有字段包括私有字段
        file.setAccessible(true); // 取消访问限制
        return file.get(item);    // 这里就体现出反射的意思了，我们通常都是通过对象拿到字段，这里是通过字段，将类的字节码对象为参数传入，来得到值
    }
    @Override
    public int hashCode() {
        return Objects.hash(claId, claName, claIdId, claState, childList, data);
    }

    public int getClaId() {
        return claId;
    }

    public void setClaId(int claId) {
        this.claId = claId;
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }

    public Integer getClaIdId() {
        return claIdId;
    }

    public void setClaIdId(Integer claIdId) {
        this.claIdId = claIdId;
    }

    public String getClaState() {
        return claState;
    }

    public void setClaState(String claState) {
        this.claState = claState;
    }

    public List<PLTreeUtils> getChildList() {
        return childList;
    }

    public void setChildList(List<PLTreeUtils> childList) {
        this.childList = childList;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}

