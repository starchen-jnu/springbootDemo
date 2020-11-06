package com.star.springbootdemo.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/5/8 15:33
 * @Description:
 */
public class FilterObject {

    public static <T> List<T> filter(List<T>list, Predicates<T> p){
        List<T>results = new ArrayList<>();
        for(T s : list){
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }
}
