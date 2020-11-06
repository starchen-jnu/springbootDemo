package com.star.springbootdemo.aop_annotation;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: StarC
 * @Date: 2020/4/10 14:12
 * @Description:
 */

public enum OperationTypeEnum {

//    QUERYLOG, UPDATELOG,ADDLOG, DELETELOG;
    QUERYLOG("0","查询"),
    UPDATELOG("1","更新"),
    ADDLOG("2","增加"),
    DELETELOG("3","删除");



    private OperationTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }
    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static OperationTypeEnum operationTypeEnum(String key){

        if(StringUtils.isNotEmpty(String.valueOf(key))) {
            for (OperationTypeEnum o : OperationTypeEnum.values()) {
                if(StringUtils.equals(o.getType(),key)){
                    return  o;
                }

            }
        }
        return null;
    }
}
