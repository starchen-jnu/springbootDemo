package com.star.springbootdemo.controller;

import com.star.springbootdemo.commons.ResultMsg;
import com.star.springbootdemo.redis.RedisConfig;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: StarC
 * @Date: 2019/10/31 19:28
 * @Description:
 */
@RequestMapping(value = "/redis")
@Controller
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/stringAndHash")
    @ResponseBody
    public ResultMsg testStringHash(){

        redisTemplate.opsForValue().set("key1","value");
        redisTemplate.opsForValue().set("int_key","1");

        stringRedisTemplate.opsForValue().set("int","1");
        stringRedisTemplate.opsForValue().increment("int",1);

        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        jedis.decr("int");

        Map<String,String> hash = new HashMap<>();
        hash.put("field1","value1");
        hash.put("field2","value2");
        stringRedisTemplate.opsForHash().putAll("hash",hash);
        stringRedisTemplate.opsForHash().put("hash","field3","value3");
        BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");
        hashOps.delete("field1","field2");
        hashOps.put("field4","value4");


        return ResultMsg.SUCCESS;
    }

    @RequestMapping("/zset")
    @ResponseBody
    public ResultMsg testZset(){

        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        for(int i=0;i<10;i++){
            double score = i*10;
            ZSetOperations.TypedTuple<String> typedTuple = new DefaultTypedTuple<>("value"+i,score);
            typedTupleSet.add(typedTuple);
        }

        stringRedisTemplate.opsForZSet().add("zset1",typedTupleSet );
        BoundZSetOperations<String,String> zetOps = stringRedisTemplate.boundZSetOps("zet1");
        zetOps.add("value10",0.26);
        Set<String> setRange =zetOps.range(1,6);
        for(String str : setRange){
            System.out.println(str);
        }
        Set<String> setScore = zetOps.rangeByScore(0.2,0.6);
        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        System.out.println(range.gt("value3"));
        return ResultMsg.SUCCESS;
    }



}
