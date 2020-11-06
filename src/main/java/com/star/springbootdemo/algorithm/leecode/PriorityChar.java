package com.star.springbootdemo.algorithm.leecode;

/**
 * @Author: StarC
 * @Date: 2020/3/26 9:12
 * @Description:
 */
import java.util.*;

public class PriorityChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return ((Character)o2.charAt(o2.length()-1)).compareTo(o1.charAt(o1.length()-1));
                }
            });
            String[] strs = input.split(",");
            for(String str:strs){
                queue.add(str);
            }
            for(int i = 0;i<strs.length;i++){
                strs[i] = queue.poll();
            }
            System.out.println(String.join(",",strs));
        }



    }

}
