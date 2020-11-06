package com.star.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: StarC
 * @Date: 2020/8/26 13:38
 * @Description:
 */
public class JingDong implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Product newProduct = (Product) arg;
        System.out.println("jingdong:"+newProduct.getName());
    }
}
