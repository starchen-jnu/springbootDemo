package com.star.springbootdemo.leecode;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.beetl.ext.fn.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/**
 * @Author: StarC
 * @Date: 2020/4/16 20:50
 * @Description:leecode 387&&451
 */
public class Leecode387 {


    public static void main(String[] args) {
        //System.out.println(new Leecode387().firstUniqChar("loveleetcode"));
        //new Leecode387().frequencySort("loveleetcode");

    }
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
      return -1;

    }

    public String frequencySort(String s) {

       Map<Character, Integer> map = new LinkedHashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
       Map<Character,Integer> hashMap = new LinkedHashMap<>();
       map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
               .forEach(
               (entry)->{
                   hashMap.put(entry.getKey(),entry.getValue());
               });

        Map<Character, Integer> characterIntegerMap = sortAscend(hashMap);
        System.out.println(characterIntegerMap);
        List<Character> targetList = new ArrayList<>();
       for(Map.Entry<Character,Integer> entry:hashMap.entrySet()){
           int n = entry.getValue();
           for(int i=0;i<n;i++){
               targetList.add(entry.getKey());
           }
       }


//        List<Character> alist = new ArrayList<>();
//        for(Map.Entry<Character,Integer>entry:map.entrySet()){
//            alist.add(entry.getKey());
//        }
        String join = StringUtils.join(targetList, ",");
       // System.out.println(join);
        return join;

    }


    public  <K, V extends Comparable<? super V>> Map<K, V> sortDescend(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> returnMap = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            returnMap.put(entry.getKey(), entry.getValue());
        }
        return returnMap;

    }

    public  <K, V extends Comparable<? super V>> Map<K, V> sortAscend(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return compare;
            }
        });

        Map<K, V> returnMap = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            returnMap.put(entry.getKey(), entry.getValue());
        }
        return returnMap;

    }

}
