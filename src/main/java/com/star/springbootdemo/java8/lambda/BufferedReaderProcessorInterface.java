package com.star.springbootdemo.java8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author: StarC
 * @Date: 2020/5/8 15:06
 * @Description:
 */
@FunctionalInterface
public interface BufferedReaderProcessorInterface {
    String process(BufferedReader b) throws IOException;
}
