package com.star.springbootdemo.tomcat.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

/**
 * @Author: StarC
 * @Date: 2019/8/28 9:23
 * @Description:
 */
public class StarRequest {

    HttpRequest r ;
    ChannelHandlerContext ctx;

    public StarRequest(HttpRequest r, ChannelHandlerContext ctx) {
        this.r = r;
        this.ctx = ctx;
    }
    public String getUri(){
        return r.getUri();
    }
    public String getMethod(){
        return r.getMethod().name();
    }

    public Map<String, List<String>> getParameters(){

        QueryStringDecoder decoder = new QueryStringDecoder(getUri());
        return  decoder.parameters();
    }

    public String getParameter(String name){
        Map<String,List<String>> params = getParameters();
        List<String> param = params.get(name);
        if(null == param){
            return null;
        }else{
            return param.get(0);
        }
    }
}
