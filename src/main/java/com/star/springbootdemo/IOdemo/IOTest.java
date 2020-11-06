package com.star.springbootdemo.IOdemo;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: StarC
 * @Date: 2020/4/11 15:28
 * @Description:
 */
public class IOTest {
    public static void main(String[] args) {
        String path = "";
        int i;
         FileInputStream fileInputStream = null;
        try {
             fileInputStream = new FileInputStream(path);
            do{
                i = fileInputStream.read();

            }while (i != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
