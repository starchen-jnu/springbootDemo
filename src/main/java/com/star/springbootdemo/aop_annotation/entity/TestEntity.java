package com.star.springbootdemo.aop_annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2020/4/11 10:31
 * @Description:
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TestEntity {

    private String id;
    private String name;
    private String job;
}
