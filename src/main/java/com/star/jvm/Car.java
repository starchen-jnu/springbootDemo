package com.star.jvm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2019/11/6 13:51
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Integer price;
    private String colour;
}
