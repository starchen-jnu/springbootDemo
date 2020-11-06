package com.star.jvm;

import java.lang.annotation.*;

/**
 * @Author: StarC
 * @Date: 2020/8/19 22:51
 * @Description:
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChenRequestParam {
    String value() default "";
}
