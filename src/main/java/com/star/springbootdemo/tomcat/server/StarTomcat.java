package com.star.springbootdemo.tomcat.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @Author: StarC
 * @Date: 2019/8/28 9:23
 * @Description:通过netty实现tomcat功能
 */
public class StarTomcat {

    public void start(int port){

        EventLoopGroup bossGroup = new NioEventLoopGroup() ;
        EventLoopGroup workerGroup = new NioEventLoopGroup() ;

        ServerBootstrap server = new ServerBootstrap();

        try {

            server.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).
                    childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new HttpResponseEncoder());
                            socketChannel.pipeline().addLast(new HttpRequestDecoder());

                            socketChannel.pipeline().addLast(new StarTomcatHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG,128)
                             .childOption(ChannelOption.SO_KEEPALIVE,true);

            ChannelFuture channelFuture = server.bind(port).sync();
            System.out.println("STARTomcat:"+port);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new StarTomcat().start(9999);
    }
}
