package com.star.springbootdemo.reflect;

import org.thymeleaf.spring5.expression.Fields;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: StarC
 * @Date: 2020/4/14 9:21
 * @Description:
 */
public class ReflectTest {

    public static void copy(Object source, Object dest){

        Field[] destFields = dest.getClass().getDeclaredFields();
        Object value;
        for(Field field : destFields){
            try {
                field.setAccessible(true);
                value = getValues(field.getName(), source);
                if(value == null) continue;
                field.set(dest,value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
    private static Object getValues(String name, Object source) {

        try {
            Field sourceField = source.getClass().getDeclaredField(name);
            sourceField.setAccessible(true);
            return sourceField.get(source);
        } catch (NoSuchFieldException e) {
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        name = name.substring(0,1).toUpperCase()+name.substring(1);
        String getMethodName = "get" + name;
        String isMethodName = "is" + name;
        Method[] methods = source.getClass().getMethods();
        for(Method method : methods){
            if(method.getName().equals(getMethodName) || method.getName().equals(isMethodName)){

                if(method.getParameterCount()>0){
                    continue;
                }
                try {
                    return method.invoke(source);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }

}
