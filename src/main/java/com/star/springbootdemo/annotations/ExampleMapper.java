package com.star.springbootdemo.annotations;


import java.util.List;

/**
 * @Author: StarC
 * @Date: 2019/8/27 15:48
 * @Description:
 */
public interface ExampleMapper {

    @Select(value = "select * from example",star = "hello")
    List<Example> findAll(@paramsTest @paramsTest1 String test);
}
