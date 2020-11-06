package com.star.springbootdemo.java8.stream;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: StarC
 * @Date: 2020/3/9 10:48
 * @Description:
 */
@Slf4j
public class StreamTest {

    static  Map<String,String> map = new HashMap<>();
    static{
        map.put(Month.JANUARY.toString(),"1月");
        map.put(Month.FEBRUARY.toString(),"2月");
        map.put("MARCH","3月");

    }
    public static void main(String[] args) {
        List<String> list = Stream.of("A","b","C").collect(Collectors.toList());
        List<User> userList = Stream.of(new User("star",29),new User("chen",18)).collect(Collectors.toList());
        list.forEach(s-> System.out.println(s));
        String result = list.stream().collect(Collectors.joining("-"));

        userList.stream().sorted(Comparator.comparing(User::getAge).reversed().thenComparing(User::getName)).forEach((user)->{
            System.out.println(user.getName());
        });

        List<String> userNameList = userList.stream().map(User::getName).collect(Collectors.toList());
        Set<String> nameSet = userList.stream().map(User::getName).collect(Collectors.toSet());

       // System.out.println(result);
        LocalDateTime currentTime = LocalDateTime.now();
        Month month = currentTime.getMonth();
        int dayOfMonth = currentTime.getDayOfMonth();
        //System.out.println("moth:"+map.get(month)+",day:"+dayOfMonth);

       // list.forEach(StreamTest::write);
       // list.stream().filter(s->!s.contains("A")).forEach(a-> System.out.println(a));
        long count = list.stream().count();
        String a = "123";
        Integer i = 15;
       //  System.out.println(i.compareTo(12));

         String reg = "^(?=.*[a-zA-Z])(?=.*[1-9])(?=.*[\\W]).{6,}$";
         String str = "asded1234";
       // System.out.println(str.matches(reg));


    }
    public static void write(String s){
        System.out.println(s.toUpperCase());
    }

}
