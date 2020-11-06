package com.star.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: StarC
 * @Date: 2020/8/5 16:01
 * @Description:
 */
@Data
@AllArgsConstructor
public class StatisticVo {

    private String departName;
    private String orgName;
    private Map<Integer,Integer> monthOfNumMap;
    public StatisticVo() {
        monthOfNumMap = new HashMap<>(12);
    }
    private Integer yearOfDepartTotal;
}
