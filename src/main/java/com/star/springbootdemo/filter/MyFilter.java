package com.star.springbootdemo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: StarC
 * @Date: 2019/8/19 18:48
 * @Description:
 */
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myfilter process ...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
