package com.star.springbootdemo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: StarC
 * @Date: 2020/4/29 9:56
 * @Description:
 */
public class StarServer {

    private final int port;

    public StarServer(int port) {
        this.port = port;
    }

    public void start(){

        try {
            StarServerHandler starServerHandler = new StarServerHandler();
            EventLoopGroup group = new NioEventLoopGroup();
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel channel) throws Exception {
                    channel.pipeline().addLast(starServerHandler);
                }
            });

            ChannelFuture f = serverBootstrap.bind().sync();
            System.out.println(StarServer.class.getName()+"start and listening for connection on "+ f.channel().localAddress());
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        new StarServer(8080).start();
    }
}
