package com.star.project;

import java.util.*;
import java.util.function.Supplier;

/**
 * @Author: StarC
 * @Date: 2020/8/5 15:31
 * @Description:
 */
public class Statics {

   static HashMap<Integer,Integer> monthOfNumMap;
    static {
       monthOfNumMap = new HashMap<>();
       for(int i=1;i<=12;i++){
           monthOfNumMap.put(i,0);
       }
    }

    public static void main(String[] args) {
       /* Date date = new Date();
        Integer month = getDate(date).get("month");
        System.out.println(month);
        monthOfNumMap.put(month,monthOfNumMap.get(month)+1);
        System.out.println(monthOfNumMap.get(month));*/
       Map<String,Integer>map = getDate(new Date());
        Optional<Map<String, Integer>> map1 = Optional.ofNullable(map);
        map1.ifPresent(x->{
            System.out.println(x.get("month"));
        });



    }
    public static Map<String,Integer> getDate(Date date){
        Map<String,Integer> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Integer year = calendar.get(Calendar.YEAR) ;
        Integer month = calendar.get(Calendar.MONTH)+1;
        Integer day  = calendar.get(Calendar.DATE) ;
        map.put("year",year);
        map.put("month",month);
        map.put("day",day);
        return map;

    }
}
