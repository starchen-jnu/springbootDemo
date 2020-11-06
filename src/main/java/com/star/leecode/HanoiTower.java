package com.star.leecode;

/**
 * @Author StarC
 * @Date 2020/10/29 16:41
 * @Description:
 */
public class HanoiTower {
    public static void main(String[] args) {
        move(2,'A','B','C');
    }

    public static void move(int topN,char from,char inner,char to){
        if(topN == 1){
            System.out.println("盘子1从"+from +"塔移到"+to+"塔");
        }else{
            move(topN-1,from,to,inner);
            System.out.println("盘子"+topN+"从"+from+"移到"+to+"塔");
            move(topN-1,inner,from,to);
        }
    }
}
