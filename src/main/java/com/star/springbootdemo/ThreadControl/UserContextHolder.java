package com.star.springbootdemo.ThreadControl;

/**
 * @Author: StarC
 * @Date: 2019/10/28 15:56
 * @Description:
 */
public class UserContextHolder {

    static ThreadLocal<User> context = new ThreadLocal<>();

    public static User currentUser(){
        return context.get();
    }

    public static void set(User user){
        context.set(user);
    }

    public static void remove(){
        context.remove();
    }



}
