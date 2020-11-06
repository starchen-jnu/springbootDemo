package com.star.springbootdemo.ThreadControl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: StarC
 * @Date: 2019/10/28 15:55
 * @Description:
 */
@Data
@AllArgsConstructor
@Builder
public class User {

    private String userId;
    private String userName;
}
