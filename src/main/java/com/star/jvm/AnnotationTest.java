package com.star.jvm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executors;

/**
 * @Author: StarC
 * @Date: 2020/8/18 14:51
 * @Description:
 */
public class AnnotationTest {

    @DataSource(name = "database1")
    public void testAnnotation(@StarRequestParam(value = "star") String value,@StarRequestParam(value = "chen") Integer number,@ChenRequestParam(value = "star") String star){
        System.out.println("datasource start");
    }

    public void test(){
        try {
            Class<?> clazz = AnnotationTest.class;
            Method method = clazz.getMethod("testAnnotation",String.class,Integer.class,String.class);
           // method.invoke(new AnnotationTest());
            DataSource dataSource = method.getAnnotation(DataSource.class);
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for(int i=0;i<parameterAnnotations.length;i++){
                for(Annotation annotation : parameterAnnotations[i]){
                    if(annotation instanceof  StarRequestParam) {
                        String paraName = ((StarRequestParam) annotation).value();
                        System.out.println(paraName);
                    }else if(annotation instanceof ChenRequestParam){
                        String paraName = ((ChenRequestParam) annotation).value();
                        System.out.println(paraName);
                    }
                }
            }

            Class<?>[] paramsType = method.getParameterTypes();
            Arrays.stream(paramsType).forEach(type->{
                if(type == String.class){

                }else if(type == Integer.class){

                }
            });

            System.out.println(dataSource.name());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AnnotationTest().test();
        new  AnnotationTest().mark(()->{
            System.out.println("hello,world");
        });
    }

    public static void mark(MarkEgg markEgg){

        markEgg.egg();
    }


}
