package com.star.springbootdemo.java8.thread;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author StarC
 * @Date 2020/9/9 16:37
 * @Description:
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
       /* System.out.println("主线程准备休眠");

        Thread thread1 = new Thread(()->{
            System.out.println("子线程1在运行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread1.join();
        System.out.println("5秒后，线程结束");*/

        List<DepartVo> departVos = Arrays.asList(new DepartVo("1","A01","1","0"),
//                new DepartVo("2","A0101","2","1"),
                new DepartVo("3","A0102","3","1"),
               /* new DepartVo("4","A010101","4","2"),
                new DepartVo("5","A010102","5","2"),*/
                new DepartVo("6","A010201","6","3"),
                new DepartVo("7","A010202","7","3")

        );
       DepartVo departVo = getTreeData(departVos,"1");
       String json =  JSON.toJSONString(departVo);
        System.out.println(json );

    }

    public static DepartVo getTreeData(List<DepartVo> departVos,String id){


        DepartVo target = null;
        for(DepartVo entity : departVos){
            if(entity.getId().equals(id)){
                target =entity;
            }
        }
        List<DepartVo>varList = new ArrayList<>();
                for(DepartVo var1 : departVos) {
                    if(target.getId().equals(var1.getParentId())){
                        varList.add(getTreeData(departVos,var1.getId()));
                    }
                }
                if(CollectionUtils.isNotEmpty(varList)) {
                    target.getList().add(varList);
                }

        return target;
    }
}
