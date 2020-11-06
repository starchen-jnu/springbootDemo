package com.star.springbootdemo.bean;

import org.springframework.util.NumberUtils;

import java.math.BigDecimal;

/**
 * @Author: StarC
 * @Date: 2019/9/4 16:49
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        String a ="345.2345";
        String result = a;
        if (a.contains(".")) {
            result =String.valueOf(Math.round(Float.parseFloat(a.substring(0, a.indexOf(".")+2))));
        }
        //System.out.println(result);

        BigDecimal bigDecimal = new BigDecimal("123.75674839294792034");
        BigDecimal setScale = bigDecimal.setScale(0,BigDecimal.ROUND_HALF_UP);

        int aa = setScale.intValue();
        System.out.println(aa);

    }
}
