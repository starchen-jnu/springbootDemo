package com.star.springbootdemo.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * @Author: StarC
 * @Date: 2019/9/19 9:15
 * @Description:
 */
@Component
@Aspect
public class AOPExtransaction {

      /* @Autowired
	   private TransactionUtils transactionUtils;

    @Pointcut("execution(* com.star.springbootdemo.service.*.*.*(..))")
    public void pointcut(){};
    // 使用异常通知进行 回滚事务
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        // 获取当前事务进行回滚
        // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        transactionUtils.rollback();
    }

    // 环绕通知 在方法之前和之后处理事情
    @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {

        // 1.获取该方法上是否加上注解
        Extransaction extTransaction = getMethodExtransaction(pjp);
        TransactionStatus transactionStatus = begin(extTransaction);
        // 2.调用目标代理对象方法
        pjp.proceed();
        // 3.判断该方法上是否就上注解
        commit(transactionStatus);
    }

    private TransactionStatus begin(Extransaction extTransaction) {
        if (extTransaction == null) {
            return null;
        }
        // 2.如果存在事务注解,开启事务
        return transactionUtils.begin();
    }

    private void commit(TransactionStatus transactionStatus) {
        if (transactionStatus != null) {
            // 5.如果存在注解,提交事务
            transactionUtils.commit(transactionStatus);
        }

    }

    private Extransaction getMethodExtransaction(ProceedingJoinPoint pjp) throws NoSuchMethodException {
        String methodName = pjp.getSignature().getName();
        Class<?> classTarget = pjp.getTarget().getClass();
        Class<?>[] type = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        Method objMethod = classTarget.getMethod(methodName,type);
        Extransaction extTransaction = objMethod.getDeclaredAnnotation(Extransaction.class);
        return extTransaction;
    }
*/
}
