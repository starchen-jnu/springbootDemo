package com.star.springbootdemo.aop;

import com.star.springbootdemo.transaction.Extransaction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;

/**
 * @Author: StarC
 * @Date: 2019/9/16 14:41
 * @Description:
 */
@Aspect
@Component
public class SleepHelper {
    @Before("sleep()")
    public void beforeSleep(){
        System.out.println("睡前刷牙---------");
    }

    @Pointcut("execution(* com.star.springbootdemo.aop.*.*(..))")
    public void sleep(){

    };

    @After("sleep()")
    public void wakeUp(){
        System.out.println("醒来洗漱--------------");
    }

    // 环绕通知 在方法之前和之后处理事情
    @Around("sleep()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {

        // 1.获取该方法上是否加上注解
        Extransaction extTransaction = getMethodExtTransaction(pjp);
         begin(extTransaction);

        // 2.调用目标代理对象方法
        pjp.proceed();
        // 3.判断该方法上是否就上注解
        commit();
    }

    private void begin(Extransaction extTransaction) {
        if (extTransaction == null) {

            System.out.println("事务启动失败");
        }else {
            System.out.println("事务启动");
        }
    }

    private void commit() {
        System.out.println("事务提交");

    }
    // 获取方法上是否存在事务注解
    private Extransaction getMethodExtTransaction(ProceedingJoinPoint pjp)
            throws NoSuchMethodException, SecurityException {
        String methodName = pjp.getSignature().getName();
        // 获取目标对象
        Class<?> classTarget = pjp.getTarget().getClass();
        // 获取目标对象类型
        Class<?>[] par = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        // 获取目标对象方法
        Method objMethod = classTarget.getMethod(methodName, par);
        Extransaction extTransaction = objMethod.getDeclaredAnnotation(Extransaction.class);
        boolean annotationPresent = objMethod.isAnnotationPresent(Extransaction.class); // 判断有没注解
        return extTransaction;
    }

}
