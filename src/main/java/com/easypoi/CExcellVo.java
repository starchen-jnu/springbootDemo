package com.easypoi;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/6/17 9:18
 * @Description:
 */
@Data
public class CExcellVo {

    private String order;
    private String project;
    private List<CItemVo> items;

    public CExcellVo() {
        items = new ArrayList<>();
    }
}
