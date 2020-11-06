package com.star.springbootdemo.aop_annotation.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Author: StarC
 * @Date: 2020/4/10 15:00
 * @Description:
 */
public enum ResultMsg {

    SUCCESS("666","成功"),
    FAIL("999","失败"),
    SYSTEM_ERROR("999999", "系统异常，请联系管理员"),
    NETWORK_ERROR("000001", "网络出错");

    private String code;
    private String value;

    ResultMsg(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("code", code);
        object.put("value", value);
        return JSON.toJSONString(object,
                // 输出key是包含双引号
                SerializerFeature.QuoteFieldNames,
                // 是否输出为null的字段,若为null 则显示该字段
                SerializerFeature.WriteMapNullValue,
                // 数值字段如果为null，则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                //  List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //  字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //  Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //    Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                //    循环引用
                SerializerFeature.DisableCircularReferenceDetect);
    }

}
