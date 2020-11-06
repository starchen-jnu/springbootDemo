package com.star.springbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @Author: StarC
 * @Date: 2019/11/18 19:55
 * @Description:
 */
public class JunitTest {


 /*   @ParameterizedTest
    @DisplayName("test")
    @CsvSource({
            "1,2,3","1,2,0","1,0,3","0,2,3","0,0,3",
    })*/
     @Test
    void testLineConverageSample(){
        CoverageSample coverageSample = new CoverageSample();
        Assertions.assertFalse(coverageSample.testMethod(1,1,0));

    }
}
