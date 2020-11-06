package com.star.springbootdemo.designpatern.delegate;

import java.util.HashMap;

/**
 * @Author: StarC
 * @Date: 2019/10/27 10:23
 * @Description:
 */
public class Manager {

    private static HashMap<String,IEmployee>hashMap = new HashMap<>();
    static {
        hashMap.put("1",new EmployeeA());
        hashMap.put("2",new EmployeeB());
    }
    public void doing(String command){
        hashMap.get(command).doing(command);
    }

}
