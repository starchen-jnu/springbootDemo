package com.star.springbootdemo.designpatern.template;

/**
 * @Author: StarC
 * @Date: 2019/10/27 13:46
 * @Description:
 */
public class BigDataCourse extends NetWorkCourse {

    private boolean needHomeWorkFlag =false;

    public BigDataCourse(boolean needHomeWorkFlag) {
        this.needHomeWorkFlag = needHomeWorkFlag;
    }

    @Override
    void checkHomeWork() {

    }

    @Override
    protected boolean needHomeWork() {
        return this.needHomeWork();
    }
}
