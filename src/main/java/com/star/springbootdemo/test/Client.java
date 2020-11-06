package com.star.springbootdemo.test;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: StarC
 * @Date: 2019/11/11 9:41
 * @Description:
 */
public class Client {

    public static void main(String[] args) {

        String reg = "([0-9]*)(([a-z]*)([A-Z]*))";
        String text ="123dyalnABC";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(text);
       /* while(matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }*/
        List<Integer> integers = new CopyOnWriteArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Iterator<Integer> itr = integers.iterator();
        while (itr.hasNext()) {
            Integer a = itr.next();
            integers.remove(a);
        }
        String[] arr = new String[]{"star","chen","jackie"};
       /* Arrays.asList(arr).stream().forEach(x-> {
            System.out.println(x);
        });*/
        List<String> alist = Arrays.asList(arr);
        Object[] array = alist.toArray();
        String[] str = Arrays.copyOf(arr, arr.length + 1);
        str[arr.length] = "handsome";
        Arrays.asList(str).stream().forEach(x-> {
            System.out.println(x);
        });

    }
}
