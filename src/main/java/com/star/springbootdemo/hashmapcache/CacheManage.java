package com.star.springbootdemo.hashmapcache;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: StarC
 * @Date: 2020/2/18 13:49
 * @Description:
 */
public class CacheManage {

    private HashMap<String,Object> cacheMap = new HashMap<>();

    public synchronized void putCache(String key, Object value){
        putCache(key,value,null);
    }
    public synchronized void putCache(String key, Object value, Long timeOut){
        if(value == null){
            return;
        }
       Cache cache = new Cache();
       cache.setKey(key);
       cache.setValue(value);
       if(timeOut != null){
           cache.setTimeOut(System.currentTimeMillis()+timeOut);
       }
       cacheMap.put(key,cache);
    }

    public synchronized Object getCache(String key){
        Cache cache = (Cache) cacheMap.get(key);
        Object o = null;
        if(cache != null){
             o = cache.getValue();
        }
        return o;
    }

    public synchronized void delCache(String key){
        cacheMap.remove(key);
    }

    public void validTimeoutCache(){

        for(Map.Entry entry : cacheMap.entrySet()){
            String cacheKey = (String) entry.getKey();
            Cache cache = (Cache) entry.getValue();
            Long timeout = cache.getTimeOut();
            if(timeout == null){
                return;
            }
            Long currentTime = System.currentTimeMillis();
            Long time = currentTime -timeout;
            if(time>0){
                cacheMap.remove(cacheKey);
            }

        }
    }


}
