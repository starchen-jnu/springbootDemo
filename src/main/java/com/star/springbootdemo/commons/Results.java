package com.star.springbootdemo.commons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Author: StarC
 * @Date: 2019/8/20 15:47
 * @Description:
 */
public class Results<T> {
    private ResultMsg msg;
    private T data;
//    private PageInfo pageInfo;

    public Results() {
    }

    public Results(ResultMsg msg) {
        this.msg = msg;
    }

    public Results(ResultMsg msg, T data) {
        this.msg = msg;
        this.data = data;
    }

   /* public Results(ResultMsg msg, PageInfo pageInfo) {
        this.msg = msg;
        this.pageInfo = pageInfo;
    }*/

    public ResultMsg getMsg() {
        return msg;
    }

    public void setMsg(ResultMsg msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

   /* public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }*/

    public static <T> Results<T> build(ResultMsg msg){
        return new Results<T>(msg);
    }
    public static <T> Results<T> build(ResultMsg msg, T data){
        return new Results<T>(msg,data);
    }
    /*public static <T> Results<T> build(ResultMsg msg, PageInfo pageInfo){
        return new Results<T>(msg,pageInfo);
    }*/

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("code",msg.getCode());
        object.put("message",msg.getMessage());
        object.put("data",data);

       /* if(null != null){
            object.put("pageInfo",pageInfo);
        }*/
        return  JSON.toJSONString(object,
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
