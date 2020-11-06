package com.star.springbootdemo.algorithm.java_algorithm;


/**
 * @Author: StarC
 * @Date: 2020/3/17 10:41
 * @Description:模拟计算器（加减乘除）
 */

import java.util.*;
public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(input+"="+calculate(input));
        }
    }

    public static double calculate(String expre) {
        List<String> num=transformEnd(expre);
        Stack<Double> stack = new Stack<>();
        double sum = 0;
        while (!num.isEmpty()) {
            String temp = String.valueOf(num.remove(0));
            if (isNamber(temp)) {
                double s=Double.parseDouble(temp);
                stack.push(s);
            } else {
                double a=stack.pop();
                double b=stack.pop();
                double c=calTwo(b,a,temp);
                stack.push(c);

            }
        }
        sum=stack.pop();
        return sum;
    }

    private static double calTwo(double a, double b, String opr) {
        double sum = 0;
        switch (opr) {
            case "+":
                sum = a + b;
                break;
            case "-":
                sum = a - b;
                break;
            case "*":
                sum = a * b;
                break;
            case "/":
                sum = a / b;
                break;
        }
        return sum;
    }


    public static List<String> transformEnd(String expre) {
        List<String> sb = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        boolean b = expre.startsWith("-");
        if(b){
            expre = expre.substring(1);
        }
        expre = expre.replaceAll("(\\D)", "o$1o");
        String[] esp = expre.trim().split("o");

        for (int i = 0; i < esp.length; i++) {
            String s = esp[i].trim();

            if (isNamber(s)) {
                // 如果是数字则输出
                if(b&&i==0){
                    sb.add(-Double.parseDouble(s)+"");
                }else{
                    sb.add(s);
                }

            } else if (!s.isEmpty()) {


                    if (s.charAt(0) == ')') {
                        while (stack.peek().charAt(0) != '(') {
                            sb.add(stack.pop());
                        }
                        stack.pop();
                    } else {
                        if (!stack.isEmpty() && !isMaxExp(s.charAt(0), stack.peek().charAt(0))) {
                            while (!stack.isEmpty() && !isMaxExp(s.charAt(0), stack.peek().charAt(0))) {
                                sb.add(stack.pop());
                            }
                            stack.push(s);
                        } else {
                            stack.push(s);
                        }
                    }
            }

        }
        while (!stack.isEmpty()) {
            sb.add(stack.pop());
        }
        return sb;
    }


    private static boolean isNamber(String str) {
        try {
            Double.parseDouble(str);

        } catch (RuntimeException e) {
            return false;
        }
        ;
        return true;
    }

    private static boolean isMaxExp(char exp1, char exp2) {
        if (exp1 == '(')
            return true;
        if (exp2 == ')')
            return true;
        if (transExp(exp1) > transExp(exp2))
            return true;

        return false;

    }

    private static int transExp(char exp) {
        int re = 0;
        switch (exp) {
            case '*':
            case '/':
                re = 2;
                break;
            case '+':
            case '-':
                re = 1;
                break;
        }
        return re;
    }

}

