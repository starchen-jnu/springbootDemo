package com.star.springbootdemo.controller;

import com.star.springbootdemo.aop.Man;
import com.star.springbootdemo.aop.SpringUtils;
import com.star.springbootdemo.bean.Person;
import com.star.springbootdemo.commons.MyException;
import com.star.springbootdemo.commons.ResultMsg;
import com.star.springbootdemo.commons.Results;
import com.star.springbootdemo.redis.RedisService;
import com.star.springbootdemo.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: StarC
 * @Date: 2019/8/12 14:09
 * @Description:
 */
@Controller
@RequestMapping("/star")
public class Test {

    @Autowired
    RedisService redisService;
   /* @Autowired
    Man man;*/

    @RequestMapping("/success")
    public String success(Model model){
        model.addAttribute("msg","hello,star");
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/fail")
    public String getMsg(){

        Results<List<Person>> results= new Results<>();
        Person p = new Person();
        p.setLastName("star");
        p.setBirth(new Date());
        p.getAge();
       List<Person>persons = new ArrayList<>();
       persons.add(p);
        results = results.build(ResultMsg.SUCCESS,persons);
//        try {
//            System.out.println(1/0);
//        } catch (Exception e) {
//            if(e instanceof MyException){
//                results = results.build(ResultMsg.DATABASE_CONNECTION_ERROR);
//            }else{
//                results = results.build(ResultMsg. SYSTEM_ERROR);
//                System.out.println(results.getMsg().getMessage());
//            }
//        }
        return results.toString();
    }

    @RequestMapping("/setRedis")
    @ResponseBody
    public String setRedis(){
        Results<Person>results = new Results<>();
        String token = UUID.randomUUID().toString().replaceAll("-","");
        Person p = new Person();
        p.setLastName("star");
        p.setBirth(new Date());
        p.setAge(22);
        try {
            redisService.set(UserKey.getByName,token,p);
            results = Results.build(ResultMsg.SUCCESS,p);
        } catch (Exception e) {
            throw new MyException(ResultMsg.NETWORK_ERROR);
        }
        return results.toString();

    }

    @RequestMapping("/getRedis")
    @ResponseBody
    public String getRedis(){
        Person person = redisService.get(UserKey.getByName, "87c11398c82c4ad0b518607da5020711", Person.class);
        Results<Person>results = new Results<>();
        results = Results.build(ResultMsg.SUCCESS,person);
        return results.toString();
    }

    @RequestMapping("/aopMapping")
    public void aop(){
        Man man = (Man) SpringUtils.getApplicationContext().getBean("man");
        Man man1 = (Man) SpringUtils.getObject("man");
        man1.study("star",28,new Date());
      /*  man.study();
        man.code();*/
    }

}
