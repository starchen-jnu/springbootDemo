package com.star.springbootdemo.algorithm;

/**
 * @Author: StarC
 * @Date: 2020/3/2 21:19
 * @Description:
 */
public class Algorithm {

    public static void main(String[] args) {

    }

    public static  int search(int[] arr,int key){

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start+end)/2;
            if(key == arr[mid]){
                System.out.println("get it ");
                return mid;
            }else if(key > arr[mid]){
                start = mid +1;
            }else if(key<arr[mid]){
                end = mid - 1;
            }
        }
        return -1;
    }

    //递归
    public static int find(int[] arr,int key, int start, int end){

        int mid = (start+end)/2;
        if(key == arr[mid]){
            return mid;
        }else if(key <arr[mid]){
            find(arr, key,start,mid-1);
        }else if(key > arr[mid]){
            find(arr,key,mid+1,end);
        }

        return -1;
    }

    public static void move(int n, char from, char temp, char to){

        if(n == 1){
            System.out.println("将"+n+"从"+from+"移动到"+to);
        }else{
            move(n-1,from,to,temp);
            System.out.println("将"+n+"从"+from+"移动到"+to);
            move(n-1,temp,from,to);
        }
    }

    public static void quickSort(int[] arr, int low, int hight){

        if(arr.length <= 0 || low >= hight) return;
        int left = low;
        int right = hight;
        int temp = arr[left];
        while(left < hight){
            while(left < right && arr[right] >= temp){
                right --;
            }
            arr[left] = arr[right];

            while(left < right && arr[left] <= temp){
                left ++;
            }
            arr[right] = arr[left];
        }
        arr[left] =temp;
        quickSort(arr,low,left-1);
        quickSort(arr, left+1,hight);

    }





}
