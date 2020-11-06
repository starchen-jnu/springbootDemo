package com.star.springbootdemo.test;

/**
 * @Author: StarC
 * @Date: 2020/3/27 11:15
 * @Description:
 */
public enum DayEnum {
//    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    MONDAY("1","星期一"),
    TUESDAY("2","星期二");
    private String index;
    private String value;

    DayEnum(String index, String value) {
        this.index = index;
        this.value = value;
    }

    public static  DayEnum value(String index){
        for(DayEnum day: DayEnum.values() ){
            if(day.getIndex().equals(index)){
                return day;
            }
        }
        return null;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }}
