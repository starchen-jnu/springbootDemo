package com.star.springbootdemo.java8.lambda;

/**
 * @Author: StarC
 * @Date: 2020/5/8 15:32
 * @Description:
 */
@FunctionalInterface
public interface Predicates<T> {

    public boolean test(T t);
}
