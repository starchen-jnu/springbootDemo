package com.star.springbootdemo.designpatern.template;

/**
 * @Author: StarC
 * @Date: 2019/10/27 13:39
 * @Description:
 */
public abstract class NetWorkCourse {
    protected final void createCourse(){

        this.postPreResource();
        this.createPPT();
        this.liveVideo();
        this.postNote();
        this.postSource();
        if(needHomeWork()){
            checkHomeWork();
        }
    }
    abstract void checkHomeWork();

    //钩子方法实现方法微调
    protected boolean needHomeWork(){return false;}

    final void postSource(){
        System.out.println("提交源代码");
    }
    final void postNote(){
        System.out.println("提交笔记");
    }
    final void liveVideo(){
        System.out.println("直播授课");
    }
    final void createPPT(){
        System.out.println("创建PPT");
    }
    final void postPreResource(){
        System.out.println("分发预习资料");
    }
}
