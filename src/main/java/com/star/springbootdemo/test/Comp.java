package com.star.springbootdemo.test;

import java.util.Comparator;

/**
 * @Author: StarC
 * @Date: 2020/3/27 13:56
 * @Description:
 */
public class Comp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((String)o1).compareTo(((String)o2));
    }
}
