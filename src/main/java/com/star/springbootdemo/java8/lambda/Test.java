package com.star.springbootdemo.java8.lambda;

import com.star.springbootdemo.bean.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Author: StarC
 * @Date: 2020/5/8 15:11
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {

        //String line = Processor.processFile((BufferedReader bufferedReader)->bufferedReader.readLine());

        List<Person>personList = new ArrayList<>();
        personList.add(new Person("chen",14));
        personList.add(new Person("star",29));
        List<Person> list = FilterObject.filter(personList, person ->{
            return "chen".equals(person.getLastName());
        } );
        System.out.println(list.toString());
        Predicate<Person> predicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return false;
            }
        };

        String[] words = {"hello","world"};
        List<String> collect = Arrays.stream(words).map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        List<String> list1 = Arrays.asList("list", "alist");
        List<String> list2 = new ArrayList<>();
        list2.addAll(list1);
        list2.add("star");
        list2.forEach(s->{
            System.out.println(s);
        });

        Supplier<Person> supplier = ()->new Person();
        supplier.get();
        

    }
}
