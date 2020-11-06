package com.star.springbootdemo.tomcat.server;


;
import com.star.springbootdemo.tomcat.http.StarRequest;
import com.star.springbootdemo.tomcat.http.StarResponse;
import com.star.springbootdemo.tomcat.servlet.MyServlet ;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

/**
 * @Author: StarC
 * @Date: 2019/8/28 9:23
 * @Description:
 */
public class StarTomcatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof HttpRequest){
            HttpRequest r = (HttpRequest) msg;

            StarRequest request = new StarRequest(r,ctx);
            StarResponse response = new StarResponse(r,ctx);

            new MyServlet().doGet(request, response);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
