package com.easypoi;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/6/17 9:21
 * @Description:
 */
@Data
public class CItemVo {
    private String checkContent;
    private String keyWord;
    private  String standard;
    private List<CBasisVo>basisVos;

    public CItemVo() {
        basisVos = new ArrayList<>();
    }
}
