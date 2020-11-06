package com.star.springbootdemo.designpatern.Adapter;

/**
 * @Author: StarC
 * @Date: 2019/10/27 14:14
 * @Description:
 */
public class SignService {

    public ResultMsg<Member> register(String userName, String passWd){
        return new ResultMsg<Member>(200,"注册成功");
    }


    public ResultMsg<Member> login(String userName, String passWd){
        return null;
    }

}
