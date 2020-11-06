package com.star.springbootdemo.commons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

/**
 * @Author: StarC
 * @Date: 2019/8/20 15:33
 * @Description:
 */

public enum ResultMsg {
    SUCCESS("000000", "成功"),
    SYSTEM_ERROR("999999", "系统异常，请联系管理员"),
    NETWORK_ERROR("000001", "网络出错"),
    DATABASE_ERROR("000002", "数据库出错"),
    DATABASE_CONNECTION_ERROR("000003", "数据库连接出错"),
    MQ_CONNECTION_ERROR("000004", "消息队列连接出错"),
    FEIGN_CONNECTION_ERROR("000005", "Feign调用服务出错"),
    PARAM_NULL_ERROR("000006", "参数为空错误"),
    MD5_ALGORITHM_ERROR("000007", "MD5加密失败"),
    PARAM_NOT_MATCH("000008", "参数不符合格式"),
    NOT_FOUND_MATCH_DATA("000009", "未查询到符合条件的数据"),
    OPERATE_LOG_SAVE_FAIL("000010", "操作日志保存失败"),
    PARAM_NOT_COMPLETE("000011", "参数不完整"),
    NO_DATA("000012", "数据列为空"),
    EXPORT_DATA_NULL("000013", "查询数据为空,无法导出!请检查后重试"),
    EXCEL_FIELD_LENGTH("000014", "配置Excel导出错误！"),
    IMPORT_EXCEL_ERROR("000015", "导入Excel失败！"),
    IBE_CONNECTION_ERROR("000016", "IBE连接异常！"),
    JSON_FORMAT_ERROR("000017", "json格式错误！"),
    OPERATOR_NULL_ERROR("000018", "连接超时,请重新登录！"),
    EXCEL_PATTERN_ERROR("000019", "EXCEL文件内容或格式错误,导入失败！"),
    IMAGE_TO_BASE_ERROR("000020", "图片流转BASE64出错！"),
    FORGET_PASSWORD("000021", "忘记密码操作相关提示！"),
    NO_PARAM__ERROR("000022", "没有填写一个查询条件"),
    OUTUSE_ERROR("000023", "外网用户最后可用日期不能为空");

    private String code;
    private String message;

    ResultMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("code", code);
        object.put("message", message);
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

