package com.star.springbootdemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: StarC
 * @Date: 2019/8/19 18:55
 * @Description:
 */
public class MyListern implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web启动....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("当前web销毁");
    }
}
