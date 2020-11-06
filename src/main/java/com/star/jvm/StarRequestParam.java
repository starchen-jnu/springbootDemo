package com.star.jvm;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import java.lang.annotation.*;

/**
 * @Author: StarC
 * @Date: 2020/8/19 22:51
 * @Description:
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StarRequestParam {
    String value() default "";
}
