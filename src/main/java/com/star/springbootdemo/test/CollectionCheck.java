package com.star.springbootdemo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: StarC
 * @Date: 2020/3/27 14:25
 * @Description:
 */
public class CollectionCheck {
    public static void main(String[] args) {
        List<String> list = Stream.of("AD","bc").collect(Collectors.toList());
        List<String> copyList = Arrays.asList(new String[list.size()]);
        Collections.copy(copyList,list);;
        Collections.fill(list,new String("ac"));
        list.forEach(s->{
            System.out.println(s);
        });
    }
}
