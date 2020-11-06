package com.star.springbootdemo.designpatern.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2019/8/26 13:34
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private String baise;
    private String wall;
    private String roofed;
}
