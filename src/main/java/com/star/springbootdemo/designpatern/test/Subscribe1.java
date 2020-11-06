package com.star.springbootdemo.designpatern.test;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: StarC
 * @Date: 2020/4/13 14:59
 * @Description:
 */
public class Subscribe1 implements Observer {

    public Subscribe1(Observable o) {
        o.addObserver(this);

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("�յ�֪ͨ1��"+ ((Publish)o).getData());
    }
}
