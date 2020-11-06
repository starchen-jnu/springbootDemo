package com.star.springbootdemo.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: StarC
 * @Date: 2020/5/8 15:08
 * @Description:
 */
public class Processor {

    public static String processFile(BufferedReaderProcessorInterface p) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("d.txt"));
        return p.process(br);
}
}
