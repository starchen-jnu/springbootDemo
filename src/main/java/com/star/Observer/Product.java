package com.star.Observer;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: StarC
 * @Date: 2020/8/26 13:46
 * @Description:
 */
@Data
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
    private double size;
    private String describe;

}
