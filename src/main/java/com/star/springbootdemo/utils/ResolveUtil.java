package com.star.springbootdemo.utils;

import com.star.springbootdemo.bean.MainData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author: StarC
 * @Date: 2019/9/18 13:38
 * @Description:
 */
public class ResolveUtil {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private void getfields(Class<?> clazz){

        Field[] fields = ReflectUtil.getFileds(clazz);
        System.out.println(Arrays.toString(fields));
    }

    public static void main(String[] args) {
        ResolveUtil resolveUtil = new ResolveUtil();
        //resolveUtil.getfields(MainData.class);
        MainData mainData = new MainData();
        mainData.setID("1");
        mainData.setFEXD("20190918");
        mainData.setCYR("CR");
        mainData.setFPTT(new Date());
        List<Map<String,Object>> targetList =ReflectUtil.getFiledsInfo(mainData);
        if(String.class.equals(targetList.get(0).get("type"))) {
            String obj = (String) targetList.get(0).get("value");
            System.out.println(obj);
        }
        if(Date.class.equals(targetList.get(19).get("type"))){
            Date date = (Date) targetList.get(19).get("value");
            System.out.println(date);
        }

        Method method = ReflectUtil.getMethodByName("getID",MainData.class);
        try {
            String  value = (String) method.invoke(mainData);
            System.out.println(value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /*System.out.println("属性类型："+targetList.get(0).get("type") +",属性名："+
                targetList.get(0).get("name")+"，属性值："+targetList.get(0).get("value"));*/


        Map<String, Object> map = new HashMap<>();
        map.put("ID","123");
        map.put("FEXD","20190918");
        map.put("FPTT",new Date());
        MainData mainData1 = (MainData) ReflectUtil.map2Object(map,MainData.class);
        System.out.println(mainData1);
    }


}
