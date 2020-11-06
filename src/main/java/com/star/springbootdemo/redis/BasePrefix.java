package com.star.springbootdemo.redis;

/**
 * @Author: StarC
 * @Date: 2019/8/21 10:18
 * @Description:
 */
public abstract class BasePrefix implements KeyPrefix{
    private int expireSecond;
    private  String prefix;

    public BasePrefix(String prefix) {
        this(0,prefix);
    }

    public BasePrefix(int expireSecond, String prefix) {
        this.expireSecond = expireSecond;
        this.prefix = prefix;
    }
    public int expireSeconds() {//默认0代表永不过期
        return expireSecond;
    }

    public String getPrefix(){
        String className = getClass().getSimpleName();
        return className+":"+prefix;
    }
}
