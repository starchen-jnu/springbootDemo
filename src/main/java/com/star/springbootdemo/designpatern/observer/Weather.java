package com.star.springbootdemo.designpatern.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2019/9/2 13:38
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    private float humidity;
    private float temperature;
    private float pressure;
}
