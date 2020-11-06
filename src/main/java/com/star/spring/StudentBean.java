package com.star.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author StarC
 * @Date 2020/9/8 11:04
 * @Description:
 */
public class StudentBean implements BeanNameAware {

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public void setBeanName(String name) {
        
    }
}
