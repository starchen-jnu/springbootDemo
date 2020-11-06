package com.star.jvm;

import java.lang.annotation.*;

/**
 * @Author: StarC
 * @Date: 2020/8/18 14:49
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
