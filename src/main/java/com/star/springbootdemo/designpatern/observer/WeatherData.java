package com.star.springbootdemo.designpatern.observer;

import org.apache.commons.collections.CollectionUtils;


import java.util.ArrayList;

/**
 * @Author: StarC
 * @Date: 2019/9/2 13:40
 * @Description:
 */
public class WeatherData implements Subject {

    private Weather weather;
    private ArrayList<Observer>observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void setData(Weather weather){
        this.weather = weather;

    }

    @Override
    public void register(Observer observer) {
        if(!CollectionUtils.isEmpty(observers)){
            observers.add(observer);
        }
    }

    @Override
    public void remove(Observer observer) {
        if(observers.contains(observer)){
            observers.remove(observer);
        }

    }

    @Override
    public void notifys() {
        for(int i=0;i<observers.size();i++){
            observers.get(i).update(weather);
        }

    }
}
