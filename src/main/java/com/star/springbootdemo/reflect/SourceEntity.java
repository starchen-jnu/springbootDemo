package com.star.springbootdemo.reflect;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2020/4/14 9:30
 * @Description:
 */
@Data
@Builder

public class SourceEntity {
    public SourceEntity() {
    }

    public SourceEntity(String name, String field) {
        this.name = name;
        this.field = field;
    }

    private String name;
    private String field;
}
