package com.star.springbootdemo.algorithm.leecode;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            int num1Sign = input.startsWith("-")?-1:1;
            int num2Sign = 1;
            input = num1Sign==-1?input.substring(1):input;
            if(input.indexOf('-')!=-1&&!Character.isDigit(input.charAt(input.indexOf('-')-1))){
                num2Sign = -1;
                input = input.replaceFirst("-","");
            }
            String[] strs = input.split("[\\+\\-\\*/]");
            if (strs.length==1){
                System.out.println(num1Sign*Double.parseDouble(strs[0]));
            }else{

                String op = String.valueOf(input.charAt(strs[0].length()));
                int result = calc(op, Integer.parseInt(strs[0])*num1Sign, Integer.parseInt(strs[1])*num2Sign);

                System.out.println(result);
            }

        }
    }

    public static int calc(String op, int num1, int num2) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
