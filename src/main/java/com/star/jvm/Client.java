package com.star.jvm;

/**
 * @Author StarC
 * @Date 2020/10/16 16:04
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Person onePerson = (Person) new JdkProxy().getInstance(new OnePerson());
        onePerson.findLove();
    }
}
