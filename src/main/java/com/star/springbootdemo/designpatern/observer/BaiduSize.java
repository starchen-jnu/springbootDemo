package com.star.springbootdemo.designpatern.observer;

/**
 * @Author: StarC
 * @Date: 2019/9/2 13:56
 * @Description:
 */
public class BaiduSize implements Observer {

    private Weather weather ;

    @Override
    public void update(Weather weather) {
        this.weather = weather;
        display();
    }

    // 显示
    public void display() {
        System.out.println("===百度网站====");
        System.out.println("***百度网站 气温 : " + weather.getTemperature() + "***");
        System.out.println("***百度网站 气压: " + weather.getPressure() + "***");
        System.out.println("***百度网站 湿度: " + weather.getHumidity() + "***");
    }
}
