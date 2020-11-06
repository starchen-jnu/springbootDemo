package com.star.springbootdemo.reflect;

import com.star.springbootdemo.bean.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: StarC
 * @Date: 2019/10/29 9:46
 * @Description:通过反射进行浅拷贝
 */
public class ReflectCopy {

    public static void copy(Object source, Object dest)  {

        Class destClazz = dest.getClass();
        Field[] fields = destClazz.getDeclaredFields();
        Object value;
        for(Field field:fields){
            try {
                value = getValues(field.getName(),source);
                field.setAccessible(true);
                field.set(dest,value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Object getValues(String name, Object source) {

        try {
            Field field = source.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(source);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // 获取对应的 getXxx() 或者 isXxx() 方法
        name = name.substring(0,1).toUpperCase()+name.substring(1);
        String getMethodName = "get" + name;
        String isMethodName = "is" + name;
        Method[] methods = source.getClass().getMethods();
        for(Method method : methods){
            // 只获取无参的方法
            if(method.getParameterCount() > 0){
                continue;
            }
            if(method.getName().equals(getMethodName) || method.getName().equals(isMethodName)){
                try {
                    return method.invoke(source);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        //User user = new User(1,"hello","123",new Date(),new Date());
        User user1 = new User();
        //copy(user,user1);
        System.out.println(user1);
    }
}
