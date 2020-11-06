package com.star.springbootdemo.aop_annotation;

import com.star.springbootdemo.annotations.Select;
import com.star.springbootdemo.aop_annotation.entity.TestEntity;
import com.star.springbootdemo.aop_annotation.exception.ResponseResult;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: StarC
 * @Date: 2020/4/10 14:00
 * @Description:
 */
@Aspect
@Component
public class SystemLogAspect {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(SystemLogAspect.class);

    @Pointcut("execution (* com.star.springbootdemo.aop_annotation.controller..*.*(..))")
    public void controllerAspect(){};

    @Before("controllerAspect()")
    public void doBefore(){

    }


    @AfterReturning(returning="rvt", pointcut="controllerAspect()")
    public void doAfter(JoinPoint joinPoint, Object rvt){

        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class<?> targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            OperationTypeEnum operationTypeEnum = null;
            for(Method method : methods){
                boolean isAnnotationPresent = method.isAnnotationPresent(OperationLog.class);
                if(isAnnotationPresent){
                    OperationLog operationLog = method.getAnnotation(OperationLog.class);
                    operationTypeEnum = operationLog.operation();
                    operationType = operationTypeEnum.getType();
                    //方法形参
                    //Object[] methodArgs = pjp.getArgs();
                    ResponseResult<TestEntity> responseResult =null;
                    //调用返回的值
                    try {
                       // responseResult = (ResponseResult) pjp.proceed(methodArgs);
                        responseResult = (ResponseResult<TestEntity>) rvt;
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    switch (operationType){
                        //日志查询
                        case  "0":
                            break;
                        //日志更新
                        case "1":
                            break;
                        //日志增加
                        case "2":
                            try {
                                addLog(responseResult);
                            } catch (Exception e) {
                                logger.error("日志添加失败{}",e);
                            }
                            break;
                        //日志删除
                        case "3":
                            break;
                            default:break;

                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private boolean addLog(ResponseResult responseResult) {
        TestEntity testEntity = (TestEntity) responseResult.getData();
        logger.debug("{}日志添加成功",testEntity.getName());
        return true;
    }

}
