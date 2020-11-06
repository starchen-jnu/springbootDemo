package com.star.springbootdemo.designpatern.delegate;

/**
 * @Author: StarC
 * @Date: 2019/10/27 10:27
 * @Description:
 */
public class Boss {
    public void command(String command,Manager manager){
        manager.doing(command);
    }
}
