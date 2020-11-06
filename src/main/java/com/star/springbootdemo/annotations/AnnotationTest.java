package com.star.springbootdemo.annotations;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: StarC
 * @Date: 2019/8/27 15:49
 * @Description:
 */
public class AnnotationTest {
    public static void main(String[] args) throws Exception {


     /*   BufferedReader br = new BufferedReader(new FileReader(new File("")));
        BufferedWriter wr = new BufferedWriter(new FileWriter(""));
        String line = br.readLine();
        while (null != line){
            wr.write(line);
            wr.newLine();
            line = br.readLine();

        }*/

        String classPath = "com.star.springbootdemo.annotations.ExampleMapper";
        Class mapperClass = Class.forName(classPath);
        Method[] methods = mapperClass.getMethods();
        for (Method method : methods) {
            boolean isAnnotationPresent = method.isAnnotationPresent(Select.class);
            if (isAnnotationPresent) {
                Select selectAnno = method.getAnnotation(Select.class);
                Annotation[][] annos = method.getParameterAnnotations();
                System.out.println(annos[0][0].toString());

                String value = selectAnno.value();
                String star = selectAnno.star();
                Type type = method.getGenericReturnType();// List<Example>----<Example>
                //判断type是不是参数化的类型
                if (type instanceof ParameterizedType) {
                    //强转
                    ParameterizedType ptype = (ParameterizedType) type;
                    //得到参数化类型中的实际类型参数
                    Type[] types = ptype.getActualTypeArguments();
                    //取出第一个
                    Class domainClass = (Class) types[0];
                    //获取domainClass的类名
                    String resultType = domainClass.getName();
                }
            }
        }
    }
}
