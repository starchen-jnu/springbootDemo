package com.star.springbootdemo.tomcat.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;

/**
 * @Author: StarC
 * @Date: 2019/8/28 9:24
 * @Description:
 */
public class StarResponse {

    HttpRequest r ;
    ChannelHandlerContext ctx;

    public StarResponse(HttpRequest r, ChannelHandlerContext ctx) {
        this.r = r;
        this.ctx = ctx;
    }

    public void write(String out){

        if(out == null){
            return;
        }
        try {
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(out.getBytes("UTF-8")));
            //response.headers().set(CONTENT_TYPE,"text/json");
            response.headers().set(CONTENT_LENGTH,response.content().readableBytes());
            response.headers().set("Content-type", "text/html;charset=UTF-8");
            response.headers().set(EXPIRES,0);
            if(HttpHeaders.isKeepAlive(r)){
                response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
            }
            ctx.write(response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            ctx.flush();

        }

    }
}
