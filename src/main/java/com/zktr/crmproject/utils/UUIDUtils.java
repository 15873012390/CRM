package com.zktr.crmproject.utils;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 随机生成id
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	/**
	 * 生成随机码
	 * @return
	 */
	public static String getCode(){
		return getId();
	}
	
	
	public static String getNewNo(String equipmentType, String equipmentNo){
        String newEquipmentNo = "00001";
 
        if(equipmentNo != null && !equipmentNo.isEmpty()){
            int newEquipment = Integer.parseInt(equipmentNo) + 1;
            newEquipmentNo = String.format(equipmentType + "%05d", newEquipment);
        }
 
        return newEquipmentNo;
    }
	
	public static String getNewNo1(String equipmentType, String equipmentNo){
        String newEquipmentNo = "001";
 
        if(equipmentNo != null && !equipmentNo.isEmpty()){
            int newEquipment = Integer.parseInt(equipmentNo) + 1;
            newEquipmentNo = String.format(equipmentType + "%03d", newEquipment);
        }
 
        return newEquipmentNo;
    }
	
	
	/*
	 * 这个 是dao中调用上面方法的步骤
	 * public String getID() {
		//查找数据库最大的Id
		String sql="select max(groupId) from tbgroups";
		String query;
		try {
			query = String.valueOf(queryOne(sql));
			String s=query.substring(query.length()-4);//截取最大id的后4位
			String equipmentNo = UUIDUtils.getNo("GR", s);
			System.out.println(equipmentNo);
			return equipmentNo;
		} catch (Exception e) {
			return "GR00001";//若没有id则返回这个
		}
		
	}*/
	
	public static void main(String[] args) {
		System.out.println(getId());
		System.out.println(getCode());
	}
}
