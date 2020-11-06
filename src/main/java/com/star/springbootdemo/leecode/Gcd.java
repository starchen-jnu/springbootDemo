package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/5/6 10:46
 * @Description:最大公约数&&最小公倍数
 */
public class Gcd {

    public static void main(String[] args) {
        System.out.println(new Gcd().getGcd(3,5));
        System.out.println(new Gcd().getLcm(3,5,new Gcd().getGcd(3,5)));
    }


    //最大公约数
    private Integer getLcm(int p,int q,int gcd){

        return p/gcd * q;
    }

    //最小公倍数
    private Integer getGcd(int p, int q){

      /*  if(q == 0){
            return p;
        }
        int r = p % q;
        return getGcd(q,r);
*/

      return q == 0 ? p:getGcd(q,p%q);
    }
}
