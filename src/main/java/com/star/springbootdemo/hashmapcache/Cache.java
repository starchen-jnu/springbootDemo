package com.star.springbootdemo.hashmapcache;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2020/2/18 13:46
 * @Description:
 */
@Data
@NoArgsConstructor
public class Cache {

    private String key;
    private Object value;
    private Long timeOut;

    public Cache(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Cache(String key, Object value, Long timeOut) {
        this.key = key;
        this.value = value;
        this.timeOut = timeOut;
    }
}
