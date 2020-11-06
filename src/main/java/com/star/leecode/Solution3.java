package com.star.leecode;

/**
 * @Author StarC
 * @Date 2020/10/10 21:29
 * @Description:
 */
public class Solution3 {

    public static void main(String[] args) {
        Integer[] arr = {1,1,1,2,2,3,3,3,3,3,3,4};
        System.out.println(removeDuplicate(arr));
    }

    private static Integer removeDuplicate(Integer[] arr) {
        Integer max = arr[arr.length-1];
        Integer sum = 0;
        Integer tmp = 0;
        for(int i = 1;i<=max;i++){
            for(int j=0;j<arr.length;j++){
                if(i==arr[j]){
                    tmp++;
                }
                if(tmp==i){
                    break;
                }
            }
            sum += tmp;
            tmp =0;

        }
        return sum;

    }
}
