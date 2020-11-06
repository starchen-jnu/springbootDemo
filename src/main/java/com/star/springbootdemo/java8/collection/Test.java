package com.star.springbootdemo.java8.collection;

import com.star.springbootdemo.designpatern.test.Student;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: StarC
 * @Date: 2020/5/21 11:07
 * @Description:
 */
public class Test {

    public static void main(String[] args)  {
        List<String> alist =new ArrayList<>();
        alist.add("A");
        alist.add("A");
        alist.add("A");
        List dest = Arrays.asList(new String[alist.size()]);
        //Object[] array =  alist.toArray();
        //Collections.fill(alist,"A");
        int[] arr = new int[]{1,2,5,3,2,6};
        Arrays.sort(arr);
        System.out.println(Arrays.binarySearch(arr,7));
        Collections.copy(dest,alist);
        System.out.println(dest.toString());
        Student student = null;
        Optional<Student> optional = Optional.ofNullable(student);

        optional.orElse(new Student());
        Calendar instance = Calendar.getInstance();
        instance.getTime();
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DATE);
        instance.add(Calendar.DATE,-22);
        System.out.println(instance.getTime());

//        File file = new File("D:\\home\\user\\");
//        File[] files = file.listFiles();
//
//        file.getAbsolutePath();
        browseFile("D:/home/user/test.txt");
        char[] buf = new char[0];
        try {
            FileReader fileReader = new FileReader("D:/home/user/test.txt");

            buf = new char[1024];
            int num =0;
            while((num=fileReader.read(buf))!=-1){
                System.out.print((char)num);

            }
            fileReader.close();
            Writer writer = new FileWriter("D:/home/user/test1.txt");
            for(char c:buf){
                writer.write(c);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void browseFile(String path){
        File file = new File(path);
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    String fileName = f.getName();
                    browseFile(path +"/"+ fileName);
                }else{
                    System.out.println(f.getName());
                }
            }
        }else{
            System.out.println(file.getName());
        }

    }
}
