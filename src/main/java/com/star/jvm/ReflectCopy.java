package com.star.jvm;

import com.star.springbootdemo.bean.Person;
import com.star.springbootdemo.bean.TargetBean;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: StarC
 * @Date: 2020/8/11 14:46
 * @Description:
 */
public class ReflectCopy {

    public static void copy(Object source, Object target) {
        try {
            Class<?> clazz = target.getClass();
            Field[] fields = clazz.getDeclaredFields();
            Object value;
            for (Field field : fields) {
                value = getVlues(field.getName(), source);
                field.setAccessible(true);
                if (value == null) {
                    continue;
                }
                field.set(target, value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    private static Object getVlues(String fieldName, Object source) {

        try {
            Field[] sourceFields = source.getClass().getDeclaredFields();
            Method[] methods = source.getClass().getDeclaredMethods();
            String name = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            for (Method method : methods) {
                if (method.getParameterCount() > 0) {
                    continue;
                }
                if (StringUtils.equals(method.getName(), name)) {
                    return method.invoke(source);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Person p = Person.builder().age(12).birth(new Date()).boss(true).lastName("star").build();
        TargetBean targetBean = new TargetBean();
        ReflectCopy.copy(p, targetBean);
        System.out.println(targetBean);
    }
}
