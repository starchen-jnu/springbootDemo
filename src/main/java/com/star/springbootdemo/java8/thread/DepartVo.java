package com.star.springbootdemo.java8.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author StarC
 * @Date 2020/9/18 16:22
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartVo {
    private String id;
    private String orgCode;
    private String departName;
    private String parentId;
    private List<List<DepartVo>> list = null;

    public DepartVo(String id, String orgCode, String departName, String parentId) {
        list = new ArrayList<>();
        this.id = id;
        this.orgCode = orgCode;
        this.departName = departName;
        this.parentId = parentId;
    }
}
