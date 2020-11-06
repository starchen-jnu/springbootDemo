package com.star.springbootdemo.designpatern.test;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: StarC
 * @Date: 2020/4/13 14:59
 * @Description:
 */
public class Subscribe implements Observer {

    public Subscribe(Observable o) {
        o.addObserver(this);

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("收到通知："+ ((Publish)o).getData());
    }
}
