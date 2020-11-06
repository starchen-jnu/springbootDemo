package com.star.springbootdemo.designpatern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2019/10/26 11:25
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class TestDatas implements Cloneable{
        Integer num;
        String name;
        int size;

        @Override
        protected Object clone()  {

            Object obj=null;
            //调用Object类的clone方法，返回一个Object实例
            try {
                obj= super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return obj;
        }

        public static void main(String[] args) {

            TestDatas testDatas = new TestDatas(1,"star",19);
            TestDatas newDatas = (TestDatas) testDatas.clone();
            newDatas.setName("chen");
            newDatas.setNum(100);
            System.out.println(testDatas);
            System.out.println(newDatas);

        }
    }
}
