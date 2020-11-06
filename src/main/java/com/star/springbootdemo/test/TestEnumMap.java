package com.star.springbootdemo.test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: StarC
 * @Date: 2020/3/27 11:16
 * @Description:
 */
public class TestEnumMap {

    public static void main(String[] args) {
        DayEnum dayEnum = DayEnum.MONDAY;
        EnumMap enumMap = new EnumMap(DayEnum.class);
        enumMap.put(DayEnum.MONDAY,"星期一");
       // System.out.println(dayEnum);

        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.forEach((key,value)->{
            System.out.println(key+":"+value);
        });
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
