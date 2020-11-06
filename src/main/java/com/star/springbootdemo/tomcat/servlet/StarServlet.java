package com.star.springbootdemo.tomcat.servlet;

import com.star.springbootdemo.tomcat.http.StarRequest;
import com.star.springbootdemo.tomcat.http.StarResponse;

/**
 * @Author: StarC
 * @Date: 2019/8/28 9:22
 * @Description:
 */
public abstract class StarServlet {
    public abstract void doGet(StarRequest request, StarResponse response);
    public abstract void doPost(StarRequest request, StarResponse response);
}
