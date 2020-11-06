package com.star.springbootdemo.config;

import com.star.springbootdemo.filter.MyFilter;
import com.star.springbootdemo.listener.MyListern;
import com.star.springbootdemo.servlet.Myservlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author: StarC
 * @Date: 2019/8/19 18:40
 * @Description:
 */
@Configuration
public class MyServerConfig {

    @Bean
    public ServletRegistrationBean myservlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new Myservlet(),"/servlet");
         return  servletRegistrationBean;
    }

   @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/servlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myLister(){
        ServletListenerRegistrationBean listenerRegistrationBean = new ServletListenerRegistrationBean(new MyListern());
        return listenerRegistrationBean;
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8081);
            }
        };
    }
}
