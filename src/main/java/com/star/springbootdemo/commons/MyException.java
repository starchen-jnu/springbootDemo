package com.star.springbootdemo.commons;

/**
 * @Author: StarC
 * @Date: 2019/8/20 15:38
 * @Description:
 */
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 374193775529289514L;
    private ResultMsg resultMsg;

    public MyException(ResultMsg resultMsg) {
        super(resultMsg.getMessage());
        this.resultMsg = resultMsg;
    }

    public MyException( ResultMsg resultMsg, Throwable throwable) {
        super(resultMsg.getMessage(),throwable);
        this.resultMsg = resultMsg;
    }

    public ResultMsg MyException() {
        return resultMsg;
    }

    public static MyException build(ResultMsg msg){
        return  new MyException(msg);
    }
    public static MyException build(ResultMsg msg, Throwable throwable){
        return  new MyException(msg,throwable);
    }

    @Override
    public String toString() {
        return "MyException{" +
                "resultMsg=" + resultMsg +
                '}';
    }
}
