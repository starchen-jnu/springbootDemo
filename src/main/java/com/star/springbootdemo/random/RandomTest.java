package com.star.springbootdemo.random;

import java.io.InputStream;
import java.util.*;

/**
 * @Author: StarC
 * @Date: 2020/2/27 8:42
 * @Description:设置抽取的数，随机抽签；
 */
public class RandomTest {

    public static void main(String[] args) {
        String name = "工商,建设,发展,中国,农业";
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入抽取数");
        Integer nums = scanner.nextInt();
        System.out.println("请输入次数");
        Integer times = scanner.nextInt();
        for(int i = 0; i< times; i++){
//            goRandom(name,nums);
            goRandom2(name,nums);
        }

    }

    public static void goRandom(String enterpriseName, int nums){

        StringBuffer results = new StringBuffer();
        String[] enterpriseNames = enterpriseName.split(",");
        HashSet<Integer> hashSet = new HashSet<>();
        if(enterpriseNames.length < nums && nums < 0){
            try {
                throw new Exception("抽签次数有误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int count = 0 ;
        if(enterpriseNames.length == nums){
            results.append(enterpriseName);
            System.out.println(results.toString());
            return;
        }
        for(int i = 0; count < nums; i++){
            Random random = new Random();
            int luckyNumber = random.nextInt(enterpriseNames.length);
            if(count == 0){
                results.append(enterpriseNames[luckyNumber]);
                count ++;
            }else{
                if(!hashSet.contains(luckyNumber)) {
                    results.append(",").append(enterpriseNames[luckyNumber]);
                    count++;
                }
            }
            hashSet.add(luckyNumber);

        }
        System.out.println(results.toString());
    }

    public static void goRandom2(String enterpriseName, int nums){

        StringBuffer results = new StringBuffer();
        String[] enterpriseNames = enterpriseName.split(",");
        List<String> dataList = new ArrayList<>();
        for(String data : enterpriseNames ){
            dataList.add(data);
        }
        if(enterpriseNames.length < nums && nums < 0){
            try {
                throw new Exception("抽签次数有误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(enterpriseNames.length == nums){
            results.append(enterpriseName);
            System.out.println(results.toString());
            return;
        }
      for(int i = 0; i < nums; i++){
          Random random = new Random();
          int luckyNum = random.nextInt(dataList.size() );
          if(i == 0){
              results.append(dataList.get(luckyNum));
          }else{
              results.append(",").append(dataList.get(luckyNum));
          }
          dataList.remove(dataList.get(luckyNum));
      }


        System.out.println(results.toString());
    }

}
