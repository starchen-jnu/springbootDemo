package com.star.springbootdemo.tomcat.servlet;

import com.star.springbootdemo.tomcat.http.StarRequest;
import com.star.springbootdemo.tomcat.http.StarResponse;

/**
 * @Author: StarC
 * @Date: 2019/8/28 9:22
 * @Description:
 */
public class MyServlet extends StarServlet {
    @Override
    public void doGet(StarRequest request, StarResponse response) {

        try {
            response.write(request.getParameter("name")+"超帅");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public  void doPost(StarRequest request, StarResponse response) {

        doGet(request,response);
    }
}
