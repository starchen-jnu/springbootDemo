package com.star.springbootdemo.reflect;

/**
 * @Author: StarC
 * @Date: 2020/4/14 9:38
 * @Description:
 */
public class Tests {

    public static void main(String[] args) {

        SourceEntity sourceEntity = SourceEntity.builder().name("star").field("get").build();
        System.out.println("source:"+sourceEntity);
        DestEntity destEntity = new DestEntity();
        ReflectTest.copy(sourceEntity,destEntity);
        System.out.println("dest:"+destEntity);
    }
}
