package com.star.springbootdemo.aop_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author: StarC
 * @Date: 2020/4/10 13:54
 * @Description:
 */
@Target(ElementType.METHOD)
public @interface OperationLog {
//    String operationType() default "";
//    String operationName() default "";
    OperationTypeEnum operation() ;
}
