package com.star.springbootdemo.designpatern.test;

import com.star.springbootdemo.bean.Person;
import com.star.springbootdemo.bean.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: StarC
 * @Date: 2020/8/11 11:11
 * @Description:
 */
public class MethodType {

    public static Function<Object,Integer> getType(Integer type){

        Function<Object,Integer> action1 = (object)->{
            Person p = (Person) object;
            System.out.println();
            return  0;
        };

        Function<Object,Integer> action2 = (object)->{
            User user = (User) object;
            return 1;
        };
        Supplier<Map<Integer,Function<Object,Integer>>> mapSupplier = ()->{
            Map<Integer,Function<Object,Integer>> map = new HashMap<>();
            map.put(1,action1);
            map.put(2,action2);
            return map;
        };
        Function<Object, Integer> objectIntegerFunction = mapSupplier.get().get(type);
        return objectIntegerFunction;
    }

    public static void execute(Integer type,Object o){
        Optional.ofNullable(getType(type)).ifPresent(x->{
            x.apply(o);
        });
    }

}
