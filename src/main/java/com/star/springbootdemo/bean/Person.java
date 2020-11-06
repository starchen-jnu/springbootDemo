package com.star.springbootdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2019/8/17 9:56
 * @Description:
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Person {
    private String lastName;
    private Integer age;
    private boolean boss;
    private Date birth;
    private List<String>lists;

    public Person(String lastName, Integer age) {
        this.lastName = lastName;
        this.age = age;
    }
}
