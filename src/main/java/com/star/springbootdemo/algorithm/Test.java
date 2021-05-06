package com.star.springbootdemo.algorithm;
//测试git
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: StarC
 * @Date: 2020/3/27 9:33
 * @Description:
 */
public class Test {

    /*public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("abd");
        treeSet.add("zmdsa");
        treeSet.add("klaf");

        List<String> list = Stream.of("abz","bcd","fkgla").collect(Collectors.toList());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((Character)o2.charAt(o2.length()-1)).compareTo(o1.charAt(o1.length()-1));
            }
        });

        Spliterator<String> spliterator = list.spliterator();
        spliterator.forEachRemaining(n->{
            System.out.println(n);
        });

    }*/


    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < p) {
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
