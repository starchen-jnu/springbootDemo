package com.star.springbootdemo.aop_annotation.exception;

/**
 * @Author: StarC
 * @Date: 2020/4/10 15:04
 * @Description:
 */
public class StarException extends RuntimeException {

    private static final long serialVersionUID = 374193775529289514L;
    private ResultMsg resultMsg;

    public StarException(ResultMsg resultMsg){
        super(resultMsg.getValue());
        this.resultMsg = resultMsg;
    }

    public StarException(ResultMsg resultMsg, Throwable throwable){
        super(resultMsg.getValue(),throwable);
        this.resultMsg = resultMsg;
    }
    public ResultMsg getResultMsg(){
        return resultMsg;
    }



}
