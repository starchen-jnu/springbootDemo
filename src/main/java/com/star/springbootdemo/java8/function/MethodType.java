package com.star.springbootdemo.java8.function;

import com.star.springbootdemo.bean.Person;
import com.star.springbootdemo.bean.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: StarC
 * @Date: 2020/6/1 14:09
 * @Description:
 */
public class MethodType {

    public static Function<Object, Integer> getType(int type){
        Function<Object, Integer> actionTest1 = (object) -> {
            // logic
            Person person = (Person) object;
            System.out.println("------------Method 1------"+person.getAge());
            return 0;
        };

        Function<Object, Integer> actionTest2 = (object) -> {
            // logic
           /* User user = (User) object;
            System.out.println("------------Method 2------"+user.getUsername());*/
            return 0;
        };

        Supplier<Map<Integer, Function<Object, Integer>>> actionSupplier = () -> {
            Map<Integer, Function<Object, Integer>> maps = new HashMap<>();
            maps.put(1, actionTest1);
            maps.put(2, actionTest2);
            return maps;
        };

        Function<Object, Integer> objectIntegerFunction = actionSupplier.get().get(type);

        return objectIntegerFunction;

    }

    public static void executeMethod(int type, Object o){
        Optional.ofNullable(MethodType.getType(type)).ifPresent(x -> x.apply(o));
    }


    public static void main(String[] args) {
        Person p = new Person("star",15);
       /* User user = new User(1,"star","chen");*/
       MethodType.executeMethod(1,p);
        /*MethodType.executeMethod(2,user);*/
    }
}
