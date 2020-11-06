package com.star.springbootdemo.reflect;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2020/4/14 9:37
 * @Description:
 */
@Data
@Builder

public class DestEntity {

    public DestEntity() {
    }

    public DestEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;
    private String name;
}
