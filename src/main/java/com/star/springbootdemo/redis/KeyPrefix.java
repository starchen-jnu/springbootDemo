package com.star.springbootdemo.redis;

/**
 * @Author: StarC
 * @Date: 2019/8/21 10:23
 * @Description:
 */
public interface KeyPrefix  {
    public int expireSeconds();
    public String getPrefix();
}
