package com.star.springbootdemo.designpatern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2019/10/27 14:13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String userName;
    private String passwd;
    private String mid;
    private String indo;
}
