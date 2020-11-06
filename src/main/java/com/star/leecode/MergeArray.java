package com.star.leecode;

import java.util.Arrays;

/**
 * @Author StarC
 * @Date 2020/10/14 10:19
 * @Description:双指针合并数组
 */
public class MergeArray {
    public static void main(String[] args) {
        new MergeArray().mergeArray();
    }

    public void mergeArray() {

        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        int i = a.length-1, j = b.length-1, t = a.length+b.length-1;

        int[] merge = new int[a.length + b.length];

        while(i>=0 || j>=0){
            if(i<0){
                merge[t--] = b[j--];
            }else if(j<0){
                merge[t--] = a[i--];
            }else if(a[i]< b[j]){
                merge[t--]=b[j--];
            }else{
                merge[t--] = a[i--];
            }
        }
        System.out.println(Arrays.toString(merge));


    }


}
