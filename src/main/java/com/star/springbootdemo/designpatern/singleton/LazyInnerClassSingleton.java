package com.star.springbootdemo.designpatern.singleton;

/**
 * @Author: StarC
 * @Date: 2019/10/26 10:32
 * @Description:
 */
public class LazyInnerClassSingleton {
    private LazyInnerClassSingleton() {
    }
    public static final LazyInnerClassSingleton getSingleton(){

        return LazyHolder.lazy;
    }
    private static class LazyHolder{
        private static final LazyInnerClassSingleton lazy = new LazyInnerClassSingleton();
    }
}
