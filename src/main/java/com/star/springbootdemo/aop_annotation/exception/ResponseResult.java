package com.star.springbootdemo.aop_annotation.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

/**
 * @Author: StarC
 * @Date: 2020/4/11 10:21
 * @Description:
 */
@Data
public class ResponseResult<T> {

    private ResultMsg resultMsg;
    private T data;

    public ResponseResult() {
        resultMsg = null;
    }

    public ResponseResult(ResultMsg resultMsg, T data) {
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public ResponseResult(ResultMsg resultMsg) {
        this.resultMsg = resultMsg;
    }

    public static<T> ResponseResult<T> build(ResultMsg resultMsg, T data){
        return new ResponseResult<>(resultMsg,data);
    }

    public static<T> ResponseResult<T> build(ResultMsg resultMsg){
        return new ResponseResult<>(resultMsg);
    }

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("code", resultMsg.getCode());
        object.put("message", resultMsg.getValue());
        object.put("data", data);
//        if (null != pageInfo) {
//            object.put("pageInfo", pageInfo);
//        }
        return JSON.toJSONString(object,
                //    输出key是包含双引号
                SerializerFeature.QuoteFieldNames,
                //    是否输出为null的字段,若为null 则显示该字段
                SerializerFeature.WriteMapNullValue,
                // 数值字段如果为null，则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                //     List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //    字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //    Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //    Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                //    循环引用
                SerializerFeature.DisableCircularReferenceDetect);
    }


}
