package com.star.springbootdemo.designpatern.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: StarC
 * @Date: 2020/8/11 15:21
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {
    private String name;
    private BigDecimal amount;
    private Integer type;
}
