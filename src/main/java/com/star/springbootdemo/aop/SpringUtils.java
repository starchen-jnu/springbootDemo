package com.star.springbootdemo.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: StarC
 * @Date: 2019/9/16 14:46
 * @Description:
 */
@Component
public class SpringUtils implements ApplicationContextAware {


    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("容器保存成功-----------");
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getObject(String beanId){
        return applicationContext.getBean(beanId);
    }

}
