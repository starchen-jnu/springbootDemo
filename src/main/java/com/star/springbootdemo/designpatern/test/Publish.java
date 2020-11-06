package com.star.springbootdemo.designpatern.test;

import java.util.Observable;

/**
 * @Author: StarC
 * @Date: 2020/4/13 15:00
 * @Description:
 */
public class Publish extends Observable {
    String data ="";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if(!this.data.equals(data)) {
            this.data = data;
            super.setChanged();
        }
        super.notifyObservers();
    }
}
