package com.star.springbootdemo.designpatern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2019/10/27 14:12
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultMsg<T> {

    private int code;
    private String msg;
    private T data;

    public ResultMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
