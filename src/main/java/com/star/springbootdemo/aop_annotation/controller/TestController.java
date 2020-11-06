package com.star.springbootdemo.aop_annotation.controller;

import com.star.springbootdemo.aop_annotation.OperationLog;
import com.star.springbootdemo.aop_annotation.OperationTypeEnum;
import com.star.springbootdemo.aop_annotation.entity.TestEntity;
import com.star.springbootdemo.aop_annotation.exception.ResponseResult;
import com.star.springbootdemo.aop_annotation.exception.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: StarC
 * @Date: 2020/4/10 14:55
 * @Description:
 */
@Controller
@RequestMapping("/testController")
public class TestController {

    @OperationLog(operation = OperationTypeEnum.ADDLOG)
    @RequestMapping("/add")
    public ResponseResult<TestEntity> addLog(TestEntity entity){
         entity= TestEntity.builder()
                .id("123")
                .name("star")
                .job("IT").build();
        ResponseResult<TestEntity> responseResult = ResponseResult.build(ResultMsg.SUCCESS,entity);
        return responseResult;

    }

}
